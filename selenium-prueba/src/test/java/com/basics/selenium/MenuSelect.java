package com.basics.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MenuSelect {

	public static void main(String[] args) {

		//Variable WebDriver
		WebDriver driver;
		
		// Crea el navegador
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		
		driver.get("https://the-internet.herokuapp.com/disappearing_elements");
		try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
		
        // Lista de posibles elementos del menú
        String menuItem = "Portfolio";

        WebElement element = driver.findElement(By.linkText(menuItem));
        if (element != null) {
            System.out.println("Elemento encontrado: " + menuItem);
            element.click();
        } else {
            System.out.println("Elemento NO encontrado: " + menuItem);
        }

        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        driver.quit();
	}

}
