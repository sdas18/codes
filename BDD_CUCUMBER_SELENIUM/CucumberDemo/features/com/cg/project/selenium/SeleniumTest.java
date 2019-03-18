package com.cg.project.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\software backup\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http:\\www.google.in");
		WebElement searchElement=driver.findElement(By.name("q"));
		searchElement.sendKeys("Agile Methodlogy");
        searchElement.submit();
        
        WebElement
	}

}
