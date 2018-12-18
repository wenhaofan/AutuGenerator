package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class ViewGenerator extends Generator{

	{
		setTemplateDir("/live/autu/generator/generator/ssm/tpl/view.tpl");
	}
	
	private String urlPrefix;
	
	
	
	public String getUrlPrefix() {
		return urlPrefix;
	}
 
	public ViewGenerator setUrlPrefix(String urlPrefix) {
		this.urlPrefix = urlPrefix;
		return this;
	}
 
	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta)
				.set("urlPrefix", getUrlPrefix());
	}

	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Page.html";
	}

}
