<template>
  
  <!--사이드바-->
  <Sidebar @isOpen="toggleSidebar" :user_name="user_name" :isOpen="isOpen"/>

   <!--NAVBAR 헤더-->
  <Header/>

  <!--main content-->
  <section id="main-content">
    <router-view></router-view>
  </section>

</template>

<script>
// components
import Sidebar from './components/Sidebar.vue';
import Header from './components/Header.vue';

export default {
  data(){
    return{
      isOpen: false,
      user_name : "User_Name",
    }
  },
  components:{
    Sidebar,
    Header,
  },
  methods:{
    toggleSidebar(){
      this.isOpen = !this.isOpen;
    },
  }

}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=DM+Sans:ital,opsz,wght@0,9..40,100..1000;1,9..40,100..1000&display=swap');

:root{
  --cream-white : #FCFCFC;
  --black : #1E1E1E;
  --grey : #F8F8F8;
  --text-grey : #A3A3A3;
  --shadow : hsla(221, 12%, 68%, 0.247);
}
html,body{
  height: 100%;
  width: 100%;
  margin: 0;
  overflow: hidden;
}
#app{
  height: 100%;
  width: 100%;
  display: flex;
}
*{
  font-family: "DM Sans", sans-serif;
  padding: 0;
}
li{
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
#sidebar.hide{
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
#sidebar.hide .side-top{
  transform: rotate(-90deg);
  margin: 0;
  width: 200px;
  height: 173px;
  margin-top: -25px;
}
#sidebar.hide .user-info{
  transform: rotate(-90deg);
}
#sidebar.hide .user-name{
  padding-left: 15px;
}
/*사이드바-열림*/
#sidebar{
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
.sidebar-hide{
  position: absolute;
  top:0;
  right:0; 
  padding-right: 33px;
  padding-top: 10px;
  font-size: 18px;
}
#sidebar .text:hover{
  color:var(--black);
}
#sidebar .side-top {
  margin: 30px;
}
#sidebar .side-top .text{
    padding-inline-start: 0;
    padding: 7px;
    font-weight: 570;
}
#sidebar .side-mid li{
  height: 47px;
  margin-left: 20px;
}
.btn{
  background: white;
  color: var(--black);
  border-style: solid;
  border-width: 1px;
  border-color: var(--shadow);
  border-radius: 20px;
  padding: 6px 45px;
  font-size: 15px;
}
.btn:hover{
  background-color: var(--darkgrey);
  transition: 0.7s; 
}
.share-btn{
  text-align: center;
  padding-top: 20px;
  border-top: solid 1px var(--shadow);
}
.user-info{
  display: flex;
  position: absolute;
  bottom: 70px;
  padding: 0;
  flex-direction: row;
  justify-content: space-between;
  width: 60%;
}
.logout-icon :hover{
  color:black;
}
.user-name{
  font-size: 15px;
  font-weight: 500;
}
.menu-sub-title{
  font-weight: 550;
}
/*navbar*/
.navbar{
  position:fixed;
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

.arrow-btn{
  background: white;
  color: var(--black);
  border-style: solid;
  border-width: 1px;
  border-color: var(--shadow);
  border-radius: 100%;
  padding: 10px 15px;
  font-size: 15px;
}
.arrow-btn:hover{
  background-color: var(--darkgrey);
  transition: 0.5s; 
}
.nav-left{
  margin-left: 16px;
}
.nav-right{
  display: flex;
  justify-content: space-between;
  font-size: 18px;
  width: 100px;
  margin-right: 20px;
}
/*main-content*/
#main-content{
  display: flex;
  flex: 1;
  background-color: #F5F5F7;
}
/* Home */
.home-container {
  display: flex;
  align-items: center; 
  width: 100%;
  height: 100%;
}
.home-white-box {
  position: absolute;
  vertical-align: middle;
  left: 10%;
  right: 0;
  width: 80%;
  height: 70%;
  padding: 40px;
  margin-top: 60px;
  border-radius: 10px;
}
.home-imgBox {
    width: 40%;
    height: 50%;
    border-radius: 15px;
    overflow: hidden; /* 부모 요소를 기준으로 자식 요소가 넘치지 않도록 설정 */
}
.home-imgBox-img {
    width: 45%;
    height: 100%;
    background: #EFEFF0;
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
  background-color: #F5F5F7;
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
  background: transparent;
}
.profile-img {
  position: absolute;
  top: 80px;
  background: transparent;
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
    height: 30px;;
    font-size: 15px;
    border: 0;
    border-bottom: 1.5px solid #D3D3D3;
}
textarea {
    width: 520px;
    height: 100px;
    font-size: 15px;
    border: 0;
    background-color: #F5F5F7;
    border-radius: 10px;
    padding: 15px 0 0 20px;
}
.myprofile-btn {
    position: absolute;
    top: 410px;
    left: 350px;
    height: 50px;
    width: 50px;
    border-radius: 50%;
    border: 0;
    background-color: white;
    background-image: url("./assets/icon/camera.png");
    background-size: 60%;
    background-repeat: no-repeat;
    background-position: center;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.3);
}
.myprofile-btn:hover {
  opacity: 0.7; 
}

</style>
