package com.griddynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class Browser {
    static String title = "";
    static WebDriverWait waitFirefox;
    static WebDriverWait waitChrome;
    static WebDriverWait waitSafari;

    public static void logInChrome(String url, WebDriver chromeDriver) throws InterruptedException {
        chromeDriver.get(url);
        waitChrome = new WebDriverWait(chromeDriver, 10);
        LogInPage.insertEmail(chromeDriver);
        LogInPage.clickOnLogInButton(chromeDriver);
        Thread.sleep(2000);
        LogInPage.insertPassword(chromeDriver);
        LogInPage.clickOnSubmitButton(chromeDriver);
        waitChrome.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='header']/a")));
        LogInPage.clickOnHeader(chromeDriver);
        title = chromeDriver.getTitle();
    }

    public static void logOutChrome(String url, WebDriver chromeDriver) throws InterruptedException {
        logInChrome(url, chromeDriver);
        LogOutPage.clickOnProfileMenuButton(chromeDriver);
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        LogOutPage.clickOnLogOutButton(chromeDriver);
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        LogOutPage.clickOnLogOutSubmitButton(chromeDriver);
        waitChrome.until(ExpectedConditions.titleIs("Logged out of Trello"));
        title = chromeDriver.getTitle();
    }

    public static void logInFirefox(String url, WebDriver firefoxDriver) throws InterruptedException {
        firefoxDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitFirefox = new WebDriverWait(firefoxDriver, 10);
        firefoxDriver.get(url);
        LogInPage.insertEmail(firefoxDriver);
        LogInPage.clickOnLogInButton(firefoxDriver);
        waitFirefox.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
        LogInPage.insertPassword(firefoxDriver);
        Thread.sleep(2000);
        LogInPage.clickOnSubmitButton(firefoxDriver);
        waitFirefox.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='header']/a")));
        LogInPage.clickOnHeader(firefoxDriver);
        title = firefoxDriver.getTitle();
    }

    public static void logOutFirefox(String url, WebDriver firefoxDriver) throws InterruptedException {
        logInFirefox(url, firefoxDriver);
        LogOutPage.clickOnProfileMenuButton(firefoxDriver);
        LogOutPage.clickOnLogOutButton(firefoxDriver);
        LogOutPage.clickOnLogOutSubmitButton(firefoxDriver);
        waitFirefox.until(ExpectedConditions.titleIs("Logged out of Trello"));
        title = firefoxDriver.getTitle();
    }

    public static void logInSafari(String url, WebDriver safariDriver) throws InterruptedException {
        waitSafari = new WebDriverWait(safariDriver, 8);
        safariDriver.get(url);
        LogInPage.insertEmail(safariDriver);
        LogInPage.clickOnLogInButton(safariDriver);
        waitSafari.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
        Thread.sleep(2000);
        LogInPage.insertPassword(safariDriver);
        LogInPage.clickOnSubmitButton(safariDriver);
        waitSafari.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='header']/a")));
        LogInPage.clickOnHeader(safariDriver);
        title = safariDriver.getTitle();
    }

    public static void logOutSafari(String url, WebDriver safariDriver) throws InterruptedException {
        logInSafari(url, safariDriver);
        LogOutPage.clickOnProfileMenuButton(safariDriver);
        LogOutPage.clickOnLogOutButton(safariDriver);
        waitSafari.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout-submit")));
        LogOutPage.clickOnLogOutSubmitButton(safariDriver);
        waitSafari.until(ExpectedConditions.titleIs("Logged out of Trello"));
        title = safariDriver.getTitle();
    }

}
