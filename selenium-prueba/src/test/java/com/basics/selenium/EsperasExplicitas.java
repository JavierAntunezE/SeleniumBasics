package com.basics.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsperasExplicitas {

	public static void main(String[] args) {

		//Variable WebDriver
		WebDriver driver;
		
		// Crea el navegador
		driver = new ChromeDriver();
		
		try {
            // Navegar a la página
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");
            Thread.sleep(2000);
            
            // Esperador explícito
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Hacer clic en el botón "Enable"
            WebElement enableButton = driver.findElement(By.xpath("//form[@id='input-example']/button"));
            enableButton.click();

            // Esperar a que el input esté habilitado
            WebElement inputField = driver.findElement(By.xpath("//form[@id='input-example']/input"));
            wait.until(ExpectedConditions.elementToBeClickable(inputField));

            // Escribir texto en el campo habilitado
            inputField.sendKeys("Texto automático");

            // Esperar un par de segundos para visualizar el resultado
            Thread.sleep(1000);
            
            //Se vuelve a dar clic en el boton para deshabilitarlo
            enableButton.click();
            
            // Esperar a que el input esté deshabilitado
            //espera explícita con una expresión lambda
            wait.until(driver_ -> inputField.isEnabled() == false);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el navegador
            driver.quit();
        }
	}

}
