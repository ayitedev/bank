<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Éditer Transaction</h2>
    <div class="card">
      <div class="card-header">
        <router-link
            class="btn btn-outline-info float-right"
            to="/">Voir toutes les transactions
        </router-link>
      </div>
      <div class="card-body">
        <form @submit.prevent="save">

          <div class="form-group">
            <label for="montant">Montant</label>
            <input
                v-model="transaction.montant"
                type="number"
                class="form-control"
                id="montant"
                name="montant"
                required />
          </div>

          <div class="form-group">
            <label for="typeTransaction">Type de Transaction</label>
            <select v-model="transaction.typeTransaction" class="form-control" id="typeTransaction" name="typeTransaction" required>
              <option value="" disabled>Choisir un type de transaction</option>
              <option v-for="type in typeTransactions" :key="type.id" :value="type.id">
                {{ type.libelle }}
              </option>
            </select>
          </div>

          <div class="form-group">
            <label for="compte">Compte associé</label>
            <select v-model="transaction.compte" class="form-control" id="compte" name="compte" required>
              <option value="" disabled>Choisir un compte</option>
              <option v-for="compte in comptes" :key="compte.id" :value="compte.id">
                {{ compte.proprietaire }} - {{ compte.balance }}€
              </option>
            </select>
          </div>

          <button
              type="submit"
              :disabled="isSaving"
              class="btn btn-outline-primary mt-3">
            Enregistrer
          </button>
        </form>
      </div>
    </div>
  </layout-div>
</template>

<script>
import LayoutDiv from '../LayoutDiv.vue';
import Swal from 'sweetalert2';
import TransactionService from "../../services/TransactionService.js";
import TypeTransactionService from "../../services/TypeTransactionService.js";
import CompteService from "../../services/CompteService.js";

export default {
  name: 'TransactionEdit',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      transaction: {
        montant: '',
        typeTransaction: '',
        compte: '',
      },
      typeTransactions: [],
      comptes: [],
      isSaving: false,
    };
  },
  created() {
    this.fetchTypeTransactions();
    this.fetchComptes();
    this.loadTransaction();
  },
  methods: {
    // Récupérer les types de transactions
    fetchTypeTransactions() {
      TypeTransactionService.getAll()
          .then(response => {
            this.typeTransactions = response.data;
          })
          .catch(error => {
            Swal.fire({
              icon: 'error',
              title: 'Erreur!',
              text: 'Impossible de récupérer les types de transactions.',
              showConfirmButton: false,
              timer: 1500,
            });
          });
    },

    // Récupérer les comptes
    fetchComptes() {
      CompteService.getAll()
          .then(response => {
            this.comptes = response.data;
          })
          .catch(error => {
            Swal.fire({
              icon: 'error',
              title: 'Erreur!',
              text: 'Impossible de récupérer les comptes.',
              showConfirmButton: false,
              timer: 1500,
            });
          });
    },

    // Charger les détails de la transaction
    loadTransaction() {
      const id = this.$route.params.id;
      TransactionService.get(id)
          .then(response => {
            const trans = response.data;
            this.transaction.montant = trans.montant;
            this.transaction.typeTransaction = trans.typeTransaction.id;
            this.transaction.compte = trans.compte.id;
          })
          .catch(error => {
            Swal.fire({
              icon: 'error',
              title: 'Erreur!',
              text: 'Impossible de charger les informations de la transaction.',
              showConfirmButton: false,
              timer: 1500,
            });
          });
    },

    // Sauvegarder les modifications de la transaction
    save() {
      this.isSaving = true;
      const id = this.$route.params.id;
      TransactionService.update(this.transaction, id)
          .then(response => {
            Swal.fire({
              icon: 'success',
              title: 'Transaction modifiée avec succès!',
              showConfirmButton: false,
              timer: 1500,
            });
            this.isSaving = false;
            this.transaction = { montant: '', typeTransaction: '', compte: '' }; // Réinitialiser le formulaire
          })
          .catch(error => {
            this.isSaving = false;
            Swal.fire({
              icon: 'error',
              title: 'Erreur!',
              text: 'La mise à jour de la transaction a échoué.',
              showConfirmButton: false,
              timer: 1500,
            });
          });
    },
  },
};
</script>
