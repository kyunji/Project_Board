import Vue from 'vue'
import Router from 'vue-router'
import signup from '../components/signup'
import board from '../components/Board'

Vue.use(Router) //플러그인 등록

export default new Router({
    mode: 'history',
    routes: [
        
        
        {
            path: '/board',
            component: board
        },

        {
            path: '/signup',
            component: signup
        }
    ]
})

