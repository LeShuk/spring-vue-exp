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
import {apiClient, apiUrls} from "@/utils/apiClient";
import {validEmail} from "@/utils/Validators";
import {secureState} from "@/utils/secureState";

export default {
  name: "LoginPage",
  data() {
    return {
      secureState,
      error: '',
      creds: {
        username: '',
        password: '',
      }
    }
  },
  methods: {
    login() {
      console.log('Yeap!')
      if ((!validEmail(this.creds.username)) || (this.creds.password.isEmpty)) {
         this.error = 'некорректный e-mail или пустой пароль';
      } else {
        this.fetchAuth()
      }
    },
    fetchAuth() {
      console.log('Hip-hip!')
      apiClient
          .post(apiUrls['auth'], this.creds)
          .then((response) => {
            secureState.login(response.headers['authorization'], this.creds.username);
            this.$router.push('/');
          })
          .catch((error) => {
            if (error.response.status === 401){
              this.error = error.response.data;
            } else {
              this.error = 'неизвестная ошибка';
              console.log(error)
            }
          })
    }
  },
}
</script>

<style scoped>
  .login {
    width: 600px;
    margin: auto;

  }
 .error {
   color: red;
 }
</style>