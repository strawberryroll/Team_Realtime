<template>
  <div class="container">
    <div class="white-box">
        <div id="title" class="box-title"><p>About</p></div>
        <div class="division-line"></div>
        <div id="content" class="box-content">
            <div class="about-text">
                <div>제작</div>
                <div>Team RealTime</div>
            </div>
            <div class="about-icon">
                <font-awesome-icon :icon="['fab', 'github']" />
                <img src="../assets/icon/tstory.png" width="3%">
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
.about-text{
  font-size: 22px;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: left;

}

.about-icon{
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>