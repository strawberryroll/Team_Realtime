import { createWebHistory, createRouter } from "vue-router";
// components
import MyProfile from '../components/MyProfile.vue';
import Home from '../components/Home.vue';
import GuestBook from '../components/GuestBook.vue';
import About from '../components/About.vue';

const routes = [
  {
    path: '/myprofile',
    component: MyProfile,
  },
  {
    path: '/home',
    component: Home,
  },
  {
    path: '/guestbook',
    component: GuestBook,
  },
  {
    path: '/about',
    component: About,
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router; 