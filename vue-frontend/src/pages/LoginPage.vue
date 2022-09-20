<template>
  <div class="login">
    <form @submit.prevent>
      <div v-if="error" class="error">{{error}}</div>
      <input type="text" placeholder="email" v-model="creds.username"/>
      <input type="password" placeholder="password" v-model="creds.password">
<!--      todo: инлайн-стили - зло!-->
      <button style="margin-top: 15px;" @click="login">Войти</button>
    </form>
  </div>
</template>

<script>
import {validEmail} from "@/utils/Validators";

export default {
  name: "LoginPage",
  data() {
    return {
      error: '',
      creds: {
        username: '',
        password: '',
      }
    }
  },
  methods: {
    login() {
      if ((validEmail(this.creds.username)) || (!this.creds.password.isEmpty)) {
        this.$store.dispatch('secureState/login', this.creds)
          .then(() => {this.$router.push('/')})
          .catch(error => console.log(error));
      } else {
        this.error = 'некорректный e-mail или пустой пароль';
      }
    },

  },
}
</script>

<style scoped>
  .login {
    width: 400px;
    margin: auto;

  }
 .error {
   color: red;
 }
  input {
    font: inherit;
    padding: 5px;
    margin-top: 15px;
    outline: none;
    border-color: teal;
  }
  form {
    display: flex;
    flex-direction: column;
  }
</style>