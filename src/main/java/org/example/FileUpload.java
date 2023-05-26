package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[3]/div[4]")).click();
driver.wait(3000);
////span[contains(text(), 'завантажте файл  ')]/self::span
        WebElement uploadbtn = driver.findElement(By.xpath("//span[@class = 'DV7the']"));
        String FilePath = "\"C:\\IdeaProjects\\minnie.png\"";
        uploadbtn.sendKeys(FilePath);
        driver.findElement(By.xpath("//body/c-wiz[1]/div[1]/div[2]/div[1]/c-wiz[1]/div[1]/div[2]/c-wiz[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]")).click();
    }
}
