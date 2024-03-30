<template>
   <section>
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
          <router-link to="/"><font-awesome-icon :icon="['fas', 'plus']" style="color: #1e1e1e;" @click="$emit('M_isOpen')" /></router-link>
          <font-awesome-icon :icon="['fas', 'trash-can']" style="color: #1e1e1e;" @click="$emit('show_D_Btn')" />
          <font-awesome-icon :icon="['fas', 'pen-to-square']" style="color: #1e1e1e;" />
      </div>
    </nav>
  </section>
</template>

<script>

export default {

}
</script>

<style>

</style>