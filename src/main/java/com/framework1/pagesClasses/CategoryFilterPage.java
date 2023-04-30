package com.framework1.pagesClasses;

import com.framework1.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryFilterPage extends BasePage {
    public CategoryFilterPage(WebDriver driver){
        super(driver);
        this.driver = driver;
       // js = (javascriptExecutor) driver;
    }
    public WebDriver driver;
   // private javascriptExecutor js;

    private String CATEGORY_DROPDOWN = "xpath=>//select";
    private String CATEGORY_OPTION = "xpath=>//option[.='%s']";
    private String CATEGORY_LIST = "class=>zen-course-thumbnail";
    //
    public void clickCategoryDropdown() {
        // Find category dropdown
        elementClick(CATEGORY_DROPDOWN, "Category Dropdown");
    }
    public WebElement findCategory(String categoryName) {
        clickCategoryDropdown();
        // Wait for the element to be clickable
        WebElement categoryOption = waitForElementToBeClickable(
                String.format(CATEGORY_OPTION, categoryName), 15);
        return categoryOption;
    }
    public ResultsPage select(String categoryName){
        WebElement categoryOption = findCategory(categoryName);
        javascriptClick(categoryOption, "Category Option");

        //WebElement categoryDropdown = driver.findElement(By.xpath(CATEGORY_DROPDOWN));
       // categoryDropdown.click();

        //
        /*WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement categoryOption = wait.until(
                ExpectedConditions.elementToBeClickable(
                By.xpath(String.format(CATEGORY_OPTION, categoryName))));
        categoryOption.click();*/
        //js.executeScript("arguments[0].click();", categoryOption);
        return new ResultsPage(driver);
    }
    public int findCoursesCount(String categoryName){
        List <WebElement> categoryList = getElementList(CATEGORY_LIST, "category list");
        //List <WebElement> categoryList = driver.findElements(By.className(CATEGORY_LIST));
        System.out.println(categoryList.size());
        return categoryList.size();
    }
}
