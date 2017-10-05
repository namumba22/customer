package com.myproj.dto;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by dumin on 7/14/17.
 */

@Projection(name = "customerView", types = {Customer.class})
public interface CustomerDto{

    long getCustomerId();

    void setCustomerId(long customerId);

    String getName();

    void setName(String name);

}
