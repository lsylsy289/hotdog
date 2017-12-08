<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="row">
	<div class="col-md-6">
		<table id="tbList1"></table>
	</div>
	<div class="col-md-6">
		<table id="tbList2"></table>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		FormScope.init();
	});

	var FormScope = {

		grid1: $("#tbList1"), // 상위코드 그리드
		grid2: $("#tbList2"), // 코드 그리드

		init: function () {

			this.grid1.jqGrid({

				datatype: "local",
				height: 'auto',
				colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
				colModel:[
					{name:'id',index:'id', width:60, sorttype:"int"},
					{name:'invdate',index:'invdate', width:90, sorttype:"date"},
					{name:'name',index:'name', width:100},
					{name:'amount',index:'amount', width:80, align:"right",sorttype:"float"},
					{name:'tax',index:'tax', width:80, align:"right",sorttype:"float"},
					{name:'total',index:'total', width:80,align:"right",sorttype:"float"},
					{name:'note',index:'note', width:150, sortable:false}
				],
				multiselect: true,
				caption: "코드헤더"
			});

			this.grid2.jqGrid({

				datatype: "local",
				height: 'auto',
				colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
				colModel:[
					{name:'id',index:'id', width:60, sorttype:"int"},
					{name:'invdate',index:'invdate', width:90, sorttype:"date"},
					{name:'name',index:'name', width:100},
					{name:'amount',index:'amount', width:80, align:"right",sorttype:"float"},
					{name:'tax',index:'tax', width:80, align:"right",sorttype:"float"},
					{name:'total',index:'total', width:80,align:"right",sorttype:"float"},
					{name:'note',index:'note', width:150, sortable:false}
				],
				multiselect: true,
				caption: "코드"
			});

			// 로컬 데이터
			var myData = [

				{id:"1",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"2",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"3",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"4",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"5",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"6",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
				{id:"7",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
				{id:"8",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
				{id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
			];

			// 데이터 추가
			for( i=0, max = myData.length ; i<=max ; i++ ){
				this.grid1.jqGrid('addRowData', i+1, myData[i]);
			}
		}
	};
</script>
</body>
</html>