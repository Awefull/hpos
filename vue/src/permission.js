import router from './router'
import store from './store'
import NProgress from 'nprogress' // Progress 进度条
import 'nprogress/nprogress.css' // Progress 进度条样式
import {getToken} from '@/utils/auth' // 验权
const whiteList = ['/login', '/404','/index','/dashboard'] //白名单,不需要登录的路由

//zr 这里的beforeEach成为‘全局前置守卫’ （to,from,next）=> {}可以简单替换为 function(to,from,next){}
//to: Route: 即将要进入的目标 路由对象
//from: Route: 当前导航正要离开的路由
//next: Function: 一定要调用该方法来 resolve 这个钩子。执行效果依赖 next 方法的调用参数。
router.beforeEach((to, from, next) => {
  NProgress.start()
  if (getToken()) {
    //如果已经登录
    if (to.path === '/login') {
      next({path: '/'})
      NProgress.done() // 结束Progress
    } else if (!store.getters.role) {
      store.dispatch('GetInfo').then(() => {
        next({...to})
      }) 
    } else {
      next()
    }
  } else if (whiteList.indexOf(to.path) !== -1) {
    //如果前往的路径是白名单内的,就可以直接前往
    next()
  } else {
    //如果路径不是白名单内的,而且又没有登录,就跳转登录页面
    next('/index')
    NProgress.done() // 结束Progress
  }
})
router.afterEach(() => {
  NProgress.done() // 结束Progress
})
