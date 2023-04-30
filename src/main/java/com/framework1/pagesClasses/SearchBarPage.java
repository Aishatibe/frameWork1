package com.framework1.pagesClasses;

import com.framework1.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchBarPage extends BasePage {
    public SearchBarPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public WebDriver driver;
    private String SEARCH_COURSE_FIELD = "xpath=>//input[@name='course']";
    private String SEARCH_COURSE_BUTTON = "class=>search-course";

    //
    public ResultsPage course(String courseName){
        sendData(SEARCH_COURSE_FIELD, courseName, "Search course field");
        elementClick(SEARCH_COURSE_BUTTON, "search course button");
        return new ResultsPage(driver);
        /*WebElement searchField = driver.findElement(By.xpath(SEARCH_COURSE_FIELD));
        searchField.clear();
        searchField.sendKeys(courseName);

        WebElement searchButton = driver.findElement(By.className(SEARCH_COURSE_BUTTON));
        searchButton.click();
        return  new ResultsPage(driver);*/
    }

   /* public void course(String courseName){
        WebElement searchField = driver.findElement(By.xpath(SEARCH_COURSE_FIELD));
        searchField.clear();
        searchField.sendKeys(courseName);

        WebElement searchButton = driver.findElement(By.className(SEARCH_COURSE_BUTTON));
        searchButton.click();
    }*/
}
