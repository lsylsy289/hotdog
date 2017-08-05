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
			<!-- NEW COL START -->
			<article class="col-sm-12 col-md-12 col-lg-6">

				<!-- Widget ID (each widget will need unique ID)-->
				<div class="jarviswidget" id="wid-id-1"
					data-widget-colorbutton="false" data-widget-editbutton="false"
					data-widget-custombutton="false">
					<header>
						<span class="widget-icon"> <i class="fa fa-edit"></i>
						</span>
						<h2>게시판 상세보기</h2>
					</header>

					<!-- widget div-->
					<div>
						<!-- widget content -->
						<div class="widget-body no-padding">

							<form class="smart-form">
								<fieldset>
									<label class="label">제목</label> 
									<label class="input state-disabled">
										<input type="text" name="title" class="input-sm" value="${board.title}" disabled="disabled">
									</label>
								</fieldset>

								<fieldset>
									<section>
										<label class="label">내용</label> 
										<label class="textarea state-disabled">
											<textarea rows="3" name="content" class="custom-scroll" disabled="disabled">${board.content}</textarea>
										</label>
										<div class="note">
											<strong>Note:</strong> height of the textarea depends on the
											rows attribute.
										</div>
									</section>
								</fieldset>
								<fieldset>
									<div id="fileuploader"></div>
								</fieldset>
								<footer>
									<button id="btnDelete" class="btn btn-danger">삭제</button>
									<button id="btnUpdt" class="btn btn-primary">수정</button>
									<button id="btnList" class="btn btn-default">목록</button>
								</footer>
								
								<input type="hidden" id="hidBoardSeq" value="${board.boardSeq}" />
								<input type="hidden" id="hidFileId" value="${board.fileId}" />
							</form>
							
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
		
		FormScope.init();
		FileUpload.init();
	});
	
	var FormScope = {
			
		listButton: $("#btnList"),
		updtButton: $("#btnUpdt"),
		deleteButton: $("#btnDelete"),
		
		init: function () {
			
			this.deleteButton.click(function (e) {
				e.preventDefault();
	
				if ( confirm("삭제하시겠습니까?") ) location.replace("/board/deleteBoard.do?boardSeq=" + $("#hidBoardSeq").val());
			});
			
			this.updtButton.click(function (e) {
				e.preventDefault();
				
				location.href = "/board/boardEdit.do?updtYn=true&boardSeq=" + $("#hidBoardSeq").val();
			});
			
			this.listButton.click(function (e) {
				e.preventDefault();
				
				location.href = "/board/boardList.do";
			});
		}
	}

	var FileUpload = {
			
		init: function () {
	        window.eObj = $("#fileuploader").uploadFile( {
	
	       	showDownload: true,	
	       	
		    onLoad: function() {
		    	
        	    $.ajax({
		            url : "/upload/onloadUpload.do",
		            method: "post",
		            dataType: "json",
		            data : { "fileId": $("#hidFileId").val() },
		            //익스는 주소가 같고, 데이터가 동일하다면 캐쉬를 사용하여 처리한다.
		            cache : false,
		            success : function(data) {
		            	
		               $.each(data.row, function (i, v) {
		             	  
		                  eObj.createProgress(v.originalFileName, v.filePath, v.fileSize, v.storedFileName, v.fileSeq);
		               });
	            
		               $("#fileuploader").hide();
		            }
		        });
		     },
	
	      	downloadCallback: function (originalFileName, fFileName) {
	
	          	$("body").append("<form id='fmFile' name='fmFileDownload'>" +
		                                  "<input type='hidden' id='hidOriginalFileName' name='originalFileName' />" +
		                                  "<input type='hidden' id='hidFFileName' name='fFileName' />" +
		                           "</form>");
	
		          var $fileDownload = $("#fmFile");
	
		          $("#hidOriginalFileName").val(originalFileName[0]);
		          $("#hidFFileName").val(fFileName);
	
		          $fileDownload.attr('action', "/upload/fileDownload.do");
		          $fileDownload.attr('method', "post");
		          $fileDownload.submit();
		          $fileDownload.remove();
		      },
	
		      deleteCallback: function (fileSeq, storedFileName) {
		          $.post("uploadDelteTest.do", {
		               fileSeq: fileSeq,
		               storedFileName: storedFileName
		          });
		      }
			 });		
		}
	}
</script>