package com.griddynamics;

public class LogOutPage {
    static String title = "Logged out of Trello";

    public void logOutChrome() {
        Browser.logOutChrome(LogInPage.url);
    }

    public void logOutFirefox() throws InterruptedException {
        Browser.logOutFirefox(LogInPage.url);
    }

    public void logOutSafari() throws InterruptedException {
        Browser.logOutSafari(LogInPage.url);
    }

    public boolean isAtDestination() {
        if (Browser.title.equals(title))
            return true;
        else
            return false;
    }
}
