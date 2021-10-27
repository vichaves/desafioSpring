# Desafio Java + Spring Framework + JPA

### Objetivos

Testar os conhecimentos do programador em relação ao desenvolvimento de APIs RESTful baseadas em Java, utilizando
Spring Boot e JPA.

* Criação de RESTful APIs altamente coesas e de baixo acoplamento, implementadas no modelo MVC (Model-view-controller)
* Criação/mapeamento de entidades, bem como os relacionamentos entre elas, utilizando anotações
* Elaboração de testes unitários

### Contexto

Você foi contratado pela loja de chocolates "Doce Sonho" para desenvolver uma aplicação para controle e comércio online
dos diversos produtos do estabelecimento. A loja vende Chocolates e Bombons por unidade, e possui um sistema de
avaliação que permite aos consumidores darem notas aos itens do catálogo.

### Escopo Técnico

A aplicação é uma API RESTful que retorna dados em formato JSON. É baseada em Java e utiliza o framework Spring.
Para deixar este exercício mais simples e independente, um banco de dados relacional em memória é utilizado (H2). O
projeto utiliza o Gradle para gerenciamento de dependências e construção.

A sua tarefa será realizar os desafios que envolvem alteração de escopo e esquema listados abaixo. É recomendável que
os desafios sejam concluídos na ordem que estão dispostos, pois alguns desafios utilizarão resoluções de desafios
anteriores. Naturalmente, os desafios possuem diversas formas de resolução, mas a coesão e objetividade contarão na
avaliação. A menos que seja especificado no desafio, você possui toda a liberdade para escolher os nomes para classes
e _endpoints_.

#### Stack

* Java 11
* Spring 2.5.3
  * Boot
  * Data JPA
  * Testing
  * Actuator
  * Devtools
* H2

### *Building*

Após clonar este repositório, basta navegar até o diretório raiz do projeto e executar o comando:

```gradlew bootRun```

A aplicação estará disponível na porta 8080. O console do H2 estará disponível no caminho ```/h2-console```, com os
seguintes parâmetros: 

```
URL         : jdbc:h2:mem:desafio-db
User Name   : desafio
Password    : desafio
```

# Desafios

## Desafio 1

Ao analisar o histórico de vendas e perguntas realizadas com frequência nos canais de comunicação com os consumidores,
o proprietário decidiu lançar uma nova categoria de produtos: Kits prontos para presente, contendo uma quantidade
pré-definida dos itens do catálogo.

Sua tarefa será alterar as classes de Recurso e Serviço (```PresenteResource``` e ```PresenteService```,
respectivamente) com os _endpoints_ e lógica de acesso aos dados. Os endpoints deverão ser usados para  para obtenção e
listagem (de todos ou de apenas um, se fornecido um ```id```), criação, alteração e exclusão destes kits. O modelo de
dados já está criado e é definido pelas classes ```Presente``` e ```ItemPresente```. Os repositórios também já estão
criados, e você deverá criar quaisquer métodos necessários para as consultas, caso julgue necessário.

##### Dica!

Você basicamente precisa apenas fazer um CRUD da entidade ```Presente```. Os itens do presente são persistidos de forma
cascateável (ou seja, ao atualizar a entidade ```Presente```, os itens serão atualizados também).

### Desafio 1.1

Elaborar os testes unitários para as funcionalidades descritas no Desafio 1 na classe ```ProdutoTest``` Pode-se utilizar
os testes da classe ```ChocolateTest``` como referência.

## Desafio 2

Ao analisar as lojas concorrentes, o proprietário da "Doce Sonho" constatou que chocolates a granel geralmente são
vendidos por peso, e não por unidade.

Sua tarefa será alterar o modelo de dados da classe ```Chocolate```, removendo o parâmetro ```preco```, e incluindo os
parâmetros ```peso``` e ```precoPorQuilograma```.

#### Dica!

Observe que o parâmetro ```preco``` se encontra na classe ```Produto```, e a classe ```Chocolate``` herda este
parâmetro, pois estende a classe ```Produto```. Se você tentar resolver esse desafio alterando a classe ```Produto```,
fará com que os Kits prontos elaborados no Desafio 1 passem a ser vendidos a granel, o que não é o proposto!

Você precisará fazer uso de mais herança! Crie mais classes: ```ProdutoPreco``` e ```ProdutoGranel```, onde ambas
estendem a classe ```Produto```, e mova o parâmetro ```preco``` da classe ```Produto``` para a classe
```ProdutoPreco```, e implemente a resolução deste desafio na classe ```ProdutoGranel```.

Por fim, altere a herança da classe ```Chocolate``` para ```ProdutoGranel``` e a ```Presente``` para ```ProdutoPreco```.

Se você concluiu o Desafio 1.1, será necessário alterar os testes unitários, pois eles irão falhar com a alteração do
modelo de dados 😉

#### Desafio 3

O proprietário deseja saber quais itens do catálogo possuem as melhores avaliações.

Sua tarefa será construir um relatório que exiba os 10 itens com melhores avaliações do catálogo. Ele deverá possuir os
seguintes campos:

```
nome: texto
mediaNotas: fração
```

Você deverá construir este relatório, criando seu modelo de dados (um DTO, não é necessário persisti-lo no banco de
dados), o serviço para compilação dos dados e o _endpoint_ para chamada pela API.

#### Dica!

Ataque esse problema em partes - primeiro, crie a classe que conterá o formato de resposta conforme especificado acima,
em seguida, na classe ```ProdutoService```, crie o método que contém a lógica de negócio (obtém os produtos, calcula a
média das notas, filtra apenas os produtos com as 10 maiores médias, transforme este resultado no DTO criado
anteriormente), e, por fim, crie o _endpoint_. A classe ```ChocolateTest``` possui um teste unitário que pode ajudar
a testar a lógica de negócio rapidamente.

Lembre-se de usar a _Stream API_ do Java 8! Com ela você poderá resolver este desafio de forma simples e elegante 😉