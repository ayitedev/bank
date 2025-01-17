<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Détails Transaction</h2>
    <div class="card">
      <div class="card-header">
        <router-link
            class="btn btn-outline-info float-right"
            to="/">Voir toutes les transactions
        </router-link>
      </div>
      <div class="card-body">
        <b class="text-muted">Date de la transaction:</b>
        <p>{{ transaction.date }}</p>

        <b class="text-muted">Montant:</b>
        <p>{{ transaction.montant }} €</p>

        <b class="text-muted">Type de transaction:</b>
        <p>{{ transaction.typeTransaction.libelle }}</p>

        <b class="text-muted">Compte associé:</b>
        <p>{{ transaction.compte.proprietaire }}</p>
      </div>
    </div>
  </layout-div>
</template>

<script>
import LayoutDiv from '../LayoutDiv.vue';
import Swal from 'sweetalert2';
import TransactionService from "../../services/TransactionService.js";

export default {
  name: 'TransactionShow',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      transaction: {
        date: '',
        montant: '',
        typeTransaction: '',
        compte: '',
      },
      isSaving: false,
    };
  },
  created() {
    const id = this.$route.params.id; // Récupérer l'ID de la transaction depuis l'URL
    TransactionService.get(id) // Récupérer les détails de la transaction via le service
        .then(response => {
          let trans = response.data;
          this.transaction.date = trans.date;
          this.transaction.montant = trans.montant;
          this.transaction.typeTransaction = trans.typeTransaction;
          this.transaction.compte = trans.compte;
          return response;
        })
        .catch(error => {
          Swal.fire({
            icon: 'error',
            title: 'Erreur!',
            text: 'Impossible de récupérer les détails de la transaction.',
            showConfirmButton: false,
            timer: 1500
          });
          return error;
        });
  },
};
</script>
