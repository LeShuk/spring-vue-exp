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
import {apiClient} from "@/utils/apiClient";

export default {
  components: {NavBar},
  created() {
    apiClient.interceptors.response.use(undefined, function (error) {
      return new Promise((resolve, reject) => {
        console.log(error);
        if (error.status === 401 && error.config && !error.config.__isRetryRequest) {
          this.$store.dispatch('secureState/logout');
        }
        throw error;
      });
    });
  },
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
