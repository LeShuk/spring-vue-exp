import {reactive} from "vue";
import axios from "axios";
import {apiClient} from "@/utils/apiClient";

export const secureState = reactive({
    isAuth: false,
    jwt: localStorage.getItem('jwt') || '',
    user: {},

    login(jwt, user) {
        this.isAuth = true;
        this.jwt = jwt;
        localStorage.setItem('jwt', jwt);
        apiClient.defaults.headers.common['Authorization'] = jwt;
        this.user = user;
    },
    logout() {
        this.isAuth = false;
        this.jwt = '';
        localStorage.removeItem('jwt');
        //todo: не работает!!!
        delete apiClient.defaults.headers.common['Authorization'];
        this.user = {};
    },

})