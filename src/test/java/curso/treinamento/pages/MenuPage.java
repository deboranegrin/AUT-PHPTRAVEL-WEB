package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class MenuPage {

	public MenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='#Cars']")
	private WebElement menuCars;

	@FindBy(xpath = "//a[@href='#ACCOUNTS']")
	private WebElement menuAccounts;
	
		public void clicar_menu_cars() {
		Helper.aguardar_elemento(10, menuCars);
		menuCars.click();

	}

	public boolean validar_submenu_cars(String subMenu) {

		return Helper.elemento_existe(
				Hooks.getDriver().findElement(By.xpath("//a[@href='#Cars']/following::a[text()='" + subMenu + "']")),
				10);
	}

	public void clicar_menu_accounts() {
		Helper.aguardar_elemento(10, menuAccounts);
		menuAccounts.click();

	}

	public boolean validar_submenu_accounts(String subMenu) {

		return Helper.elemento_existe(
				Hooks.getDriver().findElement(By.xpath("//a[@href='#ACCOUNTS']/following::a[text()='" + subMenu + "']")),
				10);
	}
	
	public void clicar_subMenu(String menu, String subMenu) {
		WebElement subMenu_ = Hooks.getDriver().findElement(By.xpath("//a[@href='#" + menu + "']/following::a[text()='" + subMenu + "']"));
		subMenu_.click();
	}
	
//	public void clicar_menu(String nomeMenu) {
//		Hooks.getDriver().findElement(By.xpath("//a[@href='#"+nomeMenu+"']")).click();
//	}
	
//	public boolean validar_menu(String menu, String subMenu) {
//		return Helper.elemento_existe(Hooks.getDriver().findElement(By.xpath("//a[@href='#"+menu+"']/following::a[text()='" + subMenu + "']")), 10);
//		
//	}

}
