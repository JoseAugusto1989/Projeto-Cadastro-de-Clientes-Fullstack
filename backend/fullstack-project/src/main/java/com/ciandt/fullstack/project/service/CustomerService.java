package com.ciandt.fullstack.project.service;

import com.ciandt.fullstack.project.model.Customer;
import com.ciandt.fullstack.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer) {
        return customerRepository.save((customer));
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
