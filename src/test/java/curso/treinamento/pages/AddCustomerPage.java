package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import curso.treinamento.utils.Helper;

public class AddCustomerPage {

	public AddCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[(text()='Add Customer')]")
	private WebElement tituloPaginaAddCustomer;
	
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

	public Boolean validar_pagina_add() {
		Helper.aguardar_elemento(10, tituloPaginaAddCustomer);
		return tituloPaginaAddCustomer.isDisplayed();
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

	public void clicar_btn_Submit() {
		botaoSubmit.click();
	}

}
