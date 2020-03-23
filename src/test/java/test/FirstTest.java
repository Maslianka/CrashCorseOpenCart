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
    //comment

    @Test
    public void testVerifyAddingToCart() {
        WebElement searchField = driver.findElement(new By.ByXPath("//input[contains(@class,'input-lg')]"));
        searchField.sendKeys("iPhone");
        WebElement searchButton = driver.findElement(By.xpath("//button/i[contains(@class,'fa-search')]"));
        searchButton.click();
        WebElement buttonaAddToCart = driver.findElement(By.xpath("//button/span[contains(text(),'Add to Cart')]"));
        buttonaAddToCart.click();
        WebElement shoppingCartLabel =driver.findElement (By.xpath("//span[contains(text(),'Shopping Cart')]"));
        shoppingCartLabel.click();
        WebElement nameOnGrid = driver.findElement(By.cssSelector(".text-left span.text-danger"));
        String actualResult = nameOnGrid.getText();


        Assert.assertEquals(actualResult, "Iphone");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
