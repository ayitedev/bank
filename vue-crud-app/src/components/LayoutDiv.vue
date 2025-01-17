<template>
  <div >
    <NavBar/>
    <slot></slot>
  </div>
</template>

<script>

import NavBar from "../components/NavBar.vue";
import SideBar from "./SideBar.vue";


export default {
  name: 'LayoutDiv',
  components: {SideBar, NavBar},
};
</script>