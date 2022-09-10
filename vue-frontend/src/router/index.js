import { createRouter, createWebHistory } from 'vue-router'
import HomePage from "@/pages/HomePage";
import ProfilePage from "@/pages/ProfilePage";
import LoginPage from "@/pages/LoginPage";

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomePage
  },
  {
    path: '/profiles',
    name: 'profiles',
    component: ProfilePage
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
})

export default router
