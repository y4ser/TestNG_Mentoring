package utilities;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

    @DataProvider(name = "faker")
    public Object[][] getFormDataFaker(){
        Faker faker = new Faker();
        return new Object[][]{
                {faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName(), faker.name().username(), faker.internet().emailAddress(), faker.internet().password()},
                {faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName(), faker.name().username(), faker.internet().emailAddress(), faker.internet().password()},
                {faker.idNumber().ssnValid(), faker.name().firstName(), faker.name().lastName(), faker.name().username(), faker.internet().emailAddress(), faker.internet().password()},
        };
    }


    @DataProvider(name = "excelDP")
    public Object[][] getUserDataFromExcel(){
        ExcelUtilities eu = new ExcelUtilities("users list.xlsx", "Sheet1") ;
        return eu.getExcelDataAsArray();
    }

}
