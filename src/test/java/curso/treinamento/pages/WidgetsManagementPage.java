package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class WidgetsManagementPage {

	public WidgetsManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Widgets Management']")
	private WebElement tituloPaginaWidgets;

	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement btnAdd;
	
	@FindBy(xpath ="//button[contains(text(),'All')]")
	private WebElement btnAll;
	

	public void clicar_btn_Add() {
		btnAdd.click();
	}

	public boolean validar_pagina_widgets() {

		return Helper.elemento_existe(tituloPaginaWidgets, 10);
	}
	
	public void clicar_btn_All() {
		btnAll.click();
	}

	public boolean validar_widget_name_na_tabela(String name) {

		WebElement valorName = Hooks.getDriver().findElement(By.xpath("//td[text()='" + name + "']"));
		return Helper.elemento_existe(valorName, 10);

	}

	public void clicar_btn_edit_widgets(String name) {
		WebElement btnEdit = Hooks.getDriver()
				.findElement(By.xpath("//td[text()='" + name + "']/following::a[@title='Edit']"));
		btnEdit.click();

	}
	
	public void clicar_btn_delete_widgets(String name) {
		WebElement btnDelete = Hooks.getDriver()
				.findElement(By.xpath("//td[text()='" + name + "']/following::a[@title='Remove']"));
		btnDelete.click();

	}

	public void remover_widget() {
		Hooks.getDriver().switchTo().alert().accept();

	}

	public String get_mensagem_widget() {
		
		if(Helper.elemento_presente(10, By.xpath("//h4[text()='Changes Saved!']")))
			return "Changes Saved!";
		
		return "";
	}
}