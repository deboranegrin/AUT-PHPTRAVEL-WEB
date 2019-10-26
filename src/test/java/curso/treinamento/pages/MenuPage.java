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

	@FindBy(xpath = "//a[@href='#TravelhopeHotels']")
	private WebElement menuTravelhopeHotels;

	@FindBy(xpath = "//a[@href='#Tours']")
	private WebElement menuTours;

	@FindBy(xpath = "//a[contains(text(),'General')]")
	private WebElement menuGeneral;

	public void clicar_menu_cars() {
		Helper.aguardar_elemento(10, menuCars);
		menuCars.click();

	}

	public void clicar_menu_accounts() {
		Helper.aguardar_elemento(10, menuAccounts);
		menuAccounts.click();

	}

	public void clicar_menu_travelhopeHotels() {
		Helper.aguardar_elemento(10, menuTravelhopeHotels);
		menuTravelhopeHotels.click();

	}

	public void clicar_menu_tours() {
		Helper.aguardar_elemento(10, menuTours);
		menuTours.click();

	}
	
	public void clicar_menu_general() {
		Helper.aguardar_elemento(10, menuGeneral);
		menuGeneral.click();

	}

	public boolean validar_submenu_cars(String subMenu) {

		return Helper.elemento_existe(
				Hooks.getDriver().findElement(By.xpath("//a[@href='#Cars']/following::a[text()='" + subMenu + "']")),
				10);
	}

	public boolean validar_submenu_accounts(String subMenu) {

		return Helper.elemento_existe(Hooks.getDriver()
				.findElement(By.xpath("//a[@href='#ACCOUNTS']/following::a[text()='" + subMenu + "']")), 10);
	}

	public boolean validar_submenu_travelhopeHotels(String subMenu) {

		return Helper.elemento_existe(Hooks.getDriver()
				.findElement(By.xpath("//a[@href='#TravelhopeHotels']/following::a[text()='" + subMenu + "']")), 10);
	}

	public boolean validar_submenu_tours(String subMenu) {

		return Helper.elemento_existe(
				Hooks.getDriver().findElement(By.xpath("//a[@href='#Tours']/following::a[text()='" + subMenu + "']")),
				10);
	}
	
	public boolean validar_submenu_general(String subMenu) {

		return Helper.elemento_existe(
				Hooks.getDriver().findElement(By.xpath("//a[contains(text(),'General')]/following::a[text()='" + subMenu + "']")),
				10);
	}
	

	public void clicar_subMenu(String menu, String subMenu) {
		WebElement subMenu_ = Hooks.getDriver()
				.findElement(By.xpath("//a[@href='#" + menu + "']/following::a[text()='" + subMenu + "']"));
		subMenu_.click();
	}
	
	public void clicar_subMenu_general(String menu, String subMenu) {
		WebElement subMenuGeneral_ = Hooks.getDriver()
				.findElement(By.xpath("//a[contains(text(),'" + menu + "')]/following::a[text()='" + subMenu + "']"));
		subMenuGeneral_.click();
	}
	

// Poderia ser feito dessa forma:

//	public void clicar_menu(String nomeMenu) {
//		Hooks.getDriver().findElement(By.xpath("//a[@href='#"+nomeMenu+"']")).click();
//	}

//	public boolean validar_menu(String menu, String subMenu) {
//		return Helper.elemento_existe(Hooks.getDriver().findElement(By.xpath("//a[@href='#"+menu+"']/following::a[text()='" + subMenu + "']")), 10);
//		
//	}

}
