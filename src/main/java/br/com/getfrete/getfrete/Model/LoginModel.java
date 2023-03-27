package br.com.getfrete.getfrete.Model;

import java.io.Serializable;
import java.io.*;
public class LoginModel   {

    private static final LoginModel instance = new LoginModel();

    private String userName;
    private LoginModel(){}

    public static LoginModel getInstance() {
        return instance;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
