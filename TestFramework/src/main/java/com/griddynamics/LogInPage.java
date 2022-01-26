package com.griddynamics;

public class LogInPage {
    static String url = "";
    static String password = "";
    static String email = "";
    static String title = "Boards | Trello";

    public void goToLogInPageInChrome(){
        Browser.logInChrome(url);
    }

    public void goToLogInPageInFirefox() throws InterruptedException {
        Browser.logInFirefox(url);
    }

    public void goToLogInPageInSafari() throws InterruptedException {
        Browser.logInSafari(url);
    }

    public boolean isAtDestination() {
        if (Browser.title.equals(title))
            return true;
        else
            return false;
    }

}
