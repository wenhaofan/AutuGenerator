package live.autu.generator.core;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
* TableMeta
*/
@SuppressWarnings("serial")
public class TableMeta implements Serializable {
	
	public String camelName;
	public String tableName;					// 表名
	public String remarks;				// 表备注
	public String primaryKey;			// 主键，复合主键以逗号分隔
	public String camlePrimaryKey;		// 驼峰主键
	public List<ColumnMeta> columnMetas = new ArrayList<ColumnMeta>();	// 字段 meta
	public String classNameSmall; 		//小写开头的类名
}




