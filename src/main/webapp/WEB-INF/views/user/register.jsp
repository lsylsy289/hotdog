<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="content" class="container">

	<div class="row">
		<div class="well no-padding">

			<form id="formRegister" action="/user/userRegister.do" method="post" class="smart-form client-form">
				<header> 회원가입 </header>

				<fieldset>
					<section>
						<label class="input"> <i class="icon-append fa fa-user"></i>
							<input type="text" id="txtUserId" name="userId" placeholder="UserId">
						</label>
					</section>
					<section>
						<label class="input"> <i class="icon-append fa fa-user"></i>
							<input type="text" id="txtUserName" name="userName" placeholder="Username">
						</label>
					</section>
					<section>
						<label class="input"> <i class="icon-append fa fa-lock"></i>
							<input type="password" id="txtPassword" name="password" placeholder="Password" />
						</label>
					</section>
					<section>
						<label class="input"> <i class="icon-append fa fa-lock"></i>
							<input type="password" id="txtPasswordConfirm" name="passwordConfirm" placeholder="Confirm password" />
						</label>
					</section>
				</fieldset>

				<fieldset>
					<section>
						<label class="input"> <i class="icon-append fa fa-lock"></i>
							<input type="email" id="txtEmailAddr" name="emailAddr" placeholder="Email" />
						</label>
					</section>
					<section>
						<label class="select"> 
							<select id="sltGender" name="gender">
									<option value="1">남자</option>
									<option value="2">여자</option>
							</select><i></i>
						</label>
					</section>
				</fieldset>
				<footer>
					<button id="btnRgst" class="btn btn-primary">가입</button>
				</footer>
				<div class="message">
					<i class="fa fa-check"></i>
					<p>Thank you for your registration!</p>
				</div>
			</form>

		</div>
		<p class="note text-center">* 회원가입시 많은 혜택을 누릴 수 있습니다. *</p>
	</div>
</div>

<script type="text/javascript">

$(document).ready(function () {

	var resultCode = '${requestScope.resultCode}';
	
	if ( _.isEqual("SUCCESS", resultCode) ) {
		
		alert("가입이 완료되었습니다.");
	} else if ( _.isEqual("FAIL", resultCode) ) {
		
		alert("가입에 실패하였습니다. \n 관리자에게 문의하여 주십시오.");
	}
	
	formScope.init();
});

var formScope = {
		
	userId: $("#userId"),
	userName: $("#userName"),
	password: $("#txtPassword"),
	passwordConfirm: $("#txtPasswordConfirm"),
	emailAddr: $("#txtEmailAddr"),
	
	formRegister: $("#formRegister"),
	rgstButton: $("#btnRgst"),
		
	init: function () {

		this.rgstButton.click(function () {
			
			formRegister.submit();
		});
	}
};

</script>
