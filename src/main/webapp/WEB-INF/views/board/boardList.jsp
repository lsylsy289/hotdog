<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.pagination {
    display: inline-block;
}

.pagination a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
}

.pagination a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>
<!-- #CSS Links -->
<!-- Basic Styles -->
<link rel="stylesheet" type="text/css" media="screen" href="/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="/css/font-awesome.min.css">

<!-- SmartAdmin Styles : Caution! DO NOT change the order -->
<link rel="stylesheet" type="text/css" media="screen" href="/css/smartadmin-production-plugins.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="/css/smartadmin-production.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="/css/smartadmin-skins.min.css">

<link href="/css/upload/uploadfile.css" rel="stylesheet" type="text/css" />

<!-- SmartAdmin RTL Support -->
<link rel="stylesheet" type="text/css" media="screen" href="/css/smartadmin-rtl.min.css"> 

<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
<link rel="stylesheet" type="text/css" media="screen" href="/css/demo.min.css">

<!-- #FAVICONS -->
<link rel="shortcut icon" href="/img/favicon/favicon.ico" type="image/x-icon">

<!-- #GOOGLE FONT -->
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">

<!-- #APP SCREEN / ICONS -->
<!-- Specifying a Webpage Icon for Web Clip
Ref: https://developer.apple.com/library/ios/documentation/AppleApplications/Reference/SafariWebContent/ConfiguringWebApplications/ConfiguringWebApplications.html -->
<link rel="apple-touch-icon" href="/img/splash/sptouch-icon-iphone.png">
<link rel="apple-touch-icon" sizes="76x76" href="/img/splash/touch-icon-ipad.png">
<link rel="apple-touch-icon" sizes="120x120" href="/img/splash/touch-icon-iphone-retina.png">
<link rel="apple-touch-icon" sizes="152x152" href="/img/splash/touch-icon-ipad-retina.png">

<!-- iOS web-app metas : hides Safari UI Components and Changes Status Bar Appearance -->
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">

<!-- Startup image for web apps -->
<link rel="apple-touch-startup-image" href="/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
<link rel="apple-touch-startup-image" href="/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
<link rel="apple-touch-startup-image" href="/img/splash/iphone.png" media="screen and (max-device-width: 320px)">

<div id="content">
	<div class="row">
		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
			<h1 class="page-title txt-color-blueDark">
				<i class="fa fa-table fa-fw "></i> 게시판
			</h1>
		</div>
	</div>

	<!-- widget grid -->
	<section id="widget-grid">

		<!-- row -->
		<div class="row">

			<!-- NEW WIDGET START -->
			<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

				<!-- Widget ID (each widget will need unique ID)-->
				<div class="jarviswidget jarviswidget-color-blueDark" id="wid-id-0"
					data-widget-editbutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-table"></i>
						</span>
						<h2>Normal Table</h2>
					</header>
					<!-- widget div-->
					<div>

						<!-- widget edit box -->
						<div class="jarviswidget-editbox">
							<!-- This area used as dropdown edit box -->

						</div>
						<!-- end widget edit box -->

						<!-- widget content -->
						<div class="widget-body">
							<div class="table-responsive">

								<table class="table table-bordered table-hover">
									<colgroup>
										<col width="5%" />
										<col width="70%" />
										<col width="5%" />
										<col width="10%" />
										<col width="10%" />
									</colgroup>
									<thead>
										<tr>
											<th style="text-align: center;">번호</th>
											<th style="text-align: center;">제목</th>
											<th style="text-align: center;">조회수</th>
											<th style="text-align: center;">등록자</th>
											<th style="text-align: center;">등록일자</th>
										</tr>
									</thead>
									<tbody>
										<c:choose>
											<c:when test="${fn:length(boardList) != 0}">
												<c:forEach var="board" items="${boardList}" varStatus="i">
													<tr onclick='javascript:FormScope.moveDetail(${board.boardSeq});' style="cursor: pointer;">
														<td style="text-align: center;">${i.count}</td>
														<td>${board.title}</td>
														<td style="text-align: center;">${board.viewCnt}</td>
														<td style="text-align: center;">${board.rgstUserName}</td>
														<td style="text-align: center;">
	                                     					<fmt:formatDate value="${board.rgstDate}" pattern="yyyy-MM-dd"/>
                                     					</td>
													</tr>
												</c:forEach>
											</c:when>
											<c:otherwise>
												<tr style="text-align: center;">
													<td colspan="5">데이터가 존재하지 않습니다.</td>
												</tr>
											</c:otherwise>
										</c:choose>
									</tbody>
								</table>
								
								<c:if test="${not empty paginationInfo}">
									<div class="text-center">
										<div class="pagination">
							        <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="FormScope.searchBoard"/>
							    		</div>
							    	</div>
							    </c:if>
							</div>
						</div>
						<div class="pull-right" style="margin-bottom: 10px">
							<button id="btnRgst" class="btn btn-primary" onclick="javascript:location.href = '/board/boardEdit.do?updtYn=false'" >등록</button>
							<button id="btnPrint" class="btn btn-primary" onclick="javascript:window.print();" >출력</button>
						</div>
					</div>
					<!-- end widget div -->

				</div>
				<!-- end widget -->
			</article>
		</div>
	</section>
</div>

<script type="text/javascript">

	$(document).ready(function () {
		
	});
	
	var FormScope = {
		
		searchBoard: function (pageNo) {
			
			location.href = "/board/boardList.do?pageNo="+pageNo;
		},	
			
		moveDetail: function (boardSeq) {
			
			location.href = '/board/boardDetail.do?boardSeq=' + boardSeq;
		}
	};

</script>