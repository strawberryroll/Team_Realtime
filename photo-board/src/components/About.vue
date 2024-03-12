<template>
  <div class="container">
    <div class="white-box">
        <div id="title" class="box-title"><p>About</p></div>
        <div class="division-line"></div>
        <div id="content" class="about-box-content">
            <div class="about-text">
<<<<<<< Updated upstream
                <div class="about-text-1">제작</div>
                <div class="about-text-2">Team RealTime</div>
=======
                <div class="about-text1">제작</div>
                <div class="about-text2">Team RealTime</div>
>>>>>>> Stashed changes
            </div>
            <div class="about-icon">
                <router-link to="/git" target="_blank">
                  <font-awesome-icon :icon="['fab', 'github']" size="xl"/>
                </router-link>
                <router-link to="/tstory" target="_blank" >
                  <img src="../assets/icon/tstory.png" width="20px">
                </router-link>
            </div>
            
        </div>
    </div>
  </div>
</template>

<script>
export default {
}
</script>

<style>
.about-box-content{
  padding-top: 40px;
  width: 100%;  
  height: 70%;
  display: flex;
  flex-direction: column;
<<<<<<< Updated upstream
  align-items: center;
  justify-content: center;
}
.about-icon a{
  flex: 1;
  padding-left:33px;
  padding-right:33px;
  color: inherit;
}
.about-text-1{
  font-size: 18px;
}
.about-text-2{
  font-weight: 800;
  margin-top: 5px;
  font-size: 31px;
=======
  align-content: center;
  justify-content: center;
}

.about-text1{
  text-align: justify
}
.about-text2{
  text-align: justify
>>>>>>> Stashed changes
}
.about-icon{
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding-top: 18px;
  width: 200px;
}
</style>