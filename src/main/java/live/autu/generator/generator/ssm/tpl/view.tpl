<script>
function formatDate(d){
	if(isNaN(d)){
		return d;
	}
	const date=new Date(d);
	return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate()
}

layui.use(['table','form','layer','laydate'],function(){
	table=layui.table;
	form=layui.form;
	layer=layui.layer;
	laydate=layui.laydate;
	#(tableMeta.classNameSmall).render#(tableMeta.camelName)Table();
		//监听提交
    form.on('submit(save#(tableMeta.camelName))', function(data){
	   lemon.ajax({
		   url:"#(urlPrefix)/#(tableMeta.classNameSmall)/save",
		   data:data.field,
		   type:"post",
		   success:function(data){
			   lemon.alertOkAndReload("操作成功！")
		   }
	   })
    return false;
  });
	  form.on('submit(update#(tableMeta.camelName))', function(data){
		  lemon.ajax({
			   url:"#(urlPrefix)/#(tableMeta.classNameSmall)/update",
			   type:"post",
			   data:data.field,
			   success:function(data){
				   lemon.alertOkAndReload("操作成功！")
			   }
		   })
		   return false;
	  });
 
})
	
var #(tableMeta.classNameSmall)={
	delete#(tableMeta.camelName):function(id){
		layer.confirm('是否确认删除？', function(index){
			lemon.ajax({
				url:"#(urlPrefix)/#(tableMeta.classNameSmall)/delete/"+id,
				success:function(){
					lemon.alertOkAndReload("删除成功！");
				}
			})
		})
	},render#(tableMeta.camelName)Table:function(){
		lemon.renderTable({
			url:"#(urlPrefix)/#(tableMeta.classNameSmall)/list"
			,elem: '##(tableMeta.classNameSmall)Table'
		    ,page: true //开启分页
		    ,cols: [[ //表头
		    	  #for(cm : tableMeta.columnMetas) #if(cm.isPrimaryKey) #continue #end
		    	 	#if(cm.javaType=="java.util.Date")
		    	 	{templet:function(d){ return formatDate(d.#(cm.javaName)); },title:"#(cm.remarks)"}#if(!for.last) ,#end
		    	 	#else if(cm.javaName=="isDeleted")
		    	 	{templet:function(d){ return !d.isDeleted?'未删除':'已删除' },title:"#(cm.remarks)"}#if(!for.last) ,#end
		    	 	#else
		    	 	{field:'#(cm.javaName)',title:"#(cm.remarks)"}#if(!for.last) ,#end
		    	 	#end 
				  #end
		      ,{templet:'#tpl-operation', title:"操作"}
		    ]]
		})
	},add#(tableMeta.camelName):function(){
	
		layer.open({
			  area:'520px',
			  type: 1,
			  title: "添加",
			  closeBtn: 0,
			  shadeClose: true,
			  content: $("#tpl-saveForm").html(),
			  success:function(){
				  form.render();
			  } 
		});
	},update#(tableMeta.camelName):function(id){
		layer.open({
			  area:'520px',
			  type: 1,
			  title: "修改",
			  closeBtn: 0,
			  shadeClose: true,
			  content: $("#tpl-updateForm").html(),
			  success:function(){
				  form.render();
				  lemon.ajax({
						url:"#(urlPrefix)/#(tableMeta.classNameSmall)/getById/"+id,
						success:function(data){
							form.val("update#(tableMeta.camelName)",data.#(tableMeta.classNameSmall)); 
						}
				  })
			  } 
			});
	}
	
}
 

$(function(){
	$("body").on("click",".#(tableMeta.classNameSmall)-delete",function(){
		#(tableMeta.classNameSmall).delete#(tableMeta.camelName)($(this).data("id"));
	})
	$("body").on("click",".#(tableMeta.classNameSmall)-udpate",function(){
		#(tableMeta.classNameSmall).update#(tableMeta.camelName)($(this).data("id"));
	})
 
	$(".save-#(tableMeta.classNameSmall)").click(function(){
		#(tableMeta.classNameSmall).add#(tableMeta.camelName)();
	})
})

</script>

<div>
	<form action="">
	  <div class="layui-inline">
  		<button  type="button" class="layui-btn layui-btn-sm save-#(tableMeta.classNameSmall)" >添加</button> 
 	 </div>
	</form>
	<table id="#(tableMeta.classNameSmall)Table" >
	</table>
</div>
 
<script type="text/html" id="tpl-operation">
<button class="layui-btn layui-btn-sm #(tableMeta.classNameSmall)-udpate" data-id="{{d.#(tableMeta.primaryKeySmall)}}">修改</button> 
<button class="layui-btn layui-btn-sm #(tableMeta.classNameSmall)-delete" data-id="{{d.#(tableMeta.primaryKeySmall)}}">删除</button> 
</script>
<script type="text/html" id="tpl-saveForm">
<form id="add#(tableMeta.camelName)" lay-filter="add#(tableMeta.camelName)" onsubmit="return false;" style="margin: 10px 20px 20px 0px;" class="layui-form">
	#for(cm : tableMeta.columnMetas)
		#if(cm.isPrimaryKey)
			#continue
		#end
			#if(cm.javaName=="gmtCreate"||cm.javaName=="gmtModified"||cm.javaName=="isDeleted"||cm.javaName=="isValid"||cm.javaName=="state")
			#continue
		#end
	<div class="layui-form-item">
 	 	<label class="layui-form-label">#(cm.remarks)</label>
  		<div class="layui-input-block">
    		<input type="text" name="#(cm.javaName)" #if(!cm.isNullable) required  lay-verify="required" #end
    		 placeholder="请输入#(cm.remarks)" autocomplete="off" class="layui-input">
  		</div>
	</div>
	#end
	<div class="layui-form-item">
  		<div class="layui-input-block">
    		<button class="layui-btn" lay-submit lay-filter="save#(tableMeta.camelName)">添加</button>
  		</div>
	</div>
</form>
</script>
<script type="text/html" id="tpl-updateForm">
<form id="add#(tableMeta.camelName)" lay-filter="update#(tableMeta.camelName)" onsubmit="return false;" style="margin: 10px 20px 20px 0px;" class="layui-form">
	<input type="hidden" name="#(tableMeta.primaryKeySmall)" >
	#for(cm : tableMeta.columnMetas)
		#if(cm.isPrimaryKey)
			#continue
		#end
			#if(cm.javaName=="gmtCreate"||cm.javaName=="gmtModified"||cm.javaName=="isDeleted"||cm.javaName=="isValid"||cm.javaName=="state")
			#continue
		#end
	<div class="layui-form-item">
 	 	<label class="layui-form-label">#(cm.remarks)</label>
  		<div class="layui-input-block">
    		<input type="text" name="#(cm.javaName)" #if(!cm.isNullable) required  lay-verify="required" #end
    		 placeholder="请输入#(cm.remarks)" autocomplete="off" class="layui-input">
  		</div>
	</div>
	#end
	<div class="layui-form-item">
  		<div class="layui-input-block">
    		<button class="layui-btn" lay-submit lay-filter="update#(tableMeta.camelName)">修改</button>
  		</div>
	</div>
</form>
</script>
 