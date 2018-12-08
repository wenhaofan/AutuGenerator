package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class ApiGenerate extends Generator{
	private String modelPackageName;
	
	private String servicePackageName;
	
	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		
		String modelQualifiedName=modelPackageName+"."+tableMeta.camelName;
		String serviceQualifiedName=servicePackageName+"."+tableMeta.camelName;
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta).set("classNameSmall", 
				StrKit.firstCharToLowerCase(tableMeta.camelName))
				.set("modelQualifiedName", modelQualifiedName)
				.set("serviceQualifiedName", serviceQualifiedName);
	}
	
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Api.java";
	}
}
