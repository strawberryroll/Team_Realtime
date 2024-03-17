<template>
<PhotoCard :PhotoData="PhotoData" />

 
</template>

<script>
import PhotoCard from './PhotoCard.vue'
export default {
  props:{
    PhotoData:Array,
  },
  components:{
    PhotoCard,
  }
  
}
</script>

<style>

</style>