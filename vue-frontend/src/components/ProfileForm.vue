<template>
  <form @submit.prevent>
    <input
        v-model="profile.name"
        type="text"
        placeholder="Имя">
    <input
        v-model="profile.surname"
        type="text"
        placeholder="Фамилия">
    <input
        v-model="profile.alias"
        type="text"
        placeholder="Алиас">
    <input
        v-model="profile.email"
        type="email"
        placeholder="E-mail">
    <input
        v-model="profile.password"
        type="password"
        placeholder="Пароль">
<!--    <input-->
<!--        v-model="confirmPassword"-->
<!--        type="password"-->
<!--        placeholder="Подтверждение пароля">-->
  </form>
</template>

<script>
export default {
  name: "ProfileForm",
  data() {
    return {
      profile: {
        name: '',
        surname: '',
        alias: '',
        email: '',
        password: '',
      },
      confirmPassword: '',
    }
  },
  props: {
  },
  methods: {
    createProfile() {
      this.$emit('create', this.profile);
      this.profile = {
        name: '',
        surname: '',
        alias: '',
        email: '',
        password: '',
      };
    }
  },
}
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
}
</style>