<template>
  <div>
    <CNavBar></CNavBar>
    <div class="header">
      <div class="header-left">
        <li class="dropdown head-dpdn">
            <a style="color:black" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
              项目管理</a>
            <br>
        </li>
            <a style="color:black;margin-left:4em">↓</a>
            <br>
        <li class="dropdown head-dpdn">
            <a style="color:black" class="dropdown-toggle"><i class="fa fa-user" aria-hidden="true"></i>
              项目招募</a>
        </li> 
      </div>
    </div>
    <div class="uc-layer-top self">
          <div class="uc-avatar face-icon">
              <img id="user-avatar" src="//img.ketangpai.com/ketangpai.aliapp.com/1/webroot/Uploads/Download/2017-02-28/1488264570.jpg%40%2162-62?OSSAccessKeyId=LTAItfPkNIKJFibY&amp;Expires=1867647789&amp;Signature=6XDeX%2BSsliObX1S38FAbsZunQ60%3D" alt="张智涵">
              <a href="javascript:;" class="change-avatar avatar upload">更改头像</a>
              <div class="marks"></div>
          </div>
          <h1 class="uc-name">{{this.$root.username}}</h1>
          <div class="s-header">
              <div class="h-nav">
                  <a href="#companyManageUnrecruited">项目招募</a>
                  <router-link to="/companyManageProgress">项目进行</router-link>
                  <router-link to="/companyManageFinished">项目已完成</router-link>
              </div>
          </div>
    </div>
     <div class="app-container">
        <el-table :data="list" v-loading.body="listLoading" element-loading-text="拼命加载中" border fit
                  highlight-current-row>
          <el-table-column align="center" label="序号" width="80">
            <template slot-scope="scope">
              <span v-text="getIndex(scope.$index)"> </span>
            </template>
          </el-table-column>

          <el-table-column align="center" label="项目标题" prop="projectName" style="width: 60px;">
          </el-table-column>
          <el-table-column align="center" label="项目详情" style="width: 60px;">
            <template slot-scope="scope">
            <a href="javascript:void(0);" @click="goParamDemand(scope.row.projectName)">查看</a>
            </template>
          </el-table-column>
           <el-table-column align="center" label="招募进度" prop="tenderStatus" width="170">
            <template slot-scope="scope">
              <p v-if="scope.row.tenderStatus==0">招募中</p>
              <p v-if="scope.row.tenderStatus==1">招募结束</p>
            </template>
          </el-table-column>
          <el-table-column align="center" label="工作室信息" prop="studioName" width="170">
            <template slot-scope="scope">
              <!-- <router-link to='/studioMessage'> -->
              <a v-if="scope.row.tenderStatus==0">未招募工作室</a>
              <a v-if="scope.row.tenderStatus==1" ><a href="javascript:void(0);" @click="goParam(scope.row.studioName)">{{scope.row.studioName}}</a></a>
              <!-- </router-link> -->
            </template>
          </el-table-column>

          <el-table-column align="center" label="定金" prop="deposit" width="170">
            <template slot-scope="scope">
              <el-button type="primary" @click="deposit(scope.row.deposit,scope.$index)" plain v-if="scope.row.tenderStatus==0">
                付款
              </el-button> 
              <el-button type="primary"  plain v-if="scope.row.tenderStatus==1" :disabled="true">
                已付款
              </el-button> 
              <el-dialog title="支付定金" :visible.sync="depositOk" :before-close="handleClose" append-to-body=""> 
                <el-form class="small-space" label-position="left" label-width="80px" style='width: 300px; margin-left:50px;'>
                  <el-form-item style="padding:0 12px 10px 0" label="工作室:">
                    <p>{{recruitedStudioName}}</p>
                  </el-form-item>
                  <el-form-item label="支付金额">
                    <p>{{depositIndex}}</p>
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
                  <el-form-item label="支付密码" required v-if="value=='1'">
                    <el-input type="password"></el-input>
                  </el-form-item>
                </el-form>
                  <span slot="footer" class="dialog-footer"> 
                    <el-button @click="depositOk = false">
                      取 消
                    </el-button> 
                    <el-button type="primary" @click="addProgressList()">
                      支付
                </el-button> 
                </span> 
              </el-dialog>
            </template>
          </el-table-column>
          <el-table-column align="center" label="招标人数" prop="applyNum" width="170">
            <template slot-scope="scope">
              <el-button type="primary" name="btn1" v-if="scope.row.tenderStatus==0"  @click="getRecruiteList(scope.$index)">
              {{scope.row.applyNum}}人(点击可筛选)
              </el-button>
              <el-button type="primary" name="btn1" v-if="scope.row.tenderStatus==1" @click="getRecruitedList(scope.$index)">
              {{scope.row.applyNum}}人(招募已完成)
              </el-button> 
              <el-dialog title="项目招标人员筛选" :visible.sync="recruitedNot" style="display: none;" >
                <el-form class="small-space" label-position="left" label-width="80px" style='width: 600px; margin-left:50px;margin-bottom:50px;'>
                  <el-table ref="filterTable" :data="recruitedList" height="250" style="width: 1000px;margin-left:50px;">
                    <el-table-column prop="updateDate" label="日期" column-key="date">                 
                    </el-table-column>
                    <el-table-column prop="projectname" label="项目名称">
                    </el-table-column>
                    <el-table-column prop="studioName" label="工作室">
                    </el-table-column>
                    <el-table-column prop="studioInfo" label="工作室详情">
                      <template slot-scope="scope">
                        <a href="javascript:void(0);" @click="goParam(scope.row.studioName)">查看</a>
                      </template>
                    </el-table-column>
                    <el-table-column prop="evaluate" label="评分" >
                      <template slot-scope="scope">
                        <el-rate v-model="scope.row.evaluate" disabled show-score text-color="#ff9900">
                        </el-rate>
                      </template>
                    </el-table-column>
                    <el-table-column label="招募">
                      <template slot-scope="scope">
                        <el-button type="primary" name="btn" v-if="scope.row.studioName!=recruitedStudioName" plain @click="recruited(scope.row.studioName,scope.row.projectname)">确定
                        </el-button>
                        <el-button type="primary" plain v-if="scope.row.studioName==recruitedStudioName" :disabled="true">已选中
                        </el-button>
                        <!-- <el-button type="primary" plain v-if="recruitedStatus==true&&scope.row.studioName!=recruitedStudioName" disabled="true">不可选
                        </el-button> -->
                      </template>
                    </el-table-column>
                  </el-table>
                </el-form>
                <el-button style="float:right;margin:-2% 1% 1%" @click="recruitedNot = false">取 消</el-button>
              </el-dialog>    
              <el-dialog title="项目招标人员筛选" :visible.sync="recruitedOk" style="display: none;" >
                <el-form class="small-space" label-position="left" label-width="80px" style='width: 600px; margin-left:50px;margin-bottom:50px;'>
                  <el-table ref="filterTable" :data="recruitedList" height="250" style="width: 1000px;margin-left:50px;">
                    <el-table-column prop="updateDate" label="日期" column-key="date">                 
                    </el-table-column>
                    <el-table-column prop="projectname" label="项目名称">
                    </el-table-column>
                    <el-table-column prop="studioName" label="工作室">
                    </el-table-column>
                    <el-table-column prop="studioInfo" label="工作室详情">
                      <template slot-scope="scope">
                        <a href="javascript:void(0);" @click="goParam(scope.row.studioName)">查看</a>
                      </template>
                    </el-table-column>
                    <el-table-column prop="evaluate" label="评分" width="170">
                      <template slot-scope="scope">
                        <el-rate v-model="scope.row.evaluate" disabled show-score text-color="#ff9900">
                        </el-rate>
                      </template>
                    </el-table-column>
                    <el-table-column label="招募">
                      <template slot-scope="scope">
                        <el-button type="primary" plain v-if="scope.$index == 0" :disabled="true">已选中
                        </el-button>
                        <el-button type="primary" plain v-if="scope.$index != 0" :disabled="true">不可选
                        </el-button>
                      </template>
                    </el-table-column>
                  </el-table>
                </el-form>
                <el-button style="float:right;margin:-2% 1% 1%" @click="recruitedOk = false">取 消</el-button>
              </el-dialog>        
            </template>
          </el-table-column>
          
          <el-table-column align="center" label="管理" width="220" >
            <template slot-scope="scope">
              <el-button type="danger" icon="delete"
                        @click="removeProject(scope.$index)">删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>
        <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="user.pageNum"
          :page-size="user.pageRow"
          :total="totalCount"
          :page-sizes="[10, 20, 50, 100]"
          layout="total, sizes, prev, pager, next, jumper">
        </el-pagination>
    </div>
  </div>  
</template>

<script>
  import {mapGetters} from 'vuex'
  import CNavBar from '@/components/NavBar/company';
  // import $ from 'jquery'
  export default {
    data() {
      return {
        dialogFormVisible:false,
        depositOk:false,
        depositIndex:'',
        dialogVisible:false,
        choose:false,
        confirm:false,
        totalCount: 0, //分页组件--数据总条数
        list: [],//表格的数据
        listLoading: false,//数据加载等待动画
        dialogStatus: 'create',
        dialogFormVisible: false,
        recruitedList:[],
        recruitedStudioName:"",
        recruitedStatus:false,
        recruitedOk:false,
        recruitedNot:false,
        index:'',
        textMap: {
          update: '编辑',
          create: '新建用户'
        },
        value:"",
        options: [{
          value: '1',
          label: '银行卡'
        }, {
          value: '2',
          label: '支付宝'
        }],
        user: {
          projectName:"",
          tenderStatus:"",
          studioName:"",
          applyNum:"",
          deposit:"",
          companyName:"",
          pageNum: 1,//页码
          pageRow: 50,//每页条数
        },
        userIndex: {
          id:"",
          projectName:"",
          tenderStatus:"",
          studioName:"",
          applyNum:"",
          deposit:"",
          companyName:"",
          deleteStatus:"",
          projectDescription:""
        },
        demandIndex:{
          projectName:'',
          id:'',
          companyName:'',
        }
      }
    },
    created() {
      this.user.companyName = this.$root.unitName;
      this.getList();
    },
    computed: {
      ...mapGetters([
        'userId'
      ])
    },
    methods: {
      getList() {
      //查询列表
      this.listLoading = true;
      this.api({
        url: "/companyProjectManagement/getNotRecruitedList",
        method: "get",
        params:this.user,
          }).then(data => {
            this.listLoading = false;
            this.list = data.list;
            this.totalCount = data.totalCount;
          });
      },
      //查询未招募列表状态
      getRecruiteList($index) {
        if (this.list[$index].tenderStatus == 1) {
          this.recruitedOk = true;
        }
        else
          this.recruitedNot = true;
        this.userIndex = this.list[$index];
        this.userIndex.companyName = this.$root.unitName;
        //this.userIndex.studioName = this.list[$index].studioName;
        this.api({
          url: "/companyProjectManagement/getRecruiteList",
          method: "post",
          data: this.userIndex
        }).then(data => {
          this.recruitedList = data.list;
        });
      },
      //查询已招募列表状态
      getRecruitedList($index) {
        this.recruitedOk = true;
        this.userIndex = this.list[$index];
        this.userIndex.companyName = this.$root.unitName;
        this.api({
          url: "/companyProjectManagement/getRecruiteList",
          method: "post",
          data: this.userIndex
        }).then(data => {
          this.recruitedList = data.list;
        });
      },
      //等价于刷新页面将未招募变为招募完成
      getRecruited(projectName) {
        this.userIndex.projectName = projectName;
        this.userIndex.companyName = this.$root.unitName;
        this.api({
          url: "/companyProjectManagement/getRecruiteList",
          method: "post",
          data: this.userIndex
        }).then(data => {
          this.recruitedList = data.list;
        });
      },
      //保存选择的工作室名称
      recruited(studioName, projectName) {
        //this.userIndex = this.list[$index];
        this.recruitedStatus = true;
        this.recruitedStudioName = studioName;
        this.getRecruited(projectName);
        this.getList();
        this.$message('请支付定金即可完成招募');
      },
      //支付定金后讲项目添加到进行中
      addProgressList() {
        this.userIndex = this.list[this.index];
        this.userIndex.companyName = this.$root.unitName;
        this.userIndex.studioName = this.recruitedStudioName;
        //添加项目到进行中
        this.api({
        url: "/companyProjectManagement/addProgressList",
          method: "post",
          data: this.userIndex
        }).then(() => {
          this.depositOk = false;
          this.updateNotRecruitedProject(this.index);
          this.updateStudioNotRecruitedProject(this.index);
          this.addStudioProgressList(this.index);
        })
      },
      //添加到工作室的进行项目中
      addStudioProgressList(index) {
        this.userIndex = this.list[index];
        this.userIndex.companyName = this.$root.unitName;
        this.userIndex.studioName = this.recruitedStudioName;
        this.api({
        url: "/studioProjectManagement/addStudioProgress",
          method: "post",
          data: this.userIndex
        }).then(() => {
          
        })
      },
      //招募后更新招募的工作室
      updateStudioNotRecruitedProject(index) {
        this.userIndex = this.list[index];
        this.userIndex.companyName = this.$root.unitName;
        this.userIndex.deleteStatus = 1;
        this.userIndex.studioName = this.recruitedStudioName;
        //添加项目到进行中
        this.api({
        url: "/studioProjectManagement/updateNotRecruitedBidStatus",
          method: "post",
          data: this.userIndex
        }).then(() => {
          this.getList();
          this.$message.success("项目以转移到进行中")
        }).catch(() => {
        })
      },
      //将招募的工作室信息更新企业项目
      updateNotRecruitedProject(index) {
        this.userIndex = this.list[index];
        this.userIndex.companyName = this.$root.unitName;
        this.userIndex.tenderStatus = 1;
        this.userIndex.deleteStatus = 1;
        this.userIndex.studioName = this.recruitedStudioName;
        //添加项目到进行中
        this.api({
        url: "/companyProjectManagement/updateNotRecruitedProject",
          method: "post",
          data: this.userIndex
        }).then(() => {
          this.getList();
          this.$message.success("项目以转移到进行中")
        }).catch(() => {
        })
      },
      deposit(deposit,index) {
        this.depositOk = true;
        this.index = index;
        this.depositIndex = deposit;
      },
      removeProject($index) {
        this.$confirm('此操作将永久删除该项目, 是否继续?', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.removeProjectNow($index);
          this.$message({
            type: 'success',
            message: '删除成功!'
          });
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });          
        });
      },
      removeProjectNow($index) {
        this.userIndex = this.list[$index];
        this.userIndex.companyName = this.$root.unitName;
        this.userIndex.deleteStatus = 0;
        //添加项目到进行中
        this.api({
        url: "/companyProjectManagement/updateNotRecruitedProject",
          method: "post",
          data: this.userIndex
        }).then(() => {
          this.getList();
        }).catch(() => {
            this.$message.error("删除失败")
          })
      },
      goParam:function(msg){
        this.$router.push({
        path:'/studioMessage',
        query:{
          studioName:msg
        }
        })
      },
      goParamDemand:function(projectName) {
        this.demandIndex.projectName = projectName;
        this.demandIndex.companyName = this.$root.unitName;
        this.api({
          url: "/classify/getDemandIdByProjectName",
          method: "post",
          data: this.demandIndex
        }).then(data => {
          this.demandIndex.id = data.json.id;
          this.$router.push({
          path: "/projectMessage",
          query: {
            projectName: "M000989",
            projectId: this.demandIndex.id
          }
        });
        })
      },
      handleClose(done) {
        this.depositOk = false;
      },
      handleSizeChange(val) {
        //改变每页数量
        this.user.pageRow = val
        this.handleFilter();
      },
      handleCurrentChange(val) {
        //改变页码
        this.user.pageNum = val
        this.getList();
      },
      handleFilter() {
        //查询事件
        this.user.pageNum = 1
        this.getList()
      },
      getIndex($index) {
        //表格序号
        return (this.user.pageNum - 1) * this.user.pageRow + $index + 1
      },
      filterHandler(value, row, column) {
        const property = column['property'];
        return row[property] === value;
      },
      showCreate() {
        //显示新增对话框
        this.dialogStatus = "create"
        this.dialogFormVisible = true
      },
    },
    components: {CNavBar},
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
  .uc-layer-top.self {
    height: 280px;
    margin-top: 65px;
  }

  .uc-avatar {
      width: 115px;
      margin: 45px auto 0;
      background-color: #fff;
      position: relative;
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
  .h-nav:hover{
    color: #000000
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

  .item-change .t-tips {
    line-height: 30px;
    color: #AAAAAA;
    margin-top: 30px;
    padding-bottom: 60px;
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
    float: left;
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
  .s-header .h-nav a:first-child {
    margin-left: 0;
  }
  .s-header .h-nav a {
    font-size: 14px;
    margin-left: 145px;
    line-height: 40px;
    color: #aaa;
  }
  .s-header .h-nav a:active {
    color: #4D90FE;
  }
  .app-container{
      padding-left:10%;
      padding-right:10%;
      padding-bottom: 20%;
  }
</style>

