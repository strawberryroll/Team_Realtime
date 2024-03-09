import { createWebHistory, createRouter } from "vue-router";

// components
import MyProfile from '../components/MyProfile.vue';
import Home from '../components/Home.vue';
import GuestBook from '../components/GuestBook.vue';
import About from '../components/About.vue';

const routes = [
  {
    path: '/',
    component: Home,
  },
  {
    path: '/myprofile',
    component: MyProfile,
  },
 
  {
    path: '/guestbook',
    component: GuestBook,
  },
  {
    path: '/about',
    component: About,
  },
  {
    path:'/tstory',
    component: ()=>import('@/components/About.vue'),
    beforeEnter (){
      window.location.href = "https://strawberryroll.tistory.com";
    }
  },
  {
    path:'/git',
    component: ()=>import('@/components/About.vue'),
    beforeEnter (){
      window.location.href = "https://github.com/strawberryroll/Team_Realtime.git";
    }
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router; 