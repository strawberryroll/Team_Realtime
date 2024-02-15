<template>

  <!--사이드바-->
  <section id="sidebar">
    <div class ="logo">Real<br>Time</div>
    <div class ="sidebar-hide">
      <font-awesome-icon :icon="['far', 'window-minimize']" style="color: #1e1e1e;" />
    </div>
    <ul class="side-top">
      <a href="#">
          <span class="text">Section 01</span>
      </a>
      <a href="#">
          <span class="text">02</span>
      </a>
      <a href="#">
          <span class="text">03</span>
      </a>
    </ul>

    <div class="menu-sub-title">Menu</div>
    <ul class="side-mid">
      <li>
        <a href="#">
          <div class="text">Home</div>
        </a>
      </li>
      <li>
        <a href="#">
          <div class="text">My Profile</div>
        </a>
      </li>
      <li>
        <a href="#">
          <div class="text">Guest book</div>
        </a>
      </li>
      <li>
        <a href="#">
          <div class="text">About</div>
        </a>
      </li>
    </ul>

    <div class="share-btn">
      <button class="btn">
      <span>share</span>
      <font-awesome-icon style="padding-left:10px; color:var(--black);" :icon="['far', 'share-from-square']" />
      </button>
    </div>
    
    <div class="user-info">
      <div class=user-icon>
        <font-awesome-icon :icon="['fas', 'circle-user']" size="xl" style="color: #b8b8b8;" />    
     </div>         
      <span class="user-name">{{user_name}}</span>
      <div class="logout-icon">
        <a href="#">
        <font-awesome-icon :icon="['fas', 'arrow-right-from-bracket']" />
        </a>
      </div>
    </div>
  </section>

  <!--메인-->
  <section id="main-content">
    <!--NAVBAR 헤더-->
    <nav class="navbar">
      <div class="nav-left">
        <button class="arrow-btn">
          <font-awesome-icon :icon="['fas', 'chevron-left']" style="color: #212121;" />
        </button>
        <button class="arrow-btn">
          <font-awesome-icon :icon="['fas', 'chevron-right']" style="color: #212121;" />
        </button>
      </div>

      <div class="nav-right">
          <font-awesome-icon :icon="['fas', 'plus']" style="color: #1e1e1e;" />
          <font-awesome-icon :icon="['fas', 'trash-can']" style="color: #1e1e1e;" />
          <font-awesome-icon :icon="['fas', 'pen-to-square']" style="color: #1e1e1e;" />
      </div>

      


    </nav>
  </section>
  




</template>

<script>
export default {
  data(){
    return{
      show_sidebar: false,
      user_name : "User_Name",
    }
  },
  methods:{
    
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
}
*{
  background-color: #F5F5F7;
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
/*사이드바*/
.sidebar-hide{
  position: absolute;
  top:0;
  right:0; 
  padding-right: 20px;
  padding-top: 10px;
  font-size: 18px;
}
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
  transition: all 0.5s;
  border-right-style: solid;
  border-right-width: 1px;
  border-color: var(--shadow);

}
#sidebar a {
  color: var(--text-grey);
  text-decoration: none;
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
/*메인*/
#main-content{
  position:fixed;
  width: calc(100% - 280px);
  top: 0;
  height: 58px;
  left: 281px;
  background: var(--cream-white);

}
#main-content .navbar{
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 10px;
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












</style>