import { createRouter, createWebHistory } from "vue-router";
import CompteCreate from "../components/comptes/CompteCreate.vue";
import CompteList from "../components/comptes/CompteList.vue";
import TransactionCreate from "@/components/transactions/TransactionCreate.vue";
import TransactionList from "@/components/transactions/TransactionList.vue";  // Ajouter la route pour la liste des transactions
import Dashbord from "@/components/Dashbord.vue";
import TransactionEdit from "@/components/transactions/TransactionEdit.vue";
import TransactionDetail from "@/components/transactions/TransactionDetail.vue";

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', component: Dashbord },
        { path: '/create-transaction', component: TransactionCreate },
        { path: '/liste-transaction', component: TransactionList },  // Modifier cette route
        { path: '/liste-compte', component: CompteList },
        { path: '/create-compte', component: CompteCreate },
        { path: '/edit-transaction/:id', component: TransactionEdit },  // Spécifier la route d'édition des transactions
        { path: '/show-transaction/:id', component: TransactionDetail },  // Spécifier la route de détail des transactions
    ],
});

export default router;
