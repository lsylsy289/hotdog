<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="content" class="container">
	<div class="row">
	    <div class="col-md-2"></div>
		<div class="col-md-7">
			<div class="well no-padding">
				<form id="login-form" name="f" class="smart-form client-form" action="/login-security.do" method="post">
					<fieldset>
						<section>
							<label class="label">UserId</label>
							<label class="input"> <i class="icon-append fa fa-user"></i>
								<input type="text" id="txtUserId" name="loginId">
								<b class="tooltip tooltip-top-right"><i class="fa fa-user txt-color-teal"></i> 사용자 아이디를 입력해주십시오.</b></label>
						</section>

						<section>
							<label class="label">Password</label>
							<label class="input"> <i class="icon-append fa fa-lock"></i>
								<input type="password" id="txtPassword" name="password">
								<b class="tooltip tooltip-top-right"><i class="fa fa-lock txt-color-teal"></i> 비밀번호를 입력해주십시오.</b> </label>
							<div class="note">
								<a href="forgotpassword.html">Forgot password?</a>
							</div>
						</section>

						<section>
							<label class="checkbox">
								<input type="checkbox" name="remember"><i></i>아이디 저장</label>
						</section>
					</fieldset>
					<footer>
						<button class="btn btn-primary">
							로그인
						</button>
					</footer>
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
				<c:if test="${not empty fail}">
					<div class="error">${fail}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function () {

	FormScope.init();
});

var FormScope = {
	
	loginForm: $("#login-form"),
		
	userId: $("#txtUserId"),	
	password: $("#txtPassword"),	
	
	loginButton: $("#btnLogin"),
	
	init: function () {

		var _this = this;
		
		this.loginButton.click(function () {
			
			_this.loginForm.submit();
		});
	}
};
</script>