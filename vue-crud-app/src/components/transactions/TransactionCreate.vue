<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Nouvelle transaction</h2>
    <div class="container card">
      <div class="card-header">
        <router-link
            class="btn btn-outline-info float-right"
            to="/"
        >Liste des transactions</router-link>
      </div>
      <div class="card-body">
        <form>
          <!-- Sélection du type de transaction -->
          <div class="form-group">
            <label htmlFor="typeTransaction">Type de transaction</label>
            <select
                class="form-control"
                v-model="transaction.typeTransaction"
                id="typeTransaction"
                name="typeTransaction"
            >
              <option
                  v-for="type in typeTransactions"
                  :key="type.id"
                  :value="type.id"
              >
                {{ type.libelle }}
              </option>
            </select>
          </div>

          <!-- Montant de la transaction -->
          <div class="form-group">
            <label htmlFor="montant">Montant</label>
            <input
                v-model="transaction.montant"
                type="number"
                class="form-control"
                id="montant"
                name="montant"
            />
          </div>

          <!-- Date de la transaction -->
          <div class="form-group">
            <label htmlFor="dateTransaction">Date de transaction</label>
            <input
                v-model="transaction.dateTransaction"
                type="date"
                class="form-control"
                id="dateTransaction"
                name="dateTransaction"
            />
          </div>

          <button
              @click="save()"
              :disabled="isSaving"
              type="button"
              class="btn btn-outline-primary mt-3"
          >
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
import TransactionService from '../../services/TransactionService.js';
import TypeTransactionService from '../../services/TypeTransactionService.js';

export default {
  name: 'TransactionCreate',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      transaction: {
        typeTransaction: null,
        montant: 0,
        dateTransaction: null,
      },
      typeTransactions: [],
      isSaving: false,
    };
  },
  created() {
    this.findAllTypeTransactions();
  },
  methods: {
    save() {
      this.isSaving = true;
      TransactionService.create(this.transaction)
          .then((response) => {
            Swal.fire({
              icon: 'success',
              title: 'Transaction créée avec succès!',
              showConfirmButton: false,
              timer: 1500,
            });
            this.isSaving = false;
            this.transaction = {
              typeTransaction: null,
              montant: 0,
              dateTransaction: null,
            };
            return response;
          })
          .catch((error) => {
            this.isSaving = false;
            Swal.fire({
              icon: 'error',
              title: 'Création de transaction échouée!',
              showConfirmButton: false,
              timer: 1500,
            });
            return error;
          });
    },
    findAllTypeTransactions() {
      this.isSaving = true;
      TypeTransactionService.getAll()
          .then((response) => {
            this.isSaving = false;
            this.typeTransactions = response.data;
          })
          .catch((error) => {
            this.isSaving = false;
            console.error(error);
          });
    },
  },
};
</script>
