<template>
    <li>
      <strong>id: </strong> {{profile.id}};
      <strong>alias: </strong> {{profile.alias}}
    </li>
</template>

<script>
export default {
  name: "ProfileItem",
  props: {
    profile: {
      type: Object,
      required: true,
    }
  }
}
</script>

<style scoped>

</style>