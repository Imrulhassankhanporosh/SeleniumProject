package SampleApp;

import org.openqa.selenium.WebDriver;

//contains the WebDriver class needed to instantiate a new browser loaded with a specific driver

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//contains the FirefoxDriver class needed to instantiate a Firefox-specific driver onto the browser instantiated by the WebDriver class

public class WebDriverScript {
    public static void main(String[] args) {

        // declaration and instantiation of objects/variables

       System.setProperty("webdriver.chrome.driver","H:\\chromedriver.exe");
       WebDriver driver = new ChromeDriver();

        //comment the above 2 lines and uncomment below 2 lines to use Firefox

        //System.setProperty("webdriver.gecko.driver","H:\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        //String baseUrl = "http://demo.guru99.com/test/newtours/";
        //String baseUrl = "http://www.google.com";


        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        // launch Fire fox and direct it to the Base URL
        // driver.get(baseUrl);
       // driver.get("http://www.google.com");
        driver.quit();
    }
}
