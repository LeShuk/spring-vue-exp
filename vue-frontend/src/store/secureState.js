import {apiClient, apiUrls} from "@/utils/apiClient";

export const secureState = {
    state: () => {
        return {
            status: '',
            jwt: localStorage.getItem('jwt') || '',
            user: {},
        }
    },
    getters: {
        isAuth(state){
          return !!state.jwt;
        } ,
        authStatus(state) {
            return state.status;
        }
    },
    mutations: {
        auth_request(state) {
            state.status = 'authorization';
        },
        auth_success(state, jwt, user) {
            state.status = 'success';
            state.jwt = jwt;
            state.user = user;
        },
        auth_error(state){
            state.status = 'error';
        },
        logout(state){
            state.status = '';
            state.jwt = '';
        }
    },
    actions: {
        login({commit}, user) {
            return new Promise((resolve, reject) => {
                commit('auth_request');
                apiClient
                    .post(apiUrls['auth'], user)
                    .then(response => {
                        //todo: заголовок приходит с маленькой буквы!!! Почему?
                        const jwt = response.headers['authorization'];
                        // const user = user;

                        console.log(response.headers);
                        localStorage.setItem('jwt', jwt);
                        apiClient.defaults.headers.common['Authorization'] = jwt;
                        commit('auth_success', jwt, user);
                        resolve(response)
                    })
                    .catch(error => {
                        commit('auth_error');
                        localStorage.removeItem('jwt');
                        reject(error);
                    })

            })
        },
        logout({commit}) {
            return new Promise((resolve, reject) =>{
                commit('logout');
                localStorage.removeItem('jwt');
                delete apiClient.defaults.headers.common['Authorization'];
                resolve();
            })
        }
    },
    namespaced: true,
}