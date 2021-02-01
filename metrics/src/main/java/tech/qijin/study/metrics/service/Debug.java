package tech.qijin.study.metrics.service;

import com.google.common.collect.Maps;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import java.util.Map;

import static com.sun.btrace.BTraceUtils.*;
import static com.sun.btrace.BTraceUtils.Strings.strcat;

@BTrace
public class Debug {
    @OnMethod(
            clazz = "org.apache.dubbo.config.spring.beans.factory.annotation.ReferenceAnnotationBeanPostProcessor",
            method = "doGetInjectedBean",
            location = @Location(Kind.RETURN)
    )
    public static void func(
            @Self Object self,
            Object p1,
            Object p2,
            Object p3,
            Object p4,
            Object p5,
            @ProbeClassName String className,
            @ProbeMethodName String methodName,
            @Duration long time) {
        final Object sum = get(field(classOf(self), "sum"), self);
        BTraceUtils.println(className + "." + methodName + ": " + time / 1e6);
        BTraceUtils.jstack();
        Map<String, String> m = Maps.newHashMap();
        m.size();
    }
}
