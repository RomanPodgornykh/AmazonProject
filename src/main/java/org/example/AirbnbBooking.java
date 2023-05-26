package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AirbnbBooking {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.airbnb.com/");
        driver.manage().window().maximize();
        driver.wait(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;


        driver.findElement(By.xpath("//span[@class = 'c1m2z0bj dir dir-ltr']")).click();
    }
}
