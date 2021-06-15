<template>
  <BoardForm v-bind:editing="true" />
</template>

<script>
import BoardForm from '@/components/BoardForm.vue';

export default {
    components: {
        BoardForm,
    }
}
</script>

<style>

</style>