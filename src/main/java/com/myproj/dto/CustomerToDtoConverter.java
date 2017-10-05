package com.myproj.dto;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

public class CustomerToDtoConverter implements Converter<Customer, CustomerDto> {

    private final SpelAwareProxyProjectionFactory projectionFactory;

    public CustomerToDtoConverter(final SpelAwareProxyProjectionFactory projectionFactory) {
        this.projectionFactory = projectionFactory;
    }

    //    @Override
    public CustomerDto convert(final Customer source) {
        return this.projectionFactory.createProjection(CustomerDto.class, source);
    }

}
