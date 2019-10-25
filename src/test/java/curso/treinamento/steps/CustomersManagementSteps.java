//package curso.treinamento.steps;
//
//import org.junit.Assert;
//
//import cucumber.api.java.pt.Dado;
//import cucumber.api.java.pt.Então;
//import cucumber.api.java.pt.Quando;
//import curso.treinamento.pages.AddAdminPage;
//import curso.treinamento.pages.AdminsManagementPage;
//import curso.treinamento.pages.MenuPage;
//import curso.treinamento.pages.UpdateAdminPage;
//import curso.treinamento.setup.Hooks;
//import curso.treinamento.utils.Helper;
//import io.cucumber.datatable.DataTable;
//
//public class CustomersManagementSteps {
//
//	MenuPage menuPage = new MenuPage(Hooks.getDriver());
//	AdminsManagementPage adminsManagementPage = new AdminsManagementPage(Hooks.getDriver());
//	AddAdminPage addAdminPage = new AddAdminPage(Hooks.getDriver());
//	UpdateAdminPage updateAdminPage = new UpdateAdminPage(Hooks.getDriver());
//
//	@Dado("que eu esteja na tela Admins Management")
//	public void que_eu_esteja_na_tela_Add_Management() {
//		menuPage.clicar_subMenu("ACCOUNTS", "Admins");
//		Assert.assertTrue("Página Admins Management NÃO apresentada.", adminsManagementPage.validar_pagina());
//
//	}
//
//	@Quando("incluo um administrador")
//	public void incluo_um_administrador(DataTable dataTable_) {
//		adminsManagementPage.clicar_btn_Add();
//
//		Assert.assertTrue("Página Add Admin NÃO apresentada.", addAdminPage.validar_pagina_add());
//
//	
//		Helper.create_datatable(dataTable_);
//		
//		addAdminPage.preencher_first_name(Helper.dataTable.get(0).get("First Name"));
//		addAdminPage.preencher_last_name(Helper.dataTable.get(0).get("Last Name"));
//		addAdminPage.preencher_email(Helper.dataTable.get(0).get("Email"));
//		addAdminPage.preencher_password(Helper.dataTable.get(0).get("Password"));
//		addAdminPage.preencher_mobile_number(Helper.dataTable.get(0).get("Mobile Number"));
//		addAdminPage.selecionar_country(Helper.dataTable.get(0).get("Country"));
//		addAdminPage.preencher_address1(Helper.dataTable.get(0).get("Address 1"));
//		addAdminPage.preencher_address2(Helper.dataTable.get(0).get("Address 2"));
//		addAdminPage.selecionar_status(Helper.dataTable.get(0).get("Status"));
//		addAdminPage.selecionar_add(Helper.dataTable.get(0).get("Add"));
//		addAdminPage.selecionar_edit(Helper.dataTable.get(0).get("Edit"));
//		addAdminPage.selecionar_remove(Helper.dataTable.get(0).get("Remove"));
//		addAdminPage.clicar_btn_Submit();
//
//		// Write code here that turns the phrase above into concrete actions
//		// For automatic transformation, change DataTable to one of
//		// E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//		// Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//		// Double, Byte, Short, Long, BigInteger or BigDecimal.
//		//
//		// For other transformations you can register a DataTableType.
//		// throw new cucumber.api.PendingException();
//	}
//
//	@Então("administrador cadastrado com sucesso")
//	public void administrador_cadastrado_com_sucesso() {
//
//		Assert.assertTrue("Usuário não cadastrado com sucesso.", adminsManagementPage.validar_email_na_tabela(Helper.dataTable.get(0).get("Email")));
//
//		// Write code here that turns the phrase above into concrete actions
//		// throw new cucumber.api.PendingException();
//	}
//
//	
//	@Quando("eu incluo um administrador com os valores: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
//	public void eu_incluo_um_administrador_com_os_valores(String firstName, String lastName, String email,
//			String password, String mobileNumber, String country, String address1, String address2, String status, String add,
//			String edit, String remove) {
//
//		adminsManagementPage.clicar_btn_Add();
//
//		Assert.assertTrue("Página Add Admin NÃO apresentada.", addAdminPage.validar_pagina_add());
//
//		addAdminPage.preencher_first_name(firstName);
//		addAdminPage.preencher_last_name(lastName);
//		addAdminPage.preencher_email(email);
//		addAdminPage.preencher_password(password);
//		addAdminPage.preencher_mobile_number(mobileNumber);
//		addAdminPage.selecionar_country(country);
//		addAdminPage.preencher_address1(address1);
//		addAdminPage.preencher_address2(address2);
//		addAdminPage.selecionar_status(status);
//		addAdminPage.selecionar_add(add);
//		addAdminPage.selecionar_edit(edit);
//		addAdminPage.selecionar_remove(remove);
//		addAdminPage.clicar_btn_Submit();
//	}
//
//	@Então("administrador {string} cadastrado com sucesso")
//	public void administrador_cadastrado_com_sucesso(String email) {
//		
//		Assert.assertTrue("Usuário não cadastrado com sucesso.", adminsManagementPage.validar_email_na_tabela(email));
//
//	}
//	
//	
//	@Quando("edito um administrador")
//	public void edito_um_administrador(DataTable dataTable_) {
//		
//		adminsManagementPage.clicar_btn_Edit();
//		
//		Assert.assertTrue("Página Update Admin NÃO apresentada.", updateAdminPage.validar_pagina_edit());
//		
//		Helper.create_datatable(dataTable_);
//		
//		adminsManagementPage.limpar_campos("fname");
//		updateAdminPage.preencher_first_name(Helper.dataTable.get(0).get("First Name"));
//		adminsManagementPage.limpar_campos("lname");
//		updateAdminPage.preencher_last_name(Helper.dataTable.get(0).get("Last Name"));
//		adminsManagementPage.limpar_campos("email");
//		updateAdminPage.preencher_email(Helper.dataTable.get(0).get("Email"));
//		adminsManagementPage.limpar_campos("password");
//		updateAdminPage.preencher_password(Helper.dataTable.get(0).get("Password"));
//		adminsManagementPage.limpar_campos("mobile");
//		updateAdminPage.preencher_mobile_number(Helper.dataTable.get(0).get("Mobile Number"));
//		updateAdminPage.selecionar_country(Helper.dataTable.get(0).get("Country"));
//		adminsManagementPage.limpar_campos("address1");
//		updateAdminPage.preencher_address1(Helper.dataTable.get(0).get("Address 1"));
//		adminsManagementPage.limpar_campos("address2");
//		updateAdminPage.preencher_address2(Helper.dataTable.get(0).get("Address 2"));
//		updateAdminPage.selecionar_status(Helper.dataTable.get(0).get("Status"));
//		updateAdminPage.selecionar_add(Helper.dataTable.get(0).get("Add"));
//		updateAdminPage.selecionar_edit(Helper.dataTable.get(0).get("Edit"));
//		updateAdminPage.selecionar_remove(Helper.dataTable.get(0).get("Remove"));
//		updateAdminPage.clicar_btn_Submit();
//		
//	}
//	
//	
//	@Então ("administrador {string} editado com sucesso")
//	public void administrador_editado_com_sucesso(String email) {
//		
//		Assert.assertTrue("Usuário não editado com sucesso.", updateAdminPage.validar_email_na_tabela(email));
//
//	}
//	
//}
