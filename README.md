# TCCFS
Projeto de TCC para o curso de Análise e Desenvolvimento de Sistemas feito em 2015, para uma empresa de fast food.

Utilizei Java 8 com padrão MVC e MySQL como banco de dados relacional. Para as telas, o Java Swing; JasperReports para os relatórios.

## Alguns recursos do sistema:
* Cadastros variados (funcionários, cidades, contas, formas de pagamento, produtos, fórmulas, promoções, produções, percas, pedidos);
* Os produtos diferem em único ou composto, final ou ingrediente:
  - Por exemplo, um refrigerante é um produto único e final, já um cachorro quente é um produto composto e final;
  - A salsicha é um produto único e ingrediente que compõe um produto final (neste caso, o cachorro quente);
  - O pão de cachorro quente é um produto composto e ingrediente (que compõe o cachorro quente);
  - O fermento é um produto final e ingrediente (que compõe o pão).
* As fórmulas são a lista de ingredientes com suas respectivas quantidades para formar um produto composto;
* As produções são, literalmente, a produção de um produto composto, para que o mesmo entre em estoque. Por exemplo: produzir o pão de cachorro quente para que tenha o mesmo no estoque a fim de vender o cachorro quente;
  - É possível fazer uma produção manual ou cadastrar uma rotina de produção, especificando o produto, a quantidade e os dias da semana;
  - Há uma thread executando "em segundo plano" para assegurar que serão feitas as rotinas de produção cadastradas.
* As percas são baixa no estoque feitas manualmente, informando uma justificativa;
* É possível, também, fazer um balanço do estoque;
* As promoções podem ser cadastradas informando um período de vigência e o valor do produto na promoção (ao vender, é informado que é uma promoção e o preço anterior);
* O cadastro de pedidos difere em pedido no local ou delivery:
  - No local, basta informar os itens do pedido e se há desconto, ao confirmar o pedido o mesmo entra na lista de pedidos com uma senha para o cliente retirar o mesmo quando ficar pronto (os produtos compostos possuem um campo para informar o tempo estimado para produção, esse tempo é utilizado para calcular a estimativa de tempo dos pedidos serem entregues);
  - Para delivery, são acrescentados os campos de endereço, contato, troco a levar e observações;
  - Ao finalizar um pedido, são impressos dois tickets, um para o cliente e outro para a cozinha.
* Há uma tela para fazer backup do banco de dados;
* Diversos relatórios de estoque, pedidos, caixa e extras;
* A maioria das tabelas e comboboxes são personalizadas;
* Há stored procedures e triggers no banco de dados para certas ações, como atualização de estoque e atualização do custo de um produto.

## Esta é a tela principal:

![image](https://github.com/mychellmotta/tccfs/assets/13575346/e349010f-37fc-40d5-9907-d0dd2331353e)

## Próximos passos:
* Migrar para Maven;
* Melhorar o código seguindo novos conceitos aprendidos.
