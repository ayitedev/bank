import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';


import process from "process";
import router from "@/router/router.js";


axios.defaults.baseURL = process.env.VUE_APP_API_URL
axios.interceptors.request.use(function (config) {
    config.headers['X-Binarybox-Api-Key'] = process.env.VUE_APP_API_KEY;
    return config;
});




createApp(App).use(router).mount('#app')
