package com.myproj;

import com.myproj.dto.Customer;
import com.myproj.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * Created by dumin on 7/14/17.
 */
@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(value = "/cust", method = {RequestMethod.POST},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public CustomerDto saveCust(@NotNull @RequestBody final CustomerDto customerDto) {
        Customer customer = conversionService.convert(customerDto, Customer.class);
        return conversionService.convert(customerRepository.save(customer), CustomerDto.class);
    }

    @RequestMapping(value = "/cust/{customerId}", method = {RequestMethod.GET})
    public CustomerDto getCustomer(@PathVariable("customerId") Long customerId) {
        Customer customer = customerRepository.findById(customerId).get();
//        return null;
        return conversionService.convert(customerRepository.save(customer), CustomerDto.class);
    }

    @RequestMapping(value = "/upsa/{projectId}", method = {RequestMethod.GET})
    public void addMemberToProject(
            @PathVariable("projectId") Long projectId) {

    }

}
