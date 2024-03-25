<template>
  <div class="home-imgBox">
    <div class="home-imgBox-img center-align">
      <img :src="`${PhotoData.url}`" style="width: 100%; height: auto" />
    </div>
    <div class="home-imgBox-content">
      <font-awesome-icon v-if="showDeleteButton" :icon="['fas', 'circle-minus']" style="color: #b8b8b8;" class="fa-2x btn-delete-minus" />
      <p class="margin-0 font-20 font-bold" style="color: #1e1e1e">
        {{ PhotoData.title }}
      </p>
      <p class="font-13 font-semi-bold" style="margin: 2px; color: #6a6a6a">
        {{ PhotoData.date }}
      </p>
      <p class="font-13" style="color: #393939">{{ PhotoData.comment }}</p>
    </div>
    <div class="clear"></div>
  </div>
</template>

<script>
export default {
  props: {
    PhotoData: Object,
    showDeleteButton: Boolean,
  },
};
</script>

<style>


</style>