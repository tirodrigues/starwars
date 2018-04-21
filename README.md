# StarWars
API REST para cadastro de planetas desafio B2W.

## Tecnologias

Java 8 <br/>
Maven <br/>
Spring Boot <br/>
Docker <br/>
Docker Compose <br/>
MongoDB <br/>
 
## RUN MAVEN
Com o banco devidamento configurado em "starwars/src/main/resources.application.properties"

Executar: ``` mvn package && java -jar target/starwars-1.0.0.jar ```

## RUN DOCKER

Executar: ``` mvn clean install``` para o build da imagem <br/>
Executar: ``` docker-compose up``` para subir os containers <br/>

## Contexto
Api fica disponível em http://localhost:8080/api/v1/planeta

## Documentação
http://localhost:8080/swagger-ui.html
