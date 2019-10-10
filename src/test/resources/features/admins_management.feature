# language: pt
Funcionalidade: Admmins Management

  Contexto: 
    Dado que eu esteja na tela de login
    Quando faço o login com o usuário "admin@phptravels.com" e senha "demoadmin"
    Dado que eu esteja na tela Home
    Quando acesso o menu Accounts

  @Admins
  Cenário: Adicionar administrador
    Dado que eu esteja na tela Admins Management
    Quando incluo um administrador
      | First Name | Last Name | Email              | Password | Mobile Number | Country | Address 1   | Address 2 | Status  | Add   | Edit | Remove    |
      | Debora     | Negrin    | teste@teste.com.br |   123456 |   11984698558 | Brazil  | Rua Jandira | Casa 2    | Enabled | Tours | Cars | Locations |
    Então administrador cadastrado com sucesso
