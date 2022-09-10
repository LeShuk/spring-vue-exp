import axios from "axios";

const backendUrl = 'http://localhost:8080/api'


export let apiClient;
apiClient = axios.create({
    baseURL: backendUrl
})
const jwt = localStorage.getItem('jwt');
if (jwt) {
    apiClient.defaults.headers.common['Authorization'] = jwt;
}


export const apiUrls = [];
apiUrls['auth'] = '/auth';
apiUrls['profiles'] = '/profiles';

