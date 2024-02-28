import { createWebHistory, createRouter } from "vue-router";
// components
import MyProfile from '../components/MyProfile.vue';

const routes = [
  {
    path: '/myprofile',
    component: MyProfile,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router; 