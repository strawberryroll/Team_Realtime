<template>
  <!-- Sidebar -->
  <Sidebar @isOpen="toggleSidebar" :user_name="user_name" :isOpen="isOpen" />

  <!-- NAVBAR Header --> 
  <Header :M_isOpen="M_isOpen" @M_isOpen="toggleModal" @deletePhotocard="deletePhotoCard" @show_D_Btn="toggleDeleteButton" />

  <!-- main content -->
  <section id="main-content">
    <router-view :key="update_key" :showDeleteButton="showDeleteButton"></router-view>
  </section>

  <!-- Modal Window -->
  <Transition name="modal">
    <div class="black-bg" v-if="M_isOpen == true">
      <div class="modal-white-box">
        <!-- modal header -->
        <div class="close-btn" @click="toggleModal">
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
              @change="PhotoSelect"
            />
          </div>
          <!--Right part-->
          <div class="modal-R">
            <div class="modal-title">
              <p>Title</p>
              <input
                v-model="photo_title"
                type="text"
                placeholder="제목을 입력하세요"
                id="modal-input"
              />
            </div>
            <div class="modal-comment">
              <p>Comment</p>
              <textarea
                v-model="photo_comment"
                placeholder="사진 설명을 입력하세요"
                id="modal-textarea"
              ></textarea>
            </div>
            <button class="upload-btn" @click="PhotoUpload">UPLOAD</button>
          </div>
        </div>
      </div>
    </div>
  </Transition>
  <!-- /Modal Window -->
</template>

<script>
import PhotoData from "./PhotoData.js";
// components
import Sidebar from "./components/Sidebar.vue";
import Header from "./components/Header.vue";

export default {
  data() {
    return {
      update_key:0,
      isOpen: false, // 사이드바 오픈 여부
      M_isOpen: false, // 모달창 오픈 여부
      user_name: "User_Name",
      photo_url: "", // 업로드 할 사진의 url
      PhotoData: PhotoData, // 업로드 사진에 대한 정보
      photo_comment:"",
      photo_title:"",
      photo_date:"",
      showDeleteButton: false, // 삭제 버튼 보임 여부
    };
  },
  components: {
    Sidebar,
    Header,
  },
  methods: {
    toggleSidebar() {
      this.isOpen = !this.isOpen;
    },
    toggleModal() {
      this.M_isOpen = !this.M_isOpen;
    },
    PhotoSelect(e) {
      let photo = e.target.files;
      let url = URL.createObjectURL(photo[0]);
      console.log(url);
      this.photo_url = url;
    },
    GetDate() {
      const currentDate = new Date();
      const year = currentDate.getFullYear();
      const month = String(currentDate.getMonth() + 1).padStart(2, "0"); // 월은 0부터 시작하므로 +1 해줌
      const day = String(currentDate.getDate()).padStart(2, "0");
      this.photo_date = `${year}-${month}-${day}`;
    },
    PhotoUpload() { // 사용자가 입력한 사진 정보를 PhotoData.js에 저장하는 함수 
      this.GetDate();
      let NewData = {
        title: this.photo_title,
        comment: this.photo_comment,
        url: this.photo_url,
        date: this.photo_date,
      };
      this.PhotoData.unshift(NewData);
      this.update_key++;
      this.toggleModal();
      
    },
    toggleDeleteButton() { 
      this.showDeleteButton = !this.showDeleteButton;
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&display=swap");

:root {
  --cream-white: #fcfcfc;
  --black: #1e1e1e;
  --grey: #f8f8f8;
  --text-grey: #a3a3a3;
  --shadow: hsla(221, 12%, 68%, 0.247);
}
html,
body {
  height: 100%;
  width: 100%;
  margin: 0;
  overflow: hidden;
}
#app {
  height: 100%;
  width: 100%;
  display: flex;
}
* {
  font-family: "DM Sans", sans-serif;
  padding: 0;
}
li {
  list-style: none;
}
.logo {
  font-size: 21px;
  text-align: left;
  line-height: 14.5px;
  margin-top: 25px;
  font-style: italic;
  font-weight: 500;
}
/*사이드바-닫힘*/
#sidebar.hide {
  width: 47px;
}
#sidebar.hide .logo,
#sidebar.hide .menu-sub-title,
#sidebar.hide .side-mid,
#sidebar.hide .share-btn,
#sidebar.hide .logout-icon {
  visibility: hidden;
  transition: all 0s;
}
#sidebar.hide .side-top {
  transform: rotate(-90deg);
  margin: 0;
  width: 200px;
  height: 173px;
  margin-top: -25px;
}
#sidebar.hide .user-info {
  transform: rotate(-90deg);
}
#sidebar.hide .user-name {
  padding-left: 15px;
}
/*사이드바-열림*/
#sidebar {
  position: relative;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 20px;
  width: 240px;
  height: 100%;
  background: white;
  overflow: hidden;
  z-index: 100;
  border-right-style: solid;
  border-right-width: 1px;
  border-color: var(--shadow);
  transition: 0.5s;
}

#sidebar a {
  color: var(--text-grey);
  text-decoration: none;
}
.sidebar-hide {
  position: absolute;
  cursor: pointer;
  top: 0;
  right: 0;
  padding-right: 33px;
  padding-top: 10px;
  font-size: 18px;
}
#sidebar .text:hover {
  color: var(--black);
}
#sidebar .side-top {
  margin: 30px;
}
#sidebar .side-top .text {
  padding-inline-start: 0;
  padding: 7px;
  font-weight: 570;
}
#sidebar .side-mid li {
  height: 47px;
  margin-left: 20px;
}
.btn {
  background: white;
  color: var(--black);
  border-style: solid;
  border-width: 1px;
  border-color: var(--shadow);
  border-radius: 20px;
  padding: 6px 45px;
  font-size: 15px;
}
.btn:hover {
  background-color: var(--darkgrey);
  transition: 0.7s;
}
.share-btn {
  text-align: center;
  padding-top: 20px;
  border-top: solid 1px var(--shadow);
}
.user-info {
  display: flex;
  position: absolute;
  bottom: 70px;
  padding: 0;
  flex-direction: row;
  justify-content: space-between;
  width: 60%;
}
.logout-icon :hover {
  color: black;
}
.user-name {
  font-size: 15px;
  font-weight: 500;
}
.menu-sub-title {
  font-weight: 550;
}
/*navbar*/
.navbar {
  position: fixed;
  width: calc(100% - 89px);
  top: 0;
  height: 65px;
  left: 89px;
  background: var(--cream-white);
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: var(--cream-white);
}

.arrow-btn {
  background: white;
  color: var(--black);
  border-style: solid;
  border-width: 1px;
  border-color: var(--shadow);
  border-radius: 100%;
  padding: 10px 15px;
  font-size: 15px;
}
.arrow-btn:hover {
  background-color: var(--darkgrey);
  transition: 0.5s;
}
.nav-left {
  margin-left: 16px;
}
.nav-right {
  display: flex;
  cursor: pointer;
  justify-content: space-between;
  font-size: 18px;
  width: 100px;
  margin-right: 20px;
}
/*main-content*/
#main-content {
  display: flex;
  flex: 1;
  background-color: #f5f5f7;
}
/* Home */
.home-container {
  display: flex;
  align-items: center;
  width: 100%;
  height: 100%;
}
.home-white-box {
  display: flex;
  left: 10%;
  right: 0;
  width: 100%;
  height: 75%;
  border-radius: 10px;
  margin-left: 50px;
  flex-wrap: wrap; /* 요소들이 Flex 컨테이너 내에서 여러 줄에 걸쳐 자동으로 나열되도록 설정 */
}
.home-white-box > *{
  flex: 0 0 calc(90% /3);
}
.home-imgBox {
  width: 40%;
  height: 50%;
  margin: 12px;
  border-radius: 15px;
  overflow: hidden; /* 부모 요소를 기준으로 자식 요소가 넘치지 않도록 설정 */
}
.btn-delete-minus {
  float: right;
  margin-top: -48px;
  margin-right: -25px;
}
.home-imgBox-img {
  width: 45%;
  height: 100%;
  background: #efeff0;
  border-top-left-radius: 15px;
  border-bottom-left-radius: 15px;
  float: left; /* float 속성으로 가로정렬 */
}
.home-imgBox-content {
  width: 55%;
  height: 100%;
  padding: 60px 40px;
  border-top-right-radius: 15px;
  border-bottom-right-radius: 15px;
  background: white;
  float: left;
  box-sizing: border-box; /* padding 값이 요소의 너비에 포함되도록 box-sizing 설정 */
}
.clear {
  clear: both; /* float 다음에 오는 박스들이 제자리를 찾게 됨 */
  float: none; /* 나중에 생길 버그예방차원 */
}
.margin-0 {
  margin: 0;
}
.font-20 {
  font-size: 20px;
}
.font-13 {
  font-size: 13px;
}
.font-bold {
  font-weight: bold;
}
.font-semi-bold {
  font-weight: 600;
}
.center-align {
  display: flex;
  justify-content: center;
  align-items: center;
}
/* My Profile */
.container {
  display: flex;
  align-items: center;
  width: 100%;
  height: 100%;
}
.white-box {
  position: absolute;
  vertical-align: middle;
  left: 10%;
  right: 0;
  width: 80%;
  height: 70%;
  background: white;
  padding: 40px;
  margin-top: 60px;
  border-radius: 10px;
}
.box-title {
  position: absolute;
  top: 10px;
  font-size: 30px;
}
.division-line {
  border-top: 1px solid #dcdfe3;
  margin-top: 55px;
}
.box-content {
  padding-top: 40px;
  width: 100%;
  height: 70%;
  background: transparent; /* 해당 요소의 배경투명 */
}
.box-content-circle {
  position: relative;
  width: 28%;
  height: 90%;
  border-radius: 50%;
  background: #efefef;
  margin-top: 30px;
  margin-left: 70px;
  overflow: hidden;
}
.box-content-person {
  position: absolute;
  color: #c4c4c4;
  font-size: 8em;
  left: 33%;
  top: 28%;
}
.content {
  position: absolute;
  top: 120px;
}
.content-name {
  left: 600px;
}
.content-email {
  left: 900px;
}
.content-phone {
  left: 600px;
  top: 250px;
}
.content-about {
  left: 600px;
  top: 380px;
}
input {
  width: 200px;
  height: 30px;
  font-size: 15px;
  border: 0;
  border-bottom: 1.5px solid #d3d3d3;
}
textarea {
  width: 520px;
  height: 100px;
  font-size: 15px;
  border: 0;
  background-color: #f5f5f7;
  border-radius: 10px;
  padding: 15px 0 0 20px;
}
.myprofile-btn {
  position: absolute;
  height: 70px;
  width: 70px;
  top: 410px;
  left: 350px;
  border-radius: 50%;
  border: 0;
  background-color: white;
  background-image: url('data:image/svg+xml;utf8,<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><!--!Font Awesome Free 6.5.1 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license/free Copyright 2024 Fonticons, Inc.--><path d="M149.1 64.8L138.7 96H64C28.7 96 0 124.7 0 160V416c0 35.3 28.7 64 64 64H448c35.3 0 64-28.7 64-64V160c0-35.3-28.7-64-64-64H373.3L362.9 64.8C356.4 45.2 338.1 32 317.4 32H194.6c-20.7 0-39 13.2-45.5 32.8zM256 192a96 96 0 1 1 0 192 96 96 0 1 1 0-192z"/></svg>');
  background-size: 40%;
  background-repeat: no-repeat; /* 배경 이미지 반복 제거 */
  background-position: center; /* 배경 이미지 위치를 가운데로 설정 */
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}
.myprofile-btn:hover {
  opacity: 0.7;
}

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
