package #(daoPackageName);

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import live.autu.generator.common.Page;
import com.jfinal.kit.Kv;
import #(modelQualifiedName);

/**
 * #(tableMeta.camelName) 
 * @author AutuGenerate
 * @createtime #date(now)
 */
@Repository
public class #(tableMeta.camelName)Dao {
 
	@Autowired
	private SqlSession sqlSession;
 
 	public boolean save#(tableMeta.camelName)s(List<#(tableMeta.camelName)> #(tableMeta.classNameSmall)s) {
		return sqlSession.insert("#(tableMeta.camelName)Mapper.save", #(tableMeta.classNameSmall))>0;
	}
 
 
	public boolean save(#(tableMeta.camelName) #(tableMeta.classNameSmall)) {
		return sqlSession.insert("#(tableMeta.camelName)Mapper.save", #(tableMeta.classNameSmall))>0;
	}
 
	public boolean delete(int #(tableMeta.classNameSmall)Id) {
		return sqlSession.update("#(tableMeta.camelName)Mapper.delete", #(tableMeta.classNameSmall)Id)>0;
	}	
	
	public boolean update(#(tableMeta.camelName) #(tableMeta.classNameSmall)) {
		return sqlSession.update("#(tableMeta.camelName)Mapper.update", #(tableMeta.classNameSmall))>0;
	}
	
	public #(tableMeta.camelName) getById(int #(tableMeta.classNameSmall)Id) {
		return sqlSession.selectOne("#(tableMeta.camelName)Mapper.getById", #(tableMeta.classNameSmall)Id);
	}
  
  	public Integer count() {
		return sqlSession.selectOne("#(tableMeta.camelName)Mapper.count");
	}	

	public List<#(tableMeta.camelName)> list(Page<#(tableMeta.camelName)> page) {
		return sqlSession.selectList("#(tableMeta.camelName)Mapper.list",Kv.by("page",page));
	}
}
