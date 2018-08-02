package cn.xjy.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * ClassName:DynamicDataSource
 * Function:选择数据库策略
 * date: 2018年07月20日
 *
 * @author 许嘉阳
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {

        String lookupKey = DynamicDataSourceHolder.getDataSource();

        return lookupKey;
    }
}
