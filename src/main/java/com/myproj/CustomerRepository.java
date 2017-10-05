package com.myproj;

import com.myproj.dto.Customer;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;

/**
 * Created by dumin on 7/14/17.
 */
interface CustomerRepository extends CrudRepository<Customer, Long> {
    @QueryHints(value = {
            @QueryHint(name = "org.hibernate.cacheable", value = "true"),
            @QueryHint(name = "org.hibernate.cacheMode", value = "NORMAL"),
            @QueryHint(name = "org.hibernate.cacheRegion", value = "Customer")
    })
    Customer save(Customer entity);



}

