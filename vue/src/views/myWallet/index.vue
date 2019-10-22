<template>
  <div>
    <div v-if="this.$root.loginedRoleId == '2'">
     <SNavBar></SNavBar>
    </div>
    <div v-if="this.$root.loginedRoleId == '3'">
      <CNavBar></CNavBar>
    </div>
    <div class="uc-layer-top self">
      <el-upload
        action="https://jsonplaceholder.typicode.com/posts/"
        list-type="picture-card"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove">
        <i class="el-icon-plus"></i>
      </el-upload>
      <el-dialog :visible.sync="dialogVisible">
        <img width="100%" :src="dialogImageUrl" alt="">
      </el-dialog>
          <h1 class="uc-name">{{this.$root.username}}</h1>
          <div class="s-header">
              <div class="h-nav">
                  <router-link to="/modifyInfo">个人资料</router-link>
                  <a href="#myWallet">我的钱包</a>
              </div>
          </div>
      </div>
      <div class="setting-page cWidth">
        <div class="item-change">
            <div class="setting-item" id="myWallet">
                <div class="options basic">
                    <h3 class="title">我的余额</h3>
                    <ul>
                        <li>
                            <p>余额：</p>
                            <div class="edit-box">
                                <span>{{this.user.balance}}</span>
                            </div>
                            <!-- <template slot-scope="scope"> -->
                                <el-button  type="primary" icon="edit" @click="showCash">提现</el-button>
                                  <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible1" style="display: none;" >
                                  <el-form class="small-space" label-position="left" label-width="80px"
                                          style='width: 300px; margin-left:50px;'>
                                    <el-form-item label="余额">
                                      <p>{{this.user.balance}}</p>
                                    </el-form-item>
                                    <el-form-item label="支付方式" required>
                                      <el-select v-model="value" placeholder="请选择">
                                        <el-option
                                          v-for="item in options"
                                          :key="item.value"
                                          :label="item.label"
                                          :value="item.value">
                                        </el-option>
                                      </el-select>
                                    </el-form-item>
                                    <el-form-item label="默认卡号" required v-if="value=='1'">
                                      <p>123456</p>
                                    </el-form-item>
                                    <el-form-item label="银行卡号" v-if="value=='1'">
                                      <el-input type="text" placeholder="新增银行卡，直接填写新卡号">123456</el-input>
                                    </el-form-item>
                                    <el-form-item label="支付密码" required v-if="value=='1'">
                                      <el-input type="password"></el-input>
                                    </el-form-item>
                                  </el-form>
                                  <div slot="footer" class="dialog-footer">
                                    <el-button @click="dialogFormVisible1 = false">取 消</el-button>
                                    <el-button type="primary" @click="cashWithdrawal">提 现</el-button>
                                  </div>
                              </el-dialog>
                            <!-- </template> -->
                        </li>
                    </ul>
                </div>
                <div class="options basic">
                    <h3 class="title">交易记录</h3>
                    <ul>
                        <li>
                            <p>已完成交易数：</p>
                            <div class="edit-box">
                                <span>{{this.user.completedTransactions}}</span>
                            </div>
                            <el-button  type="primary" icon="edit" @click="showFinishedRecord">详情</el-button>
                              <el-dialog :title="textMap[dialogStatus]"  :visible.sync="dialogFormVisible2" style="display: none;" >
                                <el-form class="small-space" label-position="left" label-width="80px" style='width: 600px; margin-left:50px;margin-bottom:50px;'>
                                  <el-table ref="filterTable" :data="completedTransactionsList" height="250" style="width: 1000px;margin-left:50px;">
                                    <!-- <el-table-column prop="updateDate" label="日期" column-key="date">                 
                                    </el-table-column> -->
                                    <!-- <el-table-column prop="beginDate" label="项目开始时间" column-key="date">
                                    </el-table-column> -->
                                    <el-table-column prop="projectName" label="项目名称">
                                    </el-table-column>
                                    <el-table-column prop="unitName" label="工作室名称">
                                    </el-table-column>
                                    <el-table-column prop="budget" label="项目金额">
                                    </el-table-column>
                                  </el-table>
                                </el-form>
                                <router-link to="/modifyInfo" style="float:right;">详情</router-link>
                              </el-dialog>                            
                        </li>
                        <li>
                            <p>未完成交易数：</p>
                            <div class="edit-box">
                                <span>{{this.user.outstandingTransactions}}</span>
                            </div>
                            <el-button  type="primary" icon="edit" @click="showFinishingRecord">详情</el-button>
                              <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible3" style="display: none;" >
                                <el-form class="small-space" label-position="left" label-width="80px" style='width: 600px; margin-left:50px;margin-bottom:50px;'>
                                  <el-table ref="filterTable" :data="outstandingTransactionsList" height="250" style="width: 1000px;margin-left:50px;">
                                    <!-- <el-table-column prop="updateDate" label="日期" column-key="date">                 
                                    </el-table-column> -->
                                    <!-- <el-table-column prop="beginDate" label="项目开始时间" column-key="date">
                                    </el-table-column> -->
                                    <el-table-column prop="projectName" label="项目名称">
                                    </el-table-column>
                                    <el-table-column prop="unitName" label="工作室名称">
                                    </el-table-column>
                                  </el-table>
                                </el-form>
                                <router-link to="/modifyInfo" style="float:right;">详情</router-link>
                              </el-dialog>
                        </li>
                    </ul>
                </div>
                <div class="options basic">
                    <h3 class="title">银行卡管理</h3>
                    <ul>
                        <li >
                            <p>银行卡</p>
                            <div class="edit-box">
                                <span>{{test1}}</span>
                            </div>
                            <!-- <template slot-scope="scope"> -->
                                <el-button  type="primary" icon="edit" @click="showSetup">设置</el-button>
                                  <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible4" style="display: none;" >
                                  <el-form class="small-space" label-position="left" label-width="80px"
                                          style='width: 300px; margin-left:50px;'>
                                    <el-form-item label="银行卡">
                                      <span>{{test1}}</span>
                                    </el-form-item>
                                    <el-form-item label="默认卡号">
                                      <el-radio v-model="radio" label="1">是</el-radio>
                                      <el-radio v-model="radio" label="0">否</el-radio>
                                    </el-form-item>
                                    <el-form-item label="是否解绑">
                                      <el-radio v-model="radioRelieve" label="1">是</el-radio>
                                      <el-radio v-model="radioRelieve" label="0">否</el-radio>
                                    </el-form-item>
                                    <el-form-item label="密码" required v-if="radioRelieve=='1'">
                                      <el-input type="password"></el-input>
                                    </el-form-item>
                                  </el-form>
                                  <div slot="footer" class="dialog-footer">
                                    <el-button @click="dialogFormVisible4 = false">取 消</el-button>
                                    <el-button type="primary" @click="updateCardInfo">确 认</el-button>
                                  </div>
                              </el-dialog>
                            <!-- </template> -->
                        </li>
                        <li>
                        <el-button  type="primary" icon="edit" @click="showAddCard">新增银行卡</el-button>
                          <el-dialog :title="textMap[dialogStatus]" :visible.sync="dialogFormVisible5" style="display: none;" >
                                  <el-form class="small-space" label-position="left" label-width="80px"
                                          style='width: 300px; margin-left:50px;'>
                                    <el-form-item label="银行卡号">
                                      <el-input type="text"></el-input>
                                    </el-form-item>
                                    <el-form-item label="默认卡号">
                                      <el-radio v-model="radio" label="1">是</el-radio>
                                      <el-radio v-model="radio" label="0">否</el-radio>
                                    </el-form-item>
                                    <el-form-item label="密码" required>
                                      <el-input type="password"></el-input>
                                    </el-form-item>
                                  </el-form>
                                  <div slot="footer" class="dialog-footer">
                                    <el-button @click="dialogFormVisible5 = false">取 消</el-button>
                                    <el-button type="primary" @click="insertCard">确 认</el-button>
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

  import SNavBar from '@/components/NavBar/studio';
  import CNavBar from '@/components/NavBar/company';
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
        dialogStatus: 'update',
        dialogFormVisible1: false,
        dialogFormVisible2: false,
        dialogFormVisible3: false,
        dialogFormVisible4: false,
        dialogFormVisible5: false,
        radio: '1',
        radioRelieve: '0',
        test:{
          test1 : "",
          test2 : "",
        },
        textMap: {
          update: '',
          showCash: '提现',
          completedDeal: '已完成交易项目',
          completingDeal: '未完成交易项目',
          setup: '设置',
          addCard: '新增银行卡'
        },
        dateMap:[{
          text: '2018-03-01', 
          value: '2018-03-01'
          }, {
          text: '2018-03-02',
          value: '2018-03-02'
          }, {
          text: '2018-03-03',
          value: '2018-03-03'
          }, {
          text: '2018-03-04',
          value: '2018-03-04'
          }],
        user: {
          roleId:"",
          projectName:"",
          progressLog:"",
          finalPayment:"",
          unitName:"",
          balance:"",
          completedTransactions:"",
          outstandingTransactions:""
        },
        completedTransactionsList:[],
        outstandingTransactionsList:[],
        options: [{
          value: '1',
          label: '银行卡'
        }, {
          value: '2',
          label: '支付宝'
        }],
        value: '',
         tableData: [{
          date: '2018-03-02',
          name: '张',
          address: '浙江',
          salary:'999',
        }, {
          date: '2018-03-04',
          name: '张',
          address: '大学',
          salary:'998',
        }, {
          date: '2018-03-01',
          name: '张',
          address: '宁波',
          salary:'997',
        }, {
          date: '2018-03-03',
          name: '张',
          address: '理工',
        },{
          date: '2018-03-04',
          name: '张',
          address: '学院',
        },{
          date: '2018-03-04',
          name: '张',
          address: '数据',
        },{
          date: '2018-03-04',
          name: '张',
          address: '',
        },{
          date: '2018-03-04',
          name: '张',
          address: '123456',
        }],
        dialogImageUrl: '',
        dialogVisible: false
      }
    },
    created() { 
      this.user.unitName = this.$root.unitName;
      this.user.roleId = this.$root.loginedRoleId;
      this.getBalance();
      this.getCompletedTransactions();
      this.getOutstandingTransactions();
      this.cardNumTransform();
    },
    methods: {
      getOutstandingTransactions() {
        this.api({
        url: "/transaction/countOutstandingTransactions",
        method: "post",
        data:this.user,
        }).then(data => {
          this.user.outstandingTransactions = data.count;
          this.outstandingTransactionsList = data.list;
        });
      },
      getCompletedTransactions() {
        this.api({
        url: "/transaction/countCompletedTransactions",
        method: "post",
        data:this.user,
        }).then(data => {
          this.user.completedTransactions = data.count;
          this.completedTransactionsList = data.list;
        });
      },
      getBalance() {
        this.api({
        url: "/transaction/getBalance",
        method: "post",
        data:this.user,
        }).then(data => {
          this.user.balance = data.balance.balance.toFixed(2);
        });
      },
      cardNumTransform() {
        var num1 = "4561234832185443";
        var num2 = "1231234832185443";
        this.test1 = num1.substring(0,3) + "******" + num1.substring(num1.length-3);
        this.test2 = num1.substring(0,3) + "******" + num1.substring(num1.length-3);
      },
      showCash() {
        // let user;
        this.dialogFormVisible1 = true;
        this.dialogStatus = 'showCash';
      },
      showFinishedRecord() {
        // let user;      
        this.dialogFormVisible2 = true;
        this.dialogStatus = 'completedDeal';
      },
      showFinishingRecord() {
        // let user;
        this.dialogFormVisible3 = true;
        this.dialogStatus = 'completingDeal';
      },
      showSetup() {
        this.dialogFormVisible4 = true;
        this.dialogStatus = 'setup';
      },
      showAddCard() {
        this.dialogFormVisible5 = true;
        this.dialogStatus = 'addCard';
      },
      cashWithdrawal() {
      },
      updateCardInfo() {
      },
      insertCard() {
      },
      formatter(row, column) {
        return row.address;
      },
      filterTag(value, row) {
        return row.tag === value;
      },
      filterHandler(value, row, column) {
        const property = column['property'];
        return row[property] === value;
      },
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
        
      }
    },
    components: {SNavBar,CNavBar},
  }
  
  
</script>

<style rel="stylesheet/scss" lang="scss" scoped>

  .el-form small-space, .el-form--label-left {
    width: 800px; margin-left: 50px;
  }
  .el-table, .el-table--fit, .el-table--enable-row-hover, .el-table--enable-row-transition{
    width: 600px;margin-left: 50px;
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
    //float: left;
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

