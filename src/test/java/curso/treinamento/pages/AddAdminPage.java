package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class AddAdminPage {

	public AddAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[(text()='Add Admin')]")
	private WebElement tituloPaginaAddAdmin;
	
	@FindBy(name = "fname")
	private WebElement campoFirstName;

	@FindBy(name = "lname")
	private WebElement campoLastName;

	@FindBy(name = "email")
	private WebElement campoEmail;

	@FindBy(name = "password")
	private WebElement campoPassword;

	@FindBy(name = "mobile")
	private WebElement campoMobileNumber;

	@FindBy(name = "country")
	private WebElement comboBoxCountry;

	@FindBy(name = "address1")
	private WebElement campoAddress1;

	@FindBy(name = "address2")
	private WebElement campoAddress2;

	@FindBy(name = "status")
	private WebElement comboBoxStatus;
	
	@FindBy(xpath = "//div[text()='×']")
	private WebElement btnCloseNeedHelp;
	
	@FindBy(xpath = "//img[@alt='Chat now']")
	private WebElement imgChatNow;
	
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement botaoSubmit;
	
//	Preferência por reutilizar o xpath para o Add, Remove e Edit
//	@FindBy(xpath = "//div[(text()='Add')]//following::label[contains(.,'Hotels')][1]")
//	private WebElement tituloCampoAdd;


	public Boolean validar_pagina_add() {
		Helper.aguardar_elemento(10, tituloPaginaAddAdmin);
		return tituloPaginaAddAdmin.isDisplayed();
	}
	
	public void clicar_fechar_need_help() {
		
		if(Helper.elemento_existe(imgChatNow, 5)) {
			Actions builder = new Actions(Hooks.getDriver());
			Action mouseOverHome = builder.moveToElement(imgChatNow).build();
		
			mouseOverHome.perform();
			
			btnCloseNeedHelp.click();
		}
	}
	
	public void preencher_first_name(String firstName) {
		campoFirstName.sendKeys(firstName);
	}

	public void preencher_last_name(String lastName) {
		campoLastName.sendKeys(lastName);
	}

	public void preencher_email(String email) {
		campoEmail.sendKeys(email);
	}

	public void preencher_password(String password) {
		campoPassword.sendKeys(password);
	}

	public void preencher_mobile_number(String mobileNumber) {
		campoMobileNumber.sendKeys(mobileNumber);
	}

	public void selecionar_country(String country) {

//		Pode usar esse método comentado ou o abaixo (tanto faz)
//		Select combo = new Select(comboBoxCountry);
//		combo.selectByVisibleText(country);

		new Select(comboBoxCountry).selectByVisibleText(country);
	}

	public void preencher_address1(String address1) {
		campoAddress1.sendKeys(address1);
	}

	public void preencher_address2(String address2) {
		campoAddress2.sendKeys(address2);
	}

	public void selecionar_status(String status) {
		new Select(comboBoxStatus).selectByVisibleText(status);
	}

	public void selecionar_add(String add) {
		Hooks.getDriver().findElement(By.xpath("//div[(text()='Add')]//following::label[contains(.,'" + add + "')][1]"))
				.click();
	}

	public void selecionar_edit(String edit) {
		Hooks.getDriver()
				.findElement(
						By.xpath("//div[contains(text(),'Edit')]//following::label[contains(.,'" + edit + "')][1]"))
				.click();
	}

	public void selecionar_remove(String remove) {
		Hooks.getDriver()
				.findElement(By.xpath("//div[(text()='Remove')]//following::label[contains(.,'" + remove + "')][1]"))
				.click();
	}

	public void clicar_btn_Submit() {
		botaoSubmit.click();

	}

}
