import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error=> error)
}

export default new Router({
  routes: [
    {
      path:'/test',
      name:'test',
      component:()=>import('../components/test')
    },
    {
      path: '/',
      name: 'Login',
      component:()=>import('../components/Login'),
    },
    {
      path: '/home',
      name: 'Home',
      component:()=>import('../components/Home'),
      children:[
        {
          path:'/personalCenter',
          name:'PersonalCenter',
          component:()=>import('../components/PersonalCenter')
        },
        {
          path: '/scoreQuery',
          name: 'ScoreQuery',
          component:()=>import('../components/ScoreQuery')
        },
        {
          path:'/classInformation',
          name:'classInformation',
          component:()=>import('../components/ClassInformation')
        },
        {
          path:'/changePassword',
          name:'changePassword',
          component:()=>import('../components/ChangePassword')
        },
        {
          path:'/gardePointAverageQuery',
          name:'gardePointAverageQuery',
          component:()=>import('../components/gradePointAverageQuery')
        },
        {
          path:'/collegeInform',
          name:'collegeInform',
          component:()=>import('../components/CollegeInform')
        },
        {
          path:'/classInform',
          name:'classInform',
          component:()=>import('../components/ClassInform')
        },
        {
          path:'/examInform',
          name:'examInform',
          component:()=>import('../components/ExamInform')
        },
      ]
    },
    {
      path:'/teacherHome',
      name:'teacherHome',
      component:()=>import('../components/TeacherHome'),
      children:[

      ]
    }
  ]
})
