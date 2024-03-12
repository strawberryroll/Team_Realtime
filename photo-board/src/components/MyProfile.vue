<template>
  <!-- My Profile -->
  <div class="container">
    <div class="white-box">
      <div id="title" class="box-title"><p>My Profile</p></div>
      <div class="division-line"></div>
      <div id="content" class="box-content">
        <div id="person" class="box-content-circle">
          <font-awesome-icon :icon="['far', 'user']" class="box-content-person" />
        </div>
        <div id="camera">
          <button type="button" id="myprofile-btn" class="myprofile-btn"></button>
        </div>
        <div>
          <div class="content content-name">
            <p>Name</p>
            <input type="text">
          </div>
          <div class="content content-email">
            <p>Email</p>
            <input type="email">
          </div>
          <div class="content content-phone">
              <p>Phone</p>
              <input type="tel">
          </div>
          <div class="content content-about">
              <p>About</p>
              <textarea></textarea>
          </div>
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

</style>