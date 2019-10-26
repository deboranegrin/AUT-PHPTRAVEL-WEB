package curso.treinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;

public class UpdateWidgetPage {

	public UpdateWidgetPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//strong[(text()='Widget Content')]")
	private WebElement paginaUpdateWidget;
	
	@FindBy(xpath = "//input[@name='title']")
	private WebElement campoWidgetName;

	@FindBy(name = "status")
	private WebElement comboBoxWidgetStatus;
	
	@FindBy(xpath = "//span[@id='cke_1_top']")
	private WebElement painelWidgetContent;
	
	@FindBy(xpath = "//textarea[@name='widgetbody']")
	private WebElement campoWidgetContent;
	
	@FindBy(xpath = "//button[contains(text(),'Update')]")
	private WebElement botaoUpdate;

	
	public Boolean validar_pagina_edit_widget() {
		Helper.aguardar_elemento(10, paginaUpdateWidget);
		return paginaUpdateWidget.isDisplayed();
	}
	
	public void limpar_campo_name() {
		WebElement name_ = Hooks.getDriver().findElement(By.xpath("//input[@name='title']"));
		name_.clear();
	}
		
	public void preencher_widget_name(String widgetName) {
		campoWidgetName.sendKeys(widgetName);
	}
	
	public void selecionar_widget_status(String status) {
		Select combo = new Select(comboBoxWidgetStatus);
		combo.selectByVisibleText(status);
	}
	
	public Boolean validar_painel_widget_content() {
		Helper.aguardar_elemento(10, painelWidgetContent);
		return painelWidgetContent.isDisplayed();
	}

	public void preencher_widget_content(String widgetContent) {
		campoWidgetContent.sendKeys(widgetContent);
	}
	
	// verificar xpath do botao update incluir aqui um scroll para ir ate botao update?

	public void clicar_btn_Update() {
		botaoUpdate.click();

	}

	public boolean validar_widget_name_na_tabela(String name) {

		WebElement valorName = Hooks.getDriver().findElement(By.xpath("//td[text()='" + name + "']"));
		return Helper.elemento_existe(valorName, 10);

	}

}
