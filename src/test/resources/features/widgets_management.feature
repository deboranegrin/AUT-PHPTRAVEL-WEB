# language: pt
Funcionalidade: Widgets Management

  Contexto: 
    Dado que eu esteja na tela de login
    Quando faço o login com o usuário "admin@phptravels.com" e senha "demoadmin"
    Dado que eu esteja na tela Home
    Quando acesso o menu General

  @AddWidget
  Cenário: Adicionar widget
    Dado que eu esteja na tela Widgets Management
    Quando incluo um widget
      | Widget Name | Widget Status | Widget Content      |
      | Widget 1    | Disable       | Descricao Widget 1  |
    Então widget cadastrado com sucesso

  @EditWidget
  Cenário: Alterar informacoes do widget
    Dado que eu esteja na tela Widgets Management
    Quando altero as informacoes do widget
      | Widget Name | Widget Status | Widget Content      |
      | Widgets     | Disable       | Descricao Widget 1  |
      | Widget 2    | Enable        | Descricao Widget 2  |
    Então widget alterado com sucesso

  @RemoveWidget
  Cenário: Remover widget
    Dado que eu esteja na tela Widgets Management
    Quando excluo um widget
     | Widget Name | Widget Status | Widget Content      |
     | Widget 2    | Enable        | Descricao Widget 2  |
    Então widget excluido com sucesso
