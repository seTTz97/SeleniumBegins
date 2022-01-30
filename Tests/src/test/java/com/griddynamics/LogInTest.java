package com.griddynamics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class LogInTest {
    public static LogInPage logInPage = Pages.logInPage();
    WebDriver chromeDriver;
    WebDriver firefoxDriver;
    WebDriver safariDriver;

    @BeforeClass
    public void setProperties() {
        LogInPage.url = PropertiesLoader.loadChosenProperty("trello.login.url");
        LogInPage.email = PropertiesLoader.loadChosenProperty("trello.email");
        LogInPage.password = PropertiesLoader.loadChosenProperty("trello.password");
        safariDriver = new SafariDriver();
        firefoxDriver = new FirefoxDriver();
        chromeDriver = new ChromeDriver();
    }

    @Test(priority = 0)
    public void shouldLogInChrome() throws InterruptedException {
        System.out.println(LogInPage.email);
        logInPage.goToLogInPageInChrome(chromeDriver);
        assertTrue(logInPage.isAtDestination());
    }

    @Test(priority = 1)
    public void shouldLogInFirefox() throws InterruptedException {
        logInPage.goToLogInPageInFirefox(firefoxDriver);
        assertTrue(logInPage.isAtDestination());
    }

    @Test(priority = 2)
    public void shouldLogInSafari() throws InterruptedException {
        logInPage.goToLogInPageInSafari(safariDriver);
        assertTrue(logInPage.isAtDestination());
    }
    @AfterClass
    public void tearDown(){
        chromeDriver.close();
        firefoxDriver.close();
        safariDriver.close();
    }


}
