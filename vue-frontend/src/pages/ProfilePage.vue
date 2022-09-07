<template>
  <div>
    <!--    todo: inline-стили - зло!-->
    <div style="justify-content: space-between" class="d-flex">
      <div>
        <Avatar alternative-text="LS"/>
      </div>
      <div style="display: flex; flex-direction: column">
        <button @click="editProfile">{{ isEdit ? 'Сохранить изменения' : 'Изменить профиль' }}</button>
        <button v-if="!isEdit" @click="changePassword">Сменить пароль</button>
        <button v-if="isEdit" @click="cancel">Отмена</button>
      </div>
    </div>
    <Profile :profile="profile" :is-edit="isEdit"/>

  </div>
</template>

<script>
import Profile from "@/components/Profile";
import Avatar from "@/components/Avatar";

export default {
  name: "ProfilePage",
  components: {Avatar, Profile},
  data() {
    return {
      profile: {
        id: 0,
        name: "Алексей",
        surname: "Костырев",
        alias: "LeShuk",
        email: "ak@leshuk.pro",
        password: "123321",
      },
      old_profile: {
        name: '',
        surname: '',
        alias: '',
      },
      isEdit: false,
    }
  },
  methods: {
    editProfile() {
      if (this.isEdit) {
        alert("Функционал пока не предусмотрен, но вы держитесь...")
      } else {
        this.old_profile.name = this.profile.name;
        this.old_profile.surname = this.profile.surname;
        this.old_profile.alias = this.profile.alias;
        this.isEdit = true;
      }
    },
    changePassword() {
      alert("Функционал пока не предусмотрен, но вы держитесь...")
    },
    cancel() {
      this.profile.name = this.old_profile.name;
      this.profile.surname = this.old_profile.surname;
      this.profile.alias = this.old_profile.alias;
      this.isEdit = false;
    }
  }
}
</script>

<style scoped>
button {
  margin-bottom: 5px;
}
</style>