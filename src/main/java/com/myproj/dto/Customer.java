package com.myproj.dto;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;

/**
 * Created by dumin on HZ koga.
 */

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "Customer")
@Entity
@Table(name = "CUSTOMER")
public class Customer {
    private static final String CUSTOMER_ID = "CUSTOMER_ID";
    private static final String CUSTOMER_SEQ = "CUSTOMER_SEQ";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = CUSTOMER_SEQ)
    @SequenceGenerator(name = CUSTOMER_SEQ, sequenceName = CUSTOMER_SEQ)
    @Column(name = CUSTOMER_ID)
    private long customerId;

    @Column(unique = true, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}
