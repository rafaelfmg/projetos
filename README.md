Rafael Faria Macedo Gonçalves

Sistema desenvolvido para busca de endereços na base dos correios (www.buscacep.com.br), foi utilizado no desenvolvimento 
as seguintes tecnologias:

- Spring Boot
- Java 8
- Tomcat embedded
- Apache Maven


Execução

Para executar a aplicação, faça as seguintes operações:

1- Tenha Java 8 instalado e devidamente configurado.

2 - Vá até o diretório raíz da aplicação e digite "mvn spring-boot:run".

3 - A aplicação sera compilada e estara disponível no endereço https://localhost:8080.


Para executar os serviços segue url:

Busca de endereço por cep:

http://localhost:8080/searchAddress/addressByZipCode?zipCode=38408400

Busca de endereço pelo logradouro:

http://localhost:8080/searchAddress/addressByDescription?name=Rondon%20pacheco

O retorno de ambos os serviços pode ser um único endereço ou uma lista de endereços, dependendo da informação passada.