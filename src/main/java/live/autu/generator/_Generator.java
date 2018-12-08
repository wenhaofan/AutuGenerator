/**
 * 请勿将俱乐部专享资源复制给其他人，保护知识产权即是保护我们所在的行业，进而保护我们自己的利益
 * 即便是公司的同事，也请尊重 JFinal 作者的努力与付出，不要复制给同事
 * 
 * 如果你尚未加入俱乐部，请立即删除该项目，或者现在加入俱乐部：http://jfinal.com/club
 * 
 * 俱乐部将提供 jfinal-club 项目文档与设计资源、专用 QQ 群，以及作者在俱乐部定期的分享与答疑，
 * 价值远比仅仅拥有 jfinal club 项目源代码要大得多
 * 
 * JFinal 俱乐部是五年以来首次寻求外部资源的尝试，以便于有资源创建更加
 * 高品质的产品与服务，为大家带来更大的价值，所以请大家多多支持，不要将
 * 首次的尝试扼杀在了摇篮之中
 */

package live.autu.generator;

import javax.sql.DataSource;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;

import live.autu.generator.config.Config;
import live.autu.generator.config.ExtMetaBuilder;
import live.autu.generator.generator.ssm.ModelGenerate;

/**
 * Model、BaseModel、_MappingKit 生成器
 */
public class _Generator {

  
	public static void main(String[] args) {
   
		// model 所使用的包名 
		String modelPackageName = "com.autu.test.model";
		// model 文件保存路径 
		String modelOutputDir = PathKit.getWebRootPath()
				+ "/src/main/java/com/autu/test/model";
		// mapper 文件保存路径 
		String mapperOutputDir= PathKit.getWebRootPath()
				+ "/src/main/java/com/autu/test/mapper";
		// list 文件保存路径 
				String listOutputDir= PathKit.getWebRootPath()
						+ "/src/main/java/com/autu/test/view";
		DataSource dataSource=Config.getDataSource();
		// 创建生成器
		GeneratorApplication application = new GeneratorApplication(dataSource);
		// 设置数据库方言
		application.setDialect(new MysqlDialect());
		
		application.addGenerator(
				new ModelGenerate()
				.setPackageName(modelPackageName)
				.setOutputDir(modelOutputDir));
	 
		new ExtMetaBuilder(dataSource);
		
		
		application.setMetaBuilder(new ExtMetaBuilder(dataSource));
		application.generate();
 
	}
}
