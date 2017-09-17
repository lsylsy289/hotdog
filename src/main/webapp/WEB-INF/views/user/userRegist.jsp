<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div id="content" class="container">
	<div class="row">
		<div class="well no-padding">

			<form id="formRegister" class="smart-form client-form">
				<header> 회원가입 </header>

				<fieldset>
					<div class="row">
						<section class="col col-6">
							<label class="input"> <i class="icon-append fa fa-user"></i>
								<input type="text" name="userId" placeholder="사용자아이디">
							</label>
						</section>
						<section class="col col-6">
							<label class="input"> <i class="icon-append fa fa-user"></i>
								<input type="text" name="userName" placeholder="사용자명">
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-6">
							<div class="col-md-6">
								<label class="input"> <i class="icon-append">@</i> <input
									type="email" name="email1">
								</label>
							</div>
							<div class="col-md-4">
								<label class="input"> <input type="email" name="email2">
								</label>
							</div>
							<div class="col-md-2">
								<label class="select"> <select>
										<option>(선택)</option>
										<option>naver.com</option>
										<option>daum.com</option>
										<option>직접입력</option>
								</select> <i></i>
								</label>
							</div>
						</section>
						<section class="col col-6">
							<label class="input"> <i class="icon-append fa fa-phone"></i>
								<input type="tel" name="phone" placeholder="휴대폰번호"
								data-mask="(999) 999-9999">
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-6">
							<label class="input"> <i class="icon-append fa fa-lock"></i>
								<input type="password" name="password" placeholder="비밀번호">
							</label>
						</section>
						<section class="col col-6">
							<label class="input"> <i class="icon-append fa fa-lock"></i>
								<input type="password" name="passwordConfirm"
								placeholder="비밀번호 확인">
							</label>
						</section>
					</div>
					<div class="row">
						<section class="col col-8">
							<div class="col-md-2">
								<label class="input"> <input type="text" id="txtPostCode" name="postCode" placeholder="우편번호" readonly="readonly">
								</label>
								<button type="button" id="btnSearch" class="btn btn-info">우편번호 검색</button>
							</div>
							<div class="col-md-5">
								<label class="input"> <input type="text" id="txtAddres" name="addres" placeholder="주소" readonly="readonly">
								</label>
							</div>
							<div class="col-md-5">
								<label class="input"> <input type="text"
									name="addresDtl" placeholder="상세주소">
								</label>
							</div>
						</section>
						<section class="col col-4">
							<label class="input"> <input type="text" name="postCode"
								placeholder="생년월일">
							</label>
						</section>
					</div>
					<div class="row">
						<div id="list"></div>
					</div>
				</fieldset>
				<footer>
					<button type="button" id="btnRgst" class="btn btn-primary">가입</button>
				</footer>
				<div class="message">
					<i class="fa fa-check"></i>
					<p>Thank you for your registration!</p>
				</div>

<%-- 				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
			</form>

		</div>
	</div>
</div>

<!--autoload=false 파라미터를 이용하여 자동으로 로딩되는 것을 막습니다.-->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js?autoload=false"></script>

<script type="text/javascript">

$(document).ready(function () {

	FormScope.init();
});

var FormScope = {
		
	form: $("#formRegister"),

	userId: $("#userId"),
	userName: $("#userName"),
	password: $("#txtPassword"),
	passwordConfirm: $("#txtPasswordConfirm"),
	emailAddr: $("#txtEmailAddr"),
	
	searchButton: $("#btnSearch"),
	rgstButton: $("#btnRgst"),
		
	init: function () {
		
		this.searchButton.click(function () {
			
			//load함수를 이용하여 core스크립트의 로딩이 완료된 후, 우편번호 서비스를 실행합니다.
		    daum.postcode.load(function(){
		        new daum.Postcode({
		            oncomplete: function(data) {
		            	
		            	if ( !_.isEmpty(data) ) {
							
							$("#txtPostCode").val(data.postcode); // 우편번호		            		
							$("#txtAddres").val(data.jibunAddress); // 주소           		
		            	}
		            }
		        }).open();
		    });
		});
		
		this.rgstButton.click(function () {

			console.log(this.form.serialize());
			
			$.ajax({
				url: '/user/registUser.do',			
				method: 'post',
				dataType: 'text',
				data: this.form.serialize(),
				success: function (data) {
					
					console.log(data);
				}
			});
		}.bind(this));
	}
};

</script>