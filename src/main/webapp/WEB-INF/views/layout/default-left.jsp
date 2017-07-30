<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- User info -->
<div class="login-info">
	<span> <!-- User image size is adjusted inside CSS, it should stay as it --> <a href="javascript:void(0);" id="show-shortcut" data-action="toggleShortcut"> <img src="/img/avatars/sunny.png" alt="me" class="online" /> <span> john.doe </span> <i class="fa fa-angle-down"></i> </a> </span>
</div>
<!-- end user info -->

<nav>
	<ul>
		<li class="top-menu-invisible">
			<a href="#"><i class="fa fa-lg fa-fw fa-cube txt-color-blue"></i> <span class="menu-item-parent">회원관리</span></a>
			<ul>
				<li class="">
					<a href="/user/register.do" title="회원가입"><i class="fa fa-lg fa-fw fa-picture-o"></i> <span class="menu-item-parent">회원가입</span></a>
				</li>
			</ul>
		</li>
		<li>
			<a href="#"><i class="fa fa-lg fa-fw fa-table"></i> <span class="menu-item-parent">커뮤니티</span></a>
			<ul>
				<li>
					<a href="/board/boardList.do"><i class="fa fa-lg fa-fw fa-picture-o"></i>게시판</a>
				</li>
			</ul>
		</li>
		<li>
			<a href="#"><i class="fa fa-lg fa-fw fa-table"></i> <span class="menu-item-parent">Tables</span></a>
			<ul>
				<li>
					<a href="dataTables.do">Data Tables <span class="badge inbox-badge bg-color-greenLight hidden-mobile">responsive</span></a>
				</li>
				<li>
					<a href="jqgrid.html">Jquery Grid</a>
				</li>
			</ul>
		</li>
	</ul>
</nav>


<span class="minifyme" data-action="minifyMenu"> 
	<i class="fa fa-arrow-circle-left hit"></i> 
</span>