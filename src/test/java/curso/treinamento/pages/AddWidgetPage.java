package curso.treinamento.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import curso.treinamento.utils.Helper;

public class AddWidgetPage {

	public AddWidgetPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//strong[(text()='Widget Content')]")
	private WebElement paginaAddWidget;

	@FindBy(xpath = "//input[@name='title']")
	private WebElement campoWidgetName;

	@FindBy(name = "status")
	private WebElement comboBoxWidgetStatus;
	
	@FindBy(xpath = "//span[@id='cke_1_top']")
	private WebElement painelWidgetContent;
	
	@FindBy(xpath = "//textarea[@name='widgetbody']")
	private WebElement campoWidgetContent;
	//html[@dir='ltr']
	
	//body[@contenteditable='true']
	
	@FindBy(xpath = "//button[contains(text(),'Add')]")
	private WebElement botaoAdd;
	

	public Boolean validar_pagina_add_widget() {
		Helper.aguardar_elemento(10, paginaAddWidget);
		return paginaAddWidget.isDisplayed();
	}

	public void preencher_widget_name(String widgetName) {
		campoWidgetName.sendKeys(widgetName);
	}
	
	public void selecionar_widget_status(String status) {
		Select combo = new Select(comboBoxWidgetStatus);
		combo.selectByVisibleText(status);
	}
	
	public Boolean validar_painel_widget_content() {
		Helper.aguardar_elemento(20, painelWidgetContent);
		return painelWidgetContent.isDisplayed();
	}
	
	public void preencher_widget_content(String widgetContent) {
		campoWidgetContent.sendKeys(widgetContent);
	}

	public void clicar_btn_Add() {
		botaoAdd.click();

	}

}
