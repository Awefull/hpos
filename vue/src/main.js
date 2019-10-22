import Vue from 'vue'
import 'normalize.css/normalize.css'// A modern alternative to CSS resets
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import locale from 'element-ui/lib/locale/lang/zh-CN'
import App from './App'
import router from './router'
import store from './store'
import '@/icons' // icon
import '@/permission' // 权限
import {default as api} from './utils/api'
import {hasPermission} from "./utils/hasPermission";
import 'bootstrap/dist/js/bootstrap.min.js'
import echarts from 'echarts'

Vue.use(ElementUI, {locale})
Vue.prototype.api = api
//全局的常量
Vue.prototype.hasPerm = hasPermission
Vue.prototype.$echarts = echarts 
//生产环境时自动设置为 false 以阻止 vue 在启动时生成生产提示。
Vue.config.productionTip = (process.env.NODE_ENV != 'production')
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: {App},
  data: function() {
    return {
      userIsLogined: false,
      loginedRoleId: -1,
      username: '',
      unitName:''
    }
  }
})
