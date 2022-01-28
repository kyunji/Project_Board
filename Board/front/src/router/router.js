import Vue from 'vue'
import Router from 'vue-router'
import Hello from '../components/HelloWorld'
import test from '../components/test'

Vue.use(Router) //플러그인 등록

export default new Router({
    mode: 'history',
    routes: [
        
        {
            path: '/Hello',
            component: Hello
        },

        {
            path: '/test',
            component: test
        }
    ]
})

