package curso.treinamento.steps;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.HomePage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.setup.Hooks;


public class VisualizacaoMenuSteps {
	
	HomePage homePage = new HomePage (Hooks.getDriver());
	MenuPage menuPage = new MenuPage (Hooks.getDriver());


@Dado("que eu esteja na tela Home")

public void que_eu_esteja_na_tela_Home() {
	Assert.assertTrue("Pagina Home não foi apresentada.", homePage.validar_pagina());

}

@Quando("acesso o menu Cars")

public void acesso_o_menu_Cars() {
	
	menuPage.clicar_menu_Cars();
	
}

@Então("são apresentados os itens {string}, {string} e {string}")

public void são_apresentados_os_itens_e(String subMenuCars, String subMenuExtras, String subMenuCarsSettings) {
	
	Assert.assertTrue("Submenu "+subMenuCars + " não apresentado.", menuPage.validar_submenu_cars(subMenuCars));
	Assert.assertTrue("Submenu "+subMenuExtras + " não apresentado.", menuPage.validar_submenu_cars(subMenuExtras));
	Assert.assertTrue("Submenu "+subMenuCarsSettings + " não apresentado.", menuPage.validar_submenu_cars(subMenuCarsSettings));
   
}
}
