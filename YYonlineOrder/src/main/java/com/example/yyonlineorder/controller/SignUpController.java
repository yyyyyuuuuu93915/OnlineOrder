package com.example.yyonlineorder.controller;

import com.example.yyonlineorder.entity.Customer;
import com.example.yyonlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {
    private CustomerService customerService;

    @Autowired
    public SignUpController (CustomerService customerService ){
        this.customerService = customerService;
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED )//java -> jason
    // @ResponseBody //JASON->JAVA
    //postman发了个request，请求。交给下面这个方法去处理
    public void signUp(@RequestBody Customer customer){
        System.out.println("customer name" + customer.getFirstName() );
        customerService.signUp(customer);
    }
}
