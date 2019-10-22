<template>
<div>
  <div class="w3ls-header"><!--header-one--> 
			<div class="w3ls-header-left">
				<p><router-link to="/index" target="_blank" style="color:white" class="dropdown-toggle">
        发猿地</router-link></p>
			</div>
      <div class="w3ls-header-right">
				<ul>
          <li class="dropdown head-dpdn">
                  <router-link to="/modifyInfo" target="_blank" style="color:white" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                  个人中心</router-link>
                </li> 
                <li class="dropdown head-dpdn">             
                  <router-link to="/help" target="_blank" style="color:white" class="dropdown-toggle"><i class="fa fa-percent" aria-hidden="true"></i>
                  项目管理</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                  <a href="contact.html" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>申请广告位</a>
                </li> 
                <li class="dropdown head-dpdn">
                  <router-link to="/help" target="_blank" style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  联系我们</router-link>
                </li>
         </ul>      
			</div>
			<div class="clearfix"> </div> 
      </div>	
</div>
</template>


<script>
import $ from 'jquery';
import img_1 from"@/images/1.jpg";

export default {
  data() {
    return {
      radio4:'上海',
      img_1
    };
  },
  computed: {
    message() {
      return "页面找不到了......";
    }
  }
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>

@import '~@/styles/bootstrap.css';
@import '.~@/styles/style.css';
@import '.~@/styles/style2.css';
@import '~@/styles/font-awesome.css';

</style>
