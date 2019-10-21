# language: pt
Funcionalidade: Widgets Management

  Contexto: 
    Dado que eu esteja na tela de login
    Quando faço o login com o usuário "admin@phptravels.com" e senha "demoadmin"
    Dado que eu esteja na tela Home
    Quando acesso o menu General
  	Dado que eu esteja na tela Widgets Management

  @AddWidget
  Cenário: Adicionar widget
    Dado que eu esteja na tela Widgets Management
    Quando incluo um widget
      | Widget Name | Widget Status | Widget Content     |
      | Widget 1    | Enable        | Descricao Widget   |
    Então widget "<Widget Name>" cadastrado com sucesso

 
  @EditWidget
  Cenário: Alterar informacoes do widget
     Dado que eu esteja na tela Customers Management
     Quando altero as informacoes do widget
       | Widget Name | Widget Status | Widget Content        |
       | Widget 2    | Disable       | Descricao Widget ABC  |
     Então widget "<Widget Name>" alterado com sucesso
     
     
  @RemoveWidget
  Cenário: Alterar informacoes do widget
     Dado que eu esteja na tela Widgets Management
     Quando excluo um widget
     Então widget "<Widget Name>" excluido com sucesso
