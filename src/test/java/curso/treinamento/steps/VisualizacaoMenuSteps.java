package curso.treinamento.steps;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.HomePage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.setup.Hooks;

public class VisualizacaoMenuSteps {

	HomePage homePage = new HomePage(Hooks.getDriver());
	MenuPage menuPage = new MenuPage(Hooks.getDriver());

	@Dado("que eu esteja na tela Home")
	public void que_eu_esteja_na_tela_Home() {

		Assert.assertTrue("Pagina Home não foi apresentada.", homePage.validar_pagina());

	}

	@Quando("acesso o menu Cars")

	public void acesso_o_menu_Cars() {

		menuPage.clicar_menu_cars();

	}

	@Então("são apresentados os itens {string}, {string} e {string}")

	public void são_apresentados_os_itens_e(String subMenuCars, String subMenuExtras, String subMenuCarsSettings) {

		Assert.assertTrue("Submenu " + subMenuCars + " não apresentado.", menuPage.validar_submenu_cars(subMenuCars));
		Assert.assertTrue("Submenu " + subMenuExtras + " não apresentado.", menuPage.validar_submenu_cars(subMenuExtras));
		Assert.assertTrue("Submenu " + subMenuCarsSettings + " não apresentado.", menuPage.validar_submenu_cars(subMenuCarsSettings));

	}
	
	@Quando("acesso o menu Accounts")
	
	public void acesso_o_menu_Accounts() {
		
		menuPage.clicar_menu_accounts();
	   
	}

	@Então("são apresentados os itens {string}, {string}, {string} e {string}")
	
	public void são_apresentados_os_itens_e(String subMenuAdmins, String subMenuSuppliers, String subMenuCustomers, String subMenuGuestCustomers) {
	    
		Assert.assertTrue("Submenu " + subMenuAdmins + " não apresentado.", menuPage.validar_submenu_accounts(subMenuAdmins));
		Assert.assertTrue("Submenu " + subMenuSuppliers + " não apresentado.", menuPage.validar_submenu_accounts(subMenuSuppliers));
		Assert.assertTrue("Submenu " + subMenuCustomers + " não apresentado.", menuPage.validar_submenu_accounts(subMenuCustomers));
		Assert.assertTrue("Submenu " + subMenuGuestCustomers + " não apresentado.", menuPage.validar_submenu_accounts(subMenuGuestCustomers));
	}
	
	@Quando("acesso o menu Travelhope Hotels")
	
	public void acesso_o_menu_travelhopeHotels() {
		
		menuPage.clicar_menu_travelhopeHotels();
	   
	}

	@Então("são apresentados os itens {string} e {string}")
	
	public void são_apresentados_os_itens_e(String subMenuBookings, String subMenuSettings) {
	    
		Assert.assertTrue("Submenu " +  subMenuBookings + " não apresentado.", menuPage.validar_submenu_travelhopeHotels(subMenuBookings));
		Assert.assertTrue("Submenu " + subMenuSettings + " não apresentado.", menuPage.validar_submenu_travelhopeHotels(subMenuSettings));
	}
	
	@Quando("acesso o menu Tours")
	
	public void acesso_o_menu_tours() {
		
		menuPage.clicar_menu_tours();
	   
	}

	@Então("são apresentados os itens {string}, {string}, {string}, {string} e {string}")
	
	public void são_apresentados_os_itens_e(String subMenuTours, String subMenuAddNew, String subMenuExtras, String subMenuReviews, String subMenuSettings) {
	    
		Assert.assertTrue("Submenu " + subMenuTours + " não apresentado.", menuPage.validar_submenu_tours(subMenuTours));
		Assert.assertTrue("Submenu " + subMenuAddNew + " não apresentado.", menuPage.validar_submenu_tours(subMenuAddNew));
		Assert.assertTrue("Submenu " + subMenuExtras + " não apresentado.", menuPage.validar_submenu_tours(subMenuExtras));
		Assert.assertTrue("Submenu " + subMenuReviews + " não apresentado.", menuPage.validar_submenu_tours(subMenuReviews));
		Assert.assertTrue("Submenu " + subMenuSettings + " não apresentado.", menuPage.validar_submenu_tours(subMenuSettings));
	}
}
