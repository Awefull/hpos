<template>
  <div class="header">
    <CNavBar></CNavBar>
    <div class="title">
      <div class="title-left">
        <li class="dropdown head-dpdn">
            <a style="color:black" class="dropdown-toggle"><i class="fa fa-comment" aria-hidden="true"></i>
                      工作室信息</a>
        </li> 
      </div>
    </div>
    <div class="padding-leftandright gray-bgcolor">
      <div class="filter-container">
        <el-form>
          <el-form-item>
            <el-row>
              <div class="project-filter-content">
                <div class="expand-option filter-item">
                  <div class="expand-option-content">
                    <div class="project-label">擅长的项目类型：</div>
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
                <div class="expand-option filter-item">
                  <div class="expand-option-content">
                    <div class="project-label">服务提供地：</div>
                    <div class="option-content">
                      <div class="option-list">
                        <div>
                          <li
                            class="liMenu"
                            :class="idxServiceProvide==indexServiceProvide?'serviceProvide':''"
                            @click="selectServiceProvide(itemServiceProvide,idxServiceProvide)"
                            v-for="(itemServiceProvide,idxServiceProvide) in serviceProvide"
                            :key="idxServiceProvide"
                          >{{itemServiceProvide}}</li>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="expand-option filter-item">
                  <div class="expand-option-content">
                    <div class="project-label">已服务雇主数量：</div>
                    <div class="option-content">
                      <div class="option-list">
                        <div>
                          <li
                            class="liMenu"
                            :class="idxServiceNum==indexServiceNum?'serviceNum':''"
                            @click="selectServiceNum(itemServiceNum,idxServiceNum)"
                            v-for="(itemServiceNum,idxServiceNum) in serviceNum"
                            :key="idxServiceNum"
                          >{{itemServiceNum}}</li>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="expand-option filter-item">
                  <div class="expand-option-content">
                    <div class="project-label">排序：</div>
                    <div class="option-content">
                      <div class="option-list">
                        <div>
                          <li
                            class="liMenu"
                            :class="idxEvaluate==indexRandType?'evaluate':''"
                            @click="selectEvaluate(itemEvaluate,idxEvaluate)"
                            v-for="(itemEvaluate,idxEvaluate) in evaluate"
                            :key="idxEvaluate"
                          >{{itemEvaluate}}</li>
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
                :data="list"
                v-loading.body="listLoading"
                element-loading-text="拼命加载中"
                border
                fit
                highlight-current-row
              >
                <el-col :span="24" v-for="o in list" :key="o" class="padding-top20">
                  <el-card :body-style="{ padding: '5px' }">
                    <div class="icon-content-3GTl0">
                      <p v-if="o.unitName=='田丁科技'">
                          <img class="img-background" :src="tianding">
                      </p>
                      <p v-if="o.unitName=='程序员'">
                          <img class="img-background" :src="chengxuyuan">
                      </p>
                       <p v-if="o.unitName=='温州邮箱公司'">
                          <img class="img-background" :src="wenzhouyouxiang">
                      </p>
                      <a @click="studioInfo(o.unitName)">
                        <!-- <img class="img-background" :src="img_1"> -->
                      </a>
                    </div>
                    <div class="body-content-2y6ks">
                      <div class="info-body-34ARl">
                        <div class="title-2q5sH">
                          <a @click="studioInfo(o.unitName)" class="name-UUeBS">
                            <span class="no-3TiXA">NO.</span>
                            <span class="no-3TiXA">{{o.id}}</span>
                          </a>
                        </div>
                        <div>
                          <div class="label-2n6KW">
                            <label>工作室名称：</label>
                            <span>{{o.unitName}}</span>
                          </div>
                          <div class="label-2n6KW">
                            <label>单位地点：</label>
                            <span>{{o.address}}</span>
                          </div>
                          <div class="label-2n6KW">
                            <label>已做项目数量：</label>
                            <span>{{o.finishedProjectNum}}</span>
                          </div>
                        </div>
                        <div class="time-2b2Sj">
                          <span>13 小时前发布</span>
                          <span>0人报名</span>
                        </div>
                        <div class="evaluate">
                          <label>评价：</label>
                        </div>
                        <div class="label-2n6KW">
                            <label>需求指标评价：</label>
                            <el-rate v-model="o.evaluateDemand" disabled show-score text-color="#ff9900"></el-rate>
                        </div>
                        <br>
                        <br>
                        <div class="label-2n6KW">
                            <label>能力指标评价：</label>
                            <el-rate v-model="o.evaluateAbility" disabled show-score text-color="#ff9900"></el-rate>
                        </div>
                        <br>
                        <br>
                        <div class="label-2n6KW">
                            <label>计划指标评价：</label>
                            <el-rate v-model="o.evaluatePlan" disabled show-score text-color="#ff9900"></el-rate>
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
              :current-page="studioMessage.pageNum"
              :page-size="studioMessage.pageRow"
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
import tianding from "@/images/tianding.png";
import chengxuyuan from "@/images/chengxuyuan.png";
import wenzhouyouxiang from "@/images/wenzhouyouxiang.png";
import SNavBar from "@/components/NavBar/studio";
import CNavBar from "@/components/NavBar/company";
import VNavBar from "@/components/NavBar/viewer";

export default {
  data() {
    return {
      img_404,
      img_404_cloud,
      img_1,
      tianding,
      chengxuyuan,
      wenzhouyouxiang,
      type: [
        "全部",
        "Web网站",
        "APP开发",
        "微信公众号",
        "HTML5应用",
        "小程序",
        "其他"
      ],
      serviceProvide: [
        "全部",
        "北京",
        "上海",
        "广州",
        "深圳",
        "杭州",
        "河北",
        "山西",
        "四川",
        "重庆",
        "江苏",
        "辽宁",
        "吉林",
        "黑龙江",
        "广西",
        "贵州"
      ],
      serviceNum: [
        "20以下",
        "20-50",
        "50-100",
        "100-150",
        "150-200",
        "200+",
      ],
      evaluate: [
        "综合评价优先",
        "需求指标评价优先",
        "能力指标评价优先",
        "计划指标评价优先",
	  ],
      indexType: 0,
      indexServiceProvide: 0,
      indexServiceNum: 0,
      indexRandType: 0,
      totalCount: 0, //分页组件--数据总条数
      projectCount: 0, //项目数量
      list: [], //表格的数据
      unitList: [],
      listLoading: false, //数据加载等待动画
      selectedItems: {
        projectType: "全部",
        tenderStatus: "全部",
        recruitmentRole: "全部"
      },
      studioMessage: {
        description: "",
        unitName: "",
        address: "",
        telephone: "",
        evaluate: "",
        finishedProjectNum:"",
        pageNum: 1, //页码
        pageRow: 50 //每页条数
      },
      selectedItems:{
        projectType: "全部",
        servePlace: "全部",
        alreadyServed: "20以下",
        orderBy:"综合评论优先",
      }
    };
  },
  created: function() {
    this.getList();
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
        url: "/studioInfo/filterStudio",
        method: "post",
        data: this.selectedItems
      }).then(data => {
        this.listLoading = false;
        this.list = data.list;
        this.totalCount = data.totalCount;
      });
    },
    selectServiceProvide(itemServiceProvide, idxServiceProvide) {
      // this.indexServiceProvide = idxServiceProvide;
      this.indexServiceProvide = idxServiceProvide;
      this.selectedItems.servePlace = itemServiceProvide; 
      this.api({
        url: "/studioInfo/filterStudio",
        method: "post",
        data: this.selectedItems
      }).then(data => {
        this.listLoading = false;
        this.list = data.list;
        this.totalCount = data.totalCount;
      });
    },
    selectServiceNum(itemServiceNum, idxServiceNum) {
      this.indexServiceNum = idxServiceNum;
      this.selectedItems.alreadyServed = itemServiceNum; 
      this.api({
        url: "/studioInfo/filterStudio",
        method: "post",
        data: this.selectedItems
      }).then(data => {
        this.listLoading = false;
        this.list = data.list;
        this.totalCount = data.totalCount;
      });
    },
    selectEvaluate(itemEvaluate, idxEvaluate) {
      this.indexRandType = idxEvaluate;
      this.selectedItems.orderBy = itemEvaluate; 
      this.api({
        url: "/studioInfo/filterStudio",
        method: "post",
        data: this.selectedItems
      }).then(data => {
        this.listLoading = false;
        this.list = data.list;
        this.totalCount = data.totalCount;
      });
    },
    getList() {
      //查询列表
      this.listLoading = true;
      this.api({
        url: "/studioInfo/listStudioInfo",
        method: "get",
        params: this.studioMessage
      }).then(data => {
          this.listLoading = false;
          this.list = data.list;
          this.totalCount = data.totalCount;
          //this.getCount();
        })
        .catch(() => {
          this.$message.error("查询失败");
        });
    },
    studioInfo(studioName) {
      this.$router.push({
        path: "/studioMessage",
        query: {
          studioName: studioName,
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
    // getCount() {
    //   for (let i = 0; i < this.list.length; i++) {
    //         this.unitList[i] = this.list[i].unitName;
    //       }
    //   //查询列表
    //   this.api({
    //     url: "/studioProjectManagement/countProjectNum",
    //     method: "get",
    //     params: this.unitList
    //   })
    //     .then(data => {
    //       this.projectCount = data.count;
    //     })
    //     .catch(() => {
    //       this.$message.error("查询失败");
    //     });
    // }
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
  .title{
    background: transparent;
    padding: 2em 2em;
    position: fixed;
}
  .title-left {
    float: left;
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
  background-color: white;
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
  margin-right: 2rem;
  display: inline-block;
  line-height: 1.8rem;
  margin-bottom: 0.5rem;
  word-break: break-all;
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
.liMenu.serviceProvide {
  color: #fff;
  background: #4289dc;
}
.liMenu.serviceNum {
  color: #fff;
  background: #4289dc;
}
.liMenu.evaluate {
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
</style>
