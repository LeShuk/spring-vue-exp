import { createRouter, createWebHistory } from 'vue-router'
import HomePage from "@/Pages/HomePage";
import ProfilePage from "@/Pages/ProfilePage";

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
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
