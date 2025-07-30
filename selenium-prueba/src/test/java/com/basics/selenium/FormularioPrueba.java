package com.basics.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FormularioPrueba {

	public static void main(String[] args) {

		//Variable WebDriver
		WebDriver driver;
		
		// Crea el navegador		
		FirefoxOptions options = new FirefoxOptions();
	    driver = new FirefoxDriver(options);
		    
	    //Abrir página
	    driver.get("https://formy-project.herokuapp.com/form");
	    try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
	    
	    // Texto
        driver.findElement(By.id("first-name")).sendKeys("Juan");
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        driver.findElement(By.id("last-name")).sendKeys("Pérez");
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        // Radio button
        driver.findElement(By.id("radio-button-2")).click();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        // Checkbox
        driver.findElement(By.id("checkbox-1")).click();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        // Dropdown (Select)
        WebElement select = driver.findElement(By.id("select-menu"));
        select.click();
        driver.findElement(By.xpath("//option[text()='5-9']")).click();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        // Date picker
        driver.findElement(By.id("datepicker")).sendKeys("07/22/2025");
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        // Submit
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        
        driver.quit();
                
	}

}
