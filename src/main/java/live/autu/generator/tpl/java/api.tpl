package #(package);

import org.springframework.stereotype.Controller;
import com.jfinal.kit.Ret;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.bjlemon.edu._admin.management.draw.model.#(tableMeta.camelName);
import com.bjlemon.edu._admin.management.draw.service.#(tableMeta.camelName)Service;

/**
 * #(tableMeta.camelName)  
 * #date(now)
 */
@RequestMapping("/api/#(tableMeta.camelName)/")
@Controller
public class #(tableMeta.camelName)Api{
 	
 	@Autowired
	#(tableMeta.camelName)Service #(classNameSmall)Service;
 
	@RequestMapping(value = "list")
	@ResponseBody
	public Ret list() {
	 	return Ret.ok("list",#(tableMeta.camelName)Service.list());
	}
	
	@RequestMapping(value = "save")
	@ResponseBody
	public Ret save(#(tableMeta.camelName) #(classNameSmall)) {
		boolean result=#(tableMeta.camelName)Service.save(#(classNameSmall));
		return result?Ret.ok():Ret.fail();
	}
	
	@RequestMapping(value = "update")
	@ResponseBody
	public Ret update(#(tableMeta.camelName) #(classNameSmall)) {
		boolean result=#(tableMeta.camelName)Service.update(#(classNameSmall));
		return result?Ret.ok():Ret.fail();
	}
	
	@RequestMapping(value = "delete/{#(classNameSmall)Id}")
	@ResponseBody
	public Ret delete(@PathVariable("#(classNameSmall)Id")Integer #(classNameSmall)Id) {
		boolean result=#(tableMeta.camelName)Service.delete(#(classNameSmall)Id);
		return result?Ret.ok():Ret.fail();
	}
	
	
	@RequestMapping(value = "getById/{#(classNameSmall)Id}")
	@ResponseBody
	public Ret getById(@PathVariable("#(classNameSmall)Id")Integer #(classNameSmall)Id) {
		#(tableMeta.camelName) result=#(tableMeta.camelName)Service.getById(#(classNameSmall)Id);
		return Ret.ok("#(classNameSamll)",result);
	}
}
