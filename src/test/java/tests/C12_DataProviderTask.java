package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C12_DataProviderTask extends TestBase {

     /*
    Go to https://claruswaysda.github.io/Registration.html
    Fill the form
    Do it with all 3 ways
    (Same class Data Provider, Data Provider with Faker, Data Provider with Excel)
    */

    @DataProvider(name = "form")
    public Object[][] getFormData() {
        return new Object[][]{
                {"123-66-4567", "Yaser", "alshammari", "y4ser", "yaser@gmail.com", "12345678"},
                {"654-66-9876", "Basil", "a", "basil", "basil@gmail.com", "12345678"},
                {"456-55-8799", "Fahad", "b", "fahad", "fahad@gmail.com", "12345678"}
        };
    }

    @Test(dataProvider = "form")
    void dataProviderTaskTest01(String ssn, String firstname, String lastname, String username, String email, String password) {
//        Go to https://claruswaysda.github.io/Registration.html
        driver.get("https://claruswaysda.github.io/Registration.html");
//        Fill the form
        driver.findElement(By.id("ssn")).sendKeys(ssn);
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);
        driver.findElement(By.xpath("//label[@for='male']")).click();
        WebElement select =  driver.findElement(By.id("job"));
        new Select(select).selectByVisibleText("Tester");
        WebElement UpLoad = driver.findElement(By.id("cv"));
        UpLoad.sendKeys(System.getProperty("user.dir") + "\\yaser.pdf");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("submit-btn")).click();
    }

    @Test(dataProvider = "faker", dataProviderClass = utilities.DataProviderUtilities.class)
    void dataProviderTaskTest02(String ssn, String firstname, String lastname, String username, String email, String password) {
//        Go to https://claruswaysda.github.io/Registration.html
        driver.get("https://claruswaysda.github.io/Registration.html");
//        Fill the form
        driver.findElement(By.id("ssn")).sendKeys(ssn);
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);
        driver.findElement(By.xpath("//label[@for='male']")).click();
        WebElement select =  driver.findElement(By.id("job"));
        new Select(select).selectByVisibleText("Tester");
        WebElement UpLoad = driver.findElement(By.id("cv"));
        UpLoad.sendKeys(System.getProperty("user.dir") + "\\yaser.pdf");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.className("submit-btn")).click();
    }


    @Test(dataProvider = "excelDP", dataProviderClass = utilities.DataProviderUtilities.class)
    void dataProviderTaskTest03(String SSN, String firstname, String lastname, String job, String username, String email, double password){
        //      Go to https://claruswaysda.github.io/Registration.html
        driver.get("https://claruswaysda.github.io/Registration.html");

//        Fill the form
        driver.findElement(By.id("ssn")).sendKeys(SSN);
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);
        driver.findElement(By.xpath("//label[@for='male']")).click();
        WebElement select =  driver.findElement(By.id("job"));
        new Select(select).selectByVisibleText(job);
        WebElement UpLoad = driver.findElement(By.id("cv"));
        UpLoad.sendKeys(System.getProperty("user.dir") + "\\yaser.pdf");
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys((int)password + "");
        driver.findElement(By.className("submit-btn")).click();

    }


}
