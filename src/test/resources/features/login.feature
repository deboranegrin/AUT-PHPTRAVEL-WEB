# language: pt

@FuncionalidadeLogin
Funcionalidade: Login

	@LoginComSucesso
	Cenário: Realizar login com sucesso
		Dado que eu esteja na tela de login
		Quando faço o login com o usuário "admin@phptravels.com" e senha "demoadmin"
		Então sou autenticado com sucesso
		
	@LoginInvalido
    Cenário: Tentativa de Login com email inválido
    	Dado que eu esteja na tela de login
    	Quando faço o login com o usuário "teste" e senha "demoadmin"
    	Então é apresentada a mensagem "The Email field must contain a valid email address."