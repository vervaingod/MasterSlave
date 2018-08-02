package cn.xjy.common.datasource;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String dataSource() default "WriteDataSource";//数据源
}
