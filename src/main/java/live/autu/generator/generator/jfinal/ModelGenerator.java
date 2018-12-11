package live.autu.generator.generator.jfinal;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class ModelGenerator extends Generator {
	
	private String packageName;
	
	private String baseModelPackageName;
	
	private boolean isGenerateChainSetter;

	private boolean isGenerateDaoInModel;
	
	{
		setTemplateDir("/live/autu/generator/generator/jfinal/tpl/model.tpl");
	}

	public boolean isGenerateChainSetter() {
		return isGenerateChainSetter;
	}

	public ModelGenerator setGenerateChainSetter(boolean isGenerateChainSetter) {
		this.isGenerateChainSetter = isGenerateChainSetter;
		return this;
	}

	
	
	public boolean isGenerateDaoInModel() {
		return isGenerateDaoInModel;
	}

	public ModelGenerator setGenerateDaoInModel(boolean isGenerateDaoInModel) {
		this.isGenerateDaoInModel = isGenerateDaoInModel;
		return this;
	}

	public String getPackageName() {
		return packageName;
	}
	
	public String getBaseModelPackageName() {
		return baseModelPackageName;
	}

	public ModelGenerator setBaseModelPackageName(String baseModelPackageName) {
		this.baseModelPackageName = baseModelPackageName;
		return this;
	}

	public ModelGenerator setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta)
				.set("packageName", packageName)
				.set("isGenerateChainSetter", isGenerateChainSetter())
				.set("isGenerateDaoInModel", isGenerateDaoInModel())
				.set("baseModelPackageName", getBaseModelPackageName()+".Base"+tableMeta.camelName+"Model")
				.set("baseModelName", "Base"+tableMeta.camelName+"Model");
	}

	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+".java";
	}

}
