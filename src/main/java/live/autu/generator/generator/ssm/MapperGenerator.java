package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class MapperGenerator extends Generator {

	{ 
		setTemplateDir("/live/autu/generator/tpl/mapper/mapper.tpl");
	}
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Mapper.xml";
	}

}
