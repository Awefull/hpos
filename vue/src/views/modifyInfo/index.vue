<template>
  <div>
    <div v-if="this.$root.loginedRoleId == '2'">
     <SNavBar></SNavBar>
    </div>
    <div v-if="this.$root.loginedRoleId == '3'">
      <CNavBar></CNavBar>
    </div>
    <div class="header">
      <div class="header-left">
        <li class="dropdown head-dpdn">
            <a style="color:black" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
                      个人中心</a>
        </li> 
      </div>
    </div>
    <div class="uc-layer-top self" >
      <!-- <el-upload
        action="https://jsonplaceholder.typicode.com/posts/"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove">
        <i class="el-icon-plus"></i>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt="">
      </el-dialog> -->
          <div class="uc-avatar face-icon">
              <img id="user-avatar" src="//img.ketangpai.com/ketangpai.aliapp.com/1/webroot/Uploads/Download/2017-02-28/1488264570.jpg%40%2162-62?OSSAccessKeyId=LTAItfPkNIKJFibY&amp;Expires=1867647789&amp;Signature=6XDeX%2BSsliObX1S38FAbsZunQ60%3D" alt="张智涵">
              <a href="javascript:;" class="change-avatar avatar upload">更改头像</a>
              <div class="marks"></div>
          </div>
          <h1 class="uc-name">{{this.$root.username}}</h1>
          <div class="s-header">
              <div class="h-nav">
                  <a href="#info">个人资料</a>
                  <router-link to="/myWallet">我的钱包</router-link>
              </div>
          </div>
      </div>
      <div class="setting-page cWidth" :model="user">
        <div class="item-change">
            <div class="setting-item" id="info" :model="user">
                <div class="options basic">
                    <h3 class="title">基本资料</h3>
                    <ul>
                        <li>
                            <p>姓名：</p>
                            <div class="edit-box">
                                <span>{{this.$root.username}}</span>
                            </div>
                            <!-- <template slot-scope="scope"> -->
                                <el-button  type="primary" icon="edit" @click="showUpdateBasicInfo">修改</el-button>
                                <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible1" style="display: none;" >
                                <el-form class="small-space" label-position="left" label-width="80px"
                                        style='width: 300px; margin-left:50px;'>
                                  <el-form-item prop="username" label="姓名" >
                                    <el-input type="text" v-model="user.username"></el-input>
                                  </el-form-item>
                                  <el-form-item prop="unitName" label="工作室" >
                                    <el-input type="text" v-model="user.unitName"></el-input>
                                  </el-form-item>
                                  <el-form-item prop="description" label="关于我们" >
                                    <el-input type="text" v-model="user.description"></el-input>
                                  </el-form-item>
                                </el-form>
                                <div slot="footer" class="dialog-footer">
                                  <el-button @click="dialogFormVisible1 = false">取 消</el-button>
                                  <el-button type="primary" @click="updateUser">修 改</el-button>
                                </div>
                              </el-dialog>
                            <!-- </template> -->
                        </li>
                        <li>
                            <p v-if="user.roleId == 2">工作室： </p>
                            <p v-if="user.roleId == 3">企业： </p>
                            <!-- <p>工作室：</p> -->
                            <div class="edit-box">
                                <span>{{user.unitName}}</span>
                            </div>
                        </li>
                        <li>
                            <p>关于我们： </p>
                            <div class="edit-box">
                                <span>{{user.description}}</span>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="options account">
                    <h3 class="title">账号设置</h3>
                    <ul>
                        <li>
                            <p>账号：</p>
                            <div class="edit-box">
                                <span>{{user.accountId}}</span>
                            </div>
                        </li>
                        <li>
                            <p>邮箱：</p>
                            <div class="edit-box">
                                <span>{{user.email}}</span>
                            </div>
                                <el-button type="primary" icon="edit" @click="showUpdateAccount">修改</el-button>
                                <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible2" style="display: none;" >
                                <el-form class="small-space" label-position="left" label-width="80px"
                                    style='width: 300px; margin-left:50px;'>
                                  <el-form-item prop="email" label="邮箱" >
                                    <el-input type="text" v-model="user.email"></el-input>
                                  </el-form-item>
                                  <el-form-item prop="telephone" label="手机" >
                                    <el-input type="text" v-model="user.telephone"></el-input>
                                  </el-form-item>
                                  <el-form-item prop="address" label="城市" >
                                    <el-input type="text" v-model="user.address"></el-input>
                                  </el-form-item>
                                </el-form>
                                <div slot="footer" class="dialog-footer">
                                  <el-button @click="dialogFormVisible2 = false">取 消</el-button>
                                  <el-button type="primary" @click="updateUser">修 改</el-button>
                                </div>
                                </el-dialog>
                        <li>
                            <p>手机：</p>
                            <div class="edit-box">
                                <span>{{user.telephone}}</span>
                            </div>
                        </li>
                        <li>
                            <p>所在城市：</p>
                            <div class="edit-box">
                                <span>{{user.address}}</span>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="options pass">
                    <h3 class="title">密码</h3>
                    <ul>
                        <li>
                            <p>密码：</p>
                            <div class="edit-box">
                                <span>***********</span>
                            </div>
                                <el-button type="primary" icon="edit" @click="showUpdatePwd">修改</el-button>
                                <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible3" style="display: none;" >
                                <el-form class="small-space" label-position="left" label-width="80px"
                                        style='width: 300px; margin-left:50px;'>
                                  <el-form-item label="原密码" required>
                                    <el-input type="password" v-model="user.oldPassword"></el-input>
                                  </el-form-item>
                                  <el-form-item label="新密码" required>
                                    <el-input type="password" v-model="user.newPassword"></el-input>
                                  </el-form-item>
                                  <el-form-item label="确认密码" required>
                                    <el-input type="password" v-model="user.reNwePassword"></el-input>
                                  </el-form-item>
                                </el-form>
                                <div slot="footer" class="dialog-footer">
                                  <el-button @click="dialogFormVisible3 = false">取 消</el-button>
                                  <el-button type="primary" @click="updateUser">修 改</el-button>
                                </div>
                              </el-dialog>
                        </li>
                    </ul> 
                </div>
            </div>
      </div>
    </div>
  </div>
    
</template>

<script>
  import {mapGetters} from 'vuex'
  import SNavBar from '@/components/NavBar/studio';
  import CNavBar from '@/components/NavBar/company';
  // import $ from 'jquery'
  export default {
    data() {
      return {
        // totalCount: 0, //分页组件--数据总条数
        // list: [],//表格的数据
        // listLoading: false,//数据加载等待动画
        // listQuery: {
        //   pageNum: 1,//页码
        //   pageRow: 50,//每页条数
        // },
        roles: [],//角色列表
        dialogStatus: 'update',
        dialogFormVisible1: false,
        dialogFormVisible2: false,
        dialogFormVisible3: false,
        textMap: {
          update: '编辑'
        },
        user: {
          accountId:'',
          username: '',
          password: '',
          oldPassword: '',
          newPassword:'',
          reNwePassword: '',
          roleId: '',
          unitName: '',
          email: '',
          telephone: '',
          address: '',
          description: '',
        },
        dialogImageUrl: '',
        dialogVisible: false
      }
    },
    created: function() {
      this.user.username = this.$root.username;
      this.getUserInfo();
    },
    methods: {
      showUpdateBasicInfo() {
        this.dialogFormVisible1 = true
      },
      showUpdateAccount() {
        this.dialogFormVisible2 = true
      },
      showUpdatePwd() {
        this.dialogFormVisible3 = true
      },
      getUserInfo() {
        //查询用户信息
        this.api({
          url: "/user/getInfo",
          method: "post",
          data:this.user
        }).then(data => {
          this.user.accountId = data.userInfo.account_id;
          this.user.username = data.userInfo.username;
          this.user.password = data.userInfo.password;
          this.$root.unitName = data.userInfo.unit_name;
          this.user.unitName = data.userInfo.unit_name;
          this.user.address = data.userInfo.address;
          this.user.email = data.userInfo.email;
          this.user.telephone = data.userInfo.telephone;
          this.user.description = data.userInfo.description;
          this.user.roleId = data.userInfo.role_id;
        }).catch(() => {
            this.$message.error("查询失败")
          })
      },
      updateUser() {
        //修改用户信息
        let _vue = this;
        if (this.dialogFormVisible3 == true) {
          if(this.user.oldPassword != this.user.password)
            this.$message.error("原密码错误");
          else if (this.user.newPassword != this.user.reNwePassword)
            this.$message.error("新密码与确认密码不符");
          else
            this.user.password = this.user.newPassword;
        }
        this.api({
          url: "/user/updateUserInfo",
          method: "post",
          data: this.user
        }).then(() => {
          let msg = "修改成功";
          if (this.dialogFormVisible1 == true)
              this.dialogFormVisible1 = false;
          else if (this.dialogFormVisible2 == true)
              this.dialogFormVisible2 = false;
          else (this.dialogFormVisible3 == true)
              this.dialogFormVisible3 = false;
        })
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      // },
      // pictureSuccess() {
        
      }
    },
    components: {SNavBar,CNavBar},
  }
  
  
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .header{
    background: transparent;
    padding: 2em 2em;
    position: fixed;
}
  .header-left {
    float: left;
}
  .el-button {
    display: inline-block;
    line-height: 1;
    white-space: nowrap;
    cursor: pointer;
    background: #fff;
    border-color: #fFF;
    color: #606266;
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
  .el-form-item {
    margin-bottom: 22px;
}
  .el-button--primary {
    color: #000;
    background-color: #fFF;
    border-color: #fFF;
    font-size: 13px;
    color: #595959;
    float: right;
}
  .el-button--primary:focus, .el-button--primary:hover {
    background: #dae7f5;
    border-color: #fff;
    color: #000;
    border-radius: 10px;
    right:28em;
}
  .modal-content {
    position: relative;
    background-color: #fff;
    -webkit-background-clip: padding-box;
    background-clip: padding-box;
    border: 1px solid #999;
    border: 1px solid rgba(0, 0, 0, .2);
    border-radius: 6px;
    outline: 0;
    -webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, .5);
    box-shadow: 0 3px 9px rgba(0, 0, 0, .5);
     margin: 20em 0em 4em;
     left: 28em;
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
    margin: 0.5em 5em 0;
  }
  .col-md-5 {
    width: 90%;
  }
  .uc-layer-top.self {
    height: 280px;
    margin-top: 65px;
  }
  .uc-layer-top {
    height: 260px;
    background-color: #fff;
    border-bottom: 1px solid #C8C8C8;
    text-align: center;
    margin-bottom: 40px;
    overflow: hidden;
  }
  .uc-avatar.face-icon {
    position: relative;
  }
  .uc-avatar {
    width: 115px;
    margin: 45px auto 0;
    background-color: #fff;
    position: relative;
  }
  .setting-page {
    margin-top: 40px;
    margin-bottom: 60px;
    border: 1px solid #c8c8c8;
    padding-bottom: 60px;
    background: #FFFFFF;
  }
  .cWidth {
    width: 980px;
    margin-left: auto;
    margin-right: auto;
  }
  .qrcode {
    padding-top: 70px;
  }
  .setting-layer {
      position: fixed;
      top: 50%;
      left: 50%;
      z-index: 10;
      width: 374px;
      height: 416px;
      margin-left: -187px;
      margin-top: -208px;
      background-color: #FFFFFF;
      box-sizing: border-box;
  }
  .hide {
      display: none;
  }
  #remove_bind {
    padding-left: 0;
    padding-top: 0;
  }
  .little-pop {
      padding-left: 26px;
      padding-top: 10px;
      display: none;
  }
  body, ul, ol, li, p, h1, h2, h3, h4, h5, h6, form, fieldset, table, td, img, div, dl, dt, dd, input, textarea {
      margin: 0;
      padding: 0;
  }
  #faceUploader {
    padding-left: 0;
    padding-top: 0;
  }
  .little-pop {
      padding-left: 26px;
      padding-top: 10px;
      display: none;
  }
  .unbind-box {
    padding-left: 30px;
    padding-top: 25px;
  }
  .little-pop {
      padding-left: 26px;
      padding-top: 10px;
      display: none;
  }
  .tel-validate {
    width: 340px;
    background: #FFFFFF;
    z-index: 10;
    padding: 30px 30px 0;
    display: none;
  }
  .unbind-box {
    padding-left: 30px;
    padding-top: 25px;
  }
  .little-pop {
      padding-left: 26px;
      padding-top: 10px;
      display: none;
  }
  .tel-validate {
    width: 340px;
    background: #FFFFFF;
    z-index: 10;
    padding: 30px 30px 0;
    display: none;
  }
  .help-dips {
    position: relative;
    position: fixed;
    bottom: 40px;
    right: 60px;
    width: 28px;
    height: 28px;
    display: block;
    z-index: 1;
  }
  .layer-feedBack {
    padding-top: 0px;
    padding-left: 0px;
  }
  .little-pop {
      padding-left: 26px;
      padding-top: 10px;
      display: none;
  }
  .uc-avatar.face-icon {
    position: relative;
  }
  .uc-avatar {
      width: 115px;
      margin: 45px auto 0;
      background-color: #fff;
      position: relative;
  }
  .uc-avatar.face-icon .marks {
    position: absolute;
    left: 50%;
    bottom: -3px;
    font-size: 0;
    width: 60px;
  }
  .uc-layer-top.self .uc-subtit {
    width: 320px;
    margin: 0 auto;
    position: relative;
    background-color: #f2f2f2;
  }
  .uc-subtit {
      font-size: 12px;
      line-height: 2;
      height: 26px;
  }
  .uc-layer-top.self .uc-subtit span.jifentxt {
    cursor: pointer;
    min-width: 100px;
    padding-left: 10px;
    padding-right: 10px;
  }
  .uc-layer-top.self .uc-subtit span {
      display: inline-block;
      vertical-align: middle;
      overflow: hidden;
  }
  .uc-subtit {
      font-size: 12px;
      line-height: 2;
      height: 26px;
  }
  .uc-layer-top {
      height: 260px;
      background-color: #fff;
      border-bottom: 1px solid #C8C8C8;
      text-align: center;
      margin-bottom: 40px;
      overflow: hidden;
  }
  .uc-layer-top.self .uc-subtit span.viptxt {
    width: 150px;
    margin-left: 5px;
  }
  .uc-layer-top.self .uc-subtit span {
      display: inline-block;
      vertical-align: middle;
      overflow: hidden;
  }
  .uc-subtit {
      font-size: 12px;
      line-height: 2;
      height: 26px;
  }
  .uc-layer-top {
      height: 260px;
      background-color: #fff;
      border-bottom: 1px solid #C8C8C8;
      text-align: center;
      margin-bottom: 40px;
      overflow: hidden;
  }
  .s-header {
    height: 60px;
    margin-top: 15px;
  } 
  .s-header .h-nav {
    text-align: center;
  }
  .item-change {
    min-height: 600px;
  }
  .item-change .setting-item, .item-change .notice-item {
    padding: 20px 40px 0 40px;
  }
  .item-change .setting-item .options {
    margin-top: 20px;
  }
  .item-change .setting-item .options .title {
    font-size: 14px;
    color: #333333;
    border-bottom: 1px solid #DCDCDC;
    padding-bottom: 20px;
    line-height: 1;
  }
  .item-change .setting-item .options ul {
    padding-top: 10px;
  }
  .item-change .setting-item .options ul li {
    height: 32px;
    margin-top: 10px;
  }
  .item-change .setting-item .options ul li .edit-box {
    float: left;
  }
  .item-change .setting-item .options ul li .edit-box .txts {
    width: 172px;
    height: 30px;
    line-height: 30px\9;
    border: 1px solid #c8c8c8;
    color: #595959;
    padding: 0 14px;
    border-radius: 3px;
    display: none;
    font-size: 14px;
  }
  .item-change .setting-item .options ul li .edit-btn {
    color: #818181;
    border: 1px solid #c8c8c8;
  }
  .item-change .setting-item .options ul li>a {
      float: right;
      min-width: 56px;
      height: 22px;
      text-align: center;
      line-height: 22px;
      font-size: 12px;
      border-radius: 3px;
      margin-top: 3px;
      padding-left: 5px;
      padding-right: 5px;
  }
  .item-change .setting-item .options ul li .exit-edit {
    color: #4d90fe;
    border: 1px solid #4d90fe;
    display: none;
  }
  .item-change .setting-item .options ul li>a {
      float: right;
      min-width: 56px;
      height: 22px;
      text-align: center;
      line-height: 22px;
      font-size: 12px;
      border-radius: 3px;
      margin-top: 3px;
      padding-left: 5px;
      padding-right: 5px;
  }
  .item-change .setting-item .options .save-btn {
    display: block;
    margin-left: 75px;
    width: 56px;
    height: 26px;
    border-radius: 3px;
    background: #4d90fe;
    color: #FFFFFF;
    text-align: center;
    line-height: 26px;
    margin-top: 10px;
  }
  .hide2 {
      display: none !important;
  }
  .item-change .setting-item .options {
    margin-top: 20px;
  }
  .item-change .setting-item .options .title {
    font-size: 14px;
    color: #333333;
    border-bottom: 1px solid #DCDCDC;
    padding-bottom: 20px;
    line-height: 1;
  }
  .item-change .setting-item .options ul li .edit-box span {
    display: inline-block;
    line-height: 32px;
    color: #595959;
  }
  .hide {
    display: none;
  }
  .item-change .notice-item .title {
    border-bottom: 1px solid #DCDCDC;
    padding: 20px 0 20px;
    line-height: 1;
  }
  .clearfix {
      zoom: 1;
  }
  .item-change .notice-item .title h2 {
    font-size: 14px;
  }
  .item-change .notice-item .l-box {
      width: 498px;
  }
  .fl {
      float: left;
  }
  .item-change .notice-item .title h3 {
    font-size: 14px;
    font-weight: normal;
  }
  .fr {
      float: right;
  }
  .item-change .t-tips {
    line-height: 30px;
    color: #AAAAAA;
    margin-top: 30px;
    padding-bottom: 60px;
  }
  .wenkudownlist .hide {
    display: none;
  }
  .wenkudownlist .change-box {
    padding: 22px 0;
    border-bottom: 1px solid #dcdcdc;
  }
  .wenkudownlist .change-box .item {
    text-align: center;
    font-size: 0;
    border: 1px solid #dcdcdc;
    border-radius: 3px;
    width: 345px;
    margin: 0 auto;
    height: 34px;
  }
  .wenkudownlist .change-box .item a:first-child.active {
    left: -1px;
    border-radius: 3px 0 0 3px;
  }
  .wenkudownlist .change-box .item a.active {
      position: relative;
      height: 36px;
      line-height: 34px;
      background: #4d90fe;
      color: #ffffff!important;
      top: -1px;
  }
  .wenkudownlist .change-box .item a {
      display: inline-block;
      font-size: 12px;
      width: 115px;
      height: 34px;
      text-align: center;
      line-height: 34px;
      color: #2d2d2d;
  }
  .wenkudownlist .tableBox {
    padding: 0 40px;
  }
  .wenkudownlist .table {
    border-spacing: 0;
    border-collapse: collapse;
    width: 100%;
  }
  tbody {
    display: table-row-group;
    vertical-align: middle;
    border-color: inherit;
  }
  .wenkudownlist .table>tbody>tr>td[align='center'] {
    text-align: center;
  }
  .wenkudownlist .table>thead>tr>th, .wenkudownlist .table>tbody>tr>td {
      text-align: left;
      padding: 10px 5px;
      line-height: 1.42857143;
      font-weight: normal;
  }
  .page .clearfix{
    zoom: 1;
  }
  .skin-vip {
    color: rgb(170,170,170);
    font-size: 12px;
    height: auto;
    text-align: center;
  }
  .mask-layer {
    position: fixed;
    width: 100%;
    height: 100%;
    background-color: #000000;
    top: 0;
    left: 0;
    opacity: 0.3;
    filter: alpha(opacity=30);
    z-index: 9;
  }
    .hide {
    display: none;
  }
  .settingclose {
    position: absolute;
    top: -16px;
    right: -16px;
    background: url(/Public/Common/img/icon-setting-close.png) 0 0 no-repeat;
    display: block;
    width: 32px;
    height: 32px;
  }
  .wechat-container {
    border: 1px #d1d1d1 solid;
    width: 228px;
    height: 228px;
    margin: 0px auto;
    background: url(/Public/Common/img/loading-grey.gif) #ffffff center 70px no-repeat;
    background-size: 45px;
    position: relative;
  }
  .loading-txt {
    display: block;
    position: absolute;
    left: 0;
    top: 120px;
    text-align: center;
    width: 228px;
    color: #5a5a5a;
    font-size: 14px;
    z-index: 0;
  }
  .wechat-container img {
    position: absolute;
    z-index: 1;
    left: 0;
    top: 0;
  }
  img {
      border: none;
  }
  span.bind-wechatuid {
    display: block;
    text-align: center;
    padding-top: 40px;
    font-size: 14px;
    color: #5a5a5a;
  }
  #remove_bind h3 {
    border-bottom: none;
  }
  .little-pop .word {
    height: 66px;
    line-height: 66px;
    font-size: 18px;
    color: #aaaaaa;
    font-weight: normal;
    border-bottom: 1px solid #dcdcdc;
    padding-left: 28px;
  }
  .remove-bind-tip {
    padding-left: 28px;
    padding-right: 28px;
    border-bottom: 1px #ececec solid;
    padding-bottom: 24px;
  }
  .little-pop .btns {
    padding-right: 26px;
    margin-top: 26px;
    height: 38px;
    text-align: right;
    font-size: 0;
    padding-bottom: 26px;
  }
  .little-pop .btns .cancel {
    color: #818181;
    margin-right: 15px;
  }
  .little-pop .btns a {
    display: inline-block;
    width: 84px;
    height: 38px;
    line-height: 38px;
    text-align: center;
    font-size: 16px;
    border-radius: 3px;
  }
  .little-pop .btns .sure.active {
    background: #357ae8;
    cursor: pointer;
  }
  .little-pop .btns .sure {
    color: #FFF;
    background: #9abdf4;
    cursor: default;
  }
  .little-pop .btns a {
    display: inline-block;
    width: 84px;
    height: 38px;
    line-height: 38px;
    text-align: center;
    font-size: 16px;
    border-radius: 3px;
  }
  .uploader-container {
    padding: 10px 30px;
  }
  .clearfix {
    zoom: 1;
  }
  .frame {
    width: 300px;
    height: 300px;
    border: 5px #D1D1D1 solid;
    border-radius: 3px;
    float: left;
    position: relative;
    overflow: hidden;
  }
  .faceUploaderPlus {
    display: inline-block;
    width: 300px;
    height: 300px;
    line-height: 300px;
    text-align: center;
    font-size: 80px;
    color: #78787A;
  }
  .frame img {
    display: block;
    overflow: hidden;
    position: absolute;
    top: 50%;
    left: 0;
    -ms-transform: translate(0,-50%);
    -moz-transform: translate(0,-50%);
    -o-transform: translate(0,-50%);
    transform: translate(0,-50%);
  }
  img {
    border: none;
  }
  #preview {
    float: left;
    width: 100px;
    height: 100px;
    border: 1px #D1D1D1 solid;
    overflow: hidden;
    margin-left: 20px;
    border-radius: 80px;
  }
  .unbind-box .title {
    font-weight: normal;
    color: #5A5A5A;
    font-size: 18px;
  }
  .unbind-box .re-words {
    margin-top: 25px;
    color: #2D2D2D;
  }
  .little-pop p {
    margin-top: 20px;
    font-size: 14px;
    color: #a9a9a9;
    height: 28px;
    line-height: 28px;
  }
  .tel-validate .title {
    margin-bottom: 30px;
  }
  .tel-validate .title a {
    position: absolute;
    width: 30px;
    height: 30px;
    right: 28px;
    top: 28px;
    background: url(/Public/Home/img/close.png) left top no-repeat;
    border-radius: 3px;
  }
  .tel-validate .words {
    line-height: 30px;
  }
  .clearfix {
    zoom: 1;
  }
  .tel-validate .yzm-box .input {
    position: relative;
    height: 56px;
    border-bottom: 1px solid #dcdcdc;
    box-sizing: border-box;
    margin-top: 10px;
  }
  .fl {
      float: left;
  }
  .tel-validate .yzm-box .input input {
    width: 130px;
    float: left;
    height: 54px;
    line-height: 54px\9;
    font-size: 16px;
  }
  .tel-validate .yzm-box .get-yzm {
    float: right;
    width: 126px;
    height: 36px;
    box-sizing: border-box;
    text-align: center;
    line-height: 36px;
    border: 1px solid #DCDCDC;
    background: #F2F2F2;
    border-radius: 3px;
    color: #818181;
    margin-top: 25px;
  }
  .tel-validate .button {
    background: #357AE8;
    color: #FFF;
    display: block;
    border-radius: 5px;
    behavior: url(/Public/Common/PIE.htc);
    height: 50px;
    line-height: 50px;
    text-align: center;
    font-size: 16px;
    width: auto;
    margin-top: 30px;
  }
  .unbind-box .re-words {
    margin-top: 25px;
    color: #2D2D2D;
  }
  .little-pop p {
    margin-top: 20px;
    font-size: 14px;
    color: #a9a9a9;
    height: 28px;
    line-height: 28px;
  }
  .unbind-box .btns {
    margin-top: 28px;
  }
  .little-pop .btns {
    padding-right: 26px;
    margin-top: 26px;
    height: 38px;
    text-align: right;
    font-size: 0;
    padding-bottom: 26px;
  }
  .little-pop .btns .cancel {
    color: #818181;
    margin-right: 15px;
  }
  .little-pop .btns a {
    display: inline-block;
    width: 84px;
    height: 38px;
    line-height: 38px;
    text-align: center;
    font-size: 16px;
    border-radius: 3px;
  }
  .little-pop .btns .sure.active {
    background: #357ae8;
    cursor: pointer;
  }
  .little-pop .btns .sure {
    color: #FFF;
    background: #9abdf4;
    cursor: default;
  }
  .little-pop .btns a {
    display: inline-block;
    width: 84px;
    height: 38px;
    line-height: 38px;
    text-align: center;
    font-size: 16px;
    border-radius: 3px;
  }
  .tel-validate .title {
    margin-bottom: 30px;
  }
  .tel-validate .words {
    line-height: 30px;
  }
  .clearfix {
    zoom: 1;
  }
  .tel-validate .yzm-box .input {
    position: relative;
    height: 56px;
    border-bottom: 1px solid #dcdcdc;
    box-sizing: border-box;
    margin-top: 10px;
  }
  .tel-validate .yzm-box .input span {
    width: 70px;
    height: 56px;
    line-height: 56px;
    color: #969696;
    font-size: 16px;
    float: left;
  } 
  .tel-validate .yzm-box .input input {
    width: 130px;
    float: left;
    height: 54px;
    line-height: 54px\9;
    font-size: 16px;
  }
  .help-dips a.help-icon-ques, .help-dips a.help-icon-ques:active {
    background-position: -45px -29px;
    background-image: url(/Public/Common/img/help-icon.png);
    background-repeat: no-repeat;
}
.help-dips a.help-icon-ques {
    width: 28px;
    height: 28px;
    background-position: -45px -29px;
    display: block;
    /* position: absolute; */
    /* right: 0; */
    /* bottom: 0; */
    cursor: pointer;
  }
  .help-icon {
    background-image: url(/Public/Common/img/help-icon.png);
    background-repeat: no-repeat;
    display: block;
  }
  .help-dips .help-dips-box {
    position: absolute;
    right: -14px;
    bottom: 45px;
    width: 130px;
    background-color: #ffffff;
    box-shadow: 1px 1.732px 3px 0px rgba(0, 0, 0, 0.3);
    padding: 5px 0px 5px 0px;
    display: none;
    box-sizing: border-box;
  }
  .help-dips .help-dips-box i.help-icon-bdot {
    display: block;
    background-position: -21px 0px;
    width: 33px;
    height: 15px;
    position: absolute;
    z-index: 99;
    bottom: -15px;
    right: 11px;
  }
  .help-icon {
    background-image: url(/Public/Common/img/help-icon.png);
    background-repeat: no-repeat;
    display: block;
  }
  .help-dips .help-dips-box a {
    font-size: 14px;
    color: #000000;
    display: block;
    padding-left: 14px;
    /* height: 37px; */
    /* line-height: 37px; */
    padding-top: 14px;
    padding-bottom: 14px;
  }
  .feedback-header {
    padding: 13px 17px 0px 17px;
  }
  .clearfix {
      zoom: 1;
  }
  .layer-feedBack .feedback-header a.closeFeedback {
    background-image: url(/Public/Home/img/close.png);
    background-repeat: no-repeat;
    display: block;
    width: 16px;
    height: 16px;
    background-position: -7px -7px;
  }
  .fr {
    float: right;
  }
  .feedMessageBox {
    padding-left: 34px;
    padding-right: 34px;
    padding-top: 20px;
  }
  .feedMessageBox textarea {
    border: 1px #dcdcdc solid;
    border-radius: 3px;
    padding: 13px 19px;
    width: 100%;
    box-sizing: border-box;
    overflow: hidden;
    height: 118px;
    margin-top: 16px;
  }
  textarea {
    resize: none;
  }
  input, select, textarea {
    outline: none;
    border: none;
    background: none;
    cursor: text;
  }
  .little-pop .btns {
    padding-right: 26px;
    margin-top: 26px;
    height: 38px;
    text-align: right;
    font-size: 0;
    padding-bottom: 26px;
  } 
  .layer-feedBack .btns .yourEmail {
    display: inline-block;
    text-align: left;
    color: #000000;
    font-size: 14px;
    height: 38px;
    line-height: 38px;
    padding-left: 34px;
  }
    .little-pop .btns {
    padding-right: 26px;
    margin-top: 26px;
    height: 38px;
    text-align: right;
    font-size: 0;
    padding-bottom: 26px;
  }
  .little-pop .btns .cancel {
    color: #818181;
    margin-right: 15px;
  }
  .little-pop .btns a {
    display: inline-block;
    width: 84px;
    height: 38px;
    line-height: 38px;
    text-align: center;
    font-size: 16px;
    border-radius: 3px;
  }
  .little-pop .btns .sure {
    color: #FFF;
    background: #9abdf4;
    cursor: default;
  }
  .little-pop .btns a {
    display: inline-block;
    width: 84px;
    height: 38px;
    line-height: 38px;
    text-align: center;
    font-size: 16px;
    border-radius: 3px;
  }
  ul, ol, li, p, h1, h2, h3, h4, h5, h6, form, fieldset, table, td, img, div, dl, dt, dd, input, textarea {
    margin: 0;
    padding: 0;
}
.item-change .setting-item .options ul li p {
    float: left;
    min-width: 75px;
    line-height: 32px;
    color: #969696;
}
.uc-name {
    border-top: 1px solid #dcdcdc;
    padding: 30px 20px 20px 20px;
    font-size: 20px;
    font-weight: bold;
    margin-top: -30px;
    line-height: 34px;
    height: 34px;
  }
  .s-header .h-nav a.active {
    color: #4D90FE;
  }
  .s-header .h-nav a:first-child {
    margin-left: 0;
  }
  .s-header .h-nav a {
    font-size: 14px;
    margin-left: 145px;
    line-height: 40px;
    color: #aaa;
  }
</style>

