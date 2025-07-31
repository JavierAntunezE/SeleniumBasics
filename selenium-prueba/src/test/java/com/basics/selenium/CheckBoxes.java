package com.basics.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxes {

	public static void main(String[] args) {

		//Variable WebDriver
		WebDriver driver;
		
		//System.setProperty("webdriver.chrome.driver", "ruta/al/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
		
		// Crea el navegador
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		try { Thread.sleep(2000); } catch (InterruptedException ignored) {}
		
        // Encuentra todos los checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

        // Itera sobre cada checkbox y alterna su estado
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click(); // Selecciona si no está seleccionado
                try { Thread.sleep(500); } catch (InterruptedException ignored) {}
            }
        }

        // Espera breve para ver el resultado (opcional)
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}

        driver.quit();
	}

}
