package #(package);

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.bjlemon.edu._admin.management.draw.model.#(tableMeta.camelName);
import com.bjlemon.edu._admin.management.draw.dao.#(tableMeta.camelName)Dao;
import java.util.List;

/**
 * #(tableMeta.camelName)Dao 
 * @author AutuGenerate
 * @createtime #date(now)
 */
@Service
public class #(tableMeta.camelName)Service {
 
	@Autowired
	private #(tableMeta.camelName)Dao #(classNameSmall)Dao;
 
	public boolean save(#(tableMeta.camelName) #(classNameSmall)) {
		return #(classNameSmall)Dao.save(#(classNameSmall));
	}
	
 	public boolean delete(int #(classNameSmall)Id) {
		return #(classNameSmall)Dao.delete( #(classNameSmall)Id);
	}	
 
	public boolean update(#(tableMeta.camelName) #(classNameSmall)) {
		return #(classNameSmall)Dao.update(#(classNameSmall));
	}
	
	 
	public #(tableMeta.camelName) getById(int #(classNameSmall)Id) {
		return #(classNameSmall)Dao.getById(#(classNameSmall)Id);
	}
  
  	public List<#(tableMeta.camelName)> list() {
		return #(classNameSmall)Dao.list();
	}
  
	public Integer count(int #(classNameSmall)Id) {
		return #(classNameSmall)Dao.count();
	}	
 
	
}
