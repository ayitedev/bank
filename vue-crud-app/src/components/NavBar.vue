<script setup lang="ts">

</script>

<template>

  <header>
    <nav class="flex-between p-4">
      <div>
        <h1 class="text-xl md:text-2xl">MyBank</h1>
      </div>

      <div class="hidden lg:block">
        <ul class="inline-flex space-x-4">
          <li><a href="/">
            Accueil
          </a></li>
          <li>
            <a href="/liste-compte">
              Comptes
            </a>
          </li>
          <li>
            <a href="/liste-transaction">
              Transactions
            </a>
          </li>
        </ul>
      </div>

    </nav>
  </header>
</template>

<style scoped>

nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #2c3e50;
  width: 100%;
  height: 4rem;
  padding: 2rem 1rem;
  color: #f2f2f2;
}

ul {
  list-style: none;
  display: flex;
  gap: 25px;
  align-items: center;
  padding-top: 10px;

}



ul li a {
  text-decoration: none;
  color: #f2f2f2;

}


</style>