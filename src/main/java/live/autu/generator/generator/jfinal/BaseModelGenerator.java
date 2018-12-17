package live.autu.generator.generator.jfinal;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class BaseModelGenerator extends Generator{
	
	/**
	 * 针对 Model 中七种可以自动转换类型的 getter 方法，调用其具有确定类型返回值的 getter 方法
	 * 享用自动类型转换的便利性，例如 getInt(String)、getStr(String)
	 * 其它方法使用泛型返回值方法： get(String)
	 * 注意：jfinal 3.2 及以上版本 Model 中的六种 getter 方法才具有类型转换功能
	 */
	@SuppressWarnings("serial")
	protected Map<String, String> getterTypeMap = new HashMap<String, String>() {{
		put("java.lang.String", "getStr");
		put("java.lang.Integer", "getInt");
		put("java.lang.Long", "getLong");
		put("java.lang.Double", "getDouble");
		put("java.lang.Float", "getFloat");
		put("java.lang.Short", "getShort");
		put("java.lang.Byte", "getByte");
	}};
 

	private String packageName;

	private boolean isGenerateChainSetter;

	{
		setTemplateDir("/live/autu/generator/generator/jfinal/tpl/baseModel.tpl");
	}

	public boolean isGenerateChainSetter() {
		return isGenerateChainSetter;
	}

	public BaseModelGenerator setGenerateChainSetter(boolean isGenerateChainSetter) {
		this.isGenerateChainSetter = isGenerateChainSetter;
		return this;
	}

	public String getPackageName() {
		return packageName;
	}

	public BaseModelGenerator setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta)
				.set("packageName", packageName)
				.set("isGenerateChainSetter", isGenerateChainSetter())
				.set("getterTypeMap", getterTypeMap);
	}

	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return "Base"+TableMeta.camelName+"Model.java";
	}

}
