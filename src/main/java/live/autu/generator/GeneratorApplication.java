package live.autu.generator;

 
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.jfinal.plugin.activerecord.dialect.Dialect;

import live.autu.generator.config.Config;
import live.autu.generator.core.MetaBuilder;
import live.autu.generator.core.TableMeta;
import live.autu.generator.generator.Generator;

public class GeneratorApplication {
	
	protected Dialect dialect = null;
	protected MetaBuilder metaBuilder;

	protected boolean generateDataDictionary = false;
	
	protected List<Generator> generators=new ArrayList<>();
   
	public GeneratorApplication() {
		this(Config.getDataSource());
	}
 
	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	public GeneratorApplication addGenerator(Generator generator) {
		generators.add(generator);
		return this;
	}
	
	public GeneratorApplication(DataSource dataSource ) {
		this.metaBuilder = new MetaBuilder(dataSource);
	}
 
	/**
	 * 设置 MetaBuilder，便于扩展自定义 MetaBuilder
	 */
	public void setMetaBuilder(MetaBuilder metaBuilder) {
		if (metaBuilder != null) {
			this.metaBuilder = metaBuilder;
		}
	}
 
  
	/**
	 * 设置需要被移除的表名前缀，仅用于生成 modelName 与  baseModelName
	 * 例如表名  "osc_account"，移除前缀 "osc_" 后变为 "account"
	 */
	public void setRemovedTableNamePrefixes(String... removedTableNamePrefixes) {
		metaBuilder.setRemovedTableNamePrefixes(removedTableNamePrefixes);
	}
	
	/**
	 * 添加不需要处理的数据表
	 */
	public void addExcludedTable(String... excludedTables) {
		metaBuilder.addExcludedTable(excludedTables);
	}
	
 
	
 
 
	public void generate() {
		if (dialect != null) {
			metaBuilder.setDialect(dialect);
		}
		
		long start = System.currentTimeMillis();
		List<TableMeta> tableMetas = metaBuilder.build();
		if (tableMetas.size() == 0) {
			System.out.println("TableMeta 数量为 0，不生成任何文件");
			return ;
		}
		 
		for (Generator generator : generators) {
			generator.setTableMetas(tableMetas);
			generator.generate();
		}
 
		long usedTime = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Generate complete in " + usedTime + " seconds.");
	}
}



