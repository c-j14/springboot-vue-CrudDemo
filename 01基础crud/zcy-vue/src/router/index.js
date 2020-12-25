import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
import Crud from '@/components/Crud'

Vue.use(Router)

export default new Router({
  routes: [
  // 下面都是固定的写法
    {
      path: '/crud',
      name: 'Crud',
      component: Crud
    }
  ]
})
