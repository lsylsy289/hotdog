<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div id="content">
	<div class="row">
		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
			<h1 class="page-title txt-color-blueDark">
				<i class="fa fa-table fa-fw "></i> 게시판
			</h1>
		</div>
	</div>

	<!-- widget grid -->
	<section id="widget-grid" class="">

		<div class="row">
			<article class="col-sm-12 col-md-12 col-lg-6">

				<!-- Widget ID (each widget will need unique ID)-->
				<div class="jarviswidget" id="wid-id-1"
					data-widget-colorbutton="false" data-widget-editbutton="false"
					data-widget-custombutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-edit"></i>
						</span>
						<h2>게시판 등록</h2>
					</header>

					<!-- widget div-->
					<div>
						<!-- widget content -->
						<div class="widget-body no-padding">

							<form id="form-boardRgst" class="smart-form" action="/board/boardSave.do" method="post">
								<fieldset>
									<label class="label">제목</label> <label class="input">
										<c:if test="${not empty(board)}">
											<input type="text" name="title" class="input-sm" value="${board.title}" >
										</c:if>
										<c:if test="${empty(board)}">
											<input type="text" name="title" class="input-sm" value="" >
										</c:if>
									</label>
								</fieldset>
								<fieldset>
									<section>
										<label class="label">내용</label> <label class="textarea">
											<c:if test="${not empty(board)}">
												<textarea rows="3" name="content" class="custom-scroll">${board.content}</textarea>
											</c:if>
											<c:if test="${empty(board)}">
												<textarea rows="3" name="content" class="custom-scroll"></textarea>
											</c:if>
										</label>
										<div class="note">
											<strong>Note:</strong> height of the textarea depends on the
											rows attribute.
										</div>
									</section>
								</fieldset>
								<footer>
									<button id="btnSave" class="btn btn-primary">저장</button>
									<button id="btnList" class="btn btn-default">목록</button>
								</footer>
								
								<input type="hidden" id="hidBoardSeq" name="boardSeq" value="${board.boardSeq}" />
							</form>
							
							<div id="fileuploader">Browse</div>
							<div>
								<button id="btnUpload" class="btn btn-info">Upload</button>
							</div>
						</div>
						<!-- end widget content -->
					</div>
					<!-- end widget div -->
				</div>
				<!-- end widget -->
			</article>
			<!-- END COL -->
		</div>
		<!-- END ROW -->
	</section>
</div>

<script type="text/javascript">

$(document).ready(function () {

	var resultCode = '${requestScope.resultCode}';

	if ( _.isEqual("SUCCESS", resultCode) ) {
		alert("저장을 완료하였습니다.");
		
		setTimeout(function () {
			location.replace("/board/boardList.do");			
		}, 1000);
	} else if ( _.isEqual("FAIL", resultCode) ){
		alert("가입에 실패하였습니다. \n 관리자에게 문의하여 주십시오.");
	}
	
	FormScope.init();
	fileUpload.init();
});

var FormScope = {
		
	form: $("#form-boardRgst"),	
		
	saveButton: $("#btnSave"),
	listButton: $("#btnList"),
	
	uploadButton: $("#btnUpload"),
	
	init: function () {
		
		this.saveButton.click(function (e) {
			e.preventDefault();
			
			if ( confirm("저장하시겠습니까?") ) FormScope.form.submit();
		});
		
		this.listButton.click(function (e) {
			e.preventDefault();
			
			location.href = "/board/boardList.do";
		});
		
		this.uploadButton.click(function (e) {
			e.preventDefault();
			
			eObj.startUpload();
		});
	}
}

var fileUpload = {
		
	init: function () {
	        window.eObj = $("#fileuploader").uploadFile( {

		    url: "/upload/saveUpload.do",
		    method: "post",
		    autoSubmit: false,
		    formData: {},
		    previewWidth: "auto",
		    previewHeight: "50px",
		    maxFileCountErrorStr: " 허용될 수 없습니다. 최대 허용될 파일 개수는:",
		    showDelete: true,

		    onLoad: function() {
		        $.ajax({

		           url : "/upload/onloadUpload.do",
		           method: "post",
		           dataType: "json",
		           data : {"signTrgNo": "hanq"},
		           //익스는 주소가 같고, 데이터가 동일하다면 캐쉬를 사용하여 처리한다.
		           cache : false,
		           success : function(data) {

		              $.each(data.row, function (i, item) {

		                 var originalFileName;
		                 var filePath;
		                 var imageSize;
		                 var fFileName;
		                 var seqNo;

		                 $.each(item, function (k,v) {

		                    if(k == "originalFileName") {
		                       originalFileName = v;
		                    }

		                    if(k == "filePath") {
		                       filePath = v;
		                    }

		                    if(k == "imageSize") {
		                       imageSize = v;
		                    }

		                    if(k == "fFileName") {
		                        fFileName = v;
		                    }

		                    if(k == "seqNo") {
		                        seqNo = v;
		                    }
		                 });

		                 eObj.createProgress(originalFileName, filePath, imageSize, fFileName, seqNo);
		              });
		           }
		        });
		     },

		     afterUploadAll: function() {
		        location.reload();
		     }
		 });		
	}
}
</script>