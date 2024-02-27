<template>
  <section id="sidebar" v-bind:class="{hide : !isOpen}">
    <div class ="logo">Real<br>Time</div>
    <div class ="sidebar-hide" @click="$emit('isOpen')">
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

</template>

<script>
export default {
    props:{
        isOpen:Boolean,
        user_name:String,
    }

}
</script>

<style>

</style>