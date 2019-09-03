package Busqueda.Google;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objetos.BusquedaGoogle;


public class Search {
	private static WebDriver driver;
	
	private static JavascriptExecutor js;
	private static BusquedaGoogle bgoogle;
	
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./Navega/Chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com.pe");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		js = (JavascriptExecutor) driver;
		
	}
	
	@Test
	public void DigitarPruebas() throws InterruptedException {
		bgoogle = new BusquedaGoogle(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		bgoogle.busquedaPruebaz().sendKeys("pruebaz");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		bgoogle.busquedaPruebaz().submit();
		

	}
	
	
	@Test(dependsOnMethods = { "DigitarPruebas" })
	public void ValidarPalabra() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bgoogle.textoPrueba().getText();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		System.out.println(bgoogle.textoPrueba().getText());
		
	}
	
	@Test(dependsOnMethods = { "ValidarPalabra" })
	public void ClickSobrePalabra() {
		bgoogle.textoPrueba().click();
		
	}
	
	@Test(dependsOnMethods = { "ClickSobrePalabra" })
	public void ObtenerListaResultados() {
		String ListaResultados = bgoogle.numeroResultados().getText();
		ListaResultados = ListaResultados.substring(8);
		System.out.println(ListaResultados);
	}
}
