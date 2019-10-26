package curso.treinamento.steps;

import org.junit.Assert;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import curso.treinamento.pages.AddWidgetPage;
import curso.treinamento.pages.MenuPage;
import curso.treinamento.pages.UpdateWidgetPage;
import curso.treinamento.pages.WidgetsManagementPage;
import curso.treinamento.setup.Hooks;
import curso.treinamento.utils.Helper;
import io.cucumber.datatable.DataTable;

public class WidgetsManagementSteps {

	MenuPage menuPage = new MenuPage(Hooks.getDriver());
	WidgetsManagementPage widgetsManagementPage = new WidgetsManagementPage(Hooks.getDriver());
	AddWidgetPage addWidgetPage = new AddWidgetPage(Hooks.getDriver());
	UpdateWidgetPage updateWidgetPage = new UpdateWidgetPage(Hooks.getDriver());

	@Dado("que eu esteja na tela Widgets Management")
	public void que_eu_esteja_na_tela_Widgets_Management() {

		menuPage.validar_submenu_general("Widgets");
		menuPage.clicar_subMenu_general("General", "Widgets");

		Assert.assertTrue("Página Widgets Management NÃO apresentada.", widgetsManagementPage.validar_pagina_widgets());
	}

	@Quando("incluo um widget")
	public void incluo_um_widget(DataTable dataTable_) {

		widgetsManagementPage.clicar_btn_Add();

		Assert.assertTrue("Página Add Widgets não apresentada.", addWidgetPage.validar_pagina_add_widget());

		Helper.create_datatable(dataTable_);

		addWidgetPage.preencher_widget_name(Helper.dataTable.get(0).get("Widget Name"));
		addWidgetPage.selecionar_widget_status(Helper.dataTable.get(0).get("Widget Status"));
		addWidgetPage.validar_painel_widget_content();
		addWidgetPage.preencher_widget_content(Helper.dataTable.get(0).get("Widget Content"));
		addWidgetPage.clicar_btn_Add();

	}

	@Então("widget cadastrado com sucesso")
	public void widget_cadastrado_com_sucesso() {

		Assert.assertTrue("Widget não cadastrado com sucesso.",
				widgetsManagementPage.validar_widget_name_na_tabela(Helper.dataTable.get(0).get("Widget Name")));

	}

	@Quando("altero as informacoes do widget")
	public void altero_as_informacoes_do_widget(DataTable dataTable_) {

		Helper.create_datatable(dataTable_);

		widgetsManagementPage.clicar_btn_edit_widgets(Helper.dataTable.get(0).get("Widget Name"));

		Assert.assertTrue("Página Update Widgets NÃO apresentada.", updateWidgetPage.validar_pagina_edit_widget());
		
		updateWidgetPage.limpar_campo_name();
		updateWidgetPage.preencher_widget_name(Helper.dataTable.get(0).get("Widget Name"));
		updateWidgetPage.selecionar_widget_status(Helper.dataTable.get(0).get("Widget Status"));
		updateWidgetPage.validar_painel_widget_content();
//		updateWidgetPage.limpar_campos();
		updateWidgetPage.preencher_widget_content(Helper.dataTable.get(0).get("Widget Content"));
		updateWidgetPage.clicar_btn_Update();
	}

	@Então("widget alterado com sucesso")
	public void widget_alterado_com_sucesso() {

		Assert.assertTrue("Widget não alterado com sucesso.",
				updateWidgetPage.validar_widget_name_na_tabela(Helper.dataTable.get(1).get("Widget Name")));
	}

	@Quando("excluo um widget")
	public void excluo_um_widget(DataTable dataTable_) {

		Helper.create_datatable(dataTable_);
		
		widgetsManagementPage.clicar_btn_All();
		widgetsManagementPage.clicar_btn_delete_widgets(Helper.dataTable.get(0).get("Widget Name"));
		widgetsManagementPage.remover_widget();

		Assert.assertTrue("Widget não encontrado.",
				updateWidgetPage.validar_widget_name_na_tabela(Helper.dataTable.get(0).get("Widget Name")));
	}

	@Então("widget excluido com sucesso")
	public void widget_excluido_com_sucesso() {

		Assert.assertEquals("Changes Saved!", widgetsManagementPage.get_mensagem_widget());
		
		Assert.assertFalse("Cliente não excluído com sucesso.",
						updateWidgetPage.validar_widget_name_na_tabela(Helper.dataTable.get(0).get("Widget Name")));
	}

}