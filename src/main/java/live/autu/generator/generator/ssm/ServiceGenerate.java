package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class ServiceGenerate extends Generator {

	private String modelPackageName;
	
	private String daoPackageName;
	
	
	public String getModelPackageName() {
		return modelPackageName;
	}

	public void setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
	}

	public String getDaoPackageName() {
		return daoPackageName;
	}

	public void setDaoPackageName(String daoPackageName) {
		this.daoPackageName = daoPackageName;
	}

	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		
		String modelQualifiedName=modelPackageName+"."+tableMeta.camelName;
		String daoQualifiedName=daoPackageName+"."+tableMeta.camelName;
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta).set("classNameSmall", 
				StrKit.firstCharToLowerCase(tableMeta.camelName))
				.set("modelQualifiedName", modelQualifiedName)
				.set("daoQualifiedName", daoQualifiedName);
	}
	
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Service.java";
	}

}
