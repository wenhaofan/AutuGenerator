package live.autu.generator.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import live.autu.generator.core.MetaBuilder;



public class ExtMetaBuilder extends MetaBuilder {

	 
	private List<String> tables=new ArrayList<>();
	
	public void addGenerateTable(String... excludedTables) {
		if (excludedTables != null) {
			for (String table : excludedTables) {
				this.tables.add(table);
			}
		}
	}
	
	
	public ExtMetaBuilder(DataSource dataSource) {
		super(dataSource);
		// TODO Auto-generated constructor stub
	}
	 @Override
    protected boolean isSkipTable(String tableName) {
        return !tables.contains(tableName);
    }
}
