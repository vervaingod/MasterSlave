package cn.xjy.common.datasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    @Bean
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
}
