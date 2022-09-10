<template>
<div class="navbar">
<!-- todo: in-line стили - зло.-->
  <div @click="$router.push('/')" style="padding-right: 15px">
    Spring&Vue
  </div>
  <div>
    <button @click="$router.push('/profiles')" >Профили</button>
    <button v-if="!secureState.isAuth" @click="$router.push('/login')">Войти</button>
    <button v-if="secureState.isAuth" @click="() => {secureState.logout(); $router.push('/login')}">Выйти</button>
  </div>
</div>
</template>

<script>
import {secureState} from "@/utils/secureState";

export default {
  name: "NavBar",
  data() {
    return {
      secureState,
    }
  }
}
</script>

<style scoped>
.navbar {
  height: 50px;
  background-color: #393a34;
  color: white;
  display: flex;
  align-items:center;
  padding: 0 15px;
}
</style>