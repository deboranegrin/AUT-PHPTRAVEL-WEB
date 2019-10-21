package curso.treinamento.pages;

import org.openqa.selenium.By;
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
	private WebElement tituloPagina;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement btnAdd;

	@FindBy(xpath = "//a[@title='Edit']")
	private WebElement btnEdit;
	
	@FindBy(xpath = "//a[@title='DELETE']")
	private WebElement btnDelete;

	public void clicar_btn_Add() {
		btnAdd.click();

	}

	public boolean validar_pagina() {

		return Helper.elemento_existe(tituloPagina, 10);

	}

	public boolean validar_email_na_tabela(String email) {

		WebElement valorEmail = Hooks.getDriver().findElement(By.xpath("//td//a[text()='" + email + "']"));
		return Helper.elemento_existe(valorEmail, 10);

	}

	public void clicar_btn_Edit() {
		btnEdit.click();

	}

	public void limpar_campos(String campo) {
		WebElement campo_ = Hooks.getDriver().findElement(By.xpath("//input[@name='" + campo + "']"));
		campo_.clear();
	}
	
	public void clicar_btn_Delete() {
		btnDelete.click();

	}

}