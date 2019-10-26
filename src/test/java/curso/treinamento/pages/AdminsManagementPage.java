package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class AdminsManagementPage {

	public AdminsManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Admins Management']")
	private WebElement tituloPagina;

	@FindBy(xpath = "//button[contains(text(),' Add')]")
	private WebElement btnAdd;
	
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

	public void clicar_btn_Edit(String email) {
		WebElement btnEdit = Hooks.getDriver()
				.findElement(By.xpath("//a[text()='" + email + "']/following::a[@title='Edit']"));
		btnEdit.click();

	}
	
	public void clicar_btn_delete(String email) {
		WebElement btnDelete = Hooks.getDriver()
				.findElement(By.xpath("//a[text()='" + email + "']/following::a[@title='DELETE']"));
		btnDelete.click();

	}

	public void remover_admin() {
		Hooks.getDriver().switchTo().alert().accept();

	}

	public String get_mensagem() {
		
		if(Helper.elemento_presente(10, By.xpath("//h4[text()='Changes Saved!']")))
			return "Changes Saved!";
		
		return "";
	}
}