package com.cmitche.api.customerapi.repository;

import com.cmitche.api.customerapi.vo.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
