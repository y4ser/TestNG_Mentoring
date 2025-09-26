package tests;

import org.testng.annotations.Test;

public class C04_AnnotationAttributesPractice {

    /*
    Task 2: TestNG Annotation Attributes Practice
    Objective: Implement various TestNG annotation attributes
    Requirements:
    1. Create a class called AttributePracticeTest
    2. Create 5 test methods with different priorities (1, 3, 2, 5, 4)
    3. Create one test method with enabled = false
    4. Create a test method with timeout of 3 seconds that includes Thread.sleep(2000)
    5. Create a test method with timeout of 1 second that includes Thread.sleep(2000) (should fail)
    6. Add meaningful descriptions to all test methods
    7. Create test methods with groups: "smoke", "regression", "api"

     */

    @Test(priority = 1, description = "This is test01", groups = {"api","smoke"})
    void Test01(){
        System.out.println("Test 01");
    }

    @Test(priority = 3, description = "This is test02", groups = "regression")
    void Test02(){
        System.out.println("Test 02");
    }

    @Test(priority = 2, enabled = false, description = "This is test03", groups = "smoke")
    void Test03(){
        System.out.println("Test 03");
    }

    @Test(priority = 5, timeOut = 3000, description = "This is test04", groups = "smoke")
    void Test04() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Test 04");

    }

    @Test(priority = 4, timeOut = 1000, description = "This is test05. This will fail intentionally", groups = "regression")
    void Test05() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Test 05");
    }

}
