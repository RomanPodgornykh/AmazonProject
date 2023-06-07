package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileUpload2 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//div[@class='nDcEnd']")).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        //WebElement uploadbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='DV7the']"))); //Upload button wait
        //uploadbtn.click();
        String FilePath = "https://drive.google.com/file/d/1SK7qLjLYszQ5Ul9Wsuh2qq83FsrmJokq/view?usp=share_link"; //Link to file for search
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
        WebElement imagelinkfield = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='cB9M7']"))); //wait till image link field load
        imagelinkfield.sendKeys("https://plus.unsplash.com/premium_photo-1680740103993-21639956f3f0?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=388&q=80");
        driver.findElement(By.xpath("//div[@class='Qwbd3']")).click();
    }
}