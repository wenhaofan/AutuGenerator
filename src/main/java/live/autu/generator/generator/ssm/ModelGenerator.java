package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;


public class ModelGenerator extends Generator {

	private String packageName;

	private boolean isLombok;
	
	private boolean isGenerateChainSetter;
	
	{
		setTemplateDir("/live/autu/generator/generator/ssm/tpl/model.tpl");
	}
	
	public boolean isLombok() {
		return isLombok;
	}

	public ModelGenerator setLombok(boolean isLombok) {
		this.isLombok = isLombok;
		return this;
	}

	public boolean isGenerateChainSetter() {
		return isGenerateChainSetter;
	}

	public ModelGenerator setGenerateChainSetter(boolean isGenerateChainSetter) {
		this.isGenerateChainSetter = isGenerateChainSetter;
		return this;
	}

	public String getPackageName() {
		return packageName;
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
				.set("isLombok", isLombok())
				.set("isGenerateChainSetter",isGenerateChainSetter());
	}

	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+".java";
	}
	
}
