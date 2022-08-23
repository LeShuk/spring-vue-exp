import { createApp } from 'vue'
import App from './App.vue'
import router from "@/router";

const app = createApp(App);

export const apiPath = () => {
    return 'http://localhost:8080/api/'
}
app
    .use(router)
    .mount('#app')
