package com.griddynamics;

public class SignUpPage {
    static String url = "https://trello.com/";
    static String title = "Trello Workspace | Trello";
    public void goToSignInPageInChrome() throws InterruptedException {
        Browser.signUpChrome(url);
    }
    public boolean isAt(){
        if(Browser.title.equals(title))
            return true;
        else
            return false;
    }
}
