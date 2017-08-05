<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"  prefix="tiles"%>
<!DOCTYPE html>
<html>
	<head>
  		<tiles:insertAttribute name="header"/>
  	</head>
  	<body>
  		<header id="header">
  			<tiles:insertAttribute name="nav"/>
  		</header>
  		<aside id="left-panel">
  			<tiles:insertAttribute name="left"/>	
  		</aside>
  		
  		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<div id="ribbon">

				<span class="ribbon-button-alignment"> <span id="refresh" class="btn btn-ribbon" data-action="resetWidgets" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true"> <i class="fa fa-refresh"></i> </span> </span>

				<ol class="breadcrumb">
					<li>
						Home
					</li>
				</ol>
			</div>
			
			<tiles:insertAttribute name="content"/>
		</div>

  		<tiles:insertAttribute name="footer"/>
  	</body>
</html>