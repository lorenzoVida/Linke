package objetos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BusquedaGoogle {

	WebDriver driver;
	
	public BusquedaGoogle(WebDriver driver) {
		this.driver = driver;
	}
	
	By busquedaPruebaz = By.xpath("//input[@name='q']");
	By btnBuscar = By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']");
	By textoPrueba = By.xpath("//i[contains(text(),'pruebas')]");
	By numeroResultados = By.xpath("//div[@id='resultStats']");
	
	public WebElement numeroResultados() {
		return driver.findElement(numeroResultados);
	}
	
	public WebElement busquedaPruebaz() {
		return driver.findElement(busquedaPruebaz);
	}
	
	public WebElement btnBuscar() {
		return driver.findElement(btnBuscar);
	}
	
	public WebElement textoPrueba() {
		return driver.findElement(textoPrueba);
	}

}
