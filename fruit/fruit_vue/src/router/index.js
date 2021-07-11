import Vue from 'vue'
import VueRouter from 'vue-router'
import Pie from '../views/Pie'
import Bar from '../views/Bar'
import Tabel from "../views/Tabel"
import Edit from "../views/Edit";
import Add from '../views/Add'
import Home from '../views/Home'

Vue.use(VueRouter)

const routes = [
  {
    path: '/home',
    component: Home
  },
  {
    path: '/bar',
    component: Bar
  },
  {
    path: '/pie',
    component: Pie
  },
  {
    path: '/table',
    component: Tabel
  },
  {
    path: '/edit',
    component: Edit
  },
  {
    path: '/add',
    component: Add
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
