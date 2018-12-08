package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class DaoGenerate extends Generator {

	private String modelPackageName;
	
	
	
	public String getModelPackageName() {
		return modelPackageName;
	}

	public void setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}

	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		
		String modelQualifiedName=modelPackageName+"."+tableMeta.camelName;
		
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta).set("classNameSmall", 
				StrKit.firstCharToLowerCase(tableMeta.camelName))
				.set("modelQualifiedName", modelQualifiedName);
	}
	
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Dao.java";
	}

}
