import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Signup from '../components/Signup.vue'
//import VueRouter from 'vue-router'
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.


    //component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    component: About
  },


  //추가: Signup page
  {
    path: '/signup',
    name: 'Signup',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    
    
    //component: () => import(/* webpackChunkName: "about" */ '../components/Signup.vue')
    component:Signup
  },

]


const router = createRouter({
  //mode:'history',
  history: createWebHistory(),
  routes
})

export default router
