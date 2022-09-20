<template>
    <div>
      <label for="profile_id">id: </label>
      <input
          type="text"
          id="profile_id"
          class="input-plaintext"
          readonly
          v-model="l_profile.id"/>
    </div>

    <div>
      <label for="profile_name">Имя: </label>
      <input
          type="text"
          id="profile_name"
          v-bind:class="isEdit ? '':'input-plaintext'"
          v-bind:readonly="!isEdit"
          v-model="l_profile.name"/>
    </div>

    <div>
      <label for="profile_surname">Фамилия: </label>
      <input
          type="text"
          id="profile_surname"
          v-bind:class="isEdit ? '':'input-plaintext'"
          v-bind:readonly="!isEdit"
          v-model="l_profile.surname"/>
    </div>

    <div>
      <label for="profile_alias">Никнейм: </label>
      <input
          type="text"
          id="profile_alias"
          v-bind:class="isEdit ? '':'input-plaintext'"
          v-bind:readonly="!isEdit"
          v-model="l_profile.alias"/>
    </div>

    <div>
      <label for="profile_email">E-mail: </label>
      <input
          type="text"
          id="profile_email"
          class="input-plaintext"
          readonly
          v-model="l_profile.email"/>
    </div>

    <div>
      <label for="profile_password">Пароль: </label>
      <input
          type="text"
          id="profile_password"
          class="input-plaintext"
          readonly
          v-model="l_profile.password"/>
    </div>
</template>

<script>
export default {
  name: "Profile",
  props: {
    profile: {
      type: Object,
      required: true
    },
    isEdit: {
      type: Boolean,
      required: false,
      default: true,
    }
  },
  data() {
    return {
      l_profile: {
        name: '',
        surname: '',
        alias: '',
        email: '',
        password: '',
      }
    }
  },
  mounted() {
    if (this.$props.profile) {
      this.l_profile=this.$props.profile;
    }
  }
}
</script>

<style scoped>
label {
  min-width: 100px;
  margin: auto;
  text-align: right;
}
input {
  font: inherit;
  width: 90%;
  padding: 5px;
  margin: 10px;
  outline: none;
}
.input-plaintext {
  background-color: transparent;
  border: none;
}

div {
  display: flex;
}
</style>