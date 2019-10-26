# language: pt
Funcionalidade: Customers Management

  Contexto: 
    Dado que eu esteja na tela de login
    Quando faço o login com o usuário "admin@phptravels.com" e senha "demoadmin"
    Dado que eu esteja na tela Home
    Quando acesso o menu Accounts

  @AddCustomer
  Cenário: Adicionar cliente
    Dado que eu esteja na tela Customers Management
    Quando incluo um cliente
      | First Name | Last Name | Email               | Password | Mobile Number | Country | Address 1  | Address 2 | Status  |
      | Marcia     | Negrin    | marcia@teste.com.br |   567123 |   11972443113 | Brazil  | Rua Egidia | Casa 6    | Enabled |
    Então cliente cadastrado com sucesso

  @EditCustomer
  Cenário: Alterar informacoes do cliente
    Dado que eu esteja na tela Customers Management
    Quando altero as informacoes do cliente
      | First Name | Last Name | Email               | Password | Mobile Number | Country  | Address 1   | Address 2 | Status   |
      | Marcia     | Negrin    | marcia@teste.com.br |   567123 |   11972443113 | Brazil   | Rua Egidia  | Casa 6    | Enabled  |
      | Mamis      | Marcia    | mamis@teste.com.br  | mamis123 |   11972440000 | Colombia | Rua Frances | Ap 44A    | Disabled |
    Então cliente alterado com sucesso

  @RemoveCustomer
  Cenário: Remover cliente
    Dado que eu esteja na tela Customers Management
    Quando excluo um cliente
      | First Name | Last Name | Email              | Password | Mobile Number | Country  | Address 1   | Address 2 | Status   |
      | Mamis      | Marcia    | marcia@teste.com.br | mamis123 |   11972440000 | Colombia | Rua Frances | Ap 44A    | Disabled |
    Então cliente excluido com sucesso
