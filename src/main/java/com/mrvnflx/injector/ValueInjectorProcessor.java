package com.mrvnflx.injector;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

/**
 * Created by mrvnf on 4/21/2017.
 */
@Component
public class ValueInjectorProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        ReflectionUtils.doWithFields(bean.getClass(), field -> {
                    ValueInjector valueInjector = field.getAnnotation(ValueInjector.class);
                    if (valueInjector != null) {
                        ValueObject valueObject = new ValueObject();
                        valueObject.setValue(valueInjector.value());

                        field.setAccessible(true);
                        field.set(bean, valueObject);
                        field.setAccessible(false);
                    }
                }
        );
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
