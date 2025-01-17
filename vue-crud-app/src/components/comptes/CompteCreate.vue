<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Nouveau compte</h2>
    <div class="container card">
      <div class="card-header">
        <router-link
            class="btn btn-outline-info float-right"
            to="/">Liste des comptes
        </router-link>
      </div>
      <div class="card-body">
        <form>

          <div class="form-group">
            <label htmlFor="typeCompte">Type compte</label>
            <select class="form-control"  v-model="compte.typeCompte" id="type" name="typeCompte">
              <option v-for="type in typeComptes" :key="type.id" :value="type.id">
                {{ type.libelle }}
              </option>
            </select>
          </div>

          <div class="form-group">
            <label htmlFor="proprietaire">Propriétaire</label>
            <input
                v-model="compte.proprietaire"
                type="text"
                class="form-control"
                id="proprietaire"
                name="proprietaire"/>
          </div>

          <div class="form-group">
            <label htmlFor="balance">Balance</label>
            <input
                v-model="compte.balance"
                type="number"
                class="form-control"
                id="balance"
                name="balance"/>
          </div>

          <button
              @click="save()"
              :disabled="isSaving"
              type="button"
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
import Swal from 'sweetalert2'
import CompteService from "../../services/CompteService.js";
import TypeCompteService from "../../services/TypeCompteService.js";

export default {
  name: 'CompteCreate',
  components: {
    LayoutDiv,
  },
  data() {

    return {
      compte: {
        typeCompte: null,
        proprietaire: '',
        balance: 0,

      },
      typeComptes : [],
      isSaving:false,
    };
  },

  created(){
    this.findAllTypeComptes();
  },



  methods: {


    save() {
      this.isSaving = true
      CompteService.create(this.compte)
          .then(response => {
            Swal.fire({
              icon: 'success',
              title: 'Compte crée avec succès!',
              showConfirmButton: false,
              timer: 1500
            })
            this.isSaving = false
            this.compte.proprietaire = ""
            this.compte.balance = ""
            this.compte.typeCompte = ""
            return response
          })
          .catch(error => {
            this.isSaving = false
            Swal.fire({
              icon: 'error',
              title: 'Création de compte échouée!',
              showConfirmButton: false,
              timer: 1500
            })
            return error
          });
    },


    findAllTypeComptes() {
      this.isSaving = true
      TypeCompteService.getAll()
          .then(response => {
            this.isSaving = false
            this.typeComptes = response.data;
          })
          .catch(error => {
            return error
          });
    },
  },
};
</script>