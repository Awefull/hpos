<template>
  <div class="header"> 
   <SNavBar></SNavBar> 
   <div class="content padding-leftandright gray-bgcolor"> 
    <section class="reward-title white-bgcolor"> 
     <input style="display:none" value="17905" name="id" /> 
     <div class="title-row"> 
      <span class="title">开发一个课外阅读微信公众号</span> 
      <span class="status status-2 pull-right">招募中</span> 
     </div> 
     <div class="desc-row"> 
      <div class="role-type"> 
       <span class="reward-no">No.17905</span> 
       <span class="type">后端开发&nbsp;</span> 
      </div> 
     </div> 
     <div class="detail-row clearfix"> 
      <span class="detail-span border-right"><span class="darker">金额</span>￥1,000</span> 
      <span class="detail-span border-right"><span class="darker">类型</span> 微信公众号 </span> 
      <span class="detail-span"> <span class="darker">周期</span> 20&nbsp;天 </span> 
      <button class="right mart-button join-button blue btn-with-shadow enable"> 参与项目 </button> 
     </div> 
    </section> 
    <section class="reward-title-mobile"> 
     <input style="display:none" value="17905" name="id" /> 
     <div style="background: url(https://dn-coding-net-production-pp.codehub.cn/478d6050-9c86-48cf-86b5-a7845bb13799.png) center/cover no-repeat" class="reward-cover"> 
      <span class="reward-no">No.17905</span> 
     </div> 
     <div class="status status-2-label pull-right">
       招募中 
     </div> 
     <div class="title-row"> 
      <span class="title">开发一个课外阅读微信公众号</span> 
     </div> 
     <div class="type-row"> 
      <i class="fa fa-weixin"></i> 
      <span class="detail-span border-right"> 微信公众号 </span> 
      <span class="type">后端开发&nbsp;</span> 
     </div> 
     <div class="detail-row"> 
      <span class="item"> <span class="darker">周期</span> <span class="number">&nbsp;20&nbsp;</span>天 </span> 
      <span class="item"> <span class="darker">金额</span><span class="number">&nbsp;￥1,000</span> </span> 
     </div> 
     <div class="button-row"> 
      <button class="right mart-button join-button blue btn-with-shadow enable"> 参与项目 </button> 
     </div> 
     <div class="apply-count">
       报名人数:&nbsp;&nbsp;0 
     </div> 
    </section> 
    <div class="apply-and-evaluation clearfix "> 
     <div class="reward-evaluation"> 
      <div class="evaluation-group"> 
       <img class="evaluation-item rmb" :src="rmb" /> 钱太少 
       <span class="evaluation-count">7</span> 
       <img class="evaluation-item clock" :src="clock" /> 时间紧 
       <span class="evaluation-count">0 </span> 
       <img class="evaluation-item hand" :src="hand" /> 不靠谱 
       <span class="evaluation-count">5</span> 
       <img class="evaluation-item frown" :src="frown" /> 不会做 
       <span class="evaluation-count">0</span> 
      </div> 
     </div> 
     <div class="reward-apply">
       报名人数:&nbsp;&nbsp;0 
     </div> 
    </div> 
    <section class="reward-content white-bgcolor"> 
     <div class="content-group"> 
      <h2>项目描述</h2> 
      <div class="description typo fold"> 
       <p>设计一个中学生课外阅读微信公众号，让老师可以随时监测学生的阅读过程，并和学生进行互动交流，主要实现三个模块：（1）个人中心（2）阅读时刻；（3）书友互动。每个模块分别实现以下功能： （1）个人中心：用户登陆/注册、我的班级、我的任务 （2）阅读时刻：今日任务、阅读监督、好书推荐、任务发布 （3）书友互动：作品秀、书友圈</p> 
      </div> 
     </div> 
     <div class="content-group"> 
      <h2>项目规划</h2> 
      <div class="content-item"> 
       <h4>项目周期</h4> 
       <div class="content-text"> 
        <p>20天</p> 
       </div> 
      </div> 
     </div> 
     <div class="content-group"> 
      <h2>招募角色</h2> 
      <div class="content-item"> 
       <h4>项目角色和金额</h4> 
       <div class="content-text"> 
        <p> <span class="role-name">后端开发</span> <span>&nbsp;&nbsp;&nbsp;1000.00&nbsp;元</span></p> 
       </div> 
      </div> 
      <div class="content-item"> 
       <h4>项目要求</h4> 
       <div class="description typo fold"> 
        <p>用Python+web.py+mysql+sae+git 来实现后台</p> 
       </div> 
      </div> 
     </div> 
     <div class="content-group"> 
      <h2>需求文件</h2> 
      <div class="item-content content-item"> 
       <div class="file-label"> 
        <span class="download"> <input class="url" type="hidden" value="https://coding-net-public-file.codehub.cn/b2b73995-41a2-4a4d-b773-ab05c27345c0.docx" /> <a href="javascript:void(0);">下载</a> </span> 
        <i class="extension">docx</i> 
        <span class="filename" title="任务.docx"> <a href="javascript:void(0)" class="owas-preview">任务.docx</a> </span>
        <span class="filename" title="任务.docx"> <a href="javascript:void(0)" class="owas-preview left60">更新时间：2019/3/22</a> </span> 
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
import rmb from"@/images/rmb.jpg";
import clock from"@/images/clock.jpg";
import frown from"@/images/frown.jpg";
import hand from"@/images/hand.jpg";
import SNavBar from '@/components/NavBar/studio';

export default {
  data() {
    return {
      img_404,
      img_404_cloud,
      rmb,
      clock,
      frown,
      hand
    };
  },
  computed: {
    message() {
      return "页面找不到了......";
    }
  },
  components:{SNavBar},
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
@import '~@/styles/font-awesome.css';
@import '~@/styles/bootstrap.css';
@import '.~@/styles/style.css';
@import '~@/styles/animate.min.css';
@import '~@/styles/menu.css';
@import '~@/styles/fonts.googleapis.com1.css';
@import '~@/styles/fonts.googleapis.com2.css';
@import '~@/styles/fonts.googleapis.com3.css';

.left60{
  margin-left:60%;
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
    box-shadow: 0 1px 3px rgba(0,0,0,.2);
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
    color: #2D3238;
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
    background-color: #8796A8;
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
    color: #979FA8;
    margin-right: 8px;
}
.reward-title div.detail-row .border-right {
    border-right: 1px solid #D9D9D9;
}
.reward-title div.detail-row .detail-span {
    float: left;
    padding: 0 14px;
    color: #2D3238;
    font-size: 14px;
}
.mart-button {
    box-shadow: 0 2px 2px 0 rgba(0,0,0,.2);
    border-radius: 4px;
    margin: 0 7px;
}
.reward-title-mobile {
    display: none;
}
.content .apply-and-evaluation {
    padding: 12px 0;
    background-color: white;
    color: #979FA8;
    border-bottom: #EDEDED solid 1px;
}
.content .apply-and-evaluation .reward-evaluation {
    width: calc(100% - 120px);
    float: left;
}
.content .apply-and-evaluation .reward-evaluation .evaluation-group {
    display: inline-block;
    padding-left: 20px;
}
.evaluation-item.rmb{
    width:4%
}
.content .apply-and-evaluation .reward-evaluation .evaluation-group .evaluation-item .evaluation-count {
    margin-left: 10px;
}
.evaluation-item.clock {
  
    width:5%
}
.evaluation-item.hand{
    width:7%
}
.evaluation-item.frown {
    width:4%
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
    border: 1px solid rgba(221,221,221,.3);
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
    color: rgba(0,0,0,.6);
    //float: right;
    margin: 10px;
    cursor: pointer;
}
.file-label i.extension {
    background: #4289DB;
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
    color: #979FA8;
}
h4 {
    font-size: 1.5rem;
    margin-bottom: 1rem;
    padding-top: 2rem;
}
h1, h2, h3, h4, h5, h6 {
    font-weight: 400;
    padding: 0;
    margin: 0;
}   
    
p {
    margin-bottom: .8em;
}
h2 {
    font-size: 2rem;
    margin-bottom: 1rem;
    padding-top: 2rem;
    font-weight:bold;
}
.padding-leftandright{
  padding-left: 20%;
  padding-right: 20%;
  padding-top: 3%;
}
.gray-bgcolor{
  background: #f0f2f5
}
.white-bgcolor{
  background: white;
}

</style>
