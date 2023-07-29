package POMRunner;

import org.testng.annotations.*;

public class TestNGAnnotationSequence {

    @BeforeSuite
    public void beforeSuite()
    {
        System.out.println("I am Before Suite");
    }

    @BeforeTest
    public void beforeTest()
    {
        System.out.println("I am Before Test");
    }

    @BeforeClass
    public void beforeClass()
    {
        System.out.println("I am Before class");
    }

    @BeforeMethod
    public void BeforeMethod()
    {
        System.out.println("I am Before Method");
    }

    @Test
    public void Test()
    {
        System.out.println("I am test");
    }

    @AfterMethod
    public void AfterMethod()
    {
        System.out.println("I am After Method");
    }

    @AfterClass
    public void AfterClass()
    {
        System.out.println("I am After class");
    }

    @AfterTest
    public void AfterTest()
    {
        System.out.println("I am After Test");
    }

    @AfterSuite
    public void AfterSuite()
    {
        System.out.println("I am After Suite");
    }
}
