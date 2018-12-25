package cn.xjy.common.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

import static cn.xjy.common.constant.DataSourceConstant.WRITE_DATASOURCE_KEY;


/**
 * ClassName:DynamicDataSourceAspect
 * Function:
 * date: 2018年07月20日
 *
 * @author 许嘉阳
 */
@Aspect
@Component
@Order(1)
public class DynamicDataSourceAspect {
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Around("execution(public * cn.xjy.service..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        if (targetMethod.isAnnotationPresent(TargetDataSource.class)) {
            String targetDataSource = targetMethod.getAnnotation(TargetDataSource.class).dataSource();
            DynamicDataSourceHolder.setDataSource(targetDataSource);
            logger.info("----------数据源是:" + targetDataSource + "------");
        } else {
            DynamicDataSourceHolder.setDataSource(WRITE_DATASOURCE_KEY);
            logger.info("没有指定数据源，默认使用主库");
        }
        Object result = pjp.proceed();//执行方法
        DynamicDataSourceHolder.clearDataSource();
        return result;
    }
}
