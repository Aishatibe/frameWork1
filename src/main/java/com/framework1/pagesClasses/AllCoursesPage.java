package com.framework1.pagesClasses;


import com.framework1.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllCoursesPage extends BasePage {
    public AllCoursesPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public WebDriver driver;
    private final String URL = "https://www.letskodeit.com/courses";
    private String ALL_COURSES_LINK = "xpath=>//a[contains(text(), 'ALL COURSES')]";

public void open(){
    elementClick(ALL_COURSES_LINK, "All courses link");
    //driver.findElement(By.xpath(ALL_COURSES_LINK)).click();
}
//
    public boolean isOpen(){
    return URL.equalsIgnoreCase(driver.getCurrentUrl());
    }
}
