<!-- MAIN CONTENT -->
<div id="content" class="container">

	<div class="row">
		<div class="well no-padding">

			<form action="/register.do" id="smart-form-register"
				class="smart-form client-form">
				<header> 회원가입 </header>

				<fieldset>
					<section>
						<label class="input"> <i class="icon-append fa fa-user"></i>
							<input type="text" name="userName" placeholder="Username"
							value="${username}"> <b
							class="tooltip tooltip-bottom-right">Needed to enter the
								website</b>
						</label>
					</section>
					<section>
						<label class="input"> <i class="icon-append fa fa-lock"></i>
							<input type="password" name="password" placeholder="Password"
							id="password"> <b class="tooltip tooltip-bottom-right">Don't
								forget your password</b>
						</label>
					</section>

					<section>
						<label class="input"> <i class="icon-append fa fa-lock"></i>
							<input type="password" name="passwordConfirm"
							placeholder="Confirm password"> <b
							class="tooltip tooltip-bottom-right">Don't forget your
								password</b>
						</label>
					</section>
				</fieldset>

				<fieldset>
					<div class="row">
						<section class="col col-6">
							<label class="select"> <select name="gender">
									<option value="0" selected="" disabled="">Gender</option>
									<option value="1">Male</option>
									<option value="2">Female</option>
							</select> <i></i>
							</label>
						</section>
					</div>
				</fieldset>
				<footer>
					<button id="submit" class="btn btn-primary">등록</button>
				</footer>
				<div class="message">
					<i class="fa fa-check"></i>
					<p>Thank you for your registration!</p>
				</div>
			</form>

		</div>
		<p class="note text-center">*FREE Registration ends on October
			2015.</p>
		<h5 class="text-center">- Or sign in using -</h5>
		<ul class="list-inline text-center">
			<li><a href="javascript:void(0);"
				class="btn btn-primary btn-circle"><i class="fa fa-facebook"></i></a>
			</li>
			<li><a href="javascript:void(0);"
				class="btn btn-info btn-circle"><i class="fa fa-twitter"></i></a></li>
			<li><a href="javascript:void(0);"
				class="btn btn-warning btn-circle"><i class="fa fa-linkedin"></i></a>
			</li>
		</ul>
	</div>
</div>

<script type="text/javascript">
	// Validation
	$(function() {

		// Validation
		$("#smart-form-register").validate({

			// Rules for form validation
			rules : {
				username : {
					required : true
				},
				email : {
					required : true,
					email : true
				},
				password : {
					required : true,
					minlength : 3,
					maxlength : 20
				},
				passwordConfirm : {
					required : true,
					minlength : 3,
					maxlength : 20,
					equalTo : '#password'
				},
				firstname : {
					required : true
				},
				lastname : {
					required : true
				},
				gender : {
					required : true
				},
				terms : {
					required : true
				}
			},

			// Messages for form validation
			messages : {
				login : {
					required : 'Please enter your login'
				},
				email : {
					required : 'Please enter your email address',
					email : 'Please enter a VALID email address'
				},
				password : {
					required : 'Please enter your password'
				},
				passwordConfirm : {
					required : 'Please enter your password one more time',
					equalTo : 'Please enter the same password as above'
				},
				firstname : {
					required : 'Please select your first name'
				},
				lastname : {
					required : 'Please select your last name'
				},
				gender : {
					required : 'Please select your gender'
				},
				terms : {
					required : 'You must agree with Terms and Conditions'
				}
			},

			// Ajax form submition
			submitHandler : function(form) {
				$(form).submit();

				// 					$(form).ajaxSubmit({
				// 						success : function(data) {
				// 							console.log(data);
				// 							$("#smart-form-register").addClass('submited');
				// 						}
				// 					});
			},

			// Do not change code below
			errorPlacement : function(error, element) {
				error.insertAfter(element.parent());
			}
		});

	});
</script>
