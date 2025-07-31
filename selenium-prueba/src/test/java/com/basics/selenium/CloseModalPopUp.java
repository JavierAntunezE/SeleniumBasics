package com.basics.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseModalPopUp {

	public static void main(String[] args) {

		//Variable WebDriver
		WebDriver driver;
		
		// Crea el navegador
		//LEVANTA EL NAVEGADOR
		driver = new ChromeDriver();
				
		driver.get("https://the-internet.herokuapp.com/entry_ad");

        // Espera breve para que el modal se cargue
        try { Thread.sleep(2000); } catch (InterruptedException ignored) {}

        // Verifica si el modal está presente
        WebElement modal = driver.findElement(By.id("modal"));
        if (modal.isDisplayed()) {
            System.out.println("Modal visible. Cerrando...");

            // Clic en el botón "Close"
            //WebElement closeButton = driver.findElement(By.cssSelector(".modal-footer > p"));
            WebElement closeButton = driver.findElement(By.xpath("//div[3]/p"));
            closeButton.click();
        } else {
            System.out.println("No se detectó el modal.");
        }
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        driver.quit();
        System.out.println("Se cierra el navegador");
	}

}
