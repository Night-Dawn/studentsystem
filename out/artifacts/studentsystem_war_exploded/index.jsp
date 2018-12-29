<%--
  Created by IntelliJ IDEA.
  User: Night_Dawn
  Date: 2018/12/26
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Meta tag Keywords -->
    <!-- Custom-Style-Sheet -->
    <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/><!--style_sheet-->
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
    <link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome_Icons-CSS -->
    <!--//Custom-Style-Sheet -->
    <!--online_fonts-->
    <link href="http://maxcdn.bootstrapcdn.com/css?family=Audiowide" rel="stylesheet">
    <link href="http://maxcdn.bootstrapcdn.com/css?family=Montserrat+Alternates" rel="stylesheet">
  </head>
  <body>
  <img id="backgroundimage" src="images/background.png"  height="99.5%" width="100%"  style="opacity: 0.8; background-size: cover;"/>
  <div class="w3l-head">
    <h1>Student Information Management System</h1>
  </div>
  <div class="w3l-main">
    <div class="w3l-left-side">

      <div class="flexslider">
        <ul class="slides">
          <li>
            <img src="images/g5.jpg" alt="image"/>
          </li>
          <li>
            <img src="images/g2.jpg" alt="image"/>
          </li>
          <li>
            <img src="images/g3.jpg" alt="image"/>
          </li>
          <li>
            <img src="images/g4.jpg" alt="image"/>
          </li>
          <li>
            <img src="images/g1.jpg" alt="image"/>
          </li>
        </ul>
      </div>
    </div>

    <div class="w3l-rigt-side">
      <form action="#" method="post">
        <div class="w3l-signin">
          <a class="w3_play_icon1" href="#small-dialog1"> sign in</a>
        </div>
        <div class="w3l-signup">
          <a class="w3_play_icon1" href="#small-dialog2"> sign up</a>
        </div>
        <div class="clear"></div>
      </form>
    </div>
    <div class="clear"></div>
  </div>

  <!--sign in form -->
  <div id="small-dialog1" class="mfp-hide">
    <div class="wthree-container">
      <div class="wthree-form">
        <div class="agileits-2">
          <h2>sign in</h2>
        </div>
        <form action="login" method="post">
          <div class="w3-user">
            <span><i class="fa fa-user-o" aria-hidden="true"></i></span>
            <input id="loginusername"  type="text" name="loginusername" placeholder="Username" required="">
          </div>
          <div class="clear"></div>
          <div class="w3-psw">
            <span><i class="fa fa-key" aria-hidden="true"></i></span>
            <input id="loginpassword" type="password" name="loginpassword" placeholder="Password" required="">
          </div>
          <div class="clear"></div>
          <div class="signin">
            <input type="submit" id="login"  value="sign in">
          </div>
          <div class="clear"></div>
        </form>
      </div>
    </div>
  </div>
  <!--sign in form -->
  <!-- for register popup -->
  <div id="tipbox"><span id= "tip" style="display: table-cell;vertical-align: middle"></span></div>
  <!--sign up form -->
  <div id="small-dialog2" class="mfp-hide">
    <div class="wthree-container">
      <div class="wthree-form bg">
        <div class="agileits-2">
          <h2>sign up here</h2>
        </div>
        <form action="register" method="post">
          <div class="w3-user">
            <span><i class="fa fa-user-o" aria-hidden="true"></i></span>
            <input id="registerusername" type="text" name="registerusername" placeholder="Username" required="">
          </div>

          <div class="clear"></div>
          <div class="w3-psw">
            <span><i class="fa fa-key" aria-hidden="true"></i></span>
            <input id="registerpassword" type="password" name="registerpassword" placeholder="Password" required="">
          </div>
          <div class="w3-cpsw">
            <span><i class="fa fa-key" aria-hidden="true"></i></span>
            <input id="registerconfirm" type="password" name="registerconfirm" placeholder="confirm-Password" required="">
          </div>
          <div class="clear"></div>
          <div class="signin">
            <input type="submit" id="register" value="sign up">
          </div>
          <div class="clear"></div>
        </form>
      </div>
    </div>

  </div>
  <!--sign in form -->
  <!-- //for register popup -->



  <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>

  <!-- pop-up-box-js-file -->
  <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
  <!--//pop-up-box-js-file -->
  <script>
    $(document).ready(function() {
      $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
        type: 'inline',
        fixedContentPos: false,
        fixedBgPos: true,
        overflowY: 'auto',
        closeBtnInside: true,
        preloader: false,
        midClick: true,
        removalDelay: 300,
        mainClass: 'my-mfp-zoom-in'
      });
      $("#tipbox").hide();
      $("#login").click(function () {
        var username = $.trim($("#loginusername").val());
        var password = $.trim($("#loginpassword").val());
        if(username==null|| username==""||password==""||password==null)
        {

          $("#tipbox").show(500);
          $("#tip").text("请输入用户名和密码");
          setTimeout(function () {
            $("#tipbox").hide(500);
          },1000);
          return false;
        }

      });
      $("#register").click(function () {
        var username = $.trim($("#registerusername").val());
        var password = $.trim($("#registerpassword").val());
        var confirm =$.trim($("#registerconfirm").val());
        if(username==null|| username==""||password==""||password==null||confirm==null||confirm=="")
        {

          $("#tipbox").show(500);
          $("#tip").text("请输入用户名和密码和验证密码");
          setTimeout(function () {
            $("#tipbox").hide(500);
          },1000);
          return false;
        }
      });
    });
  </script>
  <!-- flexSlider -->
  <script defer src="js/jquery.flexslider.js"></script>
  <script type="text/javascript">
    $(window).load(function(){
      $('.flexslider').flexslider({
        animation: "slide",
        start: function(slider){
          $('body').removeClass('loading');
        }
      });
    });
  </script>
  </body>
</html>
