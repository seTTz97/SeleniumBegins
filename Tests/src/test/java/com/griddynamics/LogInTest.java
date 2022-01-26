package com.griddynamics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class LogInTest {
    public static LogInPage logInPage = Pages.logInPage();

    @BeforeClass
    public void setProperties() {
        LogInPage.url = PropertiesLoader.loadChosenProperty("trello.login.url");
        LogInPage.email = PropertiesLoader.loadChosenProperty("trello.email");
        LogInPage.password = PropertiesLoader.loadChosenProperty("trello.password");
    }

    @Test
    public void shouldLogInFirefox() throws InterruptedException {
        logInPage.goToLogInPageInFirefox();
        assertTrue(logInPage.isAtDestination());
    }


    @Test
    public void shouldLogInChrome() {
        logInPage.goToLogInPageInChrome();
        assertTrue(logInPage.isAtDestination());
    }


    @Test
    public void shouldLogInSafari() throws InterruptedException {
        logInPage.goToLogInPageInSafari();
        assertTrue(logInPage.isAtDestination());
    }


    @AfterClass
    public void cleanUp() {
        Browser.close();
    }
}
