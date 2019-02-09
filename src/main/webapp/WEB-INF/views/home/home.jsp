<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<sec:authentication var="user" property="principal" />
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="mobile-web-app-capable" content="yes">
  <meta name="viewport" content="width=device-width, initial-scale=1.0,minu-mum-scale=1.0,maximum-scale=1.0,user-scaleable=no">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
 <!--  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
  <link type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.stepper.min.css" rel="stylesheet">

  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */
    body {height:100%;font-family: Arial, Helvetica, sans-serif;}
    html {height:100%;}
    
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    .wrap{
        height:500px;
	  	padding-right: 0px;
        padding-left: 0px;
	  	width: 100%;
	  }
	footer {
      background-color: #555;
      color: white;
      padding: 15px;
      height:60px;
    }
    .row{
    	margin-right: 0px;
        margin-left: 0px; 
     }
    
    .row.content {
    	height: 450px;
    	width: 100%;
    	margin-bottom:-60px;
    	min-height: 100%;
   	}
   	
    container-fluid {
        padding-right: 0px; 
        padding-left: 0px; 
	    margin-right: auto;
	    margin-left: auto;
	}
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    .btn.btn-primary{
    	background-color:#555; 
    	border-color:#555959;
    }
    .btn.btn-primary:hover{
    	background-color:#555959; 
    	border-color:#fff;
    }
    
@media (max-width: 768px) {
  .bs-stepper:not(.vertical) {
    display: flex;
  }
  
   html{height:100%;max-height:100%; margin:0px}
   body{height:100%;max-height:100%; margin:0px}
  .bs-stepper.vertical .bs-stepper-header {
    flex-direction: row;
    align-items: center;
    width : 100%;
  }
  .bs-stepper.vertical .line {
 	border-left: 1px solid rgba(0,0,0,.12);
 	border-top: 1px solid rgba(0,0,0,.12);
    min-width: 32px;
    min-height: 0px;
  }
  .bs-stepper.vertical .step {
    min-width: 30px;
    min-height: 0px;
  }
  .bs-stepper .step .step-trigger .bs-stepper-label, .bs-stepper .step a .bs-stepper-label, .bs-stepper .step button .bs-stepper-label{
  	display : block;
  }
  .bs-stepper .step .step-trigger, .bs-stepper .step a, .bs-stepper .step button{
  	padding-top:40px;
  }
  .bs-stepper .bs-stepper-circle{
    margin-top: 20px;
  	margin : auto;
  }
  .navbar-nav>li {
    float: right;
  }
  .sidenav {
        height: auto;
        padding: 15px;
   }
   footer {
     margin-top : 60px;
   }
}

  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#" style="padding:0px">
      	<img src="${pageContext.request.contextPath}/resources/images/Logo.png" style="height:45px">
      </a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">

      </ul>
       <ul class="nav navbar-nav navbar-right">
      	 <sec:authorize access="isAuthenticated()">
        	<li>
        		<%-- <form id="logoutform" action="${pageContext.request.contextPath}/logout.do" method="POST"> --%>
	        		<a href="javascript:$('#logoutform').submit();">
	        			<span class="glyphicon glyphicon-log-in"></span> LogOut
	        		</a>
        		<!-- </form>  -->
        	</li>
        </sec:authorize>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center wrap">    
  
</div>
<div id="myModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">커플 아이디 찾기</h4>
        </div>
        <div class="modal-body">
          <div class="input-group col-md-12">
          	<input id="uid" type="text" class="form-control input-lg" placeholder="Input Email" style="z-index:1;">
            <span class="input-group-btn">
                <button id="findUserBtn" onclick="login.findUser()" class="btn btn-default btn-lg" type="button" style="z-index:1;">
                    <i class="glyphicon glyphicon-search"></i>
                </button>
            </span>
          </div>
          
          <div class="col-md-12" id="tableDiv" style="margin-top:20px">
			  <h5>조회된 회원에게 커플 신청을 해주세요.</h5>  
			  <h5>신청 시 상대방이 수락해야만 커플로 설정이 됩니다.</h5>                                      
			  <div class="table-responsive">          
			  <table id="findTable" class="table" style="text-align: center;">
			    <thead>
			      <tr>
			        <th style="text-align: center;">#</th>
			        <th style="text-align: center;">ID</th>
			        <th style="text-align: center;">REQUEST</th>
			      </tr>
			    </thead>
			    <tbody>
			    </tbody>
			  </table>
			  </div>
			</div>
        </div>
        <div class="modal-footer">
          <!-- <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
        </div>
      </div>
    </div>
</div>
<footer class="container-fluid text-center">
   <button id ="stepBtn" class="btn btn-primary">Next</button>
</footer>
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.loadTemplate.min.js"></script>  
  <script src="${pageContext.request.contextPath}/resources/vendor/popper/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/script/common/bootbox.min.js"></script>
  <!-- <script src='http://ajax.microsoft.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js'></script> -->
<%--   <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/bootstrap.min.js"></script> --%>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/bootstrap.stepper.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/headroom/headroom.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/script/login/login.js"></script>
  
 <form id="logoutform" action="${pageContext.request.contextPath}/logout.do" method="POST">
 </form>
</body>
<script>
		
	$(document).ready(function(){

		$.ajaxSetup({
			 beforeSend: function(xhr) {
                xhr.setRequestHeader('Ajax', true);
                xhr.setRequestHeader("Accept", "application/json");
		        xhr.setRequestHeader("Content-Type", "application/json");
            }
		});
	});

</script>
</html>
