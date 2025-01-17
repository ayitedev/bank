<template>
  <layout-div>
  <div class="container">
  <div class="card">
    <div class="card-header">
      <h3>Comptes</h3>
    </div>
    <div class="card-body">
      <p class="card-content">22</p>
    </div>

  </div>

  <div class="card">
    <div class="card-header">
      <h3>Transactions</h3>
    </div>
    <div class="card-body">
      <p class="card-content">10</p>
    </div>
  </div>
  </div>
  </layout-div>
</template>


<script>
import CompteList from "./comptes/CompteList.vue";
import LayoutDiv from "./LayoutDiv.vue";

export default {
  name: "DashboardCard",
  components: {LayoutDiv, CompteList},
  props: {
    title: {
      type: 'Comptes',
      required: true
    },
    content: {
      type: 'Transactions',
      required: true
    },
    footerInfo: {
      type: String,
      required: false,
      default: ''
    }
  }
};
</script>

<style scoped>
/* Card container styles */
.card {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  width: 250px;
  margin: 20px;
  transition: transform 0.3s ease;
}

.card:hover {
  transform: translateY(-5px);
}



.container {
  display: flex;
  margin-top: 20px;
  justify-content: center;
  gap: 20px;
}

/* Card header styles */
.card-header {
  background-color: #3498db;
  color: black;
  padding: 15px;
  font-size: 18px;
  font-weight: bold;
}

/* Card body styles */
.card-body {
  padding: 20px;
  font-size: 16px;
}

.card-content {
  color: #555;
  font-size: larger;
  font-weight: bold;
  text-align: center;

}


</style>
