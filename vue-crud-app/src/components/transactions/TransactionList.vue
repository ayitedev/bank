<template>
  <layout-div>
    <div class="container">
      <h2 class="text-center mt-5 mb-3">Liste des transactions</h2>
      <div class="card">
        <div class="card-header">
          <router-link to="/create-transaction"
                       class="btn btn-outline-primary"
          >Nouvelle transaction
          </router-link>
        </div>
        <div class="card-body">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th>Date</th>
              <th>Montant</th>
              <th>Type de transaction</th>
              <th>Compte</th>
              <th width="240px">Action</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="t in transactions" :key="t.id">
              <td>{{ t.date }}</td>
              <td>{{ t.montant }}</td>
              <td>{{ t.typeTransaction.libelle }}</td>
              <td>{{ t.compte.proprietaire }}</td>
              <td>
                <router-link :to="`/transaction/${t.id}`" class="btn btn-outline-info mx-1">Détails</router-link>
                <router-link :to="`/edit-transaction/${t.id}`" class="btn btn-outline-success mx-1">Éditer</router-link>
                <button
                    @click="supprimer(t.id)"
                    class="btn btn-outline-danger mx-1">
                  Supprimer
                </button>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </layout-div>
</template>

<script>
import LayoutDiv from '../LayoutDiv.vue';
import Swal from 'sweetalert2';
import TransactionService from "../../services/TransactionService.js";

export default {
  name: 'TransactionList',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      transactions: [],
    };
  },
  created() {
    this.getAllTransactions();
  },
  methods: {
    // Récupérer toutes les transactions
    getAllTransactions() {
      TransactionService.getAll()
          .then(response => {
            this.transactions = response.data;
          })
          .catch(error => {
            Swal.fire({
              icon: 'error',
              title: 'Erreur!',
              text: 'Impossible de récupérer les transactions.',
              showConfirmButton: false,
              timer: 1500,
            });
          });
    },

    // Supprimer une transaction
    supprimer(id) {
      Swal.fire({
        title: 'Etes-vous sûr?',
        text: "Cette transaction sera supprimée définitivement!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Oui, supprimer!'
      }).then((result) => {
        if (result.isConfirmed) {
          TransactionService.delete(id)
              .then(response => {
                Swal.fire({
                  icon: 'success',
                  title: 'Transaction supprimée avec succès!',
                  showConfirmButton: false,
                  timer: 1500
                });
                this.getAllTransactions(); // Actualiser la liste des transactions
              })
              .catch(error => {
                Swal.fire({
                  icon: 'error',
                  title: 'Erreur!',
                  text: 'La suppression de la transaction a échoué.',
                  showConfirmButton: false,
                  timer: 1500
                });
              });
        }
      });
    },
  },
};
</script>
