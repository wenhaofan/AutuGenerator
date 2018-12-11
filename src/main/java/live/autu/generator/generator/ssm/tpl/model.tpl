package  #(packageName);
	#if(isLombok)
import lombok.Data;#end	
import java.io.Serializable;

/**
 * #(tableMeta.camelName) 
 * @author AutuGenerate
 * @createtime #date(now)
 */
#if(isLombok)
@Data #if(isGenerateChainSetter)
@Accessors(chain=true)
#end#end
public class #(tableMeta.camelName)  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	#for(cm : tableMeta.columnMetas)
	/**
	*	#(cm.remarks)
	*/
	private #(cm.javaType)  #(cm.javaName);
	#end
	
	#if(!isLombok)
		#for(cm : tableMeta.columnMetas)
	public #(isGenerateChainSetter ? tableMeta.camelName : 'void') set#(firstCharToUpperCase(cm.javaName))(#(cm.javaType) #(cm.javaName)) {
		this.#(cm.javaName)=#(cm.javaName);
		#if (isGenerateChainSetter)
		return this;
		#end
	}
 
	public #(cm.javaType) get#(firstCharToUpperCase(cm.javaName))() {
		return this.#(cm.javaName);
	}
		#end
	#end
}
