package com.framework1.testclasses;


import com.framework1.base.BaseTest;
import com.framework1.base.CheckPoint;
import com.framework1.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LoginTests extends BaseTest {


    @BeforeClass
    public void setUp(){

          }
@AfterMethod
public void testLogout(){
        if(nav.isUserLoggedIn()){
            nav.logout();
            nav.login();
        }
}
    @Test
    public void testLogin(){
        nav = login.signInWith("test@email.com", "abcabc");
        boolean headerResult = nav.verifyHeader();
        //Assert.assertTrue(headerResult);
        CheckPoint.mark("test-01", headerResult, "header verification");
        boolean result = nav.isUserLoggedIn();
        CheckPoint.markFinal("test-01", result, "login verification");
        //Assert.assertTrue(result);
    }
    @Test
    public void testInvalidLogin(){
        nav = login.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        boolean result = nav.isUserLoggedIn();
        Assert.assertFalse(result);
    }
}
