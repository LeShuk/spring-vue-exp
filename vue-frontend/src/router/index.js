import {createRouter, createWebHistory} from 'vue-router'
import HomePage from "@/pages/HomePage";
import OldProfilePage from "@/pages/OldProfilePage";
import RegistrationPage from "@/pages/RegistrationPage";
import ProfilePage from "@/pages/ProfilePage";
import LoginPage from "@/pages/LoginPage";
import store from "@/store"

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomePage
  },
  {
    path: '/profiles',
    name: 'profiles',
    component: OldProfilePage
  },
  {
    path: '/profile',
    name: 'profile',
    component: ProfilePage,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: '/registration',
    name: 'registration',
    component: RegistrationPage
  },
  {
    path: '/login',
    name: 'login',
    component: LoginPage
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
});

router.beforeEach((to, from, next) => {
  if(to.matched.some(record => record.meta.requiresAuth)) {
    if (store.getters["secureState/isAuth"]) {
      next();
      return;
    }
    next('/login');
    } else {
    next();
  }
});

export default router
