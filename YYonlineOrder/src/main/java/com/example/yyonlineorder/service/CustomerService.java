package com.example.yyonlineorder.service;

import com.example.yyonlineorder.dao.CustomerDao;
import com.example.yyonlineorder.entity.Cart;
import com.example.yyonlineorder.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//public class CustomerService {
//
//    private CustomerDao customerDao;
//
//    @Autowired
//    public CustomerService(CustomerDao customerDao){
//        this.customerDao = customerDao;
//    }

    @Service
    public class CustomerService {

        @Autowired
        private CustomerDao customerDao;

        public void signUp(Customer customer) {
            Cart cart = new Cart();
            customer.setCart(cart);

            customer.setEnabled(true);

            customerDao.signUp(customer);
        }

        public Customer getCustomer(String email) {

            return customerDao.getCustomer(email);
        }
    }

