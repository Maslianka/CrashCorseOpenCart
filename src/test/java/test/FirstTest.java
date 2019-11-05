package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver driver;

    @BeforeClass
    public void openURL() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Nazar/.m2/repository/webdriver/chromedriver/win32/77.0.3865.40/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://demo.opencart.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @Test
    public void testVerifyAddingToCart() {

        WebElement contactUslabel = driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]"));
        contactUslabel.click();
        WebElement nameFild = driver.findElement(By.id("input-name"));
        nameFild.sendKeys("Bob");
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("bo@gmail.com");
        WebElement enquiry = driver.findElement(By.id("input-enquiry"));
        enquiry.sendKeys("Hi I am Bob Marley");
        WebElement submit = driver.findElement(By.xpath("//input[contains(@class,'btn')]"));
        submit.click();
        WebElement continueBtn = driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
        String actualResalt = continueBtn.getText();

        Assert.assertEquals(actualResalt, "Continue");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
