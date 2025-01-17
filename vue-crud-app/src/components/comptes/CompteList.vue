
<template>
  <layout-div>
    <div class="container">
      <h2 class="text-center mt-5 mb-3">Liste des comptes</h2>
      <div class="card">
        <div class="card-header">
          <router-link to="/create-compte"
                       class="btn btn-outline-primary"
          >Nouveau compte
          </router-link>
        </div>
        <div class="card-body">

          <table class="table table-bordered">
            <thead>
            <tr>
              <th>Type compte</th>
              <th>Propriétaire</th>
              <th>Balance</th>
              <th width="240px">Action</th>
            </tr>
            </thead>
            <tbody>

            <tr v-for="c in comptes" :key="c.id">
              <td>{{c.typeCompte.libelle}}</td>
              <td>{{c.proprietaire}}</td>
              <td>{{c.balance}}</td>
              <td>
                <router-link :to="`{c.id}`" class="btn btn-outline-info mx-1">Détails</router-link>
                <router-link :to="`/edit/${c.id}`" class="btn btn-outline-success mx-1">Editer</router-link>
                <button
                    @click="supprimer(c.id)"
                    className="btn btn-outline-danger mx-1">
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
import axios from 'axios';
import LayoutDiv from '../LayoutDiv.vue';
import Swal from 'sweetalert2'
import compteService from "../../services/CompteService.js";
import CompteService from "../../services/CompteService.js";

export default {
  name: 'CompteList',
  components: {
    LayoutDiv,
  },
  data() {
    return {
      comptes:[],
    };
  },
  created() {
    this.getAllComptes();
  },
  methods: {
    getAllComptes() {
      CompteService.getAll()
          .then(response =>{
            this.comptes = response.data;
          })
          .catch(error => {
            return error
          });
    },
    supprimer(id){
      Swal.fire({
        title: 'Etes vous sur?',
        text: "Ce compte sera suprimé pour toujours!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Oui, supprimer  le!'
      }).then((result) => {
        if (result.isConfirmed) {
          compteService.delete(this.compte.id)
              .then( response => {
                Swal.fire({
                  icon: 'success',
                  title: 'Compte supprimé avec succès!',
                  showConfirmButton: false,
                  timer: 1500
                })
                this.getAllComptes();
                return response
              })
              .catch(error => {
                Swal.fire({
                  icon: 'error',
                  title: 'An Error Occured!',
                  showConfirmButton: false,
                  timer: 1500
                })
                return error
              });
        }
      })
    }
  },
};
</script>