package tasks;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class TH01_NegativeTestingWithDataProvider extends TestBase {

    /*
    HomeWork1:
    Task 3: Negative Testing with Data Provider
     Go to https://claruswaysda.github.io/signIn.html
     Do negative test with all scenarios
     */

    @Test(dataProvider = "scenarios")
    void NegativeTestingWithDataProviderTest(String username, String password){

//        Go to https://claruswaysda.github.io/signIn.html
        driver.get("https://claruswaysda.github.io/signIn.html");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

    }

    //        Do negative test with all scenarios
    @DataProvider(name = "scenarios")
    public Object[][] negativeTesting(){
        return new Object[][]{
                {"", ""},
                {"", "12345678"},
                {"yaser", ""},
                {"yaser", "!^$@!"},
                {"^!%@", "12345678"},
                {"yaser", "12345678"},
        };
    }

}
