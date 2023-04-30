package com.framework1.pagesClasses;

import com.framework1.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {


    public WebDriver driver;
    //
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private String EMAIL_FIELD = "id=>email";
    private String PASSWORD_FIELD = "id=>login-password";

    private String LOG_IN_BUTTON = "id=>login";



    //
    public NavigationPage signInWith(String email, String password){
        sendData(EMAIL_FIELD, email, "Email field");
        sendData(PASSWORD_FIELD, password, "password field");
        elementClick(LOG_IN_BUTTON, "log in button");
       /* WebElement emailField = driver.findElement(By.id(EMAIL_FIELD));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id(PASSWORD_FIELD));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id(LOG_IN_BUTTON));
        loginButton.click();*/
        return new NavigationPage(driver);
    }

    //
    /*public void signInWith(String email, String password){
        WebElement emailField = driver.findElement(By.id(EMAIL_FIELD));
        emailField.clear();
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.id(PASSWORD_FIELD));
        passwordField.clear();
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.id(LOG_IN_BUTTON));
        loginButton.click();
    }*/

}
