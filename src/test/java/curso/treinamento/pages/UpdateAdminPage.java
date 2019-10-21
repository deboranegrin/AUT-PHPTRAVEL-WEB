package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class UpdateAdminPage {

	public UpdateAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[(text()='Update Admin')]")
	private WebElement tituloPaginaUpdateAdmin;
	
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

	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement botaoSubmit;

	public Boolean validar_pagina_edit() {
		Helper.aguardar_elemento(10, tituloPaginaUpdateAdmin);
		return tituloPaginaUpdateAdmin.isDisplayed();
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
	
	public boolean validar_email_na_tabela(String email) {

		WebElement valorEmail = Hooks.getDriver().findElement(By.xpath("//td//a[text()='" + email + "']"));
		return Helper.elemento_existe(valorEmail, 10);

	}

}
