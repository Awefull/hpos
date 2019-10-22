<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app',
}
</script>

<style lang="scss">
  @import '~normalize.css/normalize.css';// normalize.css 样式格式化
  @import './styles/index.scss'; // 全局自定义的css样式
  .background-header{
    background-image:url("./assets/banner4.jpg");
    background-size:100% 100%;
  }
  .banner-bg {
    padding: 320px 80px;
    position: relative;
    background: url("./assets/banner4.jpg");
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    z-index: 2;
  }
</style>
