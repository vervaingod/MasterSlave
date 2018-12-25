package cn.xjy.common.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static cn.xjy.common.constant.DataSourceConstant.READ_DATASOURCE_KEY;
import static cn.xjy.common.constant.DataSourceConstant.WRITE_DATASOURCE_KEY;


/**
 * ClassName:DataSourceConfig
 * Function:数据源配置
 * date: 2018年07月20日
 *
 * @author 许嘉阳
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.druid.read.mapperLocations}")
    private String ReadMapperLocations;

    @Bean(name = "dynamicDatasource")
    public AbstractRoutingDataSource routingDataSource(
            @Qualifier("WriteDataSource") DataSource writeDataSource,
            @Qualifier("ReadDataSource") DataSource readDataSource
    ) {
        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap();
        targetDataSources.put(WRITE_DATASOURCE_KEY, writeDataSource);
        targetDataSources.put(READ_DATASOURCE_KEY, readDataSource);
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(writeDataSource);
        return dataSource;
    }


    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory ReadSqlSessionFactory(
            @Qualifier("dynamicDatasource") DataSource dataSource
    ) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 配置mapper文件位置 因读库写库的用的是一个mapper
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(ReadMapperLocations));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "TransactionManager")
    public DataSourceTransactionManager transactionManager(
            @Qualifier("dynamicDatasource") DataSource dataSource
    ) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }


}
