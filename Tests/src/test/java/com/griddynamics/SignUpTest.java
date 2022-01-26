package com.griddynamics;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SignUpTest {
    @BeforeClass
    public void setProperties() {
        LogInPage.url = PropertiesLoader.loadChosenProperty("trello.login.url");
        LogInPage.email = PropertiesLoader.loadChosenProperty("trello.email");
        LogInPage.password = PropertiesLoader.loadChosenProperty("trello.password");
    }
    @Test
    public void signUp() throws InterruptedException {
        SignUpPage signUpPage = Pages.signUpPage();
        signUpPage.goToSignInPageInChrome();
        assertTrue(signUpPage.isAt());
    }
}
