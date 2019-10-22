<template>
  <div>
    <div class="header background-header">
      <div class="w3ls-header">
        <div class="row"> 
          <div class="col-md-1">
            <div class="w3ls-header-left">
              <p><a href="#">hr_and_project_outsourcing_platform</a></p>
            </div>
          </div>
          <div class="col-md-3">
          </div>
          <div class="col-md-2">
            <form action="#" method="post" class="center">
              <input class="search2" name="Search" placeholder="请输入需求描述" required="">
              <button type="submit" class="btn btn-default" aria-label="Left Align">
                <i class="fa fa-search" aria-hidden="true"> </i>
              </button>  
            </form>      
          </div>
          <div class="col-md-6">     
            <div class="w3ls-header-right">             
              <!-- 工作室(学生) -->
              <ul v-if="this.$root.loginedRoleId =='2'">
                <li class="dropdown head-dpdn">
                  <router-link to="/modifyInfo"  style="color:white" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                  个人中心</router-link>
                </li> 
                <li class="dropdown head-dpdn">             
                  <router-link to="/studioManageUnrecruited"  style="color:white" class="dropdown-toggle"><i class="fa fa-percent" aria-hidden="true"></i>
                  项目管理</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                  <router-link to="/classify"  style="color:white" class="dropdown-toggle"><i class="fa fa-comment" aria-hidden="true"></i>
                  查看项目列表</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <router-link to="/advertisement"  style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                申请广告位</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                  <router-link to="/help" style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  联系我们</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <a style="color:white"  @click="loginOut" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  退出登录</a>
                </li>
              </ul>
              <!-- 企业 -->
              <ul v-if="this.$root.loginedRoleId =='3'">
                <li class="dropdown head-dpdn">
                   <router-link to="/modifyInfo"  style="color:white" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                  个人中心</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                   <router-link to="/companyManageUnrecruited"  style="color:white" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                  项目管理</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <router-link to="/studioinfo"  style="color:white" class="dropdown-toggle"><i class="fa fa-comment" aria-hidden="true"></i>
                  工作室信息</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <router-link to="/demand" style="color:white" class="dropdown-toggle"><i class="fa fa-cloud-upload" aria-hidden="true"></i>
                发布需求</router-link>
                </li>  
                <li class="dropdown head-dpdn">
                  <router-link to="/advertisement" style="color:white" class="dropdown-toggle"><i class="fa fa-gift" aria-hidden="true"></i>
                  广告位申请</router-link>
                </li> 
                <li class="dropdown head-dpdn">
                  <router-link to="/help" style="color:white" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  联系我们</router-link>
                </li>
                <li class="dropdown head-dpdn">
                  <a style="color:white"  @click="loginOut" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
                  退出登录</a>
                </li>
              </ul>
              <!--viewer -->
              <ul v-if="this.$root.userIsLogined == false">
                <li class="dropdown head-dpdn">
                  <el-button  type="primary" icon="edit" @click="showLogin"><i class="fa fa-user" aria-hidden="true"></i>登录</el-button>
                    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible1" style="display: none;width:60%;margin:10px 300px 10px" >
                    <el-form autoComplete="on" :model="loginForm" :rules="loginRules" ref="loginForm" class="small-space" label-position="left" label-width="80px"
                            style='width: 300px; margin-left:50px;'>
                      <el-form-item prop="username" label="账号" required>
                        <el-input type="text" v-model="loginForm.username" autoComplete="on"></el-input>
                      </el-form-item>
                      <el-form-item label="密码" prop="password"  required>
                        <el-input type="password" @keyup.enter.native="handleLogin" v-model="loginForm.password" autoComplete="on"></el-input>
                      </el-form-item>
                    </el-form>
                    <div slot="footer" class="dialog-footer">
                      <el-row>
                         <el-col :span="6">
                          <div>&nbsp;
                          </div>
                         </el-col>
                         <!-- <el-col :span="12"> -->
                          <el-button type="submit" :loading="loading" @click.native.prevent="handleLogin" style="border: none;outline: none;cursor: pointer;color: #fff;background: #0280e1;
                       width: 42%;padding: 0.8em 1em;font-size: 1em;margin: -3em 12.5em 0.8em -1.5em;-webkit-transition:.5s all;-moz-transition:.5s all;
	                    -o-transition:.5s all;-ms-transition:.5s all;transition:.5s all;text-transform: uppercase;-webkit-appearance:none;">
                          登 录</el-button>
                        <!-- </el-col> -->
                        <!-- <el-col :span="6">
                          <el-button @click="dialogFormVisible1 = false" style="border: none;outline: none;cursor: pointer;color: #fff;background: #0280e1;
                          font-size: 1em;margin:-20em 24em 0.8em 0em;-webkit-transition:.5s all;-moz-transition:.5s all;
                          -o-transition:.5s all;-ms-transition:.5s all;transition:.5s all;text-transform: uppercase;-webkit-appearance:none;">
                          取消</el-button>
                        </el-col> -->
                      </el-row>
                      <el-row>
                        <el-col :span="2"><el-checkbox v-model="checked" style="margin:1em 0em -2em">记住密码</el-checkbox></el-col>
                        <el-col :span="6"><div style="margin:1em -25em -2em"><router-link to="/myWallet">忘记密码?</router-link></div></el-col>
                      </el-row>
                      <!-- <el-checkbox v-model="checked" style="right:145px;margin: 1em 15em 1em">记住密码</el-checkbox>
                      <router-link to="/myWallet" style="margin: -5em 1em -2em">忘记密码</router-link>
                      <el-button style="color:#000" @click="dialogFormVisible1 = false">取 消</el-button> -->
                    </div>
                  </el-dialog>
                </li>
                <li class="dropdown head-dpdn">
                  <el-button type="primary" icon="edit" @click="showRegister"><i class="fa fa-user" aria-hidden="true"></i>注册</el-button>
                    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible2" style="display: none;width:60%;margin:10px 300px 10px" >
                      <el-form autoComplete="on" :model="registerForm" :rules="loginRules" ref="registerForm" class="small-space" label-position="left" label-width="80px"
                              style='width: 300px; margin-left:50px;'>
                        <el-form-item prop="username" label="账号" required>
                          <el-input type="text" v-model="registerForm.username" autoComplete="on"></el-input>
                        </el-form-item>
                        <el-form-item label="密码" required>
                          <el-input type="password" placeholder="输入您的密码" v-model="registerForm.password"></el-input>
                        </el-form-item>
                        <el-form-item label="密码确认" required>
                          <el-input type="password" placeholder="再次输入您的密码" v-model="registerForm.passwordAgain"></el-input>
                        </el-form-item>
                        <el-form-item label="邮箱" required>
                          <el-input type="text" placeholder="输入您的邮箱" v-model="registerForm.email"></el-input>
                        </el-form-item>
                        <el-form-item label="所在城市" required>
                          <el-input type="text" placeholder="输入您所在的城市" v-model="registerForm.address"></el-input>
                        </el-form-item>
                        <el-form-item label="联系电话" required>
                          <el-input type="text" placeholder="输入您的联系方式" v-model="registerForm.telephone"></el-input>
                        </el-form-item>
                        <el-form-item label="单位名称" required>
                          <el-input type="text" placeholder="输入您的公司/工作室名称" v-model="registerForm.unitName"></el-input>
                        </el-form-item>
                        <el-form-item label="角色" required>
                          <el-select v-model="registerForm.roleId" placeholder="请选择">
                            <el-option
                              v-for="item in roles"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value">
                            </el-option>
                          </el-select>
                        </el-form-item>
                      </el-form>
                    <div slot="footer" class="dialog-footer">
                      <el-button type="submit" @click="handleRegister" style="border: none;outline: none;cursor: pointer;color: #fff;background: #0280e1;
                       width: 70%;padding: .8em 1em;font-size: 1em;margin: -2em 4.5em 0.8em;-webkit-transition:.5s all;-moz-transition:.5s all;
	                    -o-transition:.5s all;-ms-transition:.5s all;transition:.5s all;text-transform: uppercase;-webkit-appearance:none;">注 册</el-button>
                      <el-button style="color:#000" @click="dialogFormVisible2 = false">取 消</el-button>
                    </div>
                  </el-dialog>
                </li>  
              </ul>
            </div>
          </div>
          <div class="clearfix"> </div>
        </div> 
      </div>
      <div class="header-two" style="height:520px; width:100%"><!-- header-two -->
          <div class="row">
            <div class="col-md-2">
              <div class="header-logo">              
              </div>
            </div>
            <div class="col-md-1">
            </div>
            <div class="col-md-9">	

            </div>
            <div class="clearfix"> 
            </div>
          </div>	
           <el-carousel :interval="5000" arrow="always">
            <el-carousel-item v-for="item in 4" :key="item">
              <h3>{{ item }}</h3>
            </el-carousel-item>
          </el-carousel>	
      </div><!-- //header-two -->
    </div>
	  <!-- //header -->  
    <!-- banner -->
    <!--
    <div class="banner">
      <div id="kb" class="carousel kb_elastic animate_text kb_wrapper" data-ride="carousel" data-interval="6000" data-pause="hover">
        <div class="carousel-inner" role="listbox">  
          <div class="item active">
                      <img :src="img_6" alt="" width="1920px" height="300px"/>
                      <div class="carousel-caption kb_caption kb_caption_right">
                          <h3 data-animation="animated flipInX">Flat <span>50%</span> Discount</h3>
                          <h4 data-animation="animated flipInX">Hot Offer Today Only</h4>
                      </div>
                  </div>  
                  <div class="item"> 
                      <img :src="img_5" alt=""  width="1920px" height="300px"/>
                      <div class="carousel-caption kb_caption kb_caption_right">
                          <h3 data-animation="animated fadeInDown">Our Latest Fashion Editorials</h3>
                          <h4 data-animation="animated fadeInUp">cupidatat non proident</h4>
                      </div>
                  </div>
  
                  <div class="item">
                      <img :src="img_8" alt=""  width="1920px"/>
                      <div class="carousel-caption kb_caption kb_caption_center">
                          <h3 data-animation="animated fadeInLeft">End Of Season Sale</h3>
                          <h4 data-animation="animated flipInX">cupidatat non proident</h4>
                      </div>
                  </div>
                  <a class="left carousel-control kb_control_left" href="#kb" role="button" data-slide="prev">
                    <span class="fa fa-angle-left kb_icons" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                  </a> 
                  <a class="right carousel-control kb_control_right" href="#kb" role="button" data-slide="next">
                    <span class="fa fa-angle-right kb_icons" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                  </a> 
              </div> 
      </div>     
	  </div>	--><!-- //banner -->
    <!-- //welcome -->
    <div class="welcome"> 
      <div class="container"> 
        <div class="welcome-info">
          <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
            <ul id="myTab" class=" nav-tabs" role="tablist">
              <li role="presentation"><router-link to="/classify" id="home-tab" role="tab" data-toggle="tab" >
                <i class="fa fa-laptop" aria-hidden="true" style="color:#5b91f2"></i> 
                <h5>Web网站</h5>
              </router-link></li>
              <li role="presentation"><router-link to="/classify" role="tab" id="carl-tab" data-toggle="tab"> 
                <i class="fa fa-mobile" aria-hidden="true" style="color:#f57df5"></i>
                <h5>App开发</h5>
              </router-link></li>
              <li role="presentation"><router-link to="/classify" role="tab" id="james-tab" data-toggle="tab"> 
                <i class="fa fa-book" aria-hidden="true"></i>
                <h5>微信公众号</h5>
              </router-link></li>
              <li role="presentation"><router-link to="/classify" role="tab" id="decor-tab" data-toggle="tab"> 
                <i class="fa fa-html5" aria-hidden="true" style="color:#5b91f2"></i>
                <h5>HTML5 应用</h5>
              </router-link></li>
              <li role="presentation"><router-link to="/classify" role="tab" id="sports-tab" data-toggle="tab"> 
                <i class="fa fa-weixin" aria-hidden="true"></i>
                <h5>小程序</h5>
              </router-link></li>
            </ul>
            <div class="clearfix"> </div>  
          </div>  
        </div>  	
      </div>  	
    </div> <!-- //welcome -->
    <div class="process-page">
        <div class="process-title">发猿地交易与服务流程</div>
        <div class="process-content content-web">
            <div class="content-text">
                <div class="publish-number">// 01</div>
                <div class="publish-title">发布需求</div>
                <div class="publish-desc">不知道项目如何报价？<br>
                    在这里，3分钟自动估算。<br>
                    覆盖 App、Web、HTML5、微信公众号等常用功能。
                </div>
                <div class="publish-link">
                    <a href="/quote">查看项目报价</a>
                </div>
            </div>
            <div class="content-img">
                <img src="../../assets/index-content-slice-1@2x.png" height="260">
            </div>
        </div>
        <!-- <div class="process-content content-phone">
            <div class="content-img">
                <img src="images/index/index-content-slice-1@2x.png">
            </div>
            <div class="content-text">
                <div class="publish-number">// 01</div>
                <div class="publish-title">发布需求</div>
                <div class="publish-desc">不知道项目如何报价？<br>
                    在这里，3分钟自动估算。<br>
                    覆盖 App、Web、HTML5、微信公众号等常用功能。
                </div>
                <div class="publish-link">
                    <a href="/quote">查看项目报价</a>
                </div>
            </div>
        </div> -->
        <div class="process-content">
            <div class="content-img">
                <img src="../../assets/index-content-slice-2@2x-new.png" height="260">
            </div>
            <div class="content-text">
                <div class="publish-number">// 02</div>
                <div class="publish-title">确认合作</div>
                <div class="publish-desc">海量开发者，技能多样化，<br>
                    实现技能需求匹配，<br>
                    确认合作开发者。
                </div>
            </div>
        </div>
        <div class="process-content content-web">
            <div class="content-text">
                <div class="publish-number">// 03</div>
                <div class="publish-title">资金托管</div>
                <div class="publish-desc">项目款分阶段托管，自助验收支付开发者。<br>
                    高达 1000 万元保险赔付机制，<br>
                    全方位保障开发进度。
                </div>
            </div>
            <div class="content-img">
                <img src="../../assets/index-content-slice-3@2x.png" height="260">
            </div>
        </div>
        <!-- <div class="process-content content-phone">
            <div class="content-img">
                <img src="images/index/index-content-slice-3@2x.png">
            </div>
            <div class="content-text">
                <div class="publish-number">// 03</div>
                <div class="publish-title">资金托管</div>
                <div class="publish-desc">项目款分阶段托管，自助验收支付开发者。<br>
                    高达 1000 万元保险赔付机制，<br>
                    全方位保障开发进度。
                </div>
            </div>
        </div> -->
        <div class="process-content">
            <div class="content-img">
                <img src="../../assets/index-content-slice-4@2x.png" height="260">
            </div>
            <div class="content-text">
                <div class="publish-number">// 04</div>
                <div class="publish-title">无忧交付</div>
                <div class="publish-desc">云计算软件协作工具 Coding.net，<br>
                    提供代码托管、文档管理、代码质量报告等，<br>
                    让项目过程的每一步都有迹可循，随时监管。
                </div>
                <div class="publish-link">
                    <a href="https://coding.net">使用 Coding.net</a>
                </div>
            </div>
        </div>
        <div class="process-content last-content content-web">
            <div class="content-text">
                <div class="publish-number">// 05</div>
                <div class="publish-title">无忧质保</div>
                <div class="publish-desc">项目质保期内，开发者义务修复BUG及调优，<br>
                    保障运营无忧。
                </div>
            </div>
            <div class="content-img">
                <img src="../../assets/index-content-slice-5@2x.png" height="260">
            </div>
        </div>
        <!-- <div class="process-content last-content content-phone">
            <div class="content-img">
                <img src="images/index/index-content-slice-5@2x.png">
            </div>
            <div class="content-text">
                <div class="publish-number">// 05</div>
                <div class="publish-title">无忧质保</div>
                <div class="publish-desc">项目质保期内，开发者义务修复BUG及调优，<br>
                    保障运营无忧。
                </div>
            </div>
        </div> -->
    </div>	
  </div>
</template>

<script>
import img_404 from "@/assets/404_images/404.png";
import img_404_cloud from "@/assets/404_images/404_cloud.png";
import img_3 from "@/assets/indexImage/3.jpg";
import img_5 from "@/assets/indexImage/5.jpg";
import img_8 from "@/assets/indexImage/8.jpg";
import img_4 from "@/assets/indexImage/parallax-bg.jpg";
import img_6 from "@/assets/indexImage/slider.jpg";
import SNavBar from '@/components/NavBar/studio';
import CNavBar from '@/components/NavBar/company';
import VNavBar from '@/components/NavBar/viewer';

import $ from 'jquery';

export default {
  name:'index',
  data() {
    return {
      img_404,
      img_404_cloud,
      img_3,
      img_5,
      img_8,
      img_4,
      img_6,
      roles: [{
          value: '3',
          label: '企业'
        }, {
          value: '2',
          label: '工作室'
        }],
      value: '',
      loginForm: {
          username: '',
          password: '',
          roleId: ''
        },
      registerForm: {
        username:'',
        password:'',
        passwordAgain:'',
        email:'',
        address:'',
        telephone:'',
        roleId:'',
        unitName:'',
        },
      tempUser: {
        username: '',
        password: '',
        mail: '',
        roleId: '',
        userId: ''
      },
      user: {
        username:'',
        unitName: '',
        },
      loginRules: {
        username: [{required: true, trigger: 'blur', message: "请输入用户名"}],
        password: [{required: true, trigger: 'blur', message: "请输入密码"}]
      },
      loading: false,
      isLogined: false,
      dialogStatus: 'login',
      dialogFormVisible1: false,
      dialogFormVisible2: false,
      textMap: {
        login: '登录',
        register: '注册'
      },
      checked: true
    };
  },
  methods: {
    showLogin() {
        // let user;
        // this.loginForm.username = "";
        // this.loginForm.password = "";
        this.dialogFormVisible1 = true
      },
    showRegister() {
        // let user;
        this.tempUser.username = "";
        this.tempUser.password = "";
        this.dialogStatus = 'register';
        this.dialogFormVisible2 = true
    },
    getLoginInfo() {
        //查询用户信息
        this.api({
          url: "/login/getInfo",
          method: "post",
          data:this.loginForm
        }).then(data => {
          //设置了一个全局变量用来保存登录的状态
          this.$root.loginedRoleId = data.userPermission.roleId;
          //全局的登录状态为true
          this.$root.userIsLogined = true;
          this.loginForm.roleId = data.userPermission.roleId;
          this.$root.username = this.loginForm.username;
          this.user.username =  this.loginForm.username;
          this.getUserInfo();
          this.$router.push({path: '/'});
          
        })
    },
    getUserInfo() {
        //查询用户信息
        this.api({
          url: "/user/getInfo",
          method: "post",
          data:this.user
        }).then(data => {
          this.$root.unitName = data.userInfo.unit_name;
          if (this.$root.loginedRoleId == 1) {
            this.$router.push({path: '/user/companyInfoExamined'});
          } 
        }).catch(() => {
            this.$message.error("查询失败")
          })
      },
    handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true
            this.$store.dispatch('Login', this.loginForm).then(data => {
              this.loading = false
              if ("success" === data.result) {
                this.getLoginInfo();
                // this.isLogined = true;
                this.dialogFormVisible1 = false;
              } else {
                this.$message.error("账号/密码错误");
              }
            }).catch(() => {
              this.loading = false
            })
          } else {
            return false
          }
        })
      },  
    handleRegister() {
      this.api({
        url: "/register/register",
        method: "post",
        data: this.registerForm
      }).then(data => {
        this.$message.success("注册成功！");
        this.dialogFormVisible2 = false;
      }) 
    },
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
        }).catch(() => {
          // this.$message({
          //   type: 'info',
          //   message: '已取消退出'
          // });          
        });     
    }, 
  },
  computed: {
    message() {
      return "页面找不到了......";
    }
  },
  components:{SNavBar,CNavBar,VNavBar},
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
@import "~@/styles/font-awesome.css";
@import "~@/styles/bootstrap.css";
@import ".~@/styles/style.css";
@import "~@/styles/animate.min.css";
@import "~@/styles/menu.css";
@import "~@/styles/fonts.googleapis.com1.css";
@import "~@/styles/fonts.googleapis.com2.css";
@import "~@/styles/fonts.googleapis.com3.css";

.el-carousel {
    overflow-x: hidden;
    position: relative;
}
.el-carousel__container {
    position: relative;
    height: 500px;
}
.el-carousel__item h3 {
    color: #a6a7a8;
    font-size: 18px;
    opacity: 0.3;
    line-height: 500px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
    opacity: 0.3;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
    opacity: 0.3;
  }
  .el-carousel__container {
    position: relative;
    height: 500px;
}
.el-dialog__title {
    line-height: 24px;
    font-size: 18px;
    color: #303133;
    float: right;
}
.el-button {
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: transparent;
    border-color: transparent;
    color: #fff;
    -webkit-appearance: none;
    text-align: center;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    outline: 0;
    margin: 0;
    -webkit-transition: .1s;
    transition: .1s;
    padding: 12px 20px;
    font-size: 13px;
    border-radius: 4px;
}
.el-button:hover {
    background: #dae7f5;
    border-color: #fFF;
    color: #000;
}
.btn-default {
  width: 40px;
  height: 40px;
  border: none;
  position: absolute;
  top: 0.5px;
  outline: none;
  box-shadow: none;
  padding: 0;
  border-radius: inherit;
  -webkit-appearance: none;
  -webkit-transition: .5s all;
  -moz-transition: .5s all;
  transition: .5s all;
  background: transparent;
}
.search2 {
  width: 80%;
  padding: 0.5em 2em 0.5em 1em;
    font-size: 1em;
    color: #999;
    outline: none;
    border: 1px solid #cccccc;
    background: none;
    -webkit-appearance: none;
    transition: 0.5s all;
    border-radius: 20px;
    -webkit-transition: 0.5s all;  
}
.w3ls-header {
    background: transparent;
    padding: 2em 2em;
} 
.wscn-http404 {
  position: relative;
  width: 1200px;
  margin: 20px auto 60px;
  padding: 0 100px;
  overflow: hidden;
  .pic-404 {
    position: relative;
    float: left;
    width: 600px;
    padding: 150px 0;
    overflow: hidden;
    &__parent {
      width: 100%;
    }
    &__child {
      position: absolute;
      &.left {
        width: 80px;
        top: 17px;
        left: 220px;
        opacity: 0;
        animation-name: cloudLeft;
        animation-duration: 2s;
        animation-timing-function: linear;
        animation-fill-mode: forwards;
        animation-delay: 1s;
      }
      &.mid {
        width: 46px;
        top: 10px;
        left: 420px;
        opacity: 0;
        animation-name: cloudMid;
        animation-duration: 2s;
        animation-timing-function: linear;
        animation-fill-mode: forwards;
        animation-delay: 1.2s;
      }
      &.right {
        width: 62px;
        top: 100px;
        left: 500px;
        opacity: 0;
        animation-name: cloudRight;
        animation-duration: 2s;
        animation-timing-function: linear;
        animation-fill-mode: forwards;
        animation-delay: 1s;
      }
      @keyframes cloudLeft {
        0% {
          top: 17px;
          left: 220px;
          opacity: 0;
        }
        20% {
          top: 33px;
          left: 188px;
          opacity: 1;
        }
        80% {
          top: 81px;
          left: 92px;
          opacity: 1;
        }
        100% {
          top: 97px;
          left: 60px;
          opacity: 0;
        }
      }
      @keyframes cloudMid {
        0% {
          top: 10px;
          left: 420px;
          opacity: 0;
        }
        20% {
          top: 40px;
          left: 360px;
          opacity: 1;
        }
        70% {
          top: 130px;
          left: 180px;
          opacity: 1;
        }
        100% {
          top: 160px;
          left: 120px;
          opacity: 0;
        }
      }
      @keyframes cloudRight {
        0% {
          top: 100px;
          left: 500px;
          opacity: 0;
        }
        20% {
          top: 120px;
          left: 460px;
          opacity: 1;
        }
        80% {
          top: 180px;
          left: 340px;
          opacity: 1;
        }
        100% {
          top: 200px;
          left: 300px;
          opacity: 0;
        }
      }
    }
  }
  .bullshit {
    position: relative;
    float: left;
    width: 300px;
    padding: 150px 0;
    overflow: hidden;
    &__oops {
      font-size: 32px;
      font-weight: bold;
      line-height: 40px;
      color: #1482f0;
      opacity: 0;
      margin-bottom: 20px;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-fill-mode: forwards;
    }
    &__headline {
      font-size: 20px;
      line-height: 24px;
      color: #1482f0;
      opacity: 0;
      margin-bottom: 10px;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.1s;
      animation-fill-mode: forwards;
    }
    &__info {
      font-size: 13px;
      line-height: 21px;
      color: grey;
      opacity: 0;
      margin-bottom: 30px;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.2s;
      animation-fill-mode: forwards;
    }
    &__return-home {
      display: block;
      float: left;
      width: 110px;
      height: 36px;
      background: #1482f0;
      border-radius: 100px;
      text-align: center;
      color: #ffffff;
      opacity: 0;
      font-size: 14px;
      line-height: 36px;
      cursor: pointer;
      animation-name: slideUp;
      animation-duration: 0.5s;
      animation-delay: 0.3s;
      animation-fill-mode: forwards;
    }
    @keyframes slideUp {
      0% {
        transform: translateY(60px);
        opacity: 0;
      }
      100% {
        transform: translateY(0);
        opacity: 1;
      }
    }
  }
}
.process-page {
    text-align: center;
    margin-right: auto;
    margin-left: auto;
    padding-top: 4rem;
    font-family: "PingFang SC","Helvetica Neue",Helvetica,"Hiragino Sans GB",Arial,"Microsoft YaHei","微软雅黑",sans-serif,"Segoe UI Emoji","Segoe UI Symbol";
  }
.process-title {
    font-size: 3.5rem;
    color: #2D3238;
    letter-spacing: 0;
  }
.process-content{
    width: 60rem;
    height: 20rem;
    display: table;
    table-layout: fixed;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    border-bottom: 1px solid rgba(151,159,168,.2);
  }
.content-web {
    display: table;
  }
.content-text {
    display: table-cell;
    width: 40%;
    vertical-align: middle;
  }
.publish-number{
    text-align: left;
    margin-bottom: .5rem;
    font-size: 1rem;
    color: #2D3238;
  }
.publish-title{
    font-size: 2rem;
    color: #2D3238;
    letter-spacing: 0;
    text-align: left;
  }
.publish-desc{
    font-size: 1rem;
    color: #979FA8;
    line-height: 21px;
    margin-bottom: 1rem;
    margin-top: 1rem;
    text-align: left;
  }
.publish-link{
    font-size: 1rem;
    color: #4289DB;
    letter-spacing: 0;
    text-align: left;
    margin-bottom: 0;
  }
.content-img{
    display: table-cell;
    width: 60%;
    vertical-align: middle;
  }
.content-phone{
    display: none;
  }
.last-content{
    border-bottom: none;
  }
 h3.w3ls-title.w3ls-title2 {
    // text-align: center;
    margin: 0 6em 1em;
	  font-size: 2.5em;
  }
  .login-body2 {
    padding: 3em;
    background-color: #fff;
    -webkit-box-shadow:0px 0px 4px 1px rgb(189, 189, 189);
    -moz-box-shadow:0px 0px 4px 1px rgb(189, 189, 189);
    -o-box-shadow:0px 0px 4px 1px rgb(189, 189, 189);
    -ms-box-shadow:0px 0px 4px 1px rgb(189, 189, 189);
    box-shadow:0px 0px 0px 0px rgb(189, 189, 189);
    width: 40%;
    margin: 0.5em 2.5em 0;
  }
  .login-page el-form {
      position: absolute;
      left: 0;
      right: 0;
      width: 400px;
      padding: 35px 35px 15px 35px;
      margin: 120px auto;
    }
  .login-page el-input[type="text"], .login-page el-input[type="password"] {
    font-size: 1em;
    padding: 0.9em 1em;
    width: 100%;
    color: #999;
    outline: none;
    border: 1px solid #E2DCDC;
    background: #FFFFFF;
    margin: 0 0 1em 0;
	  -webkit-transition:.5s all;
	  -moz-transition:.5s all;
  	-o-transition:.5s all;
  	-ms-transition:.5s all;
  	transition:.5s all;
  	-webkit-appearance:none;
    }
  .login-page el-input[type="submit"] {
    border: none;
    outline: none;
    cursor: pointer;
    color: #fff;
    background: #0280e1;
    width: 100%;
    padding: .8em 1em;
    font-size: 1em;
    margin: 0.5em 0 0;
    -webkit-transition:.5s all;
	  -moz-transition:.5s all;
	  -o-transition:.5s all;
  	-ms-transition:.5s all;
	  transition:.5s all;
    text-transform: uppercase;
	  -webkit-appearance:none;
    }
  .login-page el-form-item {
      border: 1px solid #E2DCDC;
      background: #FFFFFF;
      border-radius: 5px;
      color: #999;
    }
  .login-page input[type="submit"] {
    font-size: 2em;
    border: none;
    outline: none;
    cursor: pointer;
    color: #fff;
    background: #0280e1;
    width: 15%;
    padding: .6em 1em;
    font-size: 1em;
    margin: 1em -8.5em 0;
    -webkit-transition:.5s all;
	  -moz-transition:.5s all;
	  -o-transition:.5s all;
  	-ms-transition:.5s all;
	  transition:.5s all;
    text-transform: uppercase;
	  -webkit-appearance:none;
    text-align: center;
    }
  .login-page input[type="reset"] {
    font-size: 2em;
    border: none;
    outline: none;
    cursor: pointer;
    color: #fff;
    background: #0280e1;
    width: 15%;
    padding: .6em 1em;
    font-size: 1em;
    margin: 0.5em 8.5em 0;
    -webkit-transition:.5s all;
	  -moz-transition:.5s all;
	  -o-transition:.5s all;
  	-ms-transition:.5s all;
	  transition:.5s all;
    text-transform: uppercase;
	  -webkit-appearance:none;
    text-align: center;
    }
</style>
