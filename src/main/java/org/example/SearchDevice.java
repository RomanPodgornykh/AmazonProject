package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchDevice {
    public WebDriver driver;

    @BeforeMethod
    public void SetUp() throws InterruptedException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\chromedriver.exe");
        this.driver = new ChromeDriver(co);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();   //Browser setup and open homepage
    }
        @Test
        public void checkdevice () {

            System.out.println(driver.getTitle() + " =This is my title");
            String currentURL = "https://www.amazon.com/";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, currentURL);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Google Pixel 6a");
            driver.findElement(By.id("nav-search-submit-button")).click();

            WebElement successfulmsg= driver.findElement(By.xpath("//span[contains(text(),'\"Google Pixel 6a\"')]"));
            String expectedmsg="Google Pixel 6a";
            String actualmsg=successfulmsg.getText();
            Assert.assertTrue(actualmsg.contains(expectedmsg), "doesn't contain expectedmsg");
            driver.quit();     //Test check if correct results were shown
        }


    }
