package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class MapperGenerator extends Generator {

	private String modelPackageName;
	
	private String daoPackageName;
	
	{ 
		setTemplateDir("/live/autu/generator/generator/ssm/tpl/mapper.tpl");
	}
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Mapper.xml";
	}
	
	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		
		String modelQualifiedName=modelPackageName+"."+tableMeta.camelName;
		String daoQualifiedName=daoPackageName+"."+tableMeta.camelName+"Dao";
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta)
				.set("modelQualifiedName", modelQualifiedName)
				.set("daoQualifiedName", daoQualifiedName);
	}
	

}
