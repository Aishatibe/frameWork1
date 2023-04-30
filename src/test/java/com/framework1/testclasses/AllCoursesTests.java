package com.framework1.testclasses;

import com.framework1.base.BaseTest;
import com.framework1.pagesClasses.*;
import com.framework1.utilities.Constants;
import com.framework1.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class AllCoursesTests extends BaseTest {

@DataProvider(name="verifySearchCourseData")
public Object[][] getVerifySearchCourseData(){
    Object[][] testData = ExcelUtility.getTestData("verify_search_course");
    System.out.println(testData);
    return testData;

}
    @BeforeClass
    public void setUp(){

        nav = login.signInWith("test@email.com", "abcabc");
        ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "AllCoursesTests");
    }

    //
    @Test(dataProvider="verifySearchCourseData")
    public void verifySearchCourse(String courseName){

        //login.signInWith("test@email.com", "abcabc");
        //AllCoursesPage allCoursesPage = new AllCoursesPage(driver);
        //allCoursesPage.open();
       // NavigationPage nav = new NavigationPage(driver);
        nav.allCourses();
        search = new SearchBarPage(driver);
        result = search.course(courseName);
        //search.course("rest api");
       // ResultsPage result = new ResultsPage(driver);
        boolean searchResults = result.verifySearchResult();
        Assert.assertTrue(searchResults);
    }
    //
    //test to filter by category

    @Test(enabled = false)
    public void filterByCategory(){
        //NavigationPage nav =  new NavigationPage(driver);
        nav.allCourses();
        category = new CategoryFilterPage(driver);
        result = category.select("Sofware Testing");
        int count = category.findCoursesCount("Sofware Testing");
        boolean filterResult = result.verifyFilterCourseCount(count);
        Assert.assertTrue(filterResult);
    }
    //

}
