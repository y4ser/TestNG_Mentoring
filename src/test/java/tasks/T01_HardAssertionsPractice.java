package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class T01_HardAssertionsPractice extends TestBase {

    /*
    Task 4: Hard Assertions Practice
    Objective: Implement hard assertions for login functionality
    Test Case: Positive Login Test
    1. Navigate to https://claruswaysda.github.io/signIn.html
    2. Enter username: "admin"
    3. Enter password: "123"
    4. Click Submit button
    5. Use hard assertions to verify:
        New page URL is "https://claruswaysda.github.io/signIn.html"
        Page contains text "Employee Table"
        Implementation Requirements:
        Create class HardAssertLoginTest
        Use appropriate WebDriver setup and teardown
        Implement proper element locators
        Use meaningful assertion messages
     */

    @Test
    void PositiveLoginTest(){

        driver.get("https://claruswaysda.github.io/signIn.html");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("123", Keys.ENTER);

        //hard assertions to verify:

//        Use hard assertions to verify: New page URL is "https://claruswaysda.github.io/signIn.html"
        String actualURL = driver.getCurrentUrl();
        assertEquals("https://claruswaysda.github.io/signIn.html",actualURL);

//        Page contains text "Employee Table"
        WebElement EmployeeTable = driver.findElement(By.id("employeeHeader"));
        assertTrue(EmployeeTable.getText().contains("Employee Table"));


    }

}
