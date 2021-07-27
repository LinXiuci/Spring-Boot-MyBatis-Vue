import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'

/* 全局样式  */
import './assets/css/overall-situation.css'

Vue.config.productionTip = false
Vue.use(ElementUI)

Vue.prototype.$http=axios
axios.defaults.baseURL="http://localhost:8888/"

Vue.config.productionTip=false
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
