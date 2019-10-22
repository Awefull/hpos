<template>
<div>
  <SNavBar v-if="this.$root.loginedRoleId =='2'"></SNavBar>
  <CNavBar v-if="this.$root.loginedRoleId =='3'"></CNavBar>
	<div class="header">
      <div class="header-left">
        <li class="dropdown head-dpdn">
            <a style="color:black" class="dropdown-toggle"><i class="fa fa-map-marker" aria-hidden="true"></i>
              联系我们</a>
        </li>
      </div>
    </div>
  <div class="container-fluid contact_area">
		<div class="row">	
			<div class="section-title text-center wow zoomIn">
				<h2>get in touch</h2>
				<span></span>
			</div>								
			<div class="col-md-6 col-sm-12 col-xs-12">
				<div class="contact">
					<form id="contact-form" method="post" enctype="multipart/form-data">
						<div class="row">
							<div class="form-group col-md-12">
								<input type="email" name="name" class="form-control" id="first-name" placeholder="Name" required="required">
							</div>
							<div class="form-group col-md-12">
								<input type="email" name="email" class="form-control" id="email" placeholder="Email" required="required">
							</div>
							<div class="form-group col-md-12">
								<input type="email" name="text" class="form-control" id="subject" placeholder="Subject" required="required">
							</div>
							<div class="form-group col-md-12">
								<textarea rows="6" name="message" class="form-control" id="description" placeholder="Your Message" required="required"></textarea>
							</div>
							<div class="col-md-12">
								<div class="actions send_message">
									<input type="submit" value="Send message" name="submit" id="submitButton" class="btn btn-lg btn-contact-bg" title="Submit Your Message!" />
								</div>
							</div>
						</div>
					</form>
				</div>
			</div><!-- END COL -->	
			<div class="col-md-6 col-sm-12 col-xs-12 no-padding">					
				<div id="map"></div>						
			</div><!-- END COL -->						
		</div><!--- END ROW -->				
	</div><!--- END CONTAINER -->
  <div class="contact-address section-padding">
	<div class="container">
		<div class="row text-center">
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="single_address">
					<i class="fa fa-phone"></i>
					<p>(+1) 740-395-3829</p>
					<p>(+1) 740-395-3829</p>
				</div>
			</div><!-- END COL  -->
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="single_address">
					<i class="fa fa-rocket"></i>
					<p>3783 Columbia Mine Road Shinnston, WV 26431 </p>
				</div>
			</div><!-- END COL  -->
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="single_address">
					<i class="fa fa-envelope"></i>
					<p>Info@nurjahan.com</p>
					<p>Info@nurjahan.com</p>
				</div>
			</div><!-- END COL  -->
			<div class="col-md-3 col-sm-6 col-xs-12">
				<div class="single_address">
					<i class="fa fa-clock-o"></i>
					<p>Mon - Fri: 08.00 - 16.00</p>
					<p>Mon - Fri: 08.00 - 16.00</p>
				</div>
			</div><!-- END COL  -->
		</div><!--END  ROW  -->
	</div><!-- END CONTAINER  -->
</div>	
</div>
</template>


<script>
import img_404 from "@/assets/404_images/404.png";
import img_404_cloud from "@/assets/404_images/404_cloud.png";
import $ from 'jquery';
import img_1 from"@/images/1.jpg";
import SNavBar from '@/components/NavBar/studio';
import CNavBar from '@/components/NavBar/company';

export default {
  data() {
    return {
      img_404,
      img_404_cloud,
      radio4:'上海',
      img_1
    };
  },
  computed: {
    message() {
      return "页面找不到了......";
    }
	},
	components:{SNavBar,CNavBar},
};
</script>

<style rel="stylesheet/scss" lang="scss" scoped>

@import '~@/styles/bootstrap.css';
@import '.~@/styles/style.css';
@import '.~@/styles/style2.css';
@import '~@/styles/font-awesome.css';
@import '~@/styles/fonts.googleapis.com1.css';
@import '~@/styles/fonts.googleapis.com2.css';
@import '~@/styles/fonts.googleapis.com3.css';
  .header{
    background: transparent;
    padding: 2em 2em;
    position: fixed;
}
  .header-left {
    float: left;
}
.container-fluid {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}


.text-center {
    text-align: center;
}

.contact {
    padding-left:74%;
    padding-right: 60px;
    padding-top: 30px;
}
.form-group {
    margin-bottom: 15px;
}
.contact textarea {
    background: #fff none repeat scroll 0 0;
    border: 1px solid #e8e8e9;
    border-radius: 4px;
    box-shadow: none;
    color: #333;
    width: 520px;
    padding: 10px;
}
.btn-contact-bg {
    background: #2a80b9 none repeat scroll 0 0 !important;
    border: 2px solid #2a80b9 !important;
    border-radius: 3px;
    box-shadow: none;
    color: #fff!important;
    font-size: 12px;
    text-transform: uppercase;
    transition: all 0.2s ease 0s;
}
.send_message{
	margin-bottom: 30px;
}

</style>
