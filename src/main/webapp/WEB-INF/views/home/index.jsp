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
  <div id="stepper4" class="row content">
    <div class="col-sm-4 sidenav bs-stepper vertical linear" style="margin-left: auto;margin-right: auto;">
      <div class="bs-stepper-header" role="tablist" style="margin-left: auto;margin-right: auto;">
              <div class="step active" data-target="#test-vl-1">
                <button type="button" class="btn btn-link step-trigger" role="tab" id="stepper4trigger1" aria-controls="test-vl-1" aria-selected="true">
                  <span class="bs-stepper-circle">1</span>
                  <span class="bs-stepper-label">Introduce</span>
                </button>
              </div>
              <div class="line"></div>
              <div class="step" data-target="#test-vl-2">
                <button type="button" class="btn btn-link step-trigger" role="tab" id="stepper4trigger2" aria-controls="test-vl-2" aria-selected="false" disabled="disabled">
                  <span class="bs-stepper-circle">2</span>
                  <span class="bs-stepper-label">Couples</span>
                </button>
              </div>
              <div class="line"></div>
              <div class="step" data-target="#test-vl-3">
                <button type="button" class="btn btn-link step-trigger" role="tab" id="stepper4trigger3" aria-controls="test-vl-3" aria-selected="false" disabled="disabled">
                  <span class="bs-stepper-circle">3</span>
                  <span class="bs-stepper-label">Validate</span>
                </button>
              </div>
      </div>
    </div>
    <div class="col-sm-8 text-left bs-stepper vertical linear" style="height:100%; padding-left:0"> 
      <div class="bs-stepper-content" style="width: 100%; padding:0"> <!-- padding:48px 0 0 48px;"> -->
                <div id="test-vl-1" role="tabpanel" class="content active" aria-labelledby="stepper4trigger1" style="height:100%;position:absolute; padding : 0">
                  <div id="myCarousel" class="carousel slide" data-ride="carousel" style="height:100%">
				  <!-- Indicators -->
				  <ol class="carousel-indicators">
				    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				    <li data-target="#myCarousel" data-slide-to="1"></li>
				    <li data-target="#myCarousel" data-slide-to="2"></li>
				  </ol>
				
				  <!-- Wrapper for slides -->
				  <div class="carousel-inner" style="margin:0px;">
				    <div class="item active" ">
				      <img style="" src="${pageContext.request.contextPath}/resources/images/A.jpg" alt="Los Angeles">
				    </div>
				
				    <div class="item" style="">
				      <img style="" src="${pageContext.request.contextPath}/resources/images/A.jpg" alt="Los Angeles">
				    </div>
				
				    <div class="item" style="">
				      <img style="" src="${pageContext.request.contextPath}/resources/images/A.jpg" alt="Los Angeles">
				    </div>
				  </div>
				
				  <!-- Left and right controls -->
				  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left"></span>
				    <span class="sr-only">Previous</span>
				  </a>
				  <a class="right carousel-control" href="#myCarousel" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right"></span>
				    <span class="sr-only">Next</span>
				  </a>
				</div>
                 
                </div>
                <div id="test-vl-2" role="tabpanel" class="content" aria-labelledby="stepper4trigger2" style="height:100%;position:absolute;">
                <ul>
                  <li>
                  <div style="padding:30px">
                    <label for="exampleInputPasswordV1">애인의 ID를 입력해주세요.(해당 ID를 통해 커플 연결을 진행)</label>
                    <div class="input-group col-md-12">
                    <input id="coupleId" type="text" disabled class="form-control input-lg" placeholder="Click Button" style="z-index:1;">
                    <span class="input-group-btn">
                        <button id="myBtn" class="btn btn-default btn-lg" type="button" style="z-index:1;">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                	</div>
                  </div>
                  </li>
                </ul>
          <!--         <button class="btn btn-primary" onclick="stepper4.previous()">Previous</button>
                  <button class="btn btn-primary" onclick="stepper4.next()">Next</button> -->
                </div>
                <div id="test-vl-3" role="tabpanel" class="content" aria-labelledby="stepper4trigger3" style="height:100%; position:absolute;">
                	<div id="target" style="padding:30px">
                	
                	</div>
               <!--    <button class="btn btn-primary mt-5" onclick="stepper4.previous()">Previous</button>
                  <button type="submit" class="btn btn-primary mt-5">Submit</button> -->
                </div>
            </div>
    </div>
 
  </div>
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

	var stepper4;
	var stateObject = new Object();
    stateObject.userid="${user.getUserId()}";
		
	$(document).ready(function(){

		$.ajaxSetup({
			 beforeSend: function(xhr) {
                xhr.setRequestHeader('Ajax', true);
                xhr.setRequestHeader("Accept", "application/json");
		        xhr.setRequestHeader("Content-Type", "application/json");
            }
		});
		$("#myCarousel").carousel();
		stepper4 = new Stepper(document.querySelector('#stepper4'));
		$("#myModal").on('shown.bs.modal', function(event){
		   // $("#tableDiv").hide();
		});
		$("#myModal").on('hide.bs.modal', function(event){
			$( '#findTable > tbody').empty();
		});

		
		$("#myBtn").click(function(){
		    login.findRequest('${user.getUserId()}');
		});
		$("#stepBtn").click(function(){
		    debugger;
		    if(stepper4._currentIndex=='1'){
		    	if(!stateObject.coupleid){
		    		$("#target").html(tmpl("NonCoupleTemplate", stateObject));
		    	}else{
		    		if(stateObject.requestType=='Y'){
		    			$("#target").html(tmpl("preCoupletemplate", stateObject));
		    		}else{
		    			$("#target").html(tmpl("Coupletemplate", stateObject));
		    		}
		    	}
		    }else if(stepper4._currentIndex=='2'){
		    	var confirmMsg;
		    	var type;
		    	if(!stateObject.coupleid){
		    		confirmMsg = "어느 누구와도 커플 신청 및 수락등이 되지 않았습니다. 정말 진행 하시겠습니까?";
		    	}else{
			    	if(stateObject.requestType=='Y'){
			    		confirmMsg = stateObject.coupleid+"님께 커플신청을 하셨습니다. 정말로 신청 하시겠습니까?";
			    	}else{
			    		confirmMsg = stateObject.coupleid+"님의 커플신청을 수락 하셨습니다. 정말로 수락 하시겠습니까?";
			    	}
		    	}
		    	bootbox.confirm({ 
		    		  size: "medium",
		    		  message: confirmMsg, 
		    		  callback: function(result){
		    			  if(result){
		    				  if(!stateObject.coupleid){
		    			    		confirmMsg = "어느 누구와도 커플 신청 및 수락등이 되지 않았습니다. 정말 진행 하시겠습니까?";
		    			    	}else{
		    				    	if(stateObject.requestType=='Y'){
		    				    		login.requestCouple();
		    				    	}else{
		    				    		login.acceptRequest();
		    				    	}
		    			    	}
		    			  }else{
		    				  
		    			  }
		    			  /* result is a boolean; true = OK, false = Cancel*/ }
		    		})
		    }
		    stepper4.next();
		});
	});

</script>
<script type="text/x-tmpl" id="preCoupletemplate">
<div style="margin:auto">
<h3>{%=o.coupleid%}</h3>분께 커플 신청을 하셨습니다.
<p>{%=o.coupleid%} 님께서 수락을 하실 경우 정식적인 커플로 등록되며 커플메니저 서비스를 이용하실 수 있습니다.</p>
</div>
</script>
<script type="text/x-tmpl" id="Coupletemplate">
<div style="margin:auto">
<p>{%=o.coupleid%} 님께서 요청 하신 커플 신청을 수락 하셨습니다.
아래 최종적으로 수락시 정식적인 커플 관계가 설정되며 커플메니저 서비스를 이용하실 수 있습니다. 감사합니다.</p>
</div>
</script>
<script type="text/x-tmpl" id="NonCoupleTemplate">
<p>저희 서비스는 커플인 조건에만 이용 하실 수 있습니다.
추후 프로필을 통해 커플관계를 설정 하실 수 있습니다. 다만 그 전까지는 서비스 이용이 불가합니다.
가사합니다.</p>
</script>


</html>
