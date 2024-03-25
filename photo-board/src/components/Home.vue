<template>
  <div class="home-container">
    <div class="home-white-box">
      <PhotoCard
        :PhotoData="PhotoData"
        :showDeleteButton="showDeleteButton" 
        v-for="(PhotoData, i) in PhotoData"
        :key="i"
      />
    </div>
  </div>
</template>

<script>
import PhotoCard from "./PhotoCard.vue";
export default {
  props: {
    PhotoData: Array,
    showDeleteButton: Boolean,
  },
  components: {
    PhotoCard,
  },
};
</script>

<style>
</style>