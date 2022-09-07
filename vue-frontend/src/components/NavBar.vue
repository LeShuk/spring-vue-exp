<template>
<div class="navbar">
<!-- todo: in-line стили - зло.-->
  <div @click="$router.push('/')" style="padding-right: 15px">
    Spring&Vue
  </div>
  <div class="light">
    <button @click="$router.push('/profiles')" >Профили</button>
    <button @click="$router.push('/profile')">Профиль</button>
    <button @click="$router.push('/registration')">Регистрация</button>
  </div>
</div>
</template>

<script>
export default {
  name: "NavBar"
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
.light button {
  background: lightgray;
  margin: 0 5px;
}
</style>