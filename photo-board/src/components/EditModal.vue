<template>
  <Transition name="modal">
    <div class="black-bg" v-if="Edit_isOpen == true">
      <div class="modal-white-box">
        <!-- modal header -->
        <div class="close-btn" @click="$emit('toggleEditModal')">
          <font-awesome-icon
            :icon="['fas', 'x']"
            size="xl"
            style="color: #1e1e1e"
          />
        </div>
        <div id="title" class="box-title"><p>Edit</p></div>
        <div class="division-line"></div>
        <!-- modal content-->
        <div class="modal-content">
          <!--Left part-->
          <div class="modal-L">
            <!--photo preview-->
            <div
              v-if="editedPhotoData.url"
              class="modal-imgBox-img center-align"
            >
              <img
                :src="editedPhotoData.url"
                style="width: 100%; height: auto"
              />
            </div>
            <div v-else class="modal-imgBox-img center-align">
              <font-awesome-icon
                :icon="['fas', 'image']"
                style="color: #c4c4c4; font-size: 4em"
              />
            </div>
            <!--/photo preview-->
            <input
              type="file"
              accept="image/*"
              class="file-btn"
              @change="$emit('PhotoSelect',$event)"
            />
          </div>
          <!--Right part-->
          <div class="modal-R">
            <div class="modal-title">
              <p>Title</p>
              <input
                :value="editedPhotoData.title"
                @input="
                  $emit('update:title', $event.target.value)
                "
                type="text"
                id="modal-input"
              />
            </div>
            <div class="modal-comment">
              <p>Comment</p>
              <textarea
                :value="editedPhotoData.comment"
                @input="
                  $emit('update:comment', $event.target.value)
                "
                id="modal-textarea"
              ></textarea>
            </div>
            <button class="upload-btn" @click="updatePhotoData">
              SAVE
            </button>
          </div>
        </div>
      </div>
    </div>
  </Transition>
</template>

<script>
export default {
  props: {
    Edit_isOpen: Boolean,
    editedPhotoData: Object,
  },
  methods: {
    updatePhotoData() { // editedPhotoData를 App.vue로 전달
      this.$emit('updatePhotoData',this.editedPhotoData);
    },
  },
};
</script>

<style>
</style>