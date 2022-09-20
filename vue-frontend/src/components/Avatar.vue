<template>
  <div class="avatar">
    {{this.text}}
  </div>
</template>

<script>
export default {
  name: "Avatar",
  props: {
    alternativeText: {
      type: String,
      required: true
    },
  //  todo: предусмотреть передачу размера аватара.
  },
  data() {
    return {
      text: '',
    }
  },
  mounted() {
    this.text = this.$props.alternativeText;
  }
}
</script>

<style scoped>
.avatar {
  width:150px;
  height: 150px;
  font-size: 400%;
  border-radius: 50%;
  box-shadow: 0 0 0 3px green, 0 0 13px #333;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 10px;
 }
</style>