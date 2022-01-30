package com.griddynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {
    static String title = "Logged out of Trello";
    static By profileMenuButton = By.xpath("//*[@id='header']/div[4]/button[3]");
    static By logOutButton = By.xpath("/html/body/div[2]/div/section/div/nav/ul/li[8]/button");
    static By logOutSubmitButton = By.id("logout-submit");

    public void logOutChrome(WebDriver chromeDriver) throws InterruptedException {
        Browser.logOutChrome(LogInPage.url, chromeDriver);
    }

    public void logOutFirefox(WebDriver firefoxDriver) throws InterruptedException {
        Browser.logOutFirefox(LogInPage.url, firefoxDriver);
    }

    public void logOutSafari(WebDriver safariDriver) throws InterruptedException {
        Browser.logOutSafari(LogInPage.url, safariDriver);
    }

    public static void clickOnProfileMenuButton(WebDriver driver) {
        driver.findElement(profileMenuButton).sendKeys(Keys.ENTER);
    }

    public static void clickOnLogOutButton(WebDriver driver) {
        driver.findElement(logOutButton).sendKeys(Keys.ENTER);
    }

    public static void clickOnLogOutSubmitButton(WebDriver driver) {
       driver.findElement(logOutSubmitButton).sendKeys(Keys.ENTER);
    }

    public boolean isAtDestination() {
        if (Browser.title.equals(title))
            return true;
        else
            return false;
    }
}
