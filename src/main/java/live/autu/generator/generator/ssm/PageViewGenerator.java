package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class PageViewGenerator extends Generator{

	{
		setTemplateDir("/live/autu/generate/tpl/view/page.tpl");
	}
	
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Page.html";
	}

}
