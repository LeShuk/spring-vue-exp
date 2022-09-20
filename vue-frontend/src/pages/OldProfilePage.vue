<template>
  <div>
    <h1>Список профилей</h1>
    <button @click="() => {this.dialogVisible = true}">
      Новый профиль...
    </button>
    <profile-list
        :profiles="profiles"
    />
    <modal
        v-model:show="dialogVisible"
        :backdrop="false"
        ref="modal"
    >
      <template #modal-header>
        Заголовок окна
      </template>
      <profile-form
          ref="form"
          @create="addProfile"
      />
      <template #modal-footer>
        <button @click="this.$refs.form.createProfile()">Добавить профиль</button>
        <button @click="this.$refs.modal.hideModal()">Закрыть</button>
      </template>
    </modal>
  </div>
</template>

<script>
import ProfileList from "@/components/ProfileList";
import ProfileForm from "@/components/ProfileForm";
import Modal from "@/components/UI/Modal";
import {apiClient, apiUrls} from "@/utils/apiClient";

export default {
  name: "OldProfilePage",
  components: {Modal, ProfileForm, ProfileList},
  data() {
    return {
      profiles: [],
      dialogVisible: false,
    }
  },
  methods: {
    fetchProfiles() {
      apiClient
          .get(apiUrls['profiles'])
          .then((response) => {
            this.profiles = response.data
          })
          .catch((error) => {
            console.log(error)
          })
      // try {
      //   const response = await axios.get(apiPath()+ 'profiles', {
      //     params: {}
      //   });
      //   this.profiles = response.data;
      // } catch (e) {
      //   alert('Списка нет. Бекенд не работает. Ну, или кто-то накосячил в коде...')
      // }
    },
    async addProfile(profile) {
      console.log(profile);
      // try {
      //   const response = await axios.post(apiPath() + 'profiles', profile);
      //   await this.fetchProfiles();
      //   this.$refs.modal.hideModal();
      // } catch (e) {
      //   alert('Добавление не удалось')
      // }
    }
  },
  mounted() {
    this.fetchProfiles();
  }
}
</script>

<style scoped>

</style>