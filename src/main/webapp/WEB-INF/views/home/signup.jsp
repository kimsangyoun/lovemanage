<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Start your development with a Design System for Bootstrap 4.">
<meta name="author" content="Creative Tim">
<title>Insert title here</title>

  <!-- Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <!-- Icons -->
  <link href="${pageContext.request.contextPath}/resources/vendor/nucleo/css/nucleo.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <!-- Argon CSS -->
  <link type="text/css" href="${pageContext.request.contextPath}/resources/css/argon_main.css?v=1.0.1" rel="stylesheet">
   <script src="${pageContext.request.contextPath}/resources/script/login/login.js"></script>
</head>
<header class="header-global">
    <nav id="navbar-main" class="navbar navbar-main navbar-expand-lg navbar-transparent navbar-light headroom">
      <div class="container">
        <a class="navbar-brand mr-lg-5" href="../index.html">
          <img src="${pageContext.request.contextPath}/resources/images/Logo.png" style="height:45px">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="navbar-collapse collapse" id="navbar_global">
          <div class="navbar-collapse-header">
            <div class="row">
              <div class="col-6 collapse-brand">
                <a href="../index.html">
                  <img src="${pageContext.request.contextPath}/resources/images/Logo.png">
                </a>
              </div>
              <div class="col-6 collapse-close">
                <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar_global" aria-controls="navbar_global" aria-expanded="false" aria-label="Toggle navigation">
                  <span></span>
                  <span></span>
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </nav>
  </header>
<body>
<section class="section section-shaped section-lg">
      <div class="shape shape-style-1 bg-gradient-default">
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
        <span></span>
      </div>
      <div class="container pt-lg-md">
        <div class="row justify-content-center">
          <div class="col-lg-5">
            <div class="card bg-secondary shadow border-0">
              <div class="card-header bg-white pb-5">
                <div class="text-muted text-center mb-3">
                  <small>Sign up with</small>
                </div>
                <div class="text-center">
                  <a href="#" class="btn btn-neutral btn-icon mr-4">
                    <span class="btn-inner--icon">
                      <img src="${pageContext.request.contextPath}/resources/images/icons/common/github.svg">
                    </span>
                    <span class="btn-inner--text">Github</span>
                  </a>
                  <a href="#" class="btn btn-neutral btn-icon">
                    <span class="btn-inner--icon">
                      <img src="${pageContext.request.contextPath}/resources/images/icons/common/google.svg">
                    </span>
                    <span class="btn-inner--text">Google</span>
                  </a>
                </div>
              </div>
              <div class="card-body px-lg-5 py-lg-5">
                <div class="text-center text-muted mb-4">
                  <small>Or sign up with credentials</small>
                </div>
                <form:form commandName="user">
                  <div class="form-group">
                    <div class="input-group input-group-alternative mb-3">
                      <div class="input-group-prepend">
                        <span class="input-group-text"><i class="ni ni-hat-3"></i></span>
                      </div>
                      <input type="text" id="unm" class="form-control" name="text" placeholder="Your Name...">
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="input-group input-group-alternative mb-3">
                      <div class="input-group-prepend">
                        <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                      </div>
                      <form:input path = "userId" placeholder="Email" class="form-control" type="email" id="uid"/>
                      <form:errors cssStyle="color: red;" path="userId" />
                    </div>
                  </div>
                  <div class="form-group">
                    <div class="input-group input-group-alternative">
                      <div class="input-group-prepend">
                        <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                      </div>
                      <form:password path = "userPwd" id="upwd" placeholder="Password" class="form-control"/>
                      <form:errors cssStyle="color: red;" path="userPwd" />
                    </div>
                  </div>
                  <div class="text-muted font-italic">
                    <small>password strength:
                      <span class="text-success font-weight-700">strong</span>
                    </small>
                  </div>
                  <div class="row my-4">
                    <div class="col-12">
                      <div class="custom-control custom-control-alternative custom-checkbox">
                        <input class="custom-control-input" id="customCheckRegister" type="checkbox">
                        <label class="custom-control-label" for="customCheckRegister">
                          <span>I agree with the
                            <a href="#">Privacy Policy</a>
                          </span>
                        </label>
                      </div>
                    </div>
                  </div>
                  <div class="text-center">
                    <button type="button" class="btn btn-primary mt-4" onclick="login.signup(); return false;">Create account</button>
                  </div>
                </form:form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </main>
  <footer class="footer">
   
  </footer>
  <!-- Core -->

  
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <!-- Argon JS -->
  <script src="${pageContext.request.contextPath}/resources/script/common/argon.js?v=1.0.1"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/popper/popper.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/headroom/headroom.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/script/login/login.js"></script>
</body>
<!------ Include the above in your HEAD tag ---------->
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