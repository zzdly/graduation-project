// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import  'element-ui/lib/theme-chalk/index.css'

import Cookies from 'js-cookie' //导入js-cookie工具
Vue.prototype.$cookie = Cookies;

import axios from 'axios';//导入发送请求工具
Vue.prototype.$axios = axios;

import moment from 'moment'//日期格式转换工具
Vue.prototype.$moment = moment;


Vue.use(ElementUI)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
