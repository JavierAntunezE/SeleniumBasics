package com.basics.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DropdownList {

	public static void main(String[] args) {

		//Variable WebDriver
		WebDriver driver;
		
		// Crea el navegador
		driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/dropdown");
		try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
		
		SeleccionaOpcioneDirectamente(driver);
		//SeleccionSimuladaPorTeclas(driver);
		
        driver.quit();
	}
	
	
	private static void SeleccionaOpcioneDirectamente(WebDriver driver) {
		
		//Selecciona el elemento DropDown
		WebElement dropdown = driver.findElement(By.id("dropdown"));
        
        Select select = new Select(dropdown);

        // Se pueden usar estas opciones:
        // select.selectByIndex(2);
        // select.selectByVisibleText("Option 2");
        // select.selectByValue("2");
        
        select.selectByVisibleText("Option 2");

        System.out.println("Opción seleccionada: " + select.getFirstSelectedOption().getText());
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
	}
	
	private static void SeleccionSimuladaPorTeclas(WebDriver driver) {
		
		//Selecciona el elemento DropDown
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        Actions actions = new Actions(driver);

        // Da foco al dropdown
        dropdown.click();
        //try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        // Presiona flecha abajo dos veces
        actions.sendKeys(dropdown, org.openqa.selenium.Keys.ARROW_DOWN).perform();
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        actions.sendKeys(dropdown, org.openqa.selenium.Keys.ARROW_DOWN).perform();

        // Confirma con ENTER si se desea seleccionar la opción actual
        actions.sendKeys(org.openqa.selenium.Keys.ENTER).perform();

        // Muestra la opción seleccionada
        System.out.println("Opción seleccionada: " + dropdown.getAttribute("value"));
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        driver.quit();
	}
	

}
