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
          <font-awesome-icon :icon="['fas', 'plus']" style="color: #1e1e1e;" @click="$emit('M_isOpen')" />
          <font-awesome-icon :icon="['fas', 'trash-can']" style="color: #1e1e1e;" />
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