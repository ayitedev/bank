<template>
  <layout-div>
    <h2 class="text-center mt-5 mb-3">Détails compte</h2>
    <div class="card">
      <div class="card-header">
        <router-link
            class="btn btn-outline-info float-right"
            to="/">Voir tous les comptes
        </router-link>
      </div>
      <div class="card-body">
        <b className="text-muted">Type compte:</b>
        <p>{{compte.typeCompte}}</p>
        <b className="text-muted">Propriétaire:</b>
        <p>{{compte.proprietaire}}</p>
        <b className="text-muted">Balance:</b>
        <p>{{compte.balance}}</p>
      </div>
    </div>
  </layout-div>
</template>

<script>
import LayoutDiv from '../LayoutDiv.vue';
import Swal from 'sweetalert2'
import CompteService from "../../services/CompteService.js";

export default {
  name: 'ProjectShow',
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

  },
};
</script>