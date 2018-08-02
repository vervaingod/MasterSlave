package cn.xjy.common.datasource;


/**
 * ClassName:DynamicDataSourceHolder
 * Function:
 * date: 2018年07月20日
 *
 * @author 许嘉阳
 */
public class DynamicDataSourceHolder {

    private static final ThreadLocal<String> dataSources = new ThreadLocal<String>();

    public static void setDataSource(String dataSourceName) {
        dataSources.set(dataSourceName);
    }

    public static String getDataSource() {
        return (String) dataSources.get();
    }

    public static void clearDataSource() {
        dataSources.remove();
    }

}
