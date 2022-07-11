package com.kirin_app.model;

import java.sql.ResultSet;

public interface Service {
public void connectionDB();
public void saveRegistration(String name,String city,String email, String mobile);
public boolean verifyCredentials(String email, String password);
public ResultSet listAllReg();
public void deleteRegistration(String email);



}
