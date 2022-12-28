package com.cmitche.api.customerapi.controller;

import com.cmitche.api.customerapi.service.CustomerService;
import com.cmitche.api.customerapi.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // GET ALL CUSTOMERS
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    // GET CUSTOMER BY ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    // CREATE NEW CUSTOMER
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer createNewCustomer(@RequestBody Customer newCustomer){
        return customerService.createNewCustomer(newCustomer);
    }

    // UPDATE EXISTING CUSTOMER BY ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.PUT)
    public Customer updateCustomerById(@PathVariable Long id, @RequestBody Customer newCustomer){
        return customerService.updateCustomerById(id, newCustomer);
    }

    // DELETE CUSTOMER BY ID
    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public void deleteCustomerById(@PathVariable Long id){
        customerService.deleteCustomerById(id);
    }
}
