<template>
  <div v-if="profiles.length > 0">
    <ul>
      <profile-item
          v-for="profile in profiles"
          :profile="profile"
          :key="profile.id"
      />
    </ul>
  </div>
  <div v-else>
    Список профилей пуст!
  </div>
</template>

<script>
import ProfileItem from "@/components/ProfileItem";
export default {
  name: "ProfileList",
  components: {ProfileItem},
  props: {
    profiles: {
      type: Array,
      required: true,
    }
  }
}
</script>

<style scoped>

</style>