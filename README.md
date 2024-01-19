# Projeto utilizado na Graduação de Sistemas de Informação -  Disciplina DSC

## Visão geral

O projeto é uma aplicação back-end com objetivo de demonstrar a produtividade de construir um pequeno MicroServiço utilizando os frameworks [Spring Boot](https://projects.spring.io/spring-boot), [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) e [Spring Data](http://projects.spring.io/spring-data) em conjunto.

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.
 
- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) é um framework já consolidado no mercado, que a partir da versão fornece mecanismos simplificados para a criação de APIs RESTful através de anotação, além disso, também possui recursos de serialização e deserialização de objetos de forma transparente 
 
- [Spring Data](http://projects.spring.io/spring-data/) é um framework que abstrai o acesso ao modelo de dados, independente a tecnologia de base de dados.

 
# Setup da aplicação (local)

## 📋 Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 8
MySQL 9.6
Maven 3.3.3 
```

## 🔧 Preparando ambiente

É necessário a criação da base de dados relacional no MySQL

```
CREATE DATABASE "DSCapp";
```

Para os testes de integração também é necessario criar uma base de dados para os testes não interferirem na base de desenvolvimento.
```
CREATE DATABASE "DSCapp";
```

Observação: No MongoDB não é preciso criar as bases de dados, pois a aplicação cria caso não exista.

## ⚙️ Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
git clone https://github.com/peulearning/java_system.git
```
Feito isso, acesse o projeto:
```
cd system/extracthnorth
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8080
```
Tomcat started on port(s): 8080 (http)
Started AppConfig in xxxx seconds (JVM running for xxxx)
```
## 🖇️ Colaborando

Por favor, leia o [COLABORACAO.md](https://gist.github.com/usuario/linkParaInfoSobreContribuicoes) para obter detalhes sobre o nosso código de conduta e o processo para nos enviar pedidos de solicitação.

## 📌 Versão

Nós usamos [SemVer](http://semver.org/) para controle de versão. Para as versões disponíveis, observe as [tags neste repositório](https://github.com/suas/tags/do/projeto). 

## ✒️ Autores

Orientador : Petrônio Cândido (https://github.com/petroniocandido)

Alunos : 

* **Pedro Henrique** - *Coding* - [Dev](https://github.com/peulearning)
* **Athulo** - *Documentação* - [Dev](https://github.com/AthuloSantana)
* **Flávio Junior** - *Documentação* - [Dev](https://github.com/FJRMOTA)
* **Murilo** - *Documentação* - [Dev]()

Você também pode ver a lista de todos os [colaboradores](https://github.com/usuario/projeto/colaboradores) que participaram deste projeto.

## 📄 Licença

Este projeto está sob a licença (sua licença) - veja o arquivo [LICENSE.md](https://github.com/usuario/projeto/licenca) para detalhes.

## 🎁 Expressões de gratidão

* Foi uma experiência única e carrego comigo pelo resto da vida, apesar que com o passar do tempo terá que fazer atualizações constantes para futuras manutenções este projeto foi marcante. 📢;
* Um brinde a nossa equipe que obteve êxito. 🍺;
* Obrigado Dr Petrônio por nos repassar este conhecimento🫂;


---
⌨️ com ❤️ por Pedro Ribeiro
