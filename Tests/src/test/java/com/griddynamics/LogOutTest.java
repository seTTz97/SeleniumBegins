package com.griddynamics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class LogOutTest {
    public static LogOutPage logOutPage = Pages.logOutPage();

    @BeforeClass
    public void setProperties() {
        LogInPage.url = PropertiesLoader.loadChosenProperty("trello.login.url");
        LogInPage.email = PropertiesLoader.loadChosenProperty("trello.email");
        LogInPage.password = PropertiesLoader.loadChosenProperty("trello.password");
    }

    @Test
    public void shouldLogOutInFirefox() throws InterruptedException {
        logOutPage.logOutFirefox();
        assertTrue(logOutPage.isAtDestination());
    }

    @Test
    public void shouldLogOutInChrome() {
        logOutPage.logOutChrome();
        assertTrue(logOutPage.isAtDestination());
    }

    @Test
    public void shouldLogOutInSafari() throws InterruptedException {
        logOutPage.logOutSafari();
        assertTrue(logOutPage.isAtDestination());
    }

    @AfterClass
    public void cleanUp() {
        Browser.close();
    }
}
