## 🎯 Desafio Histórico de Fatura

**O desafio foi dividido em 3 partes**:

* Parte 1:
Existe uma lista desorganizada de lançamentos de cartão de crédito de um cliente e é preciso que o console nos mostre estes mesmos lançamentos de forma ordenada por meses, mostrar os lançamentos da mesma categoria escolhida por mim e preciso mostrar o total da fatura de um mês.

* Parte 2:
Dando continuidade ao que foi desenvolvido, agora é necessário utilizar o Spring, arquitetura MVC e seguir alguns requisitos propostos.

* Parte 3:
Utilizar o que foi feito nas etapas anteriores para criar o front-end.

<hr>

**Solução**:

<br>Comecei criando classes para separar e identificar os lançamentos e categorias, usando um array para listar e percorrer as opções, identificar id de posição, filtrar por categoria e/ou data, além de somar os valores por meses e categoria escolhida.
<br>Partindo para o Spring utilizei a mesma lógica, mas com algumas facilidades visto que o gerenciamento de dependência por uma injeção de dependência. Isso porque, por estar instanciado em memória, há uma conexão entre todos eles.
<br>Por último, fiz um desenvolvimento do front-end e integração com o que foi desenvolvido até o passo dois, sendo possível acessar através do menu os lançamentos por índice, filtrando pelas opções propostas.
