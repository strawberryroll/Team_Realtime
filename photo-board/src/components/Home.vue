<template>
  <div class="home-container">
    <div class="home-white-box">
      <PhotoCard
        :PhotoData="PhotoData"
        :showDeleteButton="showDeleteButton"
        :showEditButton="showEditButton"
        v-for="(PhotoData, index) in filteredPhotoData"
        :key="index"
        :index="index"
        @deletePhotoCard="deletePhotoCard"
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
    showEditButton: Boolean,
  },
  components: {
    PhotoCard,
  },
  computed: {
    filteredPhotoData() {
      // PhotoData 배열을 필터링하여 반환
      return this.PhotoData.filter((photo) => {
        // deleted 속성이 false인 경우에만 반환
        return !photo.deleted;
      });
    },
  },
  methods: {
    deletePhotoCard(index) {
      // PhotoCard.vue에서 전달받은 index 데이터를 App.vue에 전달한다.
      this.$emit("deletePhotoCard", index);
    },
  },
};
</script>

<style>
</style>