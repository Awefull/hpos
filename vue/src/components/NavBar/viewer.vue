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
                      <el-button type="submit" :loading="loading" @click.native.prevent="handleLogin" style="border: none;outline: none;cursor: pointer;color: #fff;background: #0280e1;
                       width: 70%;padding: .8em 1em;font-size: 1em;margin: -2em 4.5em 0.8em;-webkit-transition:.5s all;-moz-transition:.5s all;
	                    -o-transition:.5s all;-ms-transition:.5s all;transition:.5s all;text-transform: uppercase;-webkit-appearance:none;">
                      登 录</el-button>
                      <el-checkbox v-model="checked" style="right:145px;margin: 1em 15em 1em">记住密码</el-checkbox>
                      <router-link to="/myWallet" style="margin: -5em 1em -2em">忘记密码</router-link>
                      <el-button style="color:#000" @click="dialogFormVisible1 = false">取 消</el-button>
                    </div>
                  </el-dialog>
                </li>
                <li class="dropdown head-dpdn">
                  <el-button  type="primary" icon="edit" @click="showRegister"><i class="fa fa-user" aria-hidden="true"></i>注册</el-button>
                    <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible2" style="display: none;width:60%;margin:10px 300px 10px" >
                    <el-form class="small-space" label-position="left" label-width="80px"
                            style='width: 300px; margin-left:50px;'>
                      <el-form-item label="账号" required>
                        <el-input type="text" placeholder="输入你的用户名"></el-input>
                      </el-form-item>
                      <el-form-item label="密码" required>
                        <el-input type="password" placeholder="输入你的密码"></el-input>
                      </el-form-item>
                      <el-form-item label="密码" required>
                        <el-input type="password" placeholder="再次输入你的密码"></el-input>
                      </el-form-item>
                      <el-form-item label="邮箱" required>
                        <el-input type="text" placeholder="输入你的邮箱"></el-input>
                      </el-form-item>
                      <el-form-item label="角色" required>
                        <el-select v-model="value" placeholder="请选择">
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
			<div class="clearfix"> </div> 
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
          value: '1',
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
      tempUser: {
        username: '',
        password: '',
        mail: '',
        roleId: '',
        userId: ''
      },
      loginRules: {
        username: [{required: true, trigger: 'blur', message: "请输入用户名"}],
        password: [{required: true, trigger: 'blur', message: "请输入密码"}]
      },
      loading: false,
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
      handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true
            this.$store.dispatch('Login', this.loginForm).then(data => {
              this.loading = false
              if ("success" === data.result) {
                this.$router.push({path: '/'})
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
        
      }
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
