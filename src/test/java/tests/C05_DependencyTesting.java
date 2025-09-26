package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C05_DependencyTesting {

    /*
    Task 3: Dependency Testing
    Objective: Create interdependent test methods using dependsOnMethods
    Requirements:
    1. Create a class called DependencyTest
    2. Create a @BeforeClass method to set up WebDriver
    3. Create the following dependent test chain:
    openYahoo() - Navigate to Yahoo
    openBing() - Navigate to Bing (depends on Yahoo test)
    openDuckDuckGo() - Navigate to DuckDuckGo (depends on Bing test)
    4. Add intentional failure in Yahoo test and observe behavior
    5. Create @AfterClass method to close driver
     */

    WebDriver driver;
    @BeforeClass
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test(timeOut = 2000)
    void openYahoo() throws InterruptedException {
        driver.get("https://mail.yahoo.com/");
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "openYahoo")
    void openBing(){
        driver.get("https://www.bing.com/");
    }

    @Test(dependsOnMethods = "openBing")
    void openDuckDuckGo(){
        driver.get("https://duckduckgo.com/");
    }

    @AfterClass
    void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
