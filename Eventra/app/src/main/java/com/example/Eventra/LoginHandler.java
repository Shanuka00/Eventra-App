package com.example.Eventra;

//======================================
//Shanuka Dilshan - IM/2020/017 (end)
//======================================

public class LoginHandler {

    private final String CORRECT_USERNAME = "admin";
    private final String CORRECT_PASSWORD = "1234";
    private final String ERROR_MESSEGE    = "Incorrect username or a password";
    public boolean validate(String username, String password){
        boolean isUserAvailable = false;
        if(username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)){
            isUserAvailable = true;
        }
        System.out.println(isUserAvailable);
        return isUserAvailable;
    }

    public String getErrorMessege(){
        return this.ERROR_MESSEGE;
    }
}

//======================================
//Shanuka Dilshan - IM/2020/017 (end)
//======================================