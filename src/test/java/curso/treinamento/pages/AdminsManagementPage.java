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
}
