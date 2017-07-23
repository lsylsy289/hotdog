<!-- MAIN CONTENT -->
<div id="content">

	<!-- row -->
	<div class="row">

		<!-- col -->
		<div class="col-xs-12 col-sm-7 col-md-7 col-lg-4">
			<h1 class="page-title txt-color-blueDark"><!-- PAGE HEADER --><i class="fa-fw fa fa-home"></i> Page Header <span>>
				Subtitle </span></h1>
		</div>
		<!-- end col -->

		<!-- right side of the page with the sparkline graphs -->
		<!-- col -->
		<div class="col-xs-12 col-sm-5 col-md-5 col-lg-8">
			<!-- sparks -->
			<ul id="sparks">
				<li class="sparks-info">
					<h5> My Income <span class="txt-color-blue">$47,171</span></h5>
					<div class="sparkline txt-color-blue hidden-mobile hidden-md hidden-sm">
						1300, 1877, 2500, 2577, 2000, 2100, 3000, 2700, 3631, 2471, 2700, 3631, 2471
					</div>
				</li>
				<li class="sparks-info">
					<h5> Site Traffic <span class="txt-color-purple"><i class="fa fa-arrow-circle-up" data-rel="bootstrap-tooltip" title="Increased"></i>&nbsp;45%</span></h5>
					<div class="sparkline txt-color-purple hidden-mobile hidden-md hidden-sm">
						110,150,300,130,400,240,220,310,220,300, 270, 210
					</div>
				</li>
				<li class="sparks-info">
					<h5> Site Orders <span class="txt-color-greenDark"><i class="fa fa-shopping-cart"></i>&nbsp;2447</span></h5>
					<div class="sparkline txt-color-greenDark hidden-mobile hidden-md hidden-sm">
						110,150,300,130,400,240,220,310,220,300, 270, 210
					</div>
				</li>
			</ul>
			<!-- end sparks -->
		</div>
		<!-- end col -->

	</div>
	<!-- end row -->

	<!--
	The ID "widget-grid" will start to initialize all widgets below
	You do not need to use widgets if you dont want to. Simply remove
	the <section></section> and you can use wells or panels instead
	-->

	<!-- widget grid -->
	<section id="widget-grid" class="">

		<!-- row -->
		<div class="row">

			<!-- NEW WIDGET START -->
			<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">

				<table id="jqgrid"></table>
				<div id="pjqgrid"></div>

				<br>
				<a href="javascript:void(0)" id="m1">Get Selected id's</a>
				<br>
				<a href="javascript:void(0)" id="m1s">Select(Unselect) row 13</a>

			</article>
			<!-- WIDGET END -->

		</div>

		<!-- end row -->

	</section>
	<!-- end widget grid -->

</div>
<!-- END MAIN CONTENT -->

<script type="text/javascript">
$(document).ready(function() {
	pageSetUp();
	
	jqGrid.init();
});

$(window).on('resize.jqGrid', function() {
	$("#jqgrid").jqGrid('setGridWidth', $("#content").width());
});
	
var jqGrid = {
		
		init: function () {
			
			var jqgrid_data = [{
				id : "1",
				date : "2007-10-01",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "2",
				date : "2007-10-02",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "3",
				date : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "4",
				date : "2007-10-04",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "5",
				date : "2007-10-05",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "6",
				date : "2007-09-06",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "7",
				date : "2007-10-04",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "8",
				date : "2007-10-03",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "9",
				date : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "10",
				date : "2007-10-01",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "11",
				date : "2007-10-02",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "12",
				date : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "13",
				date : "2007-10-04",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "14",
				date : "2007-10-05",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "15",
				date : "2007-09-06",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}, {
				id : "16",
				date : "2007-10-04",
				name : "test",
				note : "note",
				amount : "200.00",
				tax : "10.00",
				total : "210.00"
			}, {
				id : "17",
				date : "2007-10-03",
				name : "test2",
				note : "note2",
				amount : "300.00",
				tax : "20.00",
				total : "320.00"
			}, {
				id : "18",
				date : "2007-09-01",
				name : "test3",
				note : "note3",
				amount : "400.00",
				tax : "30.00",
				total : "430.00"
			}];
			
			jQuery("#jqgrid").jqGrid({
				data : jqgrid_data,
				datatype : "local",
				height : 'auto',
				colNames : ['Actions', 'Inv No', 'Date', 'Client', 'Amount', 'Tax', 'Total', 'Notes'],
				colModel : [{
					name : 'act',
					index : 'act',
					sortable : false
				}, {
					name : 'id',
					index : 'id'
				}, {
					name : 'date',
					index : 'date',
					editable : true
				}, {
					name : 'name',
					index : 'name',
					editable : true
				}, {
					name : 'amount',
					index : 'amount',
					align : "right",
					editable : true
				}, {
					name : 'tax',
					index : 'tax',
					align : "right",
					editable : true
				}, {
					name : 'total',
					index : 'total',
					align : "right",
					editable : true
				}, {
					name : 'note',
					index : 'note',
					sortable : false,
					editable : true
				}],
				rowNum : 10,
				rowList : [10, 20, 30],
				pager : '#pjqgrid',
				sortname : 'id',
				toolbarfilter : true,
				viewrecords : true,
				sortorder : "asc",
				gridComplete : function() {
					var ids = jQuery("#jqgrid").jqGrid('getDataIDs');
					for (var i = 0; i < ids.length; i++) {
						var cl = ids[i];
						be = "<button class='btn btn-xs btn-default' data-original-title='Edit Row' onclick=\"jQuery('#jqgrid').editRow('" + cl + "');\"><i class='fa fa-pencil'></i></button>";
						se = "<button class='btn btn-xs btn-default' data-original-title='Save Row' onclick=\"jQuery('#jqgrid').saveRow('" + cl + "');\"><i class='fa fa-save'></i></button>";
						ca = "<button class='btn btn-xs btn-default' data-original-title='Cancel' onclick=\"jQuery('#jqgrid').restoreRow('" + cl + "');\"><i class='fa fa-times'></i></button>";
						//ce = "<button class='btn btn-xs btn-default' onclick=\"jQuery('#jqgrid').restoreRow('"+cl+"');\"><i class='fa fa-times'></i></button>";
						//jQuery("#jqgrid").jqGrid('setRowData',ids[i],{act:be+se+ce});
						jQuery("#jqgrid").jqGrid('setRowData', ids[i], {
							act : be + se + ca
						});
					}
				},
				editurl : "dummy.html",
				caption : "SmartAdmin jQgrid Skin",
				multiselect : true,
				autowidth : true,

			});
			jQuery("#jqgrid").jqGrid('navGrid', "#pjqgrid", {
				edit : false,
				add : false,
				del : true
			});
			jQuery("#jqgrid").jqGrid('inlineNav', "#pjqgrid");
			/* Add tooltips */
			$('.navtable .ui-pg-button').tooltip({
				container : 'body'
			});

			$("#m1").click(function() {
				var s;
				s = jQuery("#jqgrid").jqGrid('getGridParam', 'selarrrow');
				alert(s);
			});
			$("#m1s").click(function() {
				jQuery("#jqgrid").jqGrid('setSelection', "13");
			});

			// remove classes
			$(".ui-jqgrid").removeClass("ui-widget ui-widget-content");
			$(".ui-jqgrid-view").children().removeClass("ui-widget-header ui-state-default");
			$(".ui-jqgrid-labels, .ui-search-toolbar").children().removeClass("ui-state-default ui-th-column ui-th-ltr");
			$(".ui-jqgrid-pager").removeClass("ui-state-default");
			$(".ui-jqgrid").removeClass("ui-widget-content");

			// add classes
			$(".ui-jqgrid-htable").addClass("table table-bordered table-hover");
			$(".ui-jqgrid-btable").addClass("table table-bordered table-striped");

			$(".ui-pg-div").removeClass().addClass("btn btn-sm btn-primary");
			$(".ui-icon.ui-icon-plus").removeClass().addClass("fa fa-plus");
			$(".ui-icon.ui-icon-pencil").removeClass().addClass("fa fa-pencil");
			$(".ui-icon.ui-icon-trash").removeClass().addClass("fa fa-trash-o");
			$(".ui-icon.ui-icon-search").removeClass().addClass("fa fa-search");
			$(".ui-icon.ui-icon-refresh").removeClass().addClass("fa fa-refresh");
			$(".ui-icon.ui-icon-disk").removeClass().addClass("fa fa-save").parent(".btn-primary").removeClass("btn-primary").addClass("btn-success");
			$(".ui-icon.ui-icon-cancel").removeClass().addClass("fa fa-times").parent(".btn-primary").removeClass("btn-primary").addClass("btn-danger");

			$(".ui-icon.ui-icon-seek-prev").wrap("<div class='btn btn-sm btn-default'></div>");
			$(".ui-icon.ui-icon-seek-prev").removeClass().addClass("fa fa-backward");

			$(".ui-icon.ui-icon-seek-first").wrap("<div class='btn btn-sm btn-default'></div>");
			$(".ui-icon.ui-icon-seek-first").removeClass().addClass("fa fa-fast-backward");

			$(".ui-icon.ui-icon-seek-next").wrap("<div class='btn btn-sm btn-default'></div>");
			$(".ui-icon.ui-icon-seek-next").removeClass().addClass("fa fa-forward");

			$(".ui-icon.ui-icon-seek-end").wrap("<div class='btn btn-sm btn-default'></div>");
			$(".ui-icon.ui-icon-seek-end").removeClass().addClass("fa fa-fast-forward");
		}
}	

/******************************************
 * 그리드 관련 메소드
 ******************************************/
var gridFunc = 
{   
	addRow: function () {
	   
	   var $jqGridVar = $("#jqGrid");
	   var totCnt = $jqGridVar.getGridParam("records");
	   var addData = { seq: "", name: "", phone: "", address: "", etcc: "", gender: "1" };
	
	   $jqGridVar.addRowData(totCnt + 1, addData);
	   $jqGridVar.setColProp("name", { editable: true} );
	},
	
	rowBtn: function (cellValue, options, rowObject) {
	   
	   return (!CommonJsUtil.isEmpty(rowObject.seq)) ? "" : '<a href="javascript:gridFunc.delRow(' + options.rowId + ');"> 행삭제 </a>';
	},
	
	delRow: function (rowId) {
	
	   if ( !CommonJsUtil.isEmpty(rowId) ) {
	      $("#jqGrid").delRowData(rowId);
	   }
	},
	
	clearGrid: function () {
	    $("#jqGrid").clearGridData();
	},
	
	saveData: function () {
	
		this.ajaxFn('save', "saveJqgrid.do");
	},
	
	deleteData: function () {
		
		this.ajaxFn('del', "deleteJqgrid.do");
	},
	
	ajaxFn: function (strGubun, strUrl) {
		
		console.log(gridFunc.selectData(strGubun));
		
		$.ajax({
		    type: "post",
		    url: strUrl,
		    data: { param1: gridFunc.selectData(strGubun)},
		    async: false,
		    beforeSend: function (xhr) {
				
			},
			success: function (data) {
				
			    if ( data === "SUCCESS" ) {
			    	
			    	if ( strGubun === "save" ) {
			    		
			    	    alert("성공적으로 저장하였습니다.");
			    	} else if ( strGubun === "del" ) {
			    		
			    		alert("성공적으로 삭제하였습니다.");
			    	}
			    	
			    	jqgridTable.goSearch();
			    }
			},
			error: function () {
				
			}
		});
	},
	
	
	selectData: function (gubun) {
		
		var gubunText = gubun === 'save' ? '저장' : '삭제';
		var checkData = $("#jqGrid").getGridParam("selarrrow");
		
		if ( checkData.length === 0 ) {
			
			alert("저장할 데이터를 선택하여 주십시오.");
			
			return;
		}
		
		if (gubun === 'del') {
			
			for (var i = 0; i < checkData.length; i++) {
				
				var data = $("#jqGrid").getCell(checkData[i], "gender");
				
				if (data == "2") {
					alert("여성의 데이터는 선택할 수 없습니다.");
					
					return;
				}
			}
		}
		
		if ( confirm("선택한 데이터를 " + gubun + "하시겠습니까?" ) === false ) return;
		
		var iCnt = 0;
		var jsonArray1 = [];
		
		for (var i = 0; i < checkData.length; i++) {
		
			var editType = "";
			var jsonObj = {};
			
			var seq = $("#jqGrid").getCell(checkData[i], "seq");
			
			if ( gubun === "save" ) {
				
				if ( !CommonJsUtil.isEmpty(seq) ) editType = "U";
				else editType = "I";
				
			} else if ( gubun === "del" ) {
				
				editType = "D";
			}
			
			jsonObj.editType = editType;
			jsonObj.seq = seq;
			
			jsonObj.name = $("#jqGrid").getCell(checkData[i], "name");
			jsonObj.phone = $("#jqGrid").getCell(checkData[i], "phone");
			jsonObj.address = $("#jqGrid").getCell(checkData[i], "address");
			jsonObj.etcc = $("#jqGrid").getCell(checkData[i], "etcc");
			jsonObj.gender = $("#jqGrid").getCell(checkData[i], "gender");
			
			jsonArray1[iCnt++] =jsonObj;
		}
		
		return JSON.stringify(jsonArray1);
	},
	
	gridValid: function () {
		
		var trObj = $("#jqGrid").find("tr");
		
		for (var i = 0; i < trObj.length; i++) {
			
			var $this = $(trObj[i]);
			
			if($this.hasClass("edited")) {
				
			    var rowId = $this.prop("id");
			    var phone = $("#jqGrid").getCell(rowId, "phone");
			    
			    if (!CommonJsUtil.isNumeric(phone)) {
			         
			    	alert(rowId + "째 행 숫자만 입력 가능합니다.");
			    	
			    	return false;
			    	
			    	break;
			    }
			}
		}
		
		return true;
	},
}
</script>
