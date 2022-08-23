<template>
  <div
      v-if="show"
      @click="hideModalBackdrop"
      class="modal">
    <div
        @click.stop
        class="modal-content"
    >
      <div class="modal-header">
          <slot name="modal-header"></slot>
      </div>
      <div class="modal-body">
        <slot></slot>
      </div>
      <div class="modal-footer">
        <slot name="modal-footer"></slot>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Modal",
  expose: ['hideModal'],
  props: {
    show: {  /*Показать/скрыть модальное окно*/
      type: Boolean,
      default: false,
    },
    backdrop: { /*Закрывать ли окно при клике вне окна*/
      type: Boolean,
      default: true,
    },
  },
  methods: {
    hideModal() {
       this.$emit('update:show', false)
    },
    hideModalBackdrop() {
      if (this.backdrop) this.hideModal();
    }
  }
}
</script>

<style scoped>
.modal {
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  display: flex;
}

.modal-content {
  margin: auto;
  background: white;
  border-radius: 10px;
  min-height: 50px;
  min-width: 300px;
}

.modal-header {
  padding: 10px 10px 0 10px;
  margin-bottom: 10px;
}

.modal-body {
  padding: 10px;
}

.modal-footer {
  padding: 0 10px 10px 10px;
  margin-top: 10px;
}
</style>