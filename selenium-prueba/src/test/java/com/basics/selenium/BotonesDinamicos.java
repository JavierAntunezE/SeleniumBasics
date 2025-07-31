package com.basics.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BotonesDinamicos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Variable WebDriver
		WebDriver driver;
		
		// Crea el navegador
		driver = new ChromeDriver();
				
		

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Agrega 5 botones "Delete"
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        for (int i = 0; i < 5; i++) {
            addButton.click();
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        }

        // Espera breve (opcional) para asegurar que los botones se hayan renderizado
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        // Encuentra todos los botones "Delete" y haz clic en ellos uno por uno
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
            try { Thread.sleep(500); } catch (InterruptedException e) {}
        }
        System.out.println("****Prueba GIT****");

        driver.quit();
        
	}

}
