<template>
  <div class="header">
    <SNavBar></SNavBar>
    <div class="padding-leftandright gray-bgcolor">
      <div class="filter-container">
        <el-form>
          <el-form-item>
            <el-row>
              <div class="project-filter-content">
                <div class="expand-option filter-item">
                  <div class="expand-option-content">
                    <div class="project-label">项目类型：</div>
                    <div class="option-content">
                      <div class="option-list">
                        <div>
                          <li
                            class="liMenu"
                            :class="idxType==indexType?'type':''"
                            @click="selectType(itemType,idxType)"
                            v-for="(itemType,idxType) in type"
                            :key="idxType"
                          >{{itemType}}</li>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- <div class="expand-option filter-item">
                  <div class="expand-option-content">
                    <div class="project-label">招标状态</div>
                    <div class="option-content">
                      <div class="option-list">
                        <div>
                          <li
                            class="liMenu"
                            :class="idxSchedule==indexSchedule?'schedule':''"
                            @click="selectStatus(itemSchedule,idxSchedule)"
                            v-for="(itemSchedule,idxSchedule) in schedule"
                            :key="idxSchedule"
                          >{{itemSchedule}}</li>
                        </div>
                      </div>
                    </div>
                  </div>
                </div> -->
                <div class="expand-option filter-item">
                  <div class="expand-option-content">
                    <div class="project-label">项目角色：</div>
                    <div class="option-content">
                      <div class="option-list">
                        <div>
                          <li
                            class="liMenu"
                            :class="idxRole==indexRole?'role':''"
                            @click="selectRole(itemRole,idxRole)"
                            v-for="(itemRole,idxRole) in role"
                            :key="idxRole"
                          >{{itemRole}}</li>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </el-row>
          </el-form-item>
        </el-form>
      </div>
      <el-form>
        <div class="white-bgcolor">
          <div class="item-container-2Txk_">
            <div class="item-content--DS7m">
              <el-row
                :data="demandList"
                v-loading.body="listLoading"
                element-loading-text="拼命加载中"
                border
                fit
                highlight-current-row
              >
                <el-col :span="24" v-for="o in demandList" :key="o" >
                  <el-card :body-style="{ padding: '5px' }">
                    <div class="icon-content-3GTl0">
                        <p v-if="o.projectType=='Web网站'">
                          <img class="img-background" :src="web">
                        </p>
                        <p v-if="o.projectType=='APP开发'">
                          <img class="img-background" :src="APP">
                        </p>
                        <p v-if="o.projectType=='微信公众号'">
                          <img class="img-background" :src="weixin">
                        </p>
                        <p v-if="o.projectType=='HTML5应用'">
                          <img class="img-background" :src="html5">
                        </p>
                        <p v-if="o.projectType=='小程序'">
                          <img class="img-background" :src="small">
                        </p>
                        <p v-if="o.projectType=='其他'">
                          <img class="img-background" :src="other">
                        </p>
                        <a @click="studioInfo(o.id)">
                        </a>
                    </div>
                    <div class="body-content-2y6ks">
                      <div class="info-body-34ARl">
                        <div class="title-2q5sH">
                          <a @click="studioInfo(o.id)" class="name-UUeBS">
                            <span class="no-3TiXA">NO.</span>
                            <span class="no-3TiXA">{{o.id}}</span>
                            <span class="name-UUeBS">
                              <span class>{{o.projectName}}</span>
                            </span>
                            <span class="status-3kUbT recruiting">{{o.tenderStatus}}</span>
                          </a>
                          <span class="price-2qRFd">
                            <span class="bargain-1QpRQ"></span>
                            <span class="money-LMlJK">
                              <span>&yen;{{o.projectBudget}}</span>
                            </span>
                          </span>
                        </div>
                        <div>
                          <div class="label-2n6KW">
                            <label>招募：</label>
                            <span>{{o.recruitmentRole}}</span>
                          </div>
                          <div class="label-2n6KW">
                            <label>类型：</label>
                            <span>{{o.projectType}}</span>
                          </div>
                          <div class="label-2n6KW">
                            <label>周期(天)：</label>
                            <span>{{o.projectCycle}}</span>
                          </div>
                        </div>
                        <div class="time-2b2Sj">
                          <span>13 小时前发布</span>
                          <span>0人报名</span>
                        </div>
                      </div>
                    </div>
                  </el-card>
                </el-col>
              </el-row>
            </div>
            <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              :page-size="pageRow"
              :total="totalCount"
              :page-sizes="[10, 20, 50, 100]"
              layout="total, sizes, prev, pager, next, jumper"
            ></el-pagination>
          </div>
        </div>
      </el-form>
    </div>
  </div>
  <!-- //header -->
</template>


<script>
import img_404 from "@/assets/404_images/404.png";
import img_404_cloud from "@/assets/404_images/404_cloud.png";
import $ from "jquery";
import img_1 from "@/images/1.jpg";
import img_2 from "@/images/2.jpg";
import web from "@/images/web.png";
import APP from "@/images/APP.png";
import weixin from "@/images/weixin.png";
import html5 from "@/images/html5.png";
import small from "@/images/small.png";
import other from "@/images/other.png";
import SNavBar from "@/components/NavBar/studio";
import CNavBar from "@/components/NavBar/company";
import VNavBar from "@/components/NavBar/viewer";

export default {
  data() {
    return {
      img_404,
      img_404_cloud,
      img_1,
      img_2,
      web,
      APP,
      html5,
      other,
      small,
      weixin,
      pageNum:1,
      pageRow:50,
      listLoading: false, 
      totalCount:0,
      type: [
        "全部",
        "Web网站",
        "APP开发",
        "微信公众号",
        "HTML5应用",
        "小程序",
        "其他"
      ],
      schedule: ["全部", "招标中", "已结束"],
      demandList: [],
      role: [
        "全部",
        "项目经理",
        "产品经理",
        "设计师",
        "Android开发",
        "iOS开发",
        "前端开发",
        "后端开发",
        "全栈开发",
        "应用开发",
        "开发团队",
        "测试工程师"
      ],
      selectedItems: {
        projectType: "全部",
        tenderStatus: "全部",
        recruitmentRole: "全部"
      },
      indexType: 0,
      indexSchedule: 0,
      indexRole: 0
    };
  },
  created: function() {
    this.getAllDemand();
  },
  computed: {
    message() {
      return "页面找不到了......";
    }
  },
  methods: {
    selectType(itemType, idxType) {
      this.indexType = idxType;
      this.selectedItems.projectType = itemType;
      this.api({
        url: "/classify/filterDemand",
        method: "post",
        data: this.selectedItems
      }).then(data => {
        this.totalCount = data.totalCount
        this.demandList = data.list;
        for (var index = 0; index < this.demandList.length; index++) {
          if (this.demandList[index].tenderStatus == 1) {
            this.demandList[index].tenderStatus = "招募中";
          } else {
            this.demandList[index].tenderStatus = "已结束";
          }
        }
      });
    },
    selectStatus(itemSchedule, idxSchedule) {
      this.indexSchedule = idxSchedule;
      if (itemSchedule == "招标中") {
        this.selectedItems.tenderStatus = "1";
      } else if (itemSchedule == "已结束") {
        this.selectedItems.tenderStatus = "2";
      } else {
        this.selectedItems.tenderStatus = "全部";
      }
      this.api({
        url: "/classify/filterDemand",
        method: "post",
        data: this.selectedItems
      }).then(data => {
        this.totalCount = data.totalCount
        this.demandList = data.list;
        for (var index = 0; index < this.demandList.length; index++) {
          if (this.demandList[index].tenderStatus == 1) {
            this.demandList[index].tenderStatus = "招募中";
          } else if (this.demandList[index].tenderStatus == 2) {
            this.demandList[index].tenderStatus = "已结束";
          }
        }
      });
    },
    selectRole(itemRole, idxRole) {
      this.indexRole = idxRole;
      this.selectedItems.recruitmentRole = itemRole;
      this.api({
        url: "/classify/filterDemand",
        method: "post",
        data: this.selectedItems
      }).then(data => {
        this.totalCount = data.totalCount
        this.demandList = data.list;
        for (var index = 0; index < this.demandList.length; index++) {
          if (this.demandList[index].tenderStatus == 1) {
            this.demandList[index].tenderStatus = "招募中";
          } else if (this.demandList[index].tenderStatus == 2) {
            this.demandList[index].tenderStatus = "已结束";
          }
        }
      });
    },
    getAllDemand() {
      this.api({
        url: "/classify/getAllDemand",
        method: "post",
        data: this.selectedItems
      }).then(data => {
        this.demandList = data.list;
        this.totalCount = data.totalCount
        for (var index = 0; index < this.demandList.length; index++) {
          if (this.demandList[index].tenderStatus == "1") {
            this.demandList[index].tenderStatus = "招募中";
          } else if (this.demandList[index].tenderStatus == "2") {
            this.demandList[index].tenderStatus = "已结束";
          }
        }
      });
    },
    studioInfo(id) {
      this.$router.push({
        path: "/projectMessage",
        query: {
          projectName: "M000989",
          projectId: id
        }
      });
    },
    handleSizeChange(val) {
      //改变每页数量
      this.studioMessage.pageRow = val;
      this.handleFilter();
    },
    handleCurrentChange(val) {
      //改变页码
      this.studioMessage.pageNum = val;
      this.getList();
    },
    handleFilter() {
      //查询事件
      this.studioMessage.pageNum = 1;
      this.getList();
    },
    getIndex($index) {
      //表格序号
      return (
        (this.studioMessage.pageNum - 1) * this.studioMessage.pageRow +
        $index +
        1
      );
    },
  },
  components: { SNavBar, CNavBar, VNavBar }
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

.project-filter-container {
  background: #fff;
  box-shadow: 0 1px 2px 0 rgba(31, 45, 61, 0.1);
  border-radius: 4px;
  margin-bottom: 1rem;
  padding: 2rem;
  border-bottom: 1px solid #eff2f7;
}
.project-filter-content {
  padding: 2rem;
  border-bottom: 1px solid #eff2f7;
  background-color: #f8f9fa;
}
.filter-item {
  border-bottom: 1px solid #eff2f7;
}
.expand-option .expand-option-content {
  padding-top: 0.5rem;
}
.expand-option .expand-option-content .option-content {
  margin-left: 8rem;
  position: relative;
}
.expand-option .expand-option-content .option-content .option-list {
  padding-right: 6rem;
}
.expand-option .expand-option-content .option-content .option {
  display: inline-block;
  padding: 0.32rem 1.2rem;
  color: #273444;
  font-size: 0.9rem;
  line-height: 1.35rem;
  cursor: pointer;
  margin: 0 0.1rem 1rem;
}
.expand-option .expand-option-content .option-content .option.all {
  border-radius: 2px;
  background: #4289dc;
  color: #fff;
}
.item-container-2Txk_ {
  border-bottom: 1px solid #eff2f7;
}
.item-container-2Txk_ .item-content--DS7m {
  padding: 1.5rem 0;
  display: table;
  width: 100%;
  box-sizing: border-box;
}
.item-container-2Txk_ .item-content--DS7m .icon-content-3GTl0 {
  width: 10.71rem;
  overflow: hidden;
  position: relative;
  border-radius: 2px;
}
a {
  color: #108ee9;
  background: transparent;
  text-decoration: none;
  outline: none;
  cursor: pointer;
  transition: color 0.3s ease;
}
.item-container-2Txk_ .item-content--DS7m .body-content-2y6ks {
  position: relative;
}
.item-container-2Txk_ .item-content--DS7m .body-content-2y6ks .info-body-34ARl {
  padding-left: 1.5rem;
  margin-bottom: 1.2rem;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .title-2q5sH {
  line-height: 1.8rem;
  margin-bottom: 0.5rem;
  word-break: break-all;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .name-UUeBS {
  color: #273444;
  font-size: 1.2rem;
  font-weight: 400;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .no-3TiXA {
  margin-right: 0.5rem;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .name-UUeBS {
  color: #273444;
  font-size: 1.2rem;
  font-weight: 400;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .recruiting {
  border: 1px solid #61c279;
  color: #61c279;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .price-2qRFd {
  float: right;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .bargain-1QpRQ {
  color: #8796a8;
  font-size: 1rem;
  margin: 0 0.5rem;
}
.money-LMlJK {
  color: #f75288;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .label-2n6KW {
  font-size: 1rem;
  line-height: 1.5rem;
  margin-right: 2rem;
  display: inline-block;
}
.label-2n6KW span {
  color: #3c4858;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .time-2b2Sj {
  color: #8796a8;
  font-size: 0.9rem;
  line-height: 1.35rem;
  position: absolute;
  bottom: 0;
}
.item-container-2Txk_
  .item-content--DS7m
  .body-content-2y6ks
  .info-body-34ARl
  .time-2b2Sj
  span:first-child {
  padding-left: 0;
}
.item-container-2Txk_ .item-content--DS7m .icon-content-3GTl0 img.img-1 {
  width: 60%;
  position: absolute;
  left: 0;
  top: 0;
  overflow: hidden;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
}
.item-container-2Txk_ .item-content--DS7m .body-content-2y6ks,
.item-container-2Txk_ .item-content--DS7m .icon-content-3GTl0 {
  display: table-cell;
  vertical-align: top;
}

.liMenu {
  margin-right: 20px;
  cursor: pointer;
  display: inline-block;
  padding: 0.32rem 1.2rem;
  color: #273444;
  font-size: 0.9rem;
  line-height: 1.45rem;
  cursor: pointer;
  margin: 0 0.1rem 1rem;
}
.liMenu.type {
  color: #fff;
  background: #4289dc;
}
.liMenu.schedule {
  color: #fff;
  background: #4289dc;
}
.liMenu.role {
  color: #fff;
  background: #4289dc;
}
.padding-leftandright {
  padding-left: 20%;
  padding-right: 20%;
  padding-top: 3%;
}
.gray-bgcolor {
  background: #f0f2f5;
}
.white-bgcolor {
  background: white;
}
.padding-top20 {
  padding-top: 20px;
}
</style>
