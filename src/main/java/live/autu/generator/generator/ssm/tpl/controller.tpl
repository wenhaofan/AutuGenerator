package #(package);

import org.springframework.stereotype.Controller;
import com.jfinal.kit.String;

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
@RequestMapping("/#(tableMeta.classNameSmall)/")
@Controller
public class #(tableMeta.camelName)Controller{
 
	@RequestMapping(value = "list")
	public String list() {
	 	return "list";
	}
	
	@RequestMapping(value = "save")
	public String add( ) {
		 return "add";
	}
	
	@RequestMapping(value = "update")
	public String update() {
		 return "update";
	}
}
