package live.autu.generator.generator.ssm;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;

import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class DaoGenerator extends Generator {

	private String modelPackageName;
	
	private String daoPackageName;
	
	{
		setTemplateDir("/live/autu/generator/generator/ssm/tpl/java/dao.tpl");
	}
	
	public String getDaoPackageName() {
		return daoPackageName;
	}

	public DaoGenerator setDaoPackageName(String daoPackageName) {
		this.daoPackageName = daoPackageName;
		return this;
	}

	public String getModelPackageName() {
		return modelPackageName;
	}

	public DaoGenerator setModelPackageName(String modelPackageName) {
		this.modelPackageName = modelPackageName;
		return this;
	}

	@Override
	protected Kv buildTemplateData(TableMeta tableMeta) {
		
		String modelQualifiedName=modelPackageName+"."+tableMeta.camelName;
		
		// TODO Auto-generated method stub
		return super.buildTemplateData(tableMeta).set("classNameSmall", 
				StrKit.firstCharToLowerCase(tableMeta.camelName))
				.set("modelQualifiedName", modelQualifiedName)
				.set("daoPackageName", getDaoPackageName());
	}
	
	@Override
	protected String buildFileName(Kv data) {
		TableMeta TableMeta=data.getAs("tableMeta");
		return TableMeta.camelName+"Dao.java";
	}

}
