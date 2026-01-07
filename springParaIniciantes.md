# CURSO DE SPRING para INICIANTES | Tutorial Completo de Java Spring
### Fernanda Kipper | Dev

##  API
| STATELESS                                                                                | STATEFULL                                      | 
|:-----------------------------------------------------------------------------------------|:-----------------------------------------------| 
| a cada nova requisição o servidor recebe todas as inf que preciso para a ação do cliente | o estado de cada cliente é mantido no servidor |
| NÃO reconhece o cliente a cada requisição                                                | reconhece o cliente a cada requisição          |
| precisar enviar a cada requisição um token para identificação                            | não precisa enviar novo token de identificação |
### **Spring** 
- é um framework do ecossistema Java criado para facilitar o desenvolvimento de aplicações modernas, 
robustas e seguras. Ele simplifica tarefas complexas, como controle de dependencias, segurança, transações, tratamento 
de dados e muito mais, permitindo que você foque na lógica da aplicação.
  - "modo Just Run" -- "iniciar o projeto e 'somente' rodar ele"

###  **Spring Boot** 
- é um framework que facilita a criação de aplicações Java baseadas no Spring framework
  - é uma extensão do Spring
  - elimina a necessidade de fazer configurações manuais, já que possui: 
    1. configurações automáticas (autoconfiguration)
    2. servidor embutido (Tomcat por padrão)
    3. padronização de estrutura de projetos
    4. facilidade para criar APIs REST


### Maven** (gerenciador de dependências):
  - é a ferramenta que o Spring Boot utiliza para gerenciar bibliotecas e dependências do projeto. Ele também controla 
  ciclo de vida da aplicação - compilação, testes e empacotamento. Com ele, conseguimos:
  1. adicionar dependências ao projeto via arquivo `pom.xml`
  2. executar a aplicação com `mvn spring-boot:run`
  3. gerar builds ("realizar o processo de compilação e empacotamento do software") -- `.jar`
  4. organizar o projeto de forma padronizada


### **Spring initializr**
- ferramenta online para criação rápida de projetos com Spring Boot
  - versão do Spring Boot mais estável (série 3.5 é a 3.5.9) lançada em dezembro de 2025, que trouxe melhorias e 
  correções, **exigindo Java 17+**)
- Dependencies:


  - **Spring Boot DevTools** is a set of utilities designed to improve the development-time experience by increasing 
  developer productivity and providing a fast feedback loop for code changes. Its primary feature is the automatic 
  application restart upon classpath changes (such as saving a Java file in an IDE), which eliminates the need for 
  manual restarts.

    1.1 Automatic Restart: The application automatically restarts when it detects changes in the classpath, allowing 
  developers to see the effects of code modifications quickly. This is achieved using two classloaders: a base 
  classloader for stable third-party JARs and a restart classloader for the classes being actively developed.
  
    1.2 LiveReload: DevTools includes an embedded LiveReload server. When used with a corresponding browser extension, 
  it can automatically refresh the web browser after a resource changes (like a static file or template), further 
  speeding up front-end development.
  
    1.3 Property Defaults: It applies sensible development-time configuration properties by default. For instance, 
  caching options are typically disabled during development to ensure that changes to templates (like Thymeleaf) or 
  static files are immediately visible without requiring manual configuration.
  
    1.4 Remote Debugging Support: DevTools provides features for remote debugging over HTTP, which can be useful when 
  deploying applications to environments like Docker containers, although this should be used with extreme caution and 
  never in a production environment due to security risks.

  - **Spring Web** -- Provides core HTTP integration features, an HTTP client, and web-related remote support. Suporte 
    para criação de aplicações RESTful

  - **Lombok** -- biblioteca para geração de código boiler plate "ajuda a escrever menos código, gera códigos
automaticos"

- No intellij:
  - pasta `.xml` -- onde encontramos as dependencias criadas
  - pasta `.mvm` -- ficam as configurações do Maven
  - pasta `scr` (source) -- ficam as subpastas Main e teste:
    - pasta testes -- testes unitários
    - pasta `main` -- ficam as subpastas java e e resources
      - pasta `java` -- ficam as classes "a lógica da aplicação"
      - pasta resources -- vão os arquivos de configuração Spring, templates e arquivos estáticos (exemplo CSS, JS ou scripts 
      SQL). O application.properties -- onde saõ feitas as configurações específicas da aplicação Spring

### Classes
- public class ...Application { 
- classe principal do Spring, a que vai inicializar todo o projeto
  - @SpringBootApplication -- anotação para configuração da classe
  - Combines @Configuration, @EnableAutoConfiguration, @ComponentScan
  
  
- Key Functions:
      - @Configuration: Marks the class as a source of bean definitions.
      - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings (like adding a 
      web server if spring-boot-starter-web is present).
      - @ComponentScan: Scans the package where the class resides (and sub-packages) for other components (like 
      @Service, @Repository, @Controller) to register them as beans.
     
 
-   How it works:
      Placement: You put it on the main class of your Spring Boot application, usually with the main() method.
      Bootstrapping: When `SpringApplication.run()` is called, it uses this annotation to create the application context 
and bootstrap the app.
      Convenience: It's a shorthand, so you don't need to write @Configuration @EnableAutoConfiguration @ComponentScan 
separately on the same class. 


```
package com.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Combines @Configuration, @EnableAutoConfiguration, @ComponentScan
public class MyMainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyMainApplication.class, args);
    }
}

```
### Construindo o projeto:
- Após criar o arquivo do spring boot no site e extrair no local desejado
- Na pasta ``java`` no mesmo package que o arquivo so spring boot (talvez precise fazer o diretório ser sources root), 
criar um novo package chamado controller e dentro do package criar a classe ``HelloWorldController``
  - vai receber as requisições HTTP


- Precisamos de criar um endpoint --> mapear os endpoints (mapear quais patch vamos receber requisições)
  - @RequestMapping
    - além de add configuração de parametro de request, a gente indica qual request queremos mapear add um parametro 
    para a configuração


- Declaramos um método público helloWorld() que vai retornar uma string
- @GetMapping vai qual requisições estamos a esperar
  - @GetMapping("/get") -- pode ser passado parametros no endpoint


- Depois de rodar ``FirstSpringAppApplication``, o Tomcat vai mostar qual a porta para as requisições HTTP (geralmente
(8080)
- no navegador: acessamos ``localhost:8080/hello-world``


- posta 8080 é padrão, mas pode ser alterada
- na pasta ``resources`` em application.properties
  - ex: server.port=3000
  - é nessa pasta que a gente configura:
    - a URL -- spring.datasource.url=jdbc:mysql://localhost:3306/first_spring_app "forma chumbada"
      - spring.datasource.url=${DB_HOST:jdbc:mysql://localhost:3306/first_spring_app} "com variável de ambiente"
    - o username -- spring.datasource.username=root
    - a senha -- spring.datasource.username=root
    - o banco de dados
    

  - caso queiramos criar outro perfil (por exemplo, pra teste) -- somente criar outro file (exemplo: 
application-dev.properties)
    - na aplicação principal precisamos definir o perfil que vamos usar:
```
  @SpringBootApplication
  @Profile("dev")
  public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}
    }
```

- no application.properties eu preciso indicar o perfil ativo:
  - ``spring.profiles.active=${ACTIVE_PTOFILE:dev}`` //recuperando valor de uma variavel de ambiente
  - ele carrega por padrão o valor da variável de ambiente, e se ele não encontrar o valor dessa variavel ele usa o 
  valor de dev

-- 30:20