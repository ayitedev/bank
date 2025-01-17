
<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Editer compte</h2>
    <div class="card">
      <div class="card-header">
        <router-link
            class="btn btn-outline-info float-right"
            to="/">Voir tous les comptes
        </router-link>
      </div>
      <div class="card-body">
        <form>
          <div class="form-group">
            <label htmlFor="typeCompte">Type compte</label>
            <input
                v-model="compte.typeCompte"
                type="text"
                class="form-control"
                id="name"
                name="name"/>
          </div>
          <div class="form-group">
            <label htmlFor="proprietaire">Propriétaire</label>
            <input
                v-model="compte.proprietaire"
                type="text"
                class="form-control"
                id="name"
                name="name"/>
          </div>
          <div class="form-group">
            <label htmlFor="balance">Balance</label>
            <input
                v-model="compte.balance"
                type="number"
                class="form-control"
                id="name"
                name="name"/>
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

export default {
  name: 'ProjectEdit',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      compte: {
        typeCompte: '',
        proprietaire: '',
        balance: '',
      },
      isSaving:false,
    };
  },
  created() {
    const id = this.$route.params.id;
    CompteService.get(id)
        .then(response => {
          let compt = response.data
          this.compte.typeCompte = compt.typeCompte
          this.compte.proprietaire = compt.proprietaire
          this.compte.balance = compt.balance
          return response
        })
        .catch(error => {
          Swal.fire({
            icon: 'error',
            title: 'Erreur!',
            showConfirmButton: false,
            timer: 1500
          })
          return error
        })
  },
  methods: {
    save() {
      this.isSaving = true
      const id = this.$route.params.id;
      CompteService.update(this.compte, id)
          .then(response => {
            Swal.fire({
              icon: 'success',
              title: 'Compte modifié avec succès!',
              showConfirmButton: false,
              timer: 1500
            })
            this.isSaving = false
            this.compte.typeCompte = ""
            this.compte.proprietaire = ""
            this.compte.balance = ""
            return response
          })
          .catch(error => {
            this.isSaving = false
            Swal.fire({
              icon: 'error',
              title: 'Erreur!',
              showConfirmButton: false,
              timer: 1500
            })
            return error
          });
    },
  },
};
</script>