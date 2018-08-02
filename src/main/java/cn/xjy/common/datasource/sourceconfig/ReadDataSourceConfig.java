package cn.xjy.common.datasource.sourceconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * ClassName:ReadDataSourceConfig
 * Function:读数据源
 * date: 2018年07月20日
 *
 * @author 许嘉阳
 */
@Configuration
@MapperScan(basePackages = {"cn.xjy.mapper"},
        sqlSessionFactoryRef = "ReadSqlSessionFactory")
public class ReadDataSourceConfig {


    @Value("${spring.datasource.druid.read.mapperLocations}")
    private String ReadMapperLocations;

    @ConfigurationProperties(prefix = "spring.datasource.druid.read")
    @Bean(name = "ReadDataSource")
    public DataSource mipReadDataSource() {
        return new DruidDataSource();
    }

    /**
     * SqlSessionFactory配置
     *
     * @return
     * @throws Exception
     */
    @Bean(name = "ReadSqlSessionFactory")
    public SqlSessionFactory ReadSqlSessionFactory(
            @Qualifier("ReadDataSource") DataSource dataSource
    ) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 配置mapper文件位置
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(ReadMapperLocations));

        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置事物管理器
     *
     * @return
     */
    @Bean(name = "ReadTransactionManager")
    public DataSourceTransactionManager ReadTransactionManager(
            @Qualifier("ReadDataSource") DataSource dataSource
    ) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

}
