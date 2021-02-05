package com.online.shopping.Customer;

import com.online.shopping.Request.CustomerAddRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService {

    @Autowired
    CustomerDataHandler customerDataHandler;

    public int addUser(CustomerAddRequest customerAddRequest){
        if(customerDataHandler.checkIfExist(customerAddRequest.getEmail()) == null){
            Customer customer = new Customer(customerAddRequest.getName(),customerAddRequest.getEmail(),
                    customerAddRequest.getPhone(), customerAddRequest.getAddress());
            return customerDataHandler.save(customer).getId();
        }
        else {
            return -1;
        }
    }

    public Customer getUser(int id){
        return customerDataHandler.findById(id).get();
    }
}
