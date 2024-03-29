package curso.treinamento.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import curso.treinamento.setup.Hooks;
import io.cucumber.datatable.DataTable;

public class Helper {

	//dataTable é uma variável
	public static List<Map<String, String>> dataTable;
	
	public static void aguardar_elemento(int timeout, WebElement elemento) {

		WebDriverWait aguardar = new WebDriverWait(Hooks.getDriver(), timeout);
		aguardar.until(ExpectedConditions.visibilityOf(elemento));

	}

	public static boolean elemento_presente(int timeout, By by) {

		try {
		
			WebDriverWait aguardar = new WebDriverWait(Hooks.getDriver(), timeout);
			aguardar.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void trocar_aba(int id_aba) {
		
		List<String> abas = new ArrayList<>(Hooks.getDriver().getWindowHandles());
		Hooks.getDriver().switchTo().window(abas.get(id_aba));
	}
	
	
	public static boolean elemento_existe(WebElement elemento, int timeout) {

		try {
			aguardar_elemento(timeout, elemento);
			
			return true;
			//return elemento.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	// dataTable_ é um parâmetro
	public static void create_datatable(DataTable dataTable_) {
		dataTable = dataTable_.asMaps(String.class, String.class);
	}
	
	
	public static void screenshot(Scenario scenario) {

		String nomeEvidencia = scenario.getName().replace(" ", "_")+ "_" + scenario.getStatus().toString() + ".jpg";

		File file = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);

		try {						
			FileUtils.copyFile(file, new File("target" + File.separator + "screenshots" + File.separator +  nomeEvidencia));
		} catch (IOException e) {
			Assert.fail("Erro na geração da evidência: " + nomeEvidencia );
		}
	}
	
	
	
//	public static String get_path_driver(String navegador) {
//		
//		switch (navegador.toUpperCase()) {
//		
//		case "CHROME";
//		
//			if(System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
//				return "src" + File.separator + "teste" + File.separator + "resources" + File.separator + "drivers" + File.separator + "chromedriver.exe";
//					
//			else
//				return "src" + File.separator + "teste" + File.separator + "resources" + File.separator + "drivers" + File.separator + "chromedriver.exe";
//		case "IE";
//		
//			break;
//		}
//		
//		Assert.fail("Opção de navegador inválida.");
//		
//		return "";
//	}
}
	
