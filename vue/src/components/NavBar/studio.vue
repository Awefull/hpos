<template>
 <div>
  <div class="w3ls-header"><!--header-one--> 
	<div class="w3ls-header-left">
	    <p><router-link to="/index" style="color:white" class="dropdown-toggle">
        发猿地</router-link></p>
	</div>
    <div class="w3ls-header-right">		
        <ul>
          <li class="dropdown head-dpdn">
                  <router-link to="/modifyInfo" style="color:white" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                  个人中心</router-link>
                </li> 
                <li class="dropdown head-dpdn">             
                  <router-link to="/studioManageUnrecruited" style="color:white" class="dropdown-toggle"><i class="fa fa-percent" aria-hidden="true"></i>
                  项目管理</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                  <router-link to="/classify"  style="color:white" class="dropdown-toggle"><i class="fa fa-comment" aria-hidden="true"></i>
                  查看项目列表</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <router-link to="/advertisement" style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  申请广告位</router-link> 
                <li class="dropdown head-dpdn">
                  <router-link to="/help" style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  联系我们</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <a style="color:white"  @click="loginOut" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  退出登录</a>
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
  },
  methods: {
    loginOut(){
      this.$confirm('您即将退出, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          // this.$message({
          //   type: 'success',
          //   message: '已退出'
          // });
          this.$root.userIsLogined = false;
          this.$root.loginedRoleId = -1;
          this.$router.push({
            path: "/index",
            query: {
            }
          });
        }).catch(() => {
          // this.$message({
          //   type: 'info',
          //   message: '已取消退出'
          // });          
        });     
    }
  },
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>

@import '~@/styles/bootstrap.css';
@import '.~@/styles/style.css';
@import '.~@/styles/style2.css';
@import '~@/styles/font-awesome.css';

</style>
