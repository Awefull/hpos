<template>
  <div class="header">
    <SNavBar></SNavBar>
    <div class="padding-leftandright gray-bgcolor">
      <el-form>
        <div class="white-bgcolor">
          <div class="row">
            <!-- About Image -->
            <div class="col-md-5 col-sm-12 col-xs-12 wow slideInLeft" style="visibility: visible; animation-name: slideInLeft;">
              <div class="about-main">
                <p v-if="companyMessage.unitName=='益鼎网络'">
                  <img class="about-img" :src="yiding">
                </p>
                <p v-if="companyMessage.unitName=='发猿地'">
                  <img class="about-img" :src="fayuandi">
                </p>
                <p v-if="companyMessage.unitName=='芝信公司'">
                  <img class="about-img" :src="zhixin">
                </p>
                <!-- <img class="about-img" :src="img_1"/> -->
              </div>
            </div>
            <!--/ End About Image -->
            <div class="col-md-7 col-sm-12 col-xs-12 wow fadeIn" data-wow-delay="1s" style="visibility: visible; animation-delay: 1s; animation-name: fadeIn;">
              <!-- About Tab -->
              <div class="tabs-main">
                <!-- Tab Nav -->
                <ul class="nav nav-tabs" role="tablist">
                  <li role="presentation" class="active">
                    <a href="#welcome" data-toggle="tab">企业信息</a>
                  </li>
                </ul>
                <!--/ End Tab Nav -->
                <!-- Tab Content -->
                <div class="tab-content">
                  <div role="tabpanel" class="tab-pane fade in active" id="welcome">
                    <div class="about-us">关于我们</div>
                    <p><span>{{companyMessage.description}}</span></p>
                    <div class="row">
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <div class="single-tab">
                          <i class="fa fa-book"></i>
                          <h4>公司名称</h4>
                          <p><span>{{companyMessage.unitName}}</span></p>
                        </div>
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <!-- Single Tab -->
                        <div class="single-tab">
                          <i class="fa fa-star"></i>
                          <h4>成立时间</h4>
                          <p>2017-1-1</p>
                        </div>
                        <!--/ End Single Tab -->
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <!-- Single Tab -->
                        <div class="single-tab">
                          <i class="fa fa-home"></i>
                          <h4>公司地址</h4>
                          <p><span>{{companyMessage.address}}</span></p>
                        </div>
                        <!--/ End Single Tab -->
                      </div>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                        <!-- Single Tab -->
                        <div class="single-tab">
                          <i class="fa fa-mobile-phone"></i>
                          <h4>公司电话</h4>
                          <p><span>{{companyMessage.telephone}}</span></p>
                        </div>
                        <!--/ End Single Tab -->
                      </div>
                    </div>
                  </div>
                  
                </div>
                <!--/ End Tab Content -->
              </div>
              <!--/ End About Tab -->
            </div>
          </div>
        </div>
      </el-form>
    </div>
  </div>
</template>


<script>
import img_404 from "@/assets/404_images/404.png";
import img_404_cloud from "@/assets/404_images/404_cloud.png";
import $ from "jquery";
import img_1 from "@/images/1.jpg";
import yiding from "@/images/yiding.png";
import fayuandi from "@/images/fayuandi.png";
import zhixin from "@/images/zhixin.png";
import SNavBar from "@/components/NavBar/studio";
import CNavBar from "@/components/NavBar/company";
import VNavBar from "@/components/NavBar/viewer";

export default {
  name:'',
  data() {
    return {
      img_404,
      img_404_cloud,
      img_1,
      yiding,
      fayuandi,
      zhixin,
      params:'',
      companyName:'',
      companyMessage:{
        description:'',
        unitName:'',
        address: '',
        telephone: '',
      },
    };
  },
  created: function() {
      this.getParams();
      // this.user.username = this.$root.username;
      this.getCompanyMessage();
    },
  computed: {
    message() {
      return "页面找不到了......";
    }
  },
  methods: {
    getParams(){
        var routerParams = this.$route.query.companyName;
        this.companyName = routerParams;
    },
    getCompanyMessage() {
        this.companyMessage.unitName = this.companyName;
        // this.companyMessage.unitName = "发猿地";
        //查询企业信息
        this.api({
          url: "/companyMessage/getCompanyMessage",
          method: "post",
          data:this.companyMessage
        }).then(data => {
          this.companyMessage.description = data.companyMessageInfo.description;
          this.companyMessage.address = data.companyMessageInfo.address;
          this.companyMessage.telephone = data.companyMessageInfo.telephone;
        }).catch(() => {
            this.$message.error("查询失败")
          })
      },
  },
  mounted:function() {
    console.log(this.$route.params)
  },
  watch:{
    '$route':'getParams'
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
.row {
    margin-right: -15px;
    margin-left: -15px;
}
.col-md-5 {
    width: 41.66666667%;
}
.about-main {
    margin-top: 30px;
}
.about-img {
    margin-top: 10px;
    height: 100%;
    width: 90%;
    padding-left: 25px;
}
.col-md-7 {
    width: 58.33333333%;
}
 .tabs-main {
    margin-top: 30px;
    background: #fff;
    padding: 20px;
    -webkit-box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.30);
    -moz-box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.30);
    box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.30);
}
.tabs-main .nav-tabs {
    margin-bottom: 20px;
}
.tabs-main .nav-tabs li.active {
    border-color: transparent;
}
.nav-tabs>li {
    float: left;
    margin-bottom: -1px;
}
.tab-content>.tab-pane {
    display: none;
}
 #about-us .single-tab i, #team .team-social li a, .link,.button {
    background: #16A085;
}
#about-us .single-tab i {
    width: 40px;
    height: 40px;
    line-height: 40px;
    color: #fff;
    text-align: center;
    position: absolute;
    left: -2px;
    font-size: 18px;
    border-radius: 100%;
}
.col-md-6 .col-sm-6 .col-xs-12
{
    position: relative;
    min-height: 1px;
    padding-right: 15px;
    padding-left: 15px;
}
.col-md-6 {
    width: 50%;
}
.tab-content>.active {
    display: block;
}
.fade.in {
    opacity: 1;
}
.active{
    background:#ebeef5;
}
.about-us{
    width: 90%;
    font-size: 24px;
    margin-right: 7px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
</style>
