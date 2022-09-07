<template>
  <!--   todo: реализовать механизм сокрытия навбара?-->
  <NavBar/>
  <div class="app">
    <router-view>

    </router-view>
  </div>
</template>
<script>
import NavBar from "@/components/NavBar";

export default {
  components: {NavBar}
}
</script>
<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

.app {
  padding: 20px;
}

.d-flex {
  display: flex;
}

button {
  padding: 10px 15px;
  background: none;
  border: 1px solid teal;
}


</style>
