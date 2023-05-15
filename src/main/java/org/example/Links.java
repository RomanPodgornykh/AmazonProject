package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Links {
    //public WebDriver driver;

    public static void main(String[] args) {

            ChromeOptions co = new ChromeOptions();
            co.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.chrome.driver", "C:\\IdeaProjects\\chromedriver.exe");
            WebDriver driver = new ChromeDriver(co);
            driver.get("https://www.google.com/");
            driver.findElement(By.cssSelector("#APjFqb")).sendKeys("Amazon");
            driver.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[4]/center[1]/input[1]")).click();
            driver.findElement(By.xpath("//h3[contains(text(),'Amazon.com. Spend less. Smile more.')]")).click();  //Annoying Amazon captcha
            driver.manage().window().maximize();   //Browser setup and open homepage

            List<WebElement> links = driver.findElements(By.tagName("a"));
            System.out.println(links.size());    //Links quantity

            for(WebElement link:links){
                String url = link.getAttribute("href");
                System.out.println(url);
                if(url == null || url.isEmpty()){
                    System.out.println("URL is empty");
                    continue;

                }


                HttpURLConnection huc;
                try {
                    huc = (HttpURLConnection)(new URL(url).openConnection());
                    huc.connect();
                    if(huc.getResponseCode()>=400){
                        System.out.println(url +" "+"URL is broken");    //Broken links list
                    }
                    else {
                        System.out.println(url +" "+"URL is valid");     //Valid links list
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
                driver.quit();
    }



}
