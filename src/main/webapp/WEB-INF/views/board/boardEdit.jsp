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
									<section>
										<label class="label">제목</label> <label class="input">
											<input type="text" name="title" class="input-sm">
										</label>
								</fieldset>

								<fieldset>
									<section>
										<label class="label">내용</label> <label class="textarea">
											<textarea rows="3" name="content" class="custom-scroll"></textarea>
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
});

var FormScope = {
		
	form: $("#form-boardRgst"),	
		
	saveButton: $("#btnSave"),
	listButton: $("#btnList"),
	
	init: function () {
		
		this.saveButton.click(function (e) {
			e.preventDefault();
			
			FormScope.form.submit();
		});
		
		this.listButton.click(function (e) {
			e.preventDefault();
			
			location.href = "/board/boardList.do";
		});
	}
}
</script>