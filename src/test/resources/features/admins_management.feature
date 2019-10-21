# language: pt
Funcionalidade: Admmins Management

  Contexto: 
    Dado que eu esteja na tela de login
    Quando faço o login com o usuário "admin@phptravels.com" e senha "demoadmin"
    Dado que eu esteja na tela Home
    Quando acesso o menu Accounts
    Dado que eu esteja na tela Admins Management
    Quando incluo um administrador
      | First Name | Last Name | Email               | Password | Mobile Number | Country | Address 1   | Address 2 | Status  | Add   | Edit | Remove    |
      | Debora     | Negrin    | deborac@teste.com.br |   123456 |   11984698558 | Brazil  | Rua Jandira | Casa 2    | Enabled | Tours | Cars | Locations |
    Então administrador cadastrado com sucesso

  @Admins
  Cenário: Adicionar administrador
    Dado que eu esteja na tela Admins Management
    Quando incluo um administrador
      | First Name | Last Name | Email                | Password | Mobile Number | Country | Address 1   | Address 2 | Status  | Add   | Edit | Remove    |
      | Debora     | Negrin    | deborac@teste.com.br |   123456 |   11984698558 | Brazil  | Rua Jandira | Casa 2    | Enabled | Tours | Cars | Locations |
    Então administrador cadastrado com sucesso

  @IncluirAdministradores
  Esquema do Cenário: Inclusão de Administradores
    Dado que eu esteja na tela Admins Management
    Quando eu incluo um administrador com os valores: "<First Name>", "<Last Name>", "<Email>", "<Password>", "<Mobile Number>", "<Country>", "<Address1>", "<Address2>", "<Status>", "<Add>", "<Edit>", "<Remove>"
    Então administrador "<Email>" cadastrado com sucesso

    Exemplos: 
      | First Name | Last Name | Email               | Password | Mobile Number | Country  | Address 1   | Address 2 | Status  | Add   | Edit | Remove    |
      | Debora     | Negrin    | debora@teste.com.br |   123456 |   11984698558 | Brazil   | Rua Jandira | Casa 2    | Enabled | Tours | Cars | Locations |
      | Daniel     | Rocha     | daniel@teste.com.br |   123456 |   11984698558 | Canada   | Rua Jandira | Casa 2    | Enabled | Tours | Cars | Locations |
      | Celso      | Ferreira  | celso@teste.com.br  |   123456 |   11984698558 | Colombia | Rua Jandira | Casa 2    | Enabled | Tours | Cars | Locations |

  @EditAdmin
  Cenário: Alterar informacoes do administrador
    Quando edito um administrador
      | First Name | Last Name | Email               | Password  | Mobile Number | Country | Address 1   | Address 2 | Status   | Add    | Edit  | Remove   |
      | Debs       | Cristina  | debs@teste.com.br   | debs123   |   11900000000 | Canada  | Rua Olimpia | Ap 44A    | Disabled | Hotels | Tours | Cars     |
    Então administrador "<Email>" editado com sucesso
    
  @RemoveAdmin
  Cenário: Excluir administrador
    Quando excluo um administrador
    Então administrador "<Email>" editado com sucesso
