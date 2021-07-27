import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import Home from '../components/Home.vue'
Vue.use(VueRouter)

const routes = [{
    path: '/',
    name: 'Index',
    component: Index,
    redirect:"/home",
    children:[
      {
        path: '/home',
        name: 'home',
        component:Home
      },
      {
        path: '/user',
        name: 'User',
        component:() => import('../components/admin/UserList.vue')
      }
    ]
  },

  {
    path: '/login',
    name: 'Login',
    component: () => import('../components/Login.vue')
  },

]

const router = new VueRouter({
  routes
})
/**
 *挂载路由导航守卫
 * to：将要访问
 * from：从哪访问
 * next：接着 next(url)重定向到 url 上 next() 继续访问 to 路径
 */
router.beforeEach((to,from,next)=>{
  if (to.path=='/login') {
    return next();
  }
  //获取user
  const userFlag = window.sessionStorage.getItem("user");//取出当前用户
  if (!userFlag) {
    return next('/login');  //无值，返回登录页
  }else{
    next(); //放行
  }

})
export default router