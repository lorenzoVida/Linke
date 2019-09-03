package definicionPasos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objetos.BusquedaGoogle;

public class DefinicionPasos {
	private static WebDriver driver;
	private static JavascriptExecutor js;
	private static BusquedaGoogle bgoogle;
	
	 @Given("^Initialize the browser chrome$")
	    public void initialize_the_browser_chrome() throws Throwable {
		 System.setProperty("webdriver.chrome.driver", "./Navega/Chrome/chromedriver.exe");
			driver = new ChromeDriver();
			
	    }

	    @When("^User writes \"([^\"]*)\"$")
	    public void user_writes_something(String strArg1) throws Throwable {
	    	bgoogle = new BusquedaGoogle(driver);
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			bgoogle.busquedaPruebaz().sendKeys(strArg1);

	    }

	    @Then("^Verify number of results is greater than 6$")
	    public void verify_number_of_results_is_greater_than_6() throws Throwable {
	    	String ListaResultados = bgoogle.numeroResultados().getText();
			ListaResultados = ListaResultados.substring(8);
			System.out.println(ListaResultados);
	    }

	    @And("^Navigate to \"([^\"]*)\" site$")
	    public void navigate_to_something_site(String strArg1) throws Throwable {
	    	driver.get(strArg1);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			js = (JavascriptExecutor) driver;
	    }

	    @And("^Click in Search$")
	    public void click_in_search() throws Throwable {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			bgoogle.busquedaPruebaz().submit();
	    }

	    @And("^Click in Pruebas$")
	    public void click_in_pruebas() throws Throwable {
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			bgoogle.textoPrueba().click();
	    }
	

}
