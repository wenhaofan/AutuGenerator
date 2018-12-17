package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class ServiceGenerator extends Generator {

	private String modelPackageName;
	
	private String daoPackageName;
	
	private String servicePackageName;
	
	{
		setTemplateDir("/live/autu/generator/generator/ssm/tpl/service.tpl");
	}
	
	public String getModelPackageName() {
		return modelPackageName;
	}

	public ServiceGenerator setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
		return this;
	}

	public String getDaoPackageName() {
		return daoPackageName;
	}

	public ServiceGenerator setDaoPackageName(String daoPackageName) {
		this.daoPackageName = daoPackageName;
		return this;
	}
	
	public String getServicePackageName() {
		return servicePackageName;
	}

	public ServiceGenerator setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
		return this;
	}

	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		
		String modelQualifiedName=modelPackageName+"."+tableMeta.camelName;
		String daoQualifiedName=daoPackageName+"."+tableMeta.camelName+"Dao";
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta).set("classNameSmall", 
				StrKit.firstCharToLowerCase(tableMeta.camelName))
				.set("modelQualifiedName", modelQualifiedName)
				.set("daoQualifiedName", daoQualifiedName)
				.set("servicePackageName", getServicePackageName());
	}
	
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Service.java";
	}

}
