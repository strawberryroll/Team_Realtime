<template>
  <div class="home-container">
    <div class="home-white-box">
      <PhotoCard
        v-for="(PhotoData, index) in filteredPhotoData"
        :PhotoData="PhotoData"
        :showDeleteButton="showDeleteButton"
        :showEditButton="showEditButton"
        :key="index"
        :index="index"
        @deletePhotoCard="deletePhotoCard"
        @toggleEditModal="toggleEditModal"
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
    toggleEditModal(index) {
      // 수정하기 위해 선택된 포토카드의 인덱스를 PhotoCard->Home->App순으로 전달
      this.$emit("toggleEditModal",index);
    },
  },
};
</script>

<style>
</style>