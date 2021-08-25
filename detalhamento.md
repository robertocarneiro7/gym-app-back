# Funcionalidades(Aplicativo de exercícios) Server
	01. CRUD exercícios
		- Criar, Editar, Buscar e Desativar
		- Somente exercícios criados por usuários com perfil PROFISSIONAL poderão ser visíveis por outros
	02. CRUD ficha de exercícios
		- Criar, Editar, Buscar e Desativar
	03. CRUD fichas padrões
		- Criar, Editar, Buscar e Desativar
	04. Utilizar ficha padrão para determinado user
	05. Fazer upload de vídeos para ser aprovado por exercícios
	06. Aprovar vídeo enviado
	07. Excluir vídeo aprovado
	08. Comprar fichas padrões
	09. Listar fichas padrões
	10. Listar fichas padrões compradas por usuários
		
# Microsserviços
	01. exercicio-api
		- Exercício
		- Músculo
		- Músculo_Exercício
	02. video-api
		- Vídeo
		- Vídeo_Exercício
	03. ficha-api
		- Ficha
		- Sessão_Ficha
		- Sessão_Ficha_Exercício
		- Sessão_Ficha_Exercício_Repetição
	04. usuario-api
		- Usuário
		- Perfil
		- Academia
		- Aluno
		- Academia_Aluno
		- Profissional
		- Academia_Profissional
		- Admin
	05. autenticacao-api
	06. ficha-modelo-api
		- Ficha_Modelo
		- Sessão_Ficha_Modelo
		- Sessão_Ficha_Modelo_Exercício
		- Sessão_Ficha_Modelo_Exercício_Repetição
	07. pagamento-api
		- Ficha_Modelo_Comprada_Usuário
	
# Entidades
	01. Músculo
		- id
		- nome
		- dt_criação
		- dt_alteração
		- dt_exclusão
	02. Exercício
		- id
		- nome
		- descrição
		- outros_nomes
		- id_musculo(músculo_principal)
		- dt_criação
		- dt_alteração
		- dt_exclusão
		- id_usuario_criação
	03. Músculo_Exercício(músculos secudários)
		- id_musculo
		- id_exercicio
	04. Ficha
		- id
		- nome
		- dt_criação
		- dt_alteração
		- dt_exclusão
		- id_usuario_criação
		- id_usuario_edição
	05. Sessão_Ficha
		- id
		- nome
		- id_ficha
		- dt_criação
		- dt_alteração
		- dt_exclusão
		- id_usuario_criação
		- id_usuario_edição
	06. Sessão_Ficha_Exercício
		- id
		- nome
		- id_sessão_ficha
		- id_exercicio
		- ordem
		- dt_criação
		- dt_alteração
		- dt_exclusão
	07. Sessão_Ficha_Exercício_Repetição
		- id
		- id_sessão_ficha_exercicio
		- tipo(tempo, repetição)
		- nr_serie
		- nr_repetição
		- tempo
	08. Ficha_Modelo
		- id
		- nome
		- valor
		- gratis
		- dt_criação
		- dt_alteração
		- dt_exclusão
		- id_usuario_criação
	09. Sessão_Ficha_Modelo
		- id
		- nome
		- id_ficha_modelo
		- dt_criação
		- dt_alteração
		- dt_exclusão
		- id_usuario_criação
		- id_usuario_edição
	10. Sessão_Ficha_Modelo_Exercício
		- id
		- nome
		- id_sessão_ficha_modelo
		- id_exercicio
		- ordem
		- dt_criação
		- dt_alteração
		- dt_exclusão
	11. Sessão_Ficha_Modelo_Exercício_Repetição
		- id
		- id_sessão_ficha_modelo_exercicio
		- tipo(tempo, repetição)
		- nr_serie
		- nr_repetição
		- tempo
	13. Vídeo
		- id
		- id_exercicio_inicial
		- dt_criação
		- dt_aprovação
		- id_usuario_criação
		- id_usuario_aprovação
	14. Vídeo_Exercício
		- id_video
		- id_exercicio
	15. Usuário
		- id
		- email
		- username
		- senha
	16. Perfil
		- id
		- tipo(PROFISSIONAL, ADM, ALUNO_GRATIS, ALUNO_PRO, ACADEMIA)
		- id_profissional
		- id_admin
		- id_aluno
		- id_academia
	17. Academia
		- id
		- nome
		- descrição
		- endereço
		- cnpj
	18. Aluno
		- id
		- nome
		- data_nascimento
		- cpf
	19. Academia_Aluno
		- id_academia
		- id_usuario
		- dt_criação
		- dt_exclusão
	20. Profissional
		- id
		- nome
		- data_nascimento
		- cpf
		- cref
	21. Academia_Profissional
		- id_academia
		- id_profissional
		- dt_criação
		- dt_exclusão
	22. Admin
		- id
		- nome
	23. Ficha_Modelo_Comprada_Usuário
		- id
		- id_ficha_modelo
		- id_usuario
		- valor_epoca
		- dt_compra