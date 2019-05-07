# Campos&Linhas Backend

Este repositório faz parte do projeto Campos&Linhass, para acessar o repositório de frontend clique [aqui](https://github.com/amandabezerra/treinamento-frontend). As configurações recomendadas bem como os passos para rodar o projeto encontram-se nas seções abaixo.

## Pré requisitos

+ [Maven](https://www.eclipse.org/m2e/)

## Instalação

+ Clone este repositório em seu computador utilizando o comando:

  `$ https://github.com/amandabezerra/treinamento-backend.git`

+ Caso esteja utilizando [IDE Eclipse](https://www.eclipse.org/downloads/) clique em *File* > *Import* > *Existing Maven Projects* e selecione o projeto na pasta clonada em seu computador.

+ Clique com o botão direito na classe **App.java** e em seguida em *Run as* e *Java Application*.

+ No seu navegador acesse:

    `http://localhost:8080/campo/listar`

+ Para visualizar as iformações do banco de dados acesse:

    `http://localhost:8080/h2/`
    
## Funcionalidades disponíveis:

Funcionalidade | Endpoint | Dado | Método 
:--: | :--: | :--: | :--:
Listar campos cadastrados | /campo/listar | - | GET |
Cadastrar um campo | /campo/cadastrar | {  "nome": "Campo 1" } | POST | 
Cadastrar um campo com linhas |  /campo/cadastrar | {  "nome": "Campo 1", "linhas": [ { "nome": "Linha 1.1" }, { "nome": "Linha 1.2" } ] } | POST
Consultar um campo específico | /campo/consultar/{idCampo} | - | GET |
Alterar um campo específico | /campo/alterar/{idCampo} | {  "nome": "Campo 1 Alterado" } | PUT
Alterar campo adicionando linhas | /campo/alterar/{idCampo | {  "nome": "Campo 1 Alterado", "linhas": [ { "nome": "Linha 1.3" }, { "nome": "Linha 1.4" } ] } | PUT
Excluir um campo específico | /campo/excluir/{idCampo} | - | DELETE
