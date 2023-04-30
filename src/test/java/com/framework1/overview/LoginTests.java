package com.framework1.overview;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTests {
    WebDriver driver;
    String baseURL;

@BeforeClass
public void beforeClass(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();

    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    baseURL = "https://www.letskodeit.com/";
    driver.get(baseURL);
}
@Test
    public void testLogin(){
    driver.findElement(By.xpath("//a[@href='/login']")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("test@email.com");
    WebElement passwordElement = driver.findElement(By.id("login-password"));
    passwordElement.clear();
    passwordElement.sendKeys("abcabc");
    driver.findElement(By.id("login")).click();
    WebElement accountImage = null;
    try{
        accountImage = driver.findElement(By.className("zl-navbar-rhs-img"));
    }catch (Exception e){
        e.printStackTrace();
    }
    Assert.assertNotNull(accountImage);
}
}
