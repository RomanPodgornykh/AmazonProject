package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Calendar {
    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(co);
        driver.get("https://www.spicejet.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("(//div[@class='css-76zvg2 css-bfa6kz r-homxoj r-ubezar'])[1]")).click(); //open calendar
        while (!driver.findElement(By.xpath("//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79']")).getText().contains("July")) {
            driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[3]/div[2]/div[4]/div/div[2]/div[2]/div[1]/svg/g/circle")).click();
        }
        int count = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).size();
        for (int i=0;i<count;i++){
            String text = driver.findElements(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).get(i).getText();
            if (text.equalsIgnoreCase("21")){
                driver.findElements(By.xpath("//div[@class='css-76zvg2 r-jwli3a r-ubezar r-16dba41']")).get(i).click();
            }
        }
    }
}