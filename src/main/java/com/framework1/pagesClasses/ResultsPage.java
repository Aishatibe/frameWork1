package com.framework1.pagesClasses;

import com.framework1.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends BasePage {
    public ResultsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public WebDriver driver;
    private String URL = "https://www.letskodeit.com/courses";
    private String COURSES_LIST = "class=>zen-course-list";

    //methods
    public boolean isOpen(){
        return driver.getCurrentUrl().equalsIgnoreCase(URL);
    }

    //
    public int coursesCount(){
        List<WebElement> coursesList = getElementList(COURSES_LIST, "Courses list");
        // List<WebElement> coursesList = driver.findElements(By.className(COURSES_LIST));
        return coursesList.size();
    }
//
    public boolean verifySearchResult(){
        boolean result = false;
        if(coursesCount() > 0){
            result = true;
        }
        result = isOpen() && result;
        return result;
    }
public boolean verifyFilterCourseCount(int expectedCount){
        return coursesCount() == expectedCount;
}
}
