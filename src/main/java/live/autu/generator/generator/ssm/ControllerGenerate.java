package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class ControllerGenerate extends Generator {
 
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Controller.java";
	}

}
