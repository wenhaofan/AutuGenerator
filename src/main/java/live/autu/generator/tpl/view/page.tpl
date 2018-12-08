<script type="text/javascript">

layui.use(['table','form','layer'],function(){
	table=layui.table;
	form=layui.form;
	layer=layui.layer;
	render#(tableMeta.camelName)Table();
})

function render#(tableMeta.camelName)Table(where){
	lemon.renderTable({
		toolbar: true
		,where:where
		,url:"/api/#(tableMeta.camelName)/page/"
		,elem: '##(tableMeta.camelName)Table'
	    ,page: true //开启分页
	    ,cols: [[ //表头
	        #for(cm : tableMeta.columnMetas)
		   		 {field:'#(cm.camelName)',title:"#(cm.remarks)"}
				 #if(!for.last)
				 	,
				 #end
			#end
	    ]]
	})
}
</script>
 
<div>
	<form action="" class="layui-form" lay-filter="queryForm">
	 
	</form>
	<table id="drawCountTable" lay-filter="drawCountTable" >
	
	</table>
</div>
 
 