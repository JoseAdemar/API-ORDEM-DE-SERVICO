# API-ORDEM-DE-SERVICO
API para realizar o cadastro de um cliente e abertura de ordem de serviço para o cliente cadastrado

## Explicação do Projeto
Foi desenvolvida uma API RESFUL para realizar o cadastro de ordem de serviço.
Simulando uma loja de informática onde o cliente leva seu equipamento para o concerto,
a API funciona da seguinte forma:<br/>

O cliente ao chegar a loja é preciso fazer um cadastro no sistema onde é coletado os seguintes dados:<br/>
nome, endereço, telefone e email<br/><br/>

Para realizar esse cadastro na API tem que utilizar o seguinte endpoint:<br/>
http://localhost:8080/clientes  utilizando o método POST no postman <br/>
Exemplo:
```
{
    "nome": "Pedro Martins",
    "endereco": {
        "cep": "72125478",
        "logradouro": "Rua A",
        "numero": "15",
        "complemento": "Apartamento",
        "bairro": "Avenida Brasil",
        "cidade": "Brasília"
    },
    "telefone": "61998845758",
    "email": "pedro@email.com"
}
```
Após cadastrar o cliente no sistema é possível realizar consulta dinânica do cliente por:<br/>
nome, telefone, e email utilizando parametros e também é possível fazer a consulta pelo ID do cliente.<br/>
Também é possível atualizar e deletar os dados de um cliente. Também foi feita uma tratamento de execões com o ExceptionHandler.<br/>

## Endpoints da classe Cliente
Cadastrar um cliente http://localhost:8080/clientes  utilizando o método POST<br/>
Pesquisar um cliente por id http://localhost:8080/clientes/id  utilizando o método GET<br/>
Consulta dinâmica de um cliente por parametros http://localhost:8080/clientes/consulta-dinamica?telefone=61998826547&email=maria@.com&nome=Maria    utilizando o método GET<br/>
Atualizar os dados do cliente http://localhost:8080/clientes/id  utilizando o método PUT<br/>
Deletar os dados do cliente http://localhost:8080/clientes/id  utilizando o método DELETE<br/>

## Fazendo o cadastro de uma ordem de serviço

Após ter os dados do cliente cadastrado no sistema é possível vincular esse cliente cadastrado a uma ordem de serviço.<br/>
Observe que para realizar o cadastro de uma ordem de serviço foi preciso passar as informações da classe OrdemDeServico e o ID do cliente.<br/>
Como regra de négocio ao criar uma OS ela já é criada com o status INICIADO e também com o horário de cadastro podendo alterar o status
para PENDENTE, CANCELADO ou FINALIZADO de acordo com o andamento do antendimento. Caso uma ordem de serviço esteja com o status FINALIZADO essa OS não pode mais ser alterada
e é automaticamente setado o horário de finalização.
Exemplo endpoint para cadastro de uma ordem de serviço: <br/>
http://localhost:8080/os   utilizando o método POST
```
 {
    "tipo": "Computador",
    "marca": "Dell",
    "problema": "Não liga",
    "cliente": {
        "id": 2
    },
    "status": "INICIADO",
    "dataInicio": "2021-07-01",
    "dataEntrega": null,
    "descricao": "Recebido o computador com o defeito (não liga)"
}
```
## Endpoints da classe OrdemDeServico
Foi criado os endpoints para cadastrar uma ordem de serviço, fazer consultas dinâmicas utilizando status da OS, email do cliente, tipo, marca, problema
também atualização e deleção.<br/>

Cadastrar uma OS http://localhost:8080/os  utilizando o método POST<br/>
Pesquisar uma OS  por id http://localhost:8080/os/id  utilizando o método GET<br/>
Consulta dinâmica de uma OS por http://localhost:8080/os/busca-dinamica?tipo=Computador&marca=Dell&problema=Não liga&status=INICIADO&email=maria@.com  utilizando o método GET<br/>
Atualizar os dados da OS http://localhost:8080/os/id  utilizando o método PUT<br/>
Deletar os dados de uma OS http://localhost:8080/os/id  utilizando o método DELETE<br/>

## Como rodar o projeto
Para rodar o projeto basta importar o projeto em alguma IDE suportada como STS, Eclipse entre outras.<br/>
Após importar o projeto basta rodar o projeto e fazer os testes utilizando o banco de dados em memória H2 ou o Mysql as configurações 
já está pronta no arquivo application.properties<br/>

O endereço para acessar o banco de dados no navegador é: http://localhost:8080/h2-console e inserir as informações do arquivo application.properties.<br/>
```
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
```









