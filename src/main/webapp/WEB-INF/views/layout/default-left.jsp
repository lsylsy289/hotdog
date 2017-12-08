<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- User info -->
<div class="login-info">
	<span><a href="javascript:void(0);" id="show-shortcut"> <span> ${loginId} </span></a> </span>
</div>
<!-- end user info -->

<nav>
	<ul>
		<li class="top-menu-invisible">
			<a href="javascript:;"><i class="fa fa-lg fa-fw fa-cube txt-color-blue"></i> <span class="menu-item-parent">회원관리</span></a>
			<ul>
				<li class="">
					<a href="/user/userRegist.do" title="회원가입"><i class="fa fa-lg fa-fw fa-picture-o"></i> <span class="menu-item-parent">회원가입</span></a>
				</li>
			</ul>
		</li>
		<li>
			<a href="javascript:;"><i class="fa fa-lg fa-fw fa-pencil-square-o"></i> <span class="menu-item-parent">시스템 관리</span></a>
			<ul>
				<li>
					<a href="/admin/codeMng.do">코드 관리</a>
				</li>
			</ul>
		</li>
	</ul>
</nav>