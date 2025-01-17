import { createRouter , createWebHistory } from "vue-router";
import CompteCreate from "../components/comptes/CompteCreate.vue";
import CompteList from "../components/comptes/CompteList.vue";
import TransactionCreate from "@/components/transactions/TransactionCreate.vue";
import Dashbord from "@/components/Dashbord.vue";
import TransactionEdit from "@/components/transactions/TransactionEdit.vue";
import TransactionDetail from "@/components/transactions/TransactionDetail.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', component: Dashbord },
        { path: '/create-transaction', component: TransactionCreate },
        { path: '/liste-transaction', component: TransactionCreate },
        { path: '/liste-compte', component: CompteList },
        { path: '/create-compte', component: CompteCreate },
        { path: '/edit/:id', component: TransactionEdit },
        { path: '/show/:id', component: TransactionDetail },
    ],
})




export default router;