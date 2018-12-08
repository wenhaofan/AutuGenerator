package live.autu.generator.config;

import javax.sql.DataSource;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.druid.DruidPlugin;

public class Config {
	
	static Prop loadConfig() {
		//先加载开发环境配置文件 找不到再去加载生产环境配置文件
		return PropKit.use("config.txt");
	}
	 static {
		 loadConfig();
	 }
	/**
	 * 重用数据源配置，避免冗余配置
	 */
	public static DataSource getDataSource() {
		DruidPlugin druidPlugin = createDruidPlugin();
		druidPlugin.start();
		return druidPlugin.getDataSource();
	}
	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}

	 
}
