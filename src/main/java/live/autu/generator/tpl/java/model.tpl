package  #(packageName);

import lombok.Data;
import java.io.Serializable;

/**
 * #(tableMeta.camelName) 
 * @author AutuGenerate
 * @createtime #date(now)
 */
@Data
public class #(tableMeta.camelName)  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	#for(cm : tableMeta.columnMetas)
	/**
	*	#(cm.remarks)
	*/
	private #(cm.javaType)  #(cm.camelName);
	#end
}
