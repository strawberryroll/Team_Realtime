<template>
  <div v-if="isVisible && !PhotoData.deleted" class="home-imgBox">
    <!-- PhotoCard가 삭제되지 않은 경우에 보여줌 -->
    <div class="home-imgBox-img center-align">
      <img :src="`${PhotoData.url}`" style="width: 100%; height: auto" />
    </div>
    <div class="home-imgBox-content">
      <font-awesome-icon
        v-if="showDeleteButton"
        :icon="['fas', 'circle-minus']"
        style="color: #b8b8b8"
        class="fa-2x btn-delete-minus"
        @click="deletePhotoCard"
      />
      <font-awesome-icon
        v-if="showEditButton"
        :icon="['fas', 'circle-check']"
        style="color: #b8b8b8"
        size="2xl"
        class="btn-edit-circle"
      />
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
    showEditButton: Boolean,
    index: Number,
  },
  data() {
    return {
      isVisible: true, // PhotoCard 보임에 대한 여부
    };
  },
  methods: {
    deletePhotoCard() {
      // 삭제버튼(btn-minus)을 눌렀을 때 해당 PhotoCard의 index가 deletePhotoCard 메서드를 통해 Home.vue로 전달되며, PhotoCard를 화면에서 안보이게 한다.
      this.$emit("deletePhotoCard", this.index, this.PhotoData); // 삭제 이벤트를 상위 컴포넌트(Home.vue)로 전달
      //this.PhotoData.deleted = true; // PhotoData 객체의 deleted 속성을 true로 설정하여 삭제된 것으로 표시. 코드 실행에 오류가 있어서 주석 처리 및 위 40번째 코드로 옮김
      this.isVisible = false; // 화면에서 안보이게 함
    },
  },
};
</script>

<style>
</style>