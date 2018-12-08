package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;


public class ModelGenerate extends Generator {

	private String packageName;

	{
		setTemplateDir("live/autu/generate/tpl/java/model.tpl");
	}
	
	public String getPackageName() {
		return packageName;
	}

	public ModelGenerate setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}

	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta)
				.set("packageName", packageName);
	}

	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+".java";
	}
	
}
