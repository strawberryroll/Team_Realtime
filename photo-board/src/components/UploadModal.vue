<template>
  <Transition name="modal">
    <div class="black-bg" v-if="Upload_isOpen == true">
      <div class="modal-white-box">
        <!-- modal header -->
        <div class="close-btn" @click="$emit('toggleUploadModal')">
          <font-awesome-icon
            :icon="['fas', 'x']"
            size="xl"
            style="color: #1e1e1e"
          />
        </div>
        <div id="title" class="box-title"><p>UPLOAD</p></div>
        <div class="division-line"></div>
        <!-- modal content-->
        <div class="modal-content">
          <!--Left part-->
          <div class="modal-L">
            <!--photo preview-->
            <div v-if="photo_url" class="modal-imgBox-img center-align">
              <img :src="photo_url" style="width: 100%; height: auto" />
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
              @change="$emit('PhotoSelect', $event)"
            />
          </div>
          <!--Right part-->
          <div class="modal-R">
            <div class="modal-title">
              <p>Title</p>
              <input
                :value="photo_title"
                @input="$emit('update:photo_title', $event.target.value)"
                type="text"
                placeholder="제목을 입력하세요"
                id="modal-input"
              />
            </div>
            <div class="modal-comment">
              <p>Comment</p>
              <textarea
                :value="photo_comment"
                @input="$emit('update:photo_comment', $event.target.value)"
                placeholder="내용을 입력하세요"
                id="modal-textarea"
              ></textarea>
            </div>
            <button class="upload-btn" @click="$emit('PhotoUpload')">
              UPLOAD
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
    Upload_isOpen: Boolean,
    photo_url: String,
    photo_title: String,
    photo_comment: String,
  },
};
</script>

<style>
/* Modal window */
.black-bg {
  width: 100%;
  height: 100%;
  background: rgba(38, 38, 38, 0.9);
  position: fixed;
  padding: 20px;
  z-index: 1000;
}
.modal-white-box {
  position: absolute;
  vertical-align: middle;
  left: 14%;
  right: 0;
  width: 65%;
  height: 68%;
  background: white;
  padding: 40px;
  margin-top: 50px;
  border-radius: 10px;
}
.close-btn {
  position: absolute;
  cursor: pointer;
  top: 0;
  right: 0;
  padding: 35px;
}
.modal-imgBox-img {
  width: 100%;
  height: 75%;
  background: #efeff0;
  float: left;
  margin-top: 25px;
  border-radius: 20px;
}
.modal-content {
  display: flex;
  flex-wrap: nowrap;
  min-height: 100%;

  flex-direction: row;
  box-sizing: border-box;
}
.modal-L {
  display: flex;
  flex-direction: column;
  flex-basis: 35%;
  align-items: center;
}
.modal-R {
  display: flex;
  flex-direction: column;
  flex-basis: 65%;
}
#modal-input {
  width: 500px;
  height: 50px;
  font-size: 15px;
  border: 0;
  border-bottom: 1.5px solid #d3d3d3;
  margin-left: 20px;
}
#modal-textarea {
  width: 540px;
  height: 184px;
  font-size: 15px;
  border: 0;
  background-color: #f5f5f7;
  border-radius: 10px;
  padding: 15px 0 0 20px;
  margin-left: 20px;
}
.modal-title {
  padding: 30px;
  padding-bottom: 0;
}
.modal-comment {
  padding: 30px;
  width: 400px;
}
.upload-btn {
  font-size: 19px;
  font-weight: 700;
  color: #a3a3a3;
  cursor: pointer;
  background-color: transparent;
  border: 0;
  text-align: right;
  margin-top: 5px;
}
.upload-btn:hover {
  color: #1e1e1e;
  transition: 0.5s;
}
.file-btn {
  padding: 20px;
  border: 0;
}
input[type="file"]::file-selector-button {
  font-size: 16px;
  font-weight: 550;
  background: transparent;
  border: 0;
  cursor: pointer;
}
/* modal window animation */
.modal-enter-from {
  opacity: 0;
}
.modal-enter-active {
  transition: all 0.2s;
}
.modal-enter-to {
  opacity: 1;
}
.modal-leave-from {
  opacity: 1;
}
.modal-leave-active {
  transition: all 0.2s;
}
.modal-leave-to {
  opacity: 0;
}
</style>