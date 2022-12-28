package com.cmitche.api.customerapi.service;

import com.cmitche.api.customerapi.repository.CustomerRepository;
import com.cmitche.api.customerapi.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    // FIELDS
    @Autowired
    private CustomerRepository customerRepository;

    // METHODS
    // GET ALL CUSTOMERS
    public List<Customer> getAllCustomers(){
        List<Customer> allCustomers = new ArrayList<>();
        customerRepository.findAll().forEach(customer -> allCustomers.add(customer));
        return allCustomers;
    }

    // GET A SINGLE CUSTOMER BY ID
    public Customer getCustomerById(Long id){
        if (customerRepository.existsById(id)){
            return customerRepository.findById(id).get();
        }
        return null;
    }

    // CREATE NEW CUSTOMER
    public Customer createNewCustomer(Customer newCustomer){
        // IF CUSTOMER DOES NOT ALREADY EXIST THEN CREATE THE NEW CUSTOMER
        if (!customerRepository.existsById(newCustomer.getCustomerId())){
            customerRepository.save(newCustomer);
        }
        return newCustomer;
    }


    // UPDATE EXISTING CUSTOMER BY ID
    public Customer updateCustomerById(Long id, Customer customer){
        // CHECK IF THE CUSTOMER ALREADY EXISTS BY ID
        if (customerRepository.existsById(id)){
            // GRAB THE CUSTOMER
            Customer existingCusomer = customerRepository.findById(id).get();
            // UPDATE THE EXISITING CUSTOMER DETAILS
            existingCusomer.setFirstName(customer.getFirstName());
            existingCusomer.setNumberOfRewardPoints(customer.getNumberOfRewardPoints());
            customerRepository.save(existingCusomer);
        }
        // RETURN THE UPDATED CUSTOMER
        return customer;
    }


    // DELETE A CUSTOMER BY ID
    public void deleteCustomerById(Long id){
        if (customerRepository.existsById(id)){
            customerRepository.deleteById(id);
        }
    }

}
