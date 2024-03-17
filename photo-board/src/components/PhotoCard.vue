<template>
  <div class="home-container">
    <div class="home-white-box">
      <div class="home-imgBox">
        <div class="home-imgBox-img center-align">
          <img :src="`${PhotoData[0].url}`" style="width: 100%; height: auto;">
        </div>
        <div class="home-imgBox-content">
          <p class="margin-0 font-20 font-bold" style="color: #1E1E1E">{{PhotoData[0].title}}</p>
          <p class="font-13 font-semi-bold" style="margin: 2px; color: #6A6A6A;">{{PhotoData[0].date}}</p>
          <p class="font-13" style="color: #393939;">{{PhotoData[0].comment}} </p>
        </div>
        <div class="clear"></div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props:{
    PhotoData:Object,
  }
}
</script>

<style>

</style>