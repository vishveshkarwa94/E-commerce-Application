package com.online.shopping.Controlers;

import com.online.shopping.Customer.Customer;
import com.online.shopping.Customer.CustomerService;
import com.online.shopping.Customer.Login.LoginService;
import com.online.shopping.Request.CustomerAddRequest;
import com.online.shopping.Request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    LoginService loginService;

    @PostMapping("/addCustomer")
    public int addCustomer(@RequestBody CustomerAddRequest customerAddRequest){
        int customerId = customerService.addUser(customerAddRequest);
        if(customerId != -1) { loginService.addDetails(customerId,customerAddRequest); }
        return customerId;
    }

    @GetMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getUser(id);
    }

    @PostMapping("/login")
    public int login(@RequestBody LoginRequest loginRequest){ return loginService.authenticate(loginRequest); }

}
