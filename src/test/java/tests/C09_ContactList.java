package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C09_ContactList extends TestBase {

    /*
        Go to https://thinking-tester-contact-list.herokuapp.com/
        Enter email as "johndoeSDA@yahoo.com" using parameter
        Enter password as "John.123" using parameter
        Create a contact using parameter(Only firstname and lastname)
        Assert the added contact.
        Make the group name "CL" for method and run it via group.
     */

    @Test(groups = "CL")
    @Parameters({"email", "password", "firstname", "lastname"})
    void contactListTest(String email, String password, String firstname, String lastname){

        driver.get(" https://thinking-tester-contact-list.herokuapp.com/");

        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password, Keys.ENTER);

        driver.findElement(By.id("add-contact")).click();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastname);
        driver.findElement(By.id("submit")).click();

        String actualName = driver.findElement(By.id("firstName")).getText();
        Assert.assertEquals(actualName, firstname);



        String addedContactName = driver.findElement(By.xpath("//tr[last()]/td[1]")).getText();
        Assert.assertTrue(addedContactName.contains(firstname) && addedContactName.contains(lastname),"Contact was not added successfully.");



    }

}
