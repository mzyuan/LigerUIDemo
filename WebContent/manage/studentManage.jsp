<%@ page language="java" pageEncoding="utf-8"%>
<%@include file="head.jsp"%>
<!--分组管理列表界面-->
<div id="mainsearch" style="margin: 5px;">
	<div class="searchtitle">
		<span>搜索</span><img src="../theme/images/icons/search.png" alt="" />
		<div class="togglebtn"></div>
	</div>
	<div class="navline" style="margin-bottom: 4px; margin-top: 4px;"></div>

	<div class="searchbox">
		<form id="formsearch" class="l-form"></form>
	</div>
</div>
<div id="maingrid"></div>
<script type="text/javascript">
	var columns = [ {
		name : 'id',
		hide: true
	}, {
		display : '姓名',
		name : 'stuname',
		width : 120
	}, {
		display : '学号',
		name : 'stunumber',
		width : 120
	}, {
		display : '生日',
		name : 'stubirth',
		width : 120
	}, {
		display : '电话',
		name : 'stuphone',
		width : 120
	}, {
		display : '分数',
		name : 'stumark',
		width : 120
	}, {
		display : '地址',
		name : 'stuaddress',
		width : 120
	} ];
	var grid = $("#maingrid").ligerGrid({
		columns : columns,
		pageSize : 10,
		url : "../student/studentList",
		sortName : "id",
		height : '100%',
		rownumbers : true,
		checkbox : false,
		toolbar : {
			items : [ {
				text : '增加',
				click : gridInsert,
				icon : 'add'
			}, {
				line : true
			}, {
				text : '修改',
				click : gridUpdate,
				icon : 'modify'
			}, {
				line : true
			}, {
				text : '查看',
				click : gridDetails,
				icon : 'search'
			}, {
				line : true
			}, {
				text : '删除',
				click : gridDelete,
				icon : 'delete'
			} ]
		}
	});
    //搜索框
    var searchData = [
        { display: "学生姓名", name: "StuName", newline: true, labelWidth: 80, width: 220, space: 30, type: "text", cssClass: "field" }
    ];

    //搜索表单应用ligerui样式
    $("#formsearch").ligerForm({ fields: searchData });

    //添加搜索按钮
    $(function () {
        AddSearchButtons("#formsearch", grid);
    });
    //附加表单搜索按钮：搜索、清除
    function AddSearchButtons(form, grid) {
        if (!form) return;
        form = $(form);
        //搜索按钮
        var container = $('<ul><li style="margin-right:8px;"></li><li></li></ul><div class="l-clear"></div>').appendTo(form);
        SearchButtons(form, grid, container.find("li:eq(0)"), container.find("li:eq(1)"));
    };

    //创建表单搜索按钮：搜索、清除
    function SearchButtons(form, grid, btn1Container, btn2Container) {
        if (!form) return;
        if (btn1Container) {
            LG.createButton({
                appendTo: btn1Container,
                width: 70,
                text: '搜索',
                click: function () {
                    var search = $('#formsearch').serializeArray();
                    grid.set('parms', { where: JSON2.stringify({ searchList: search }) });
                    grid.loadData();
                }
            });
        }
        if (btn2Container) {
            LG.createButton({
                appendTo: btn2Container,
                width: 70,
                text: '清除',
                click: function () {
                    grid.set('parms', {});
                    grid.loadData();
                }
            });
        }
    };
	function gridInsert() {
		return;
	}
	function gridUpdate() {
		return;
	}
	function gridDetails() {
		return;
	}
	function gridDelete() {
		return;
	}
</script>

<%@include file="foot.jsp"%>