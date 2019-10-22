<template>
  <div class="header">
    <SNavBar></SNavBar>
    <div class="content padding-leftandright gray-bgcolor">
      <section class="reward-title white-bgcolor">
        <input style="display:none" value="17905" name="id">
        <div class="title-row">
          <span class="title">{{projectMessage[0].projectName}}</span>
          <span class="status status-2 pull-right">{{projectMessage[0].tenderStatus}}</span>
        </div>
        <div class="desc-row">
          <div class="role-type">
            <span class="reward-no">No.{{projectMessage[0].id}}</span>
            <span class="type">{{projectMessage[0].recruitmentRole}}&nbsp;</span>
          </div>
        </div>
        <div class="detail-row clearfix">
          <span class="detail-span border-right">
            <span class="darker">金额</span>{{projectMessage[0].projectBudget}}
          </span>
          <span class="detail-span border-right">
            <span class="darker">类型</span> {{projectMessage[0].projectType}}
          </span>
          <span class="detail-span border-right">
            <span class="darker">周期</span> {{projectMessage[0].projectCycle}}&nbsp;天
          </span>
          <span class="detail-span">
            <span class="darker">需求类型</span> {{projectMessage[0].demandType}}
          </span>
          <el-button type="primary" size="medium" @click="participationProject">参与项目</el-button>
        </div>
      </section>
      <div class="apply-and-evaluation clearfix">
        <div class="reward-evaluation">
          <div class="evaluation-group">
            <!-- <i class="fa fa-money" aria-hidden="true" style="color:#5b91f2" ></i>  -->
            <el-badge :value=projectMessage[0].commentMoney :max="99" class="padding_item">
              <el-tag size="medium"><a @click="commentMoneyAdd">钱太少</a></el-tag>
            </el-badge>
            <el-badge :value=projectMessage[0].commentTime :max="99" class="padding_item">
              <el-tag size="medium"><a @click="commentTimeAdd">时间紧</a></el-tag>
            </el-badge>
            <el-badge :value=projectMessage[0].commentReliable :max="99" class="padding_item">
              <el-tag size="medium"><a @click="commentReliableAdd">不靠谱</a></el-tag>
            </el-badge>
            <el-badge :value=projectMessage[0].commentHard :max="99" class="padding_item">
              <el-tag size="medium"><a @click="commentHardAdd">不会做</a></el-tag>
            </el-badge>
          </div>
        </div>
        <div class="reward-apply">报名人数:&nbsp;&nbsp;{{projectMessage[0].applyNum}}</div>
      </div>
      <section class="reward-content white-bgcolor">
        <div class="content-group">
          <h2>项目描述</h2>
          <div class="description typo fold">
            <p>{{projectMessage[0].projectDescription}}</p>
          </div>
        </div>
        <div class="content-group">
          <h2>项目规划</h2>
          <div class="content-item">
            <h4>项目周期</h4>
            <div class="content-text">
              <p>{{projectMessage[0].projectCycle}}天</p>
            </div>
          </div>
        </div>
        <div class="content-group">
          <h2>招募角色</h2>
          <div class="content-item">
            <h4>项目角色和金额</h4>
            <div class="content-text">
              <p>
                <span class="role-name">{{projectMessage[0].recruitmentRole}}</span>
                <span>&nbsp;&nbsp;&nbsp;&nbsp;{{projectMessage[0].projectBudget}}元</span>
              </p>
            </div>
          </div>
          <div class="content-item">
            <h4>项目要求</h4>
            <div class="description typo fold">
              <p>{{projectMessage[0].projectDemand}}</p>
            </div>
          </div>
        </div>
        <div class="content-group">
          <h2>需求文件</h2>
          <div class="item-content content-item">
            <div class="file-label">
              <span class="download">
                <input
                  class="url"
                  type="hidden"
                  value="https://coding-net-public-file.codehub.cn/b2b73995-41a2-4a4d-b773-ab05c27345c0.docx"
                >
                <a href="javascript:void(0);">下载</a>
              </span>
              <i class="extension">docx</i>
              <span class="filename" title="任务.docx">
                <a href="javascript:void(0)" class="owas-preview">任务.docx</a>
              </span>
              <span class="filename" title="任务.docx">
                <a href="javascript:void(0)" class="owas-preview left60">更新时间：2019/3/22</a>
              </span>
            </div>
          </div>
        </div>
      </section>
    </div>
  </div>
</template>

<script>
import img_404 from "@/assets/404_images/404.png";
import img_404_cloud from "@/assets/404_images/404_cloud.png";
import rmb from "@/images/rmb.jpg";
import clock from "@/images/clock.jpg";
import frown from "@/images/frown.jpg";
import hand from "@/images/hand.jpg";
import SNavBar from "@/components/NavBar/studio";

export default {
  data() {
    return {
      img_404,
      img_404_cloud,
      rmb,
      clock,
      frown,
      hand,
      project:{
        projectName:'',
        projectId:'',
      },
      projectMessage:{
      },
      participationProjectData:{
        projectName:'',
        deposit:'',
        finalPayment:'',
        companyName:'',
        studioName:'',
      },
      commentMoneyFlag:1,
      commentTimeFlag:1,
      commentReliableFlag:1,
      commentHardFlag:1,
    };
  },
  created() {
    this.getParams();
  },
  computed: {
    message() {
      return "页面找不到了......";
    }
  },
  methods:{
    getParams() {
      this.project.projectName = this.$route.query.projectName;
      this.project.projectId = this.$route.query.projectId;
      this.api({
        url: "/classify/getDemandByProjectName",
        method: "post",
        data: this.project
      }).then(data => {
        this.projectMessage = data.list;
        if (this.projectMessage[0].tenderStatus == "1") {
          this.projectMessage[0].tenderStatus = "招募中"
        } else if (this.projectMessage[0].tenderStatus == "2") {
          this.projectMessage[0].tenderStatus = "已结束"
        }
      }) 
    },
    participationProject() {
      this.participationProjectData.projectName = this.projectMessage[0].projectName;
      this.participationProjectData.deposit = parseFloat(this.projectMessage[0].projectBudget)*0.1;
      this.participationProjectData.finalPayment = parseFloat(this.projectMessage[0].projectBudget)*0.9;
      this.participationProjectData.companyName = this.projectMessage[0].employerName;
      this.participationProjectData.studioName = this.$root.unitName;
      this.api({
        url: "/classify/participationProject",
        method: "post",
        data: this.participationProjectData
      }).then(data => {
        if (data == "已参与") {
        this.$message.error("不可参与同一个项目！");
        }
        else 
        this.$message.success("参与成功");
        //this.projectMessage[0].
      })      
    },
    commentMoneyAdd() {
      if (this.$root.userIsLogined == true) {
        if(this.commentMoneyFlag == 1){
          this.projectMessage[0].commentMoney = this.projectMessage[0].commentMoney + 1;
          this.commentMoneyFlag = 0;
        } else {
        this.$message.error("一个用户一次只能评论一次！");
        }
      } else {
        this.$message.error("请先登录！");
      }
      
    },
    commentTimeAdd() {
      if (this.$root.userIsLogined == true) {
        if(this.commentTimeFlag == 1){
          this.projectMessage[0].commentTime = this.projectMessage[0].commentTime + 1;
          this.commentTimeFlag = 0;
        } else {
        this.$message.error("一个用户一次只能评论一次！");
        }
      } else {
        this.$message.error("请先登录！");
      }
    },
    commentReliableAdd() {
      if (this.$root.userIsLogined == true) {
        if(this.commentReliableFlag == 1) {
          this.projectMessage[0].commentReliable = this.projectMessage[0].commentReliable + 1;
          this.commentReliableFlag = 0;
        } else {
        this.$message.error("一个用户一次只能评论一次！");
        }
      } else {
        this.$message.error("请先登录！");
      }
    },
    commentHardAdd() {
      if (this.$root.userIsLogined == true) {
        if(this.commentHardFlag == 1){
          this.projectMessage[0].commentHard = this.projectMessage[0].commentHard + 1;
          this.commentHardFlag = 0;
        } else {
        this.$message.error("一个用户一次只能评论一次！");
        }
      } else {
        this.$message.error("请先登录！");
      }
      
    }

  },
  components: { SNavBar }
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

.left60 {
  margin-left: 60%;
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
.content {
  //margin: 28px auto;
  padding-bottom: 50px;
  background: #fff;
  min-height: 500px;
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
  font-size: 14px;
  color: #333;
  border-radius: 4px;
}
.reward-title {
  padding: 30px 25px;
  background: #f7f7f7;
  border-bottom: 1px solid #ededed;
  border-top: 1px solid #fff;
  border-top-left-radius: 4px;
  border-top-right-radius: 4px;
}
.reward-title div.title-row {
  min-height: 40px;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  display: -webkit-flex;
}
.reward-title div.title-row .title {
  font-size: 28px;
  color: #2d3238;
  -ms-word-break: break-all;
  word-break: break-all;
}
.reward-title div.title-row .status {
  font-size: 16px;
  -webkit-box-flex: 1;
  -ms-flex-positive: 1;
  flex-grow: 1;
  -webkit-flex-grow: 1;
  white-space: nowrap;
  text-align: right;
  margin-top: 4px;
}
.reward-title div.desc-row {
  margin-top: 8px;
}
.reward-title div.desc-row .role-type {
  font-size: 14px;
  line-height: 28px;
}
.reward-title .reward-no {
  border-radius: 3px;
  background-color: #8796a8;
  color: #fff;
  font-size: 10px;
  padding: 3px 4px;
  margin-right: 6px;
}
.reward-title div.detail-row {
  margin-top: 28px;
}
.reward-title div.detail-row .detail-span:first-child {
  padding-left: 0;
}
.reward-title div.detail-row .darker {
  color: #979fa8;
  margin-right: 8px;
}
.reward-title div.detail-row .border-right {
  border-right: 1px solid #d9d9d9;
}
.reward-title div.detail-row .detail-span {
  float: left;
  padding: 0 14px;
  color: #2d3238;
  font-size: 14px;
}
.mart-button {
  box-shadow: 0 2px 2px 0 rgba(0, 0, 0, 0.2);
  border-radius: 4px;
  margin: 0 7px;
}
.reward-title-mobile {
  display: none;
}
.content .apply-and-evaluation {
  padding: 12px 0;
  background-color: white;
  color: #979fa8;
  border-bottom: #ededed solid 1px;
}
.content .apply-and-evaluation .reward-evaluation {
  width: calc(100% - 120px);
  float: left;
  font-size: 20px;
}
.content .apply-and-evaluation .reward-evaluation .evaluation-group {
  display: inline-block;
  padding-left: 20px;
}
.evaluation-item.rmb {
  width: 4%;
}
.content
  .apply-and-evaluation
  .reward-evaluation
  .evaluation-group
  .evaluation-item
  .evaluation-count {
  margin-left: 10px;
}
.evaluation-item.clock {
  width: 5%;
}
.evaluation-item.hand {
  width: 7%;
}
.evaluation-item.frown {
  width: 4%;
}
.content .apply-and-evaluation .reward-apply {
  width: 105px;
  float: right;
  margin-right: 15px;
}
.reward-content {
  padding-top: 40px;
  padding-left: 25px;
  padding-right: 25px;
  padding-bottom: 20px;
}
.description {
  font-size: 14px;
  color: #333;
  line-height: 23px;
  word-wrap: break-word;
}
.file-label {
  background: #edf5fc;
  border: 1px solid rgba(221, 221, 221, 0.3);
  border-radius: 5px;
  margin-bottom: 6px;
  padding: 0 10px;
}
.file-label span.download {
  border-radius: 4px;
  display: inline-block;
  width: 40px;
  height: 40px;
  text-align: center;
  line-height: 40px;
  font-size: 14px;
  color: rgba(0, 0, 0, 0.6);
  //float: right;
  margin: 10px;
  cursor: pointer;
}
.file-label i.extension {
  background: #4289db;
  border-radius: 4px;
  display: inline-block;
  width: 40px;
  height: 40px;
  text-align: center;
  line-height: 40px;
  font-size: 12px;
  color: #fff;
  margin: 10px;
  text-transform: uppercase;
  white-space: nowrap;
  text-overflow: ellipsis;
  font-style: normal;
}
.file-label span.filename {
  font-size: 14px;
  margin: 10px;
  white-space: nowrap;
  text-overflow: ellipsis;
  width: 400px;
  display: inline-block;
  vertical-align: middle;
  overflow: hidden;
}
.file-label span.filename .owas-preview {
  color: #979fa8;
}
h4 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
  padding-top: 2rem;
}
h1,
h2,
h3,
h4,
h5,
h6 {
  font-weight: 400;
  padding: 0;
  margin: 0;
}

p {
  margin-bottom: 0.8em;
}
h2 {
  font-size: 2rem;
  margin-bottom: 1rem;
  padding-top: 2rem;
  font-weight: bold;
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
.padding_item{
  padding-left: 30px;
}
</style>
