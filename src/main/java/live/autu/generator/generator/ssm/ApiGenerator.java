package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class ApiGenerator extends Generator{
	
	private String modelPackageName;
	
	private String servicePackageName;
	
	private String apiPackageName;
	
	{
		setTemplateDir("/live/autu/generator/generator/ssm/tpl/api.tpl");
	}
	
	public String getModelPackageName() {
		return modelPackageName;
	}

	public ApiGenerator setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
		return this;
	}

	public String getServicePackageName() {
		return servicePackageName;
	}

	public ApiGenerator setServicePackageName(String servicePackageName) {
		this.servicePackageName = servicePackageName;
		return this;
	}

	

	public String getApiPackageName() {
		return apiPackageName;
	}

	public ApiGenerator setApiPackageName(String apiPackageName) {
		this.apiPackageName = apiPackageName;
		return this;
	}

	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		
		String modelQualifiedName=modelPackageName+"."+tableMeta.camelName;
		String serviceQualifiedName=servicePackageName+"."+tableMeta.camelName+"Service";
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta)
				.set("modelQualifiedName", modelQualifiedName)
				.set("serviceQualifiedName", serviceQualifiedName)
				.set("apiPackageName",getApiPackageName());
	}
	
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Api.java";
	}
}
