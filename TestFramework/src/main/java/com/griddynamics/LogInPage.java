package com.griddynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    static String url = "";
    static String password = "";
    static String email = "";
    static String title = "Boards | Trello";
    static By emailField = By.xpath("//*[@id='user']");
    static By logInButton = By.xpath("//*[@id='login']");
    static By passwordField = By.xpath("//*[@id='password']");
    static By submitButton = By.xpath("//*[@id='login-submit']");
    static By header = By.xpath("//*[@id='header']/a");

    public void goToLogInPageInChrome(WebDriver chromeDriver) throws InterruptedException {
        Browser.logInChrome(url, chromeDriver);
    }

    public void goToLogInPageInFirefox(WebDriver firefoxDriver) throws InterruptedException {
        Browser.logInFirefox(url, firefoxDriver);
    }

    public void goToLogInPageInSafari(WebDriver safariDriver) throws InterruptedException {
        Browser.logInSafari(url, safariDriver);
    }


    public static void insertEmail(WebDriver driver) {
        driver.findElement(emailField).sendKeys(email);
    }


    public static void clickOnLogInButton(WebDriver driver) {
        driver.findElement(logInButton).sendKeys(Keys.ENTER);
    }


    public static void insertPassword(WebDriver driver) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public static void clickOnSubmitButton(WebDriver driver) {
        driver.findElement(submitButton).sendKeys(Keys.ENTER);
    }

    public static void clickOnHeader(WebDriver driver) {
        driver.findElement(header).click();
    }

    public boolean isAtDestination() {
        if (Browser.title.equals(title))
            return true;
        else
            return false;
    }

}
