import Vue from 'vue'
import Router from 'vue-router'
// in development env not use Lazy Loading,because Lazy Loading too many pages will cause webpack hot update too slow.so only in production use Lazy Loading
/* layout */
import Layout from '../views/layout/Layout'
import Index from '../views/index/index'

const _import = require('./_import_' + process.env.NODE_ENV)
Vue.use(Router)
export const constantRouterMap = [
  {path: '/login', component: _import('login/index'), hidden: true},
  {path: '/404', component: _import('404'), hidden: true},
  {path: '/index', component: _import('index/index'), hidden: true},
  {path: '/classify', component: _import('classify/index'), hidden: true},
  {path: '/projectMessage', component: _import('messagePage/projectMessage'), hidden: true},
  {path: '/companyMessage', component: _import('messagePage/companyMessage'), hidden: true},
  {path: '/studioMessage', component: _import('messagePage/studioMessage'), hidden: true},
  {path: '/modifyInfo', component: _import('modifyInfo/index'), hidden: true},
  {path: '/studioManageUnrecruited', component: _import('projectManagement/studioManageUnrecruited'), hidden: true},
  {path: '/studioManageProgress',component: _import('projectManagement/studioManageProgress'), hidden: true},
  {path: '/studioManageFinished', component: _import('projectManagement/studioManageFinished'), hidden: true},
  {path: '/help', component: _import('help/index'), hidden: true},
  {path: '/myWallet', component: _import('myWallet/index'), hidden: true},
  {path: '/advertisement', component: _import('advertisement/index'), hidden: true},
  {path: '/companyManageUnrecruited', component: _import('projectManagement/companyManageUnrecruited'), hidden: true},
  {path: '/companyManageProgress', component: _import('projectManagement/companyManageProgress'), hidden: true},
  {path: '/companyManageFinished', component: _import('projectManagement/companyManageFinished'), hidden: true},
  {path: '/demand', component: _import('demand/index'), hidden: true},
  {path: '/studioinfo', component: _import('studioinfo/index'), hidden: true},
  {path: '/companyInfo', component: _import('companyInfo/index'), hidden: true},
  {
    path: '/dashboard',
    component: Layout,
    name: '首页',
    hidden: true,
  },
  {
    path: '/',
    component: Index,
    redirect: '/index',
    name: '首页',
    hidden: true,
    children: [{
      path: 'index', component: _import('index/index')
    }]
  },
  // {
  //   path: '/dashboard',
  //   component: Layout,
  //   redirect: '/dashboard',
  //   name: '首页',
  //   hidden: true,
  //   children: [{
  //     path: 'dashboard', component: _import('dashboard/index')
  //   }]
  // }
]
export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({y: 0}),
  routes: constantRouterMap
})
export const asyncRouterMap = [
  {
    path: '/system',
    component: Layout,
    redirect: '/system/article',
    name: '功能模块',
    meta: {title: '功能模块', icon: 'tree'},
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: '',
    meta: {title: '用户权限', icon: 'table'},
    children: [
      {
        path: 'companyInfoExamined',
        name: '企业信息审核',
        component: _import('user/companyInfoExamined'),
        meta: {title: '企业信息审核', icon: 'company'},
        menu: 'role'
      },
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: 'user',
    children: [
      {
        path: 'studioInfoExamined',
        name: '工作室信息审核',
        component: _import('user/studioInfoExamined'),
        meta: {title: '工作室信息审核', icon: 'studio'},
        menu: 'role'
      },
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: 'user',
    children: [
      {
        path: 'projectTendered',
        name: '项目招标进度', 
        component: _import('user/projectTendered'), 
        meta: {title: '项目招标进度', icon: 'tender'}, 
        menu: 'role'
      },
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: 'user',
    children: [
      {
        path: 'projectImplemented',
        name: '项目执行情况', 
        component: _import('user/projectImplemented'), 
        meta: {title: '项目执行情况', icon: 'log'}, 
        menu: 'role'
      },
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: 'user',
    children: [
      {
        path: 'costManagement',
        name: '支付情况', 
        component: _import('user/costManagement'), 
        meta: {title: '支付情况', icon: 'cost'}, 
        menu: 'role'
      },
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: 'user',
    children: [
      {
        path: 'advertisementManagement',
        name: '广告管理', 
        component: _import('user/advertisementManagement'), 
        meta: {title: '广告管理', icon: 'manage'}, 
        menu: 'role'
      },
    ]
  },
  {
    path: '/user',
    component: Layout,
    redirect: '/user/',
    name: 'user',
    children: [
      {
        path: 'echarts',
        name: '图表', 
        component: _import('user/echarts'), 
        meta: {title: '图表', icon: 'tender'}, 
        menu: 'role'
      },
    ]
  },
  {path: '*', redirect: '/404', hidden: true}
]
