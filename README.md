# runthebank
Teste William

O que melhoraria neste codigo?
R.: Este serviço restful possui muitas funcionalidades juntas, para melhorar deve-se separar estas funcionalidades em serviços distintos. Outro ponto há melhorar seria o uso do JPA, para transações entre contas, corrente e etc, todas as transações deveriam ser realizadas diretamente na base de dados via procedure, na minha opinião é mais seguro.

A parte de transferencia está com problemas, necessita de mais tempo para analisar e ajustar (A injeção de dependencia da classe TransferenciaFactory, não seta o bean por nada no mundo)...

É uma aplicação relativamente grande, seriam necessarios de 12, 14...20 horas para fazer todos os itens do enunciado dos desafio da BRQ, incluindo testes unitarios, desenho da arquitetura e etc.

Os pattens que utilizei foram o factory (Para receber os dados para cadastrar os perfis de pessoa fisica e pessoa juridica) Dao (Para interagir com JPA), DTO (Para receber dados externos).

Utilizei o @Transation do spring boot para cuidar da transação entre contas mas, por falta de tempo para resolver a questão mencionada no segundo paragrafo, não consegui realizar testes. A ideia é, em caso de erro, o @Transation fará o rollback dos dados alterados.

Os itens para cadastar pessoa e criar conta estão validando conforme enunciado.

Postman:

Cadastrar usuario PF ou PJ:
Post http://localhost:8080/demo/api/cadastrar
PF:
{
   "nome":"William Teste",
   "endereco":"Rua Itatiaia, 45",
   "cpf":"335.564.963.54"
}
ou PJ:
{
   "nome":"William Petroleo",
   "endereco":"Rua Itatiaia, 45",
   "cnpj":"33.000.167/0001-01"
}
curl --location 'http://localhost:8080/demo/api/cadastrar' \
--header 'Content-Type: application/json' \
--data '{
   "nome":"William Teste",
   "endereco":"Rua Itatiaia, 45",
   "cpf":"335.564.963.54"
}'
--------------------------------------------------------

Criar conta:
Post http://localhost:8080/demo/api/criar_conta

{
   "agencia":"12345",
   "saldo":"100",
   "status":"Ativa",
   "cpf_cnpj":"33.000.167/0001-01"
}

{
   "agencia":"456789",
   "saldo":"300",
   "status":"Ativa",
   "cpf_cnpj":"335.564.963.54"
}

{
   "agencia":"12345",
   "saldo":"200",
   "status":"Ativa",
   "cpf_cnpj":"335.564.963.54"
}

curl --location 'http://localhost:8080/demo/api/criar_conta' \
--header 'Content-Type: application/json' \
--data '{
   "agencia":"12345",
   "saldo":"200",
   "status":"Ativa",
   "cpf_cnpj":"335.564.963.54"
}'
-----------------------------------------------------------
Transferencia entre contas:
Post http://localhost:8080/demo/api/transferencia

{
   "agenciaRemetente":"123456",
   "agenciaBeneficio":"456789",
   "valorTransferencia":"50"
}

curl --location 'http://localhost:8080/demo/api/transferencia' \
--header 'Content-Type: application/json' \
--data '{
   "agenciaRemetente":"123456",
   "agenciaBeneficio":"456789",
   "valorTransferencia":"50"
}'
-------------------------------------------------------------
