package SampleApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

public class webtable {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","H:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       // String baseUrl = "https://stg.tallykhata.com/payment/sms-payment-history";
        String baseUrl = "https://stg.tallykhata.com/admin/login/?next=/payment/sms-payment-history";
        driver.get(baseUrl);

       // driver.wait(10);

        Thread.sleep(3000);

        WebElement username = driver.findElement(By.xpath("//*[@id=\"id_username\"]"));
        username.sendKeys("progoti_qa");

        Thread.sleep(3000);




        //driver.wait(5);
      //  driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebElement password = driver.findElement(By.xpath("//*[@id=\"id_password\"]"));
        password.sendKeys("pr0g0t1@202two");

        Thread.sleep(3000);

        //driver.wait(5);
     //   driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id=\"grp-content-container\"]/div/form/div/ul/li/input")).click();

        //WebDriverWait wait = new WebDriverWait(driver,30);
       // driver.wait(10);


        WebElement baseTable = driver.findElement(By.tagName("table"));
        WebElement l = driver.findElement(By.xpath("//*[@id=\"sms-payment-history-body\"]/div[1]/div/input"));

        l.sendKeys("01712964538");
        String val = l.getAttribute("value");
       // System.out.println("The input value: "+ val);

        Thread.sleep(3000);


        driver.findElement(By.xpath("//*[@id=\"button-addon2\"]")).click();

        Thread.sleep(3000);

        //driver.wait(10);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //To find first row of table

        WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"sms-payment-history-body\"]/div[4]/table/thead/tr/th[2]"));

        //to get first row's 2nd column data

        WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"sms-payment-history-body\"]/div[4]/table/tbody/tr[1]/td[2]"));

        String valueofcol = cellIneed.getText();


        if (val.contentEquals(valueofcol)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        driver.quit();



    }

}
