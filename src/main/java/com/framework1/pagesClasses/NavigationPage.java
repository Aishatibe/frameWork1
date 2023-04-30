package com.framework1.pagesClasses;


import com.framework1.base.BasePage;
import com.framework1.utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NavigationPage extends BasePage {
    public NavigationPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public WebDriver driver;
    private final String URL = "https://www.letskodeit.com/courses";
    private String ALL_COURSES_LINK = "xpath=>//a[contains(text(), 'ALL COURSES')]";
    private String ACCOUNT_ICON = "class=>zl-navbar-rhs-img";
    private String LOGOUT_LINK = "xpath=>//a[.='Logout']";
    private String LOGIN_LINK = "xpath=>//a[@href='/login']";

//public void open(){
  //  driver.findElement(By.xpath(ALL_COURSES_LINK)).click();
//}
    //
public LoginPage login(){
    elementClick(LOGIN_LINK, "link to login");
    //driver.findElement(By.xpath(LOGIN_LINK)).click();
    return new LoginPage(driver);
}
public void allCourses(){
    elementClick(ALL_COURSES_LINK, "All courses link");
    //driver.findElement(By.xpath(ALL_COURSES_LINK)).click();
}
//
    public boolean isOpen(){
    return URL.equalsIgnoreCase(driver.getCurrentUrl());
    }
    //
    public boolean isUserLoggedIn(){

        try{
            List<WebElement> accountImage = getElementList(ACCOUNT_ICON, "Account icon");
            //List<WebElement> accountImage =driver.findElement(By.className(ACCOUNT_ICON));
            if(accountImage.size() > 0) {
                return true;
            }else{return  false;}
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }

    //
    public void logout(){
    elementClick(ACCOUNT_ICON, "account icon");
        WebElement logoutLink = waitForElement(LOGOUT_LINK, 10);
        elementClick(logoutLink, "log out link");
        //
    //driver.findElement(By.className(ACCOUNT_ICON)).click();
       // WebDriverWait wait = new WebDriverWait(driver, 3);
       // WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LOGOUT_LINK)));
       // logoutLink.click();
    }

    public boolean verifyHeader(){
    WebElement link = getElement(ALL_COURSES_LINK, "all courses link");
    //driver.findElement(By.xpath(ALL_COURSES_LINK));
    String text = link.getText();
    return  Util.verifyTextContains(text, "All Courses");
    }
}
