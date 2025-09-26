package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C10_CrossBrowserTest extends TestBase {

    /*
        Task 5: Soft Assertions Practice
        Objective: Implement soft assertions for negative test scenarios
        Test Case: Negative Login Test
        1. Navigate to https://claruswaysda.github.io/signIn.html
        2. Enter username: "wronguser"
        3. Enter password: "wrongpass"
        4. Click Submit button
        5. Use soft assertions to verify: Alert message text is "Incorrect username or password"
     */

    @Test
    void CrossBrowserTest(){

        driver.get("https://claruswaysda.github.io/signIn.html");
        driver.findElement(By.id("username")).sendKeys("wronguser");
        driver.findElement(By.id("password")).sendKeys("wrongpass", Keys.ENTER);
        String alertText = driver.switchTo().alert().getText();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(alertText, "Incorrect username or password");
        softAssert.assertTrue(true, "Condition is false");
        softAssert.assertEquals(2, 2, " Values did not match");
        softAssert.assertAll();


    }

}
