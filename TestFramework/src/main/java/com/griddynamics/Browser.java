package com.griddynamics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Browser {
    static WebDriver chromeDriver;
    static WebDriver firefoxDriver;
    static WebDriver safariDriver;
    static String title = "";
    static WebDriverWait waitFirefox;
    static WebDriverWait waitChrome;
    static WebDriverWait waitSafari;

    public static void logInChrome(String url) {
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeDriver.get(url);
        WebElement email = chromeDriver.findElement(By.name("user"));
        email.sendKeys(LogInPage.email);
        WebElement logInButton = chromeDriver.findElement(By.xpath("//*[@id='login']"));
        logInButton.click();
        WebElement password = chromeDriver.findElement(By.className("css-1us7xzt"));
        password.sendKeys(LogInPage.password);
        WebElement submitButton = chromeDriver.findElement(By.id("login-submit"));
        submitButton.click();
        chromeDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//*[@id='header']/a")).click();
        title = chromeDriver.getTitle();
    }

    public static void logOutChrome(String url) {
        logInChrome(url);
        waitChrome = new WebDriverWait(chromeDriver, 10);
        WebElement profileMenu = chromeDriver.findElement(By.xpath("//*[@id='header']/div[4]/button[3]"));
        profileMenu.click();
        WebElement logOutButton = chromeDriver.findElement(By.xpath("/html/body/div[2]/div/section/div/nav/ul/li[8]/button"));
        logOutButton.click();
        WebElement logOutSubmitButton = chromeDriver.findElement(By.id("logout-submit"));
        logOutSubmitButton.click();
        waitChrome.until(ExpectedConditions.titleIs("Logged out of Trello"));
        title = chromeDriver.getTitle();
    }

    public static void logInFirefox(String url) throws InterruptedException {
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitFirefox = new WebDriverWait(firefoxDriver, 10);
        firefoxDriver.get(url);
        WebElement email = firefoxDriver.findElement(By.name("user"));
        email.sendKeys(LogInPage.email);
        firefoxDriver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        waitFirefox.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
        waitFirefox.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement password = firefoxDriver.findElement(By.id("password"));
        password.sendKeys(LogInPage.password);
        WebElement submitButton = firefoxDriver.findElement(By.id("login-submit"));
        submitButton.sendKeys(Keys.ENTER);
        firefoxDriver.findElement(By.xpath("//*[@id='header']/a")).click();
        title = firefoxDriver.getTitle();
    }

    public static void logOutFirefox(String url) throws InterruptedException {
        logInFirefox(url);
        WebElement profileMenu = firefoxDriver.findElement(By.xpath("//*[@id='header']/div[4]/button[3]"));
        profileMenu.click();
        WebElement logOutButton = firefoxDriver.findElement(By.xpath("/html/body/div[2]/div/section/div/nav/ul/li[8]/button"));
        logOutButton.click();
        WebElement logOutSubmitButton = firefoxDriver.findElement(By.id("logout-submit"));
        logOutSubmitButton.click();
        waitFirefox.until(ExpectedConditions.titleIs("Logged out of Trello"));
        title = firefoxDriver.getTitle();
    }

    public static void logInSafari(String url) throws InterruptedException {
        safariDriver = new SafariDriver();
        safariDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        waitSafari = new WebDriverWait(safariDriver, 8);
        safariDriver.manage().window().maximize();
        safariDriver.get(url);
        WebElement email = safariDriver.findElement(By.name("user"));
        email.sendKeys(LogInPage.email);
        safariDriver.findElement(By.id("login")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        waitSafari.until(ExpectedConditions.titleIs("Log in to continue - Log in with Atlassian account"));
        waitSafari.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        WebElement password = safariDriver.findElement(By.id("password"));
        password.sendKeys(LogInPage.password);
        WebElement submitButton = safariDriver.findElement(By.id("login-submit"));
        submitButton.sendKeys(Keys.ENTER);
        waitSafari.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='header']/a")));
        safariDriver.findElement(By.xpath("//*[@id='header']/a")).click();
        title = safariDriver.getTitle();
    }

    public static void logOutSafari(String url) throws InterruptedException {
        logInSafari(url);
        WebElement profileMenu = safariDriver.findElement(By.xpath("//*[@id='header']/div[4]/button[3]"));
        profileMenu.click();
        WebElement logOutButton = safariDriver.findElement(By.xpath("/html/body/div[2]/div/section/div/nav/ul/li[8]/button"));
        logOutButton.click();
        WebElement logOutSubmitButton = safariDriver.findElement(By.id("logout-submit"));
        logOutSubmitButton.click();
        waitSafari.until(ExpectedConditions.titleIs("Logged out of Trello"));
        title = safariDriver.getTitle();
    }

    public static void signUpChrome(String url) throws InterruptedException {
        chromeDriver = new ChromeDriver();
        waitChrome = new WebDriverWait(chromeDriver, 10);
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeDriver.get(url);
        chromeDriver.findElement(By.xpath("/html/body/header/nav/div/a[2]")).click();
        waitChrome.until(ExpectedConditions.visibilityOfElementLocated(By.id("google")));
        chromeDriver.findElement(By.name("email")).sendKeys("ief03783@zwoho.com");
        chromeDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        chromeDriver.findElement(By.id("signup-submit")).click();
        chromeDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        chromeDriver.findElement(By.name("displayName")).sendKeys("Will Smith");
        chromeDriver.findElement(By.id("signup-submit")).click();
        Thread.sleep(10000);
        chromeDriver.findElement(By.xpath("//*[@id='content']/div/main/div[1]/div/form/button")).click();
        chromeDriver.findElement(By.xpath("//*[@id='content']/div/main/div[1]/div/div[4]/div/button[1]")).click();
        Thread.sleep(4000);
        title = chromeDriver.getTitle();
    }

    public static void close() {
        chromeDriver.close();
        firefoxDriver.close();
        safariDriver.close();
    }

}
