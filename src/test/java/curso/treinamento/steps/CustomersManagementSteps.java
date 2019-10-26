package curso.treinamento.steps;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.AddCustomerPage;
import curso.treinamento.pages.CustomersManagementPage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.pages.UpdateCustomerPage;
import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;
import io.cucumber.datatable.DataTable;

public class CustomersManagementSteps {

	MenuPage menuPage = new MenuPage(Hooks.getDriver());
	CustomersManagementPage customersManagementPage = new CustomersManagementPage(Hooks.getDriver());
	AddCustomerPage addCustomerPage = new AddCustomerPage(Hooks.getDriver());
	UpdateCustomerPage updateCustomerPage = new UpdateCustomerPage(Hooks.getDriver());

	@Dado("que eu esteja na tela Customers Management")
	public void que_eu_esteja_na_tela_Customers_Management() {

		menuPage.validar_submenu_general("Customers");
		menuPage.clicar_subMenu("ACCOUNTS", "Customers");

		Assert.assertTrue("Página Customers Management NÃO apresentada.",
				customersManagementPage.validar_pagina_customers());
	}

	@Quando("incluo um cliente")
	public void incluo_um_cliente(DataTable dataTable_) {

		customersManagementPage.clicar_btn_Add();

		Assert.assertTrue("Página Add Customer NÃO apresentada.", addCustomerPage.validar_pagina_add_customer());

		Helper.create_datatable(dataTable_);

		addCustomerPage.preencher_first_name(Helper.dataTable.get(0).get("First Name"));
		addCustomerPage.preencher_last_name(Helper.dataTable.get(0).get("Last Name"));
		addCustomerPage.preencher_email(Helper.dataTable.get(0).get("Email"));
		addCustomerPage.preencher_password(Helper.dataTable.get(0).get("Password"));
		addCustomerPage.preencher_mobile_number(Helper.dataTable.get(0).get("Mobile Number"));
		addCustomerPage.selecionar_country(Helper.dataTable.get(0).get("Country"));
		addCustomerPage.preencher_address1(Helper.dataTable.get(0).get("Address 1"));
		addCustomerPage.preencher_address2(Helper.dataTable.get(0).get("Address 2"));
		addCustomerPage.selecionar_status(Helper.dataTable.get(0).get("Status"));
		addCustomerPage.clicar_btn_Submit();
	}

	@Então("cliente cadastrado com sucesso")
	public void cliente_cadastrado_com_sucesso() {

		Assert.assertTrue("Cliente não cadastrado com sucesso.",
				customersManagementPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email")));

	}

	@Quando("altero as informacoes do cliente")
	public void altero_as_informacoes_do_cliente(DataTable dataTable_) {

		Helper.create_datatable(dataTable_);

		customersManagementPage.fechar_msg_Experience();
		customersManagementPage.clicar_btn_All();
		customersManagementPage.encontrar_customer_edit(Helper.dataTable.get(0).get("Email"));
		customersManagementPage.clicar_btn_edit_customers(Helper.dataTable.get(0).get("Email"));
		
		Assert.assertTrue("Página Update Customer NÃO apresentada.", updateCustomerPage.validar_pagina_edit_customer());

		updateCustomerPage.limpar_campos("fname");
		updateCustomerPage.preencher_first_name(Helper.dataTable.get(1).get("First Name"));
		updateCustomerPage.limpar_campos("lname");
		updateCustomerPage.preencher_last_name(Helper.dataTable.get(1).get("Last Name"));
		updateCustomerPage.limpar_campos("email");
		updateCustomerPage.preencher_email(Helper.dataTable.get(1).get("Email"));
		updateCustomerPage.limpar_campos("password");
		updateCustomerPage.preencher_password(Helper.dataTable.get(1).get("Password"));
		updateCustomerPage.limpar_campos("mobile");
		updateCustomerPage.preencher_mobile_number(Helper.dataTable.get(1).get("Mobile Number"));
		updateCustomerPage.selecionar_country(Helper.dataTable.get(1).get("Country"));
		updateCustomerPage.limpar_campos("address1");
		updateCustomerPage.preencher_address1(Helper.dataTable.get(1).get("Address 1"));
		updateCustomerPage.limpar_campos("address2");
		updateCustomerPage.preencher_address2(Helper.dataTable.get(1).get("Address 2"));
		updateCustomerPage.selecionar_status(Helper.dataTable.get(1).get("Status"));
		updateCustomerPage.clicar_btn_Submit();

	}

	@Então("cliente alterado com sucesso")
	public void cliente_alterado_com_sucesso() {
		
		customersManagementPage.clicar_btn_All();

		Assert.assertTrue("Cliente não alterado com sucesso.",
				updateCustomerPage.validar_email_na_tabela(Helper.dataTable.get(1).get("Email")));
	}

	@Quando("excluo um cliente")
	public void excluo_um_cliente(DataTable dataTable_) {

		Helper.create_datatable(dataTable_);

		customersManagementPage.fechar_msg_Experience();
		customersManagementPage.clicar_btn_All();
		customersManagementPage.encontrar_customer_remove(Helper.dataTable.get(0).get("Email"));
		customersManagementPage.clicar_btn_delete_customers(Helper.dataTable.get(0).get("Email"));
		customersManagementPage.remover_customer();
		customersManagementPage.clicar_btn_All();

		Assert.assertEquals("Changes Saved!", customersManagementPage.get_mensagem_customer());

	}

	@Então("cliente excluido com sucesso")
	public void cliente_excluido_com_sucesso() {

		customersManagementPage.clicar_btn_All();

		Assert.assertTrue("Cliente não excluído com sucesso.",
				updateCustomerPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email")));

	}

}