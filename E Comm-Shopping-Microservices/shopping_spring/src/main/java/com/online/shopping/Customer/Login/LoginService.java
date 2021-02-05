package com.online.shopping.Customer.Login;

import com.online.shopping.Request.CustomerAddRequest;
import com.online.shopping.Request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService{

    @Autowired
    LoginDataHandler loginDataHandler;

    public void addDetails(int userId,CustomerAddRequest customerAddRequest){
        Login loginDetails = new Login(userId,customerAddRequest.getEmail(),customerAddRequest.getPassword());
        loginDataHandler.save(loginDetails);
    }

    public int authenticate(LoginRequest loginRequest){
        Login login = loginDataHandler.findById(loginRequest.getEmail()).get();
        if(login.getPassword().equals(loginRequest.getPassword())){
            return login.getUserId();
        }
        else {
            return -1;
        }
    }
}
