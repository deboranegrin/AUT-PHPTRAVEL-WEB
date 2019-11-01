package curso.treinamento.utils;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import curso.treinamento.setup.Hooks;
import io.cucumber.datatable.DataTable;

public class JSHelper {

public static void scroll_pagina(int x, int y) {
		
	JavascriptExecutor js = (JavascriptExecutor) Hooks.getDriver()
		
	}

public static void scroll_elemento(String css, int x, int y) {
	String scriptJS = "document.querySelector"('" + css + "').scrollBy(0, 1000);
	

			

}
}