package com.griddynamics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class LogOutTest {
    public static LogOutPage logOutPage = Pages.logOutPage();
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

    @Test
    public void shouldLogOutInFirefox() throws InterruptedException {
        logOutPage.logOutFirefox(firefoxDriver);
        assertTrue(logOutPage.isAtDestination());
    }

    @Test
    public void shouldLogOutInChrome() throws InterruptedException {
        logOutPage.logOutChrome(chromeDriver);
        assertTrue(logOutPage.isAtDestination());
    }

    @Test
    public void shouldLogOutInSafari() throws InterruptedException {
        logOutPage.logOutSafari(safariDriver);
        assertTrue(logOutPage.isAtDestination());
    }

    @AfterClass
    public void tearDown() {
        chromeDriver.close();
        firefoxDriver.close();
        safariDriver.close();
    }
}
