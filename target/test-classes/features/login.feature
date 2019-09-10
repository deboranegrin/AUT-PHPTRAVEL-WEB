# language: pt

Funcionalidade: Login

	Cenário: Realizar login com sucesso
		Dado que eu deseje logar no sistema
		Quando faço o login com o usuário "admin@phptravels.com" e senha "demoadmin"
		Então sou autenticado com sucesso
		
    Cenário: Tentativa de Login com email inválido
    	Dado que eu deseje logar no sistema
    	Quando faço o login com o usuário "teste" e senha "demoadmin"
    	Então é apresentada a mensagem "The Email field must contain a valid email address."