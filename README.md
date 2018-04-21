# StarWars
API REST para cadastro de planetas desafio B2W.

## Tecnologias

Java 8
Maven
Spring Boot
Docker
Docker Compose
MongoDB

## RUN MAVEN
Com o banco devidamento configurado em "/starwars/src/main/resources.application.properties"

Executar: ``` mvn package && java -jar target/starwars-1.0.0.jar ```

## RUN DOCKER
Com o banco devidamento configurado em "/starwars/src/main/resources.application.properties"

Executar: ``` mvn clean install``` para o build da imagem
Executar: ``` docker-compose up``` para subir os containers

## Contexto
Api fica disponível em http://localhost:8080/api/v1/planeta

## Documentação
http://localhost:8080/swagger-ui.html
