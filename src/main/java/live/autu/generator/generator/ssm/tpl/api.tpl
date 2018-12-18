package #(apiPackageName);

import org.springframework.stereotype.Controller;
import com.jfinal.kit.Ret;
import live.autu.generator.common.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import #(modelQualifiedName);
import #(serviceQualifiedName);

/**
 * #(tableMeta.camelName)  
 * #date(now)
 */
@RequestMapping("/api/#(tableMeta.classNameSmall)/")
@Controller
public class #(tableMeta.camelName)Api{
 	
 	@Autowired
	#(tableMeta.camelName)Service #(tableMeta.classNameSmall)Service;
 
	@RequestMapping(value = "list")
	@ResponseBody
	public Ret list() {
	 	return Ret.ok("list",#(tableMeta.classNameSmall)Service.list());
	}
	
	@RequestMapping(value = "save")
	@ResponseBody
	public Ret save(#(tableMeta.camelName) #(tableMeta.classNameSmall)) {
		boolean result=#(tableMeta.classNameSmall)Service.save(#(tableMeta.classNameSmall));
		return result?Ret.ok():Ret.fail();
	}
	
	@RequestMapping(value = "update")
	@ResponseBody
	public Ret update(#(tableMeta.camelName) #(tableMeta.classNameSmall)) {
		boolean result=#(tableMeta.classNameSmall)Service.update(#(tableMeta.classNameSmall));
		return result?Ret.ok():Ret.fail();
	}
	
	@RequestMapping(value = "delete/{#(tableMeta.classNameSmall)Id}")
	@ResponseBody
	public Ret delete(@PathVariable("#(tableMeta.classNameSmall)Id")Integer #(tableMeta.classNameSmall)Id) {
		boolean result=#(tableMeta.classNameSmall)Service.delete(#(tableMeta.classNameSmall)Id);
		return result?Ret.ok():Ret.fail();
	}
	
	
	@RequestMapping(value = "getById/{#(tableMeta.classNameSmall)Id}")
	@ResponseBody
	public Ret getById(@PathVariable("#(tableMeta.classNameSmall)Id")Integer #(tableMeta.classNameSmall)Id) {
		#(tableMeta.camelName) result=#(tableMeta.classNameSmall)Service.getById(#(tableMeta.classNameSmall)Id);
		return Ret.ok("#(tableMeta.classNameSmall)",result);
	}
	
	@RequestMapping(value = "page")
	@ResponseBody
	public Ret page(@RequestParam(value="pageNum",defaultValue="1")Integer pageNum,
	@RequestParam(value="pageSize",defaultValue="10")Integer pageSize) {
		Page<#(tableMeta.camelName)> page=#(tableMeta.classNameSmall)Service.page(pageNum,pageSize);
		return Ret.ok("page",page);
	}
}
