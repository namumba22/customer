package com.myproj.dto;

import org.springframework.core.convert.converter.Converter;

public class DtoToCustomerConverter implements Converter<CustomerDto, Customer> {

    public Customer convert(final CustomerDto source) {
        Customer customer = new Customer();
        customer.setCustomerId(source.getCustomerId());
        customer.setName(source.getName());
        return customer;
    }

}
