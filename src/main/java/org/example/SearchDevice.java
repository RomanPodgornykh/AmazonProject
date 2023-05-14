package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchDevice {
    public WebDriver driver;

    @BeforeMethod
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }
        @Test
        public void checkdevice () {
            WebDriver driver = new ChromeDriver();
            System.out.println(driver.getTitle() + " =This is my title");
            String currentURL = "https://www.amazon.com/";
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, currentURL);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Google Pixel 6a");
            driver.findElement(By.id("nav-search-submit-button")).click();
        }
    }
