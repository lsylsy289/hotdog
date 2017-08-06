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

<!-- 								<div class="text-center"> -->
<!-- 									<ul class="pagination pagination-sm"> -->
<!-- 										<li> -->
<!-- 											<a href="javascript:void(0);"><i class="fa fa-angle-left"></i></a> -->
<!-- 										</li> -->
<!-- 										<li class="active"> -->
<!-- 											<a href="javascript:void(0);">1</a> -->
<!-- 										</li> -->
<!-- 										<li> -->
<!-- 											<a href="javascript:void(0);">2</a> -->
<!-- 										</li> -->
<!-- 										<li> -->
<!-- 											<a href="javascript:void(0);">3</a> -->
<!-- 										</li> -->
<!-- 										<li> -->
<!-- 											<a href="javascript:void(0);">4</a> -->
<!-- 										</li> -->
<!-- 										<li> -->
<!-- 											<a href="javascript:void(0);">5</a> -->
<!-- 										</li> -->
<!-- 										<li> -->
<!-- 											<a href="javascript:void(0);"><i class="fa fa-angle-right"></i></a> -->
<!-- 										</li> -->
<!-- 									</ul> -->
<!-- 								</div> -->
							</div>
						</div>
						<div class="pull-right" style="margin-bottom: 10px">
							<button id="btnRgst" class="btn btn-primary" onclick="javascript:location.href = '/board/boardEdit.do?updtYn=false'" >등록</button>
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