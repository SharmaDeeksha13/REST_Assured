import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SubClassUpcastingDownCasting extends UpcastingDownCasting{

    // Here we have one common variable(String) and one common method
    // Here we have one unique variable (Integer) and one unique method

    int i=10;;
    String s1="Child class String";


    public void child1()
    {
        System.out.println("I Am child1 method");
    }

    public void method1()
    {
        System.out.println("I Am method1 from child class");
    }


  @Test
    public void execution()
  {
      SubClassUpcastingDownCasting obj1= new SubClassUpcastingDownCasting();
//      obj1.parent1();
//      System.out.println(obj1.s1);



      UpcastingDownCasting obj2= new UpcastingDownCasting();
//      System.out.println(obj2.s1);
      obj2.method1();



      // upcasting :

      UpcastingDownCasting obj3= new SubClassUpcastingDownCasting();
//      obj3.method1();



      // Downcasting

     // SubClassUpcastingDownCasting obj4= new UpcastingDownCasting();  // Converted as below
      UpcastingDownCasting obj4= new SubClassUpcastingDownCasting();
     SubClassUpcastingDownCasting obj5= ( SubClassUpcastingDownCasting) obj4;


//     obj4.method1();


    String s1 ="123";
    int j= 567;

    // String to Integer

      System.out.println(Integer.parseInt("123"));

      // Integer to String
String s2= Integer.toString(567);
String s3=String.valueOf(567);
      System.out.println(s2 +" " + s3);


      String s5= "America @345      123$";
      System.out.println(s5.replaceAll("\\W ",""));
      System.out.println(s5.trim());







      SubClassUpcastingDownCasting o1= new SubClassUpcastingDownCasting();






  }




}
