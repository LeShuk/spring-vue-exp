<template>
<div class="navbar">
<!-- todo: in-line стили - зло.-->
  <div @click="$router.push('/')" style="padding-right: 15px">
    Spring&Vue
  </div>
  <div class="light">
    <button v-if="isAuth" @click="$router.push('/profile')">Профиль</button>
    <button v-if="!isAuth" @click="$router.push('/registration')">Регистрация</button>
    <button v-if="!isAuth" @click="$router.push('/login')">Вход</button>
    <button v-if="isAuth" @click="logout">Попрощаться</button>

  </div>
</div>
</template>

<script>

export default {
  name: "NavBar",
  computed: {
    isAuth() {
      return this.$store.getters['secureState/isAuth'];
    }
  },
  methods: {
    logout() {
      this.$store.dispatch('secureState/logout')
        .then(() => {this.$router.push('/login')})
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
.light button {
  background: lightgray;
  margin: 0 5px;
}
</style>