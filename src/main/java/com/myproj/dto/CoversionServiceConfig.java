package com.myproj.dto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class CoversionServiceConfig {

    @Bean
    public ConversionService conversionService(final SpelAwareProxyProjectionFactory projectionFctory) {
        final ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(createConverters(projectionFctory));
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private Set<Converter<?, ?>> createConverters(final SpelAwareProxyProjectionFactory projectionFctory) {
        Set<Converter<?, ?>> converters = new HashSet();

        converters.add(new CustomerToDtoConverter(projectionFctory));
        converters.add(new DtoToCustomerConverter());

        return converters;
    }

    @Bean
    public SpelAwareProxyProjectionFactory projectionFactory() {
        return new SpelAwareProxyProjectionFactory();
    }
}
