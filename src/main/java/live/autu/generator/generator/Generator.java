package live.autu.generator.generator;

import java.io.File;
import java.util.List;

import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;

import live.autu.generator.core.TableMeta;

public abstract class Generator {
	
	protected Engine engine;
	private String templateDir;
	private String outputDir;
	private Template template;
	private List<TableMeta> tableMetas;
	
	private boolean isOverride=true;
	
	
	public Generator() {
		super();
	}

   protected Kv buildTemplateData(TableMeta tableMeta) {
		return Kv.by("tableMeta", tableMeta)
				.set("classNameSamll", StrKit.firstCharToUpperCase(tableMeta.camelName));
	};
	
   protected abstract String buildFileName(Kv data);
	
	public void generate() {
		initEngine();
		for (TableMeta tableMeta : tableMetas) {
			writeToFile(buildTemplateData(tableMeta));
		}
	};
	
	public void writeToFile(Kv data)   {
		File dir = new File(getOutputDir());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String fileName=buildFileName(data);
		String target = getOutputDir() + File.separator + fileName;
		
		if(!isOverride()) {
			File file=new File(target);
			if(file.exists()){
				return;
			}
		}
		
		template.render(data, target);
	}
	
	public void initEngine() {
		if(engine==null) {
			engine = new Engine();
			engine.setToClassPathSourceFactory(); // 从 class path 内读模板文件
			engine.addSharedMethod(new StrKit());
		}
		//初始化模板
		template=engine.getTemplate(getTemplateDir());
	}
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public String getTemplateDir() {
		return templateDir;
	}

	public Generator setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
		return this;
	}

	public Template getTemplate() {
		return template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public void setTableMetas(List<TableMeta> tableMetas) {
		this.tableMetas = tableMetas;
	}
	
	public String getOutputDir() {
		return outputDir;
	}

	public Generator setOutputDir(String outputDir) {
		this.outputDir = outputDir;
		return this;
	}

	public boolean isOverride() {
		return isOverride;
	}

	public Generator setOverride(boolean isOverride) {
		this.isOverride = isOverride;
		return this;
	}
 
}
