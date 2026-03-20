package com.selenium.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

public class TestPro {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {

            System.setProperty("webdriver.chrome.driver",
            "D:\\downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

            driver = new ChromeDriver();

            driver.get("file:///C:/Users/MANASVI/Desktop/Devops Lab/index.html");

            driver.manage().window().maximize();

            driver.findElement(By.id("name")).sendKeys("Manasvi");

            driver.findElement(By.id("email")).sendKeys("manasvi@gmail.com");

            driver.findElement(By.id("mobile")).sendKeys("9876543210");

            driver.findElement(By.id("department")).sendKeys("Computer Science");

            driver.findElement(By.xpath("//input[@value='Female']")).click();

            driver.findElement(By.id("feedback")).sendKeys(
            "I really like its design and validation was all correct. I am satisfied with the form."
            );

            driver.findElement(By.cssSelector("input[type='submit']")).click();

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();

            System.out.println("Alert Message: " + alertText);

            if(alertText.contains("Form submitted successfully")){
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

            alert.accept(); // close alert

        } 
        catch(Exception e) {

            System.out.println("TEST FAILED");
            e.printStackTrace();

        } 
        finally {

            if(driver != null) {
                driver.quit();
            }

        }
    }
}