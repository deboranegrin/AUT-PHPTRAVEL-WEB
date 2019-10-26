package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class CustomersManagementPage {

	public CustomersManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Customers Management']")
	private WebElement tituloPaginaCustomers;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement btnAdd;

	@FindBy(xpath = "//button[contains(text(),'All')]")
	private WebElement btnAll;

	@FindBy(xpath = "//a[text()='No, I do not want an improved experience.']")
	private WebElement btnExperience;

	public void clicar_btn_Add() {
		btnAdd.click();

	}

	public boolean validar_pagina_customers() {

		return Helper.elemento_existe(tituloPaginaCustomers, 10);

	}

	public void fechar_msg_Experience() {
		btnExperience.click();

	}

	public boolean validar_email_na_tabela(String email) {

		WebElement valorEmail = Hooks.getDriver().findElement(By.xpath("//td//a[text()='" + email + "']"));
		return Helper.elemento_existe(valorEmail, 10);

	}

	public String encontrar_customer_edit(String email) {

		if (Helper.elemento_presente(10, By.xpath("//a[text()='" + email
				+ "']/following::a[@href='https://phptravels.net/admin/accounts/customers/edit/219']")))
			return "Cliente encontrado!";

		return "";

//		a[@title='Edit']
	}

	public void clicar_btn_edit_customers(String email) {

		WebElement btnEdit = Hooks.getDriver()
				.findElement(By.xpath("//a[@href='https://phptravels.net/admin/accounts/customers/edit/219']"));

		JavascriptExecutor jse = (JavascriptExecutor) Hooks.getDriver();
		jse.executeScript("arguments[0].scrollIntoView(); window.scrollBy(0, -90)", btnEdit);

		btnEdit.click();
	}

	public void clicar_btn_All() {
		btnAll.click();

	}

	public String encontrar_customer_remove(String email) {

		if (Helper.elemento_presente(10, By.xpath("//a[text()='" + email + "']/following::a[@title='DELETE']")))
			return "Cliente encontrado!";

		return "";

	}

	public void clicar_btn_delete_customers(String email) {
		WebElement btnDelete = Hooks.getDriver()
				.findElement(By.xpath("//a[text()='" + email + "']/following::a[@title='DELETE']"));

		JavascriptExecutor jse = (JavascriptExecutor) Hooks.getDriver();
		jse.executeScript("arguments[0].scrollIntoView(); window.scrollBy(0, -90)", btnDelete);

		btnDelete.click();

	}

	public void remover_customer() {
		Hooks.getDriver().switchTo().alert().accept();

	}

	public String get_mensagem_customer() {

		if (Helper.elemento_presente(20, By.xpath("//h4[text()='Changes Saved!']")))
			return "Changes Saved!";

		return "";
	}
}