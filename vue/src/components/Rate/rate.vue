
<template>
	<div class="Rating" :value='value'>
      <a class="Rating-list" v-for="s in 5" :key="s" @click="changeRate(s)">
          <i :class="s <= star ? 'el-icon-star-on':'el-icon-star-off'" :style='style'></i>
      </a>
      <slot></slot> <!--显示用户自定义内容-->
    </div>
</template>

<script>
  export default {
    props: { 
    size: { //父组件传值设置字体大小
        type: String,
        default: '20px'
        },
    value: { //绑定value，与$emit实现双向绑定
      // type:String,
      default:0 
         }
    },
    data() {
        return {
            star: this.value, // 初始化
            style: {
            fontSize: this.size //通过prop传值设置星星字体大小
            }
        }
        },
    methods: {
    changeRate(s) {
            this.star = s //更新当前星星数量
            this.$emit('input', s); //将当前星星数量s与v-model绑定
        }
    }
  }
</script>