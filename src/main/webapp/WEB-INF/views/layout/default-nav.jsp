<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="logo-group">

	<!-- PLACE YOUR LOGO HERE -->
	<span id="logo"><a href="/main.do"><img src="/img/logo.png" alt="SmartAdmin"></a></span>
	<!-- END LOGO PLACEHOLDER -->
</div>

<!-- pulled right: nav area -->
<div class="pull-right">

	<!-- logout button -->
	<div id="logout" class="btn-header transparent pull-right">
		<span> <a href="#" onclick="javascript: if(confirm('로그아웃 하시겠습니까?')) location.href = '/logout.do'" title="로그아웃" data-action="userLogout"><i class="fa fa-sign-out"></i></a> </span>
	</div>

	<!-- login button -->
	<div id="login" class="btn-header transparent pull-right">
		<span> <a href="/login.do" title="로그인" data-action="userLogin"><i class="fa fa-smile-o"></i></a> </span>
	</div>
</div>
<!-- end pulled right: nav area -->

<script type="text/javascript">

$(function () {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
});
</script>

