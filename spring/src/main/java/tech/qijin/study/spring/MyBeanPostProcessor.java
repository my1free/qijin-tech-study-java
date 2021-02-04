package tech.qijin.study.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Iterator;

import static java.lang.String.format;
import static java.util.Arrays.asList;
import static org.springframework.util.ClassUtils.resolveClassName;
import static org.springframework.util.ObjectUtils.nullSafeEquals;

@Slf4j
@Component
public class MyBeanPostProcessor implements BeanDefinitionRegistryPostProcessor{
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        registerBeans(registry, MySpringService.class);
        System.out.println("");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }

    public static void registerBeans(BeanDefinitionRegistry registry, Class<?>... annotatedClasses) {

        if (ObjectUtils.isEmpty(annotatedClasses)) {
            return;
        }

        // Remove all annotated-classes that have been registered
        Iterator<Class<?>> iterator = new ArrayList<Class<?>>(asList(annotatedClasses)).iterator();

        while (iterator.hasNext()) {
            Class<?> annotatedClass = iterator.next();
            if (isPresentBean(registry, annotatedClass)) {
                iterator.remove();
            }
        }

        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(registry);


        reader.register(annotatedClasses);
    }

    public static boolean isPresentBean(BeanDefinitionRegistry registry, Class<?> annotatedClass) {

        boolean present = false;

        String[] beanNames = registry.getBeanDefinitionNames();

        ClassLoader classLoader = annotatedClass.getClassLoader();

        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(beanName);
            if (beanDefinition instanceof AnnotatedBeanDefinition) {
                AnnotationMetadata annotationMetadata = ((AnnotatedBeanDefinition) beanDefinition).getMetadata();
                String className = annotationMetadata.getClassName();
                Class<?> targetClass = resolveClassName(className, classLoader);
                present = nullSafeEquals(targetClass, annotatedClass);
                if (present) {
                    break;
                }
            }
        }

        return present;
    }
}
