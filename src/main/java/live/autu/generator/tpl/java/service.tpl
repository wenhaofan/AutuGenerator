package #(servicePackageName);

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import live.autu.generator.common.Page;
import #(daoQualifiedName);
import #(modelQualifiedName);
import java.util.List;

/**
 * #(tableMeta.camelName)Dao 
 * @author AutuGenerate
 * @createtime #date(now)
 */
@Service
public class #(tableMeta.camelName)Service {
 
	@Autowired
	private #(tableMeta.camelName)Dao #(tableMeta.classNameSmall)Dao;
 
	public boolean save(#(tableMeta.camelName) #(tableMeta.classNameSmall)) {
		return #(tableMeta.classNameSmall)Dao.save(#(tableMeta.classNameSmall));
	}
	
 	public boolean delete(int #(tableMeta.classNameSmall)Id) {
		return #(tableMeta.classNameSmall)Dao.delete( #(tableMeta.classNameSmall)Id);
	}	
 
	public boolean update(#(tableMeta.camelName) #(tableMeta.classNameSmall)) {
		return #(tableMeta.classNameSmall)Dao.update(#(tableMeta.classNameSmall));
	}
	
	 
	public #(tableMeta.camelName) getById(int #(tableMeta.classNameSmall)Id) {
		return #(tableMeta.classNameSmall)Dao.getById(#(tableMeta.classNameSmall)Id);
	}
  
  	public List<#(tableMeta.camelName)> list() {
		return #(tableMeta.classNameSmall)Dao.list(null);
	}
  
	public Integer count() {
		return #(tableMeta.classNameSmall)Dao.count();
	}	
 	
 	public Page<#(tableMeta.camelName)> page(int pageNum,int pageSize){
 		Page<#(tableMeta.camelName)> page=new Page<>();
 		
 		page.setPageNumber(pageNum);
 		page.setPageSize(pageSize);
 		
 		Integer count=count();
 		if(count==null||count==0){
 			return page;
 		}
 		
 		page.setTotalRow(count);
 		List<#(tableMeta.camelName)> list=#(tableMeta.classNameSmall)Dao.list(page);
 		page.setList(list);
 		return page;
 	}	
}
