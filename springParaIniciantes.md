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

    ````
    
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController 
    @RequestMapping("/hello-world")

    public class HelloWordController {
    @GetMapping 
        public String helloWorld() {  
            return "Hello World";
        }
    }
    ````
    

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
  - variaveis de ambiente podem ser configuradas em ``run/debug configurations`` 


### Gerenciamento de dependências

- Criar a primeira classe Service -- new package service
- Criar classe dentro do package HelloWorldService
- Contém a lógica da aplicação, as regras de negócio
  - precisa decorar a classe com @Service
  - indica pro Spring que é uma classe service -- depois qualquer outra classe que pedir uma instância de service, o 
  Spring já vai conseguir gerir a injeção de dependências na outra classe que tiver uma dependencia com essa classe
  
- Criar um método com a lógica do négocio, acessos a repost (classes que fazem conexão com banco de dados)
- No ``controller`` vamos modificar para acessar a classe de ``service`` para que ela a lógica
  - não usaremos mais a lógica direto no controller
  - indicamos ao Spring que precisamos de uma instância da classe HelloWorldService
  

- Essa indicação pode ser feita de 2 formas:
- 1º criar um construtor (método público) que recebe por parametro o HelloWorldService e no momento de execução o Spring
injeta o HelloWorldService
  
  ````
    import com.santos_caroline.first_spring_app.service.HelloWorldService;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/hello-world")

    public class HelloWordController {

    private HelloWorldService helloWorldService;

    public HelloWordController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping 
    public String helloWorld() {  
       return helloWorldService.helloWorld("Carolis");
    }

    }
  ````
- não foi criada uma instância para service (new HelloWorldService) e sim ela foi passada por parametro no 
construtor. Quem passou a instância e fez a injeção de dependencia foi o Spring

- 2º forma mais simples, ao inves de colocar um construtor, vamos colocar uma dependencia que queremos 
````private HelloWorldService helloWorldService;```` e o @Autowired -- indica que a dependencia tem que ser injetada 
(Autowired == automaticamente injetada na minha classe)  

````
    import com.santos_caroline.first_spring_app.service.HelloWorldService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/hello-world")

        public class HelloWordController {
            @Autowired
            private HelloWorldService helloWorldService;


        @GetMapping 
        public String helloWorld() {  
            return helloWorldService.helloWorld("Carolis");
        }

    }
````

### Classe de configuração

- Criar package configuration
- Criar classe de configuração HelloConfiguration
  - utilizada no Spring para configurar beans e instâncias de classe no contexto de uma aplicação Spring
    - Usar @ConfigurationProperties para vincular propriedades externas a classes imutáveis, facilitando a configuração
    - Lets you directly map configuration values to fields in a Java object.
    - Works with nested properties and complex data structures.
    - Provides type safety with strong validation of properties when the application starts.
    - Application configurations are decoupled from the business logic, promoting cleaner code.
    - Unlike reading configuration values directly from Environment or @Value , @ConfigurationProperties ensures that 
    properties are bound to types correctly.
    - It allows for grouping related configurations together under a specific prefix, making the properties easier to 
    manage and understand.
    - How @ConfigurationProperties Works?  At its core, @ConfigurationProperties maps property values defined in the 
    configuration file (like application.yml or application.properties) to fields in a Java class. The key aspect is 
    that you specify a prefix for properties to be bound.
    
  - Dentro da classe de configuração normalmente definimos métodos públicos que retornam o tipo da classe que queremos 
  configurar 
  - @Bean é usado dentro das classes @Configuration pra indicar rpo spring que ele deve gerenciar o retorno do método 
  como um bean no contexto da aplicação
    - basicamente, beans é criar instâncias de classe que não podem ser gerenciadas pelo spring (classe externas, de 
    bibliotecas de terceiros)
    - indicar pro spring instâncias de classes pra que le consiga fazer o gerenciamento quando ele não consegue fazer 
    automatico
    - por padrão as instâncias geradas pelo @Bean são do escopo singleton
    - O **Escopo Singleton** garante que uma classe tenha apenas **uma única instância durante toda a vida útil de uma 
    aplicação** e fornece um ponto de acesso global a essa instância. É ideal para gerenciar recursos compartilhados, 
    como conexões de banco de dados ou arquivos de configuração, evitando a criação desnecessária de múltiplos objetos 
    e economizando memória, mas deve ser usado com cautela, pois pode criar acoplamento global e dificultar testes 
    unitários. 
  
  ### Configurações especificas do controller
- para receber parâmetros pela URL, configuração do body e o mapeamento de alguns métodos
- Vamos criar um método do tipo @PostMapping no controller
  - para quando for enviado uma requisição de POST no endpoint /hello-world
-criar método público String helloWordPost()
    - normalmente num endpoint de POST recebemos os valores por body da requisição em JSON
    - então precisamos receber esses valores que o cliente mandou na requisição (@RequestBody String body) -- parâmetro
      String body)
    - indica pro spring que esse parâmmetro é pra ser injetado -- Sprinf injeta dentro do ``@RequestBody`` o que ele 
    receber no body
    - não é preciso ser tipo primitivo (ex. String etc) po ser classe também
-Criei a classe User e defini atributos privados de nome e email (os getter,setter e construtores foram pelo lombok)
    - agora no controller é possivel receber esses atributos no body:

````
    @PostMapping
    public String helloWordPost(@RequestBody User body){
        return "Hello World" + body.getName();
    }
}
````
-ela fez o teste usando o insomine -- pesquisar melhor !!

- caso eu queira pegar um id pela URL
  - para isso colocamos as chaves e o nome da variavel no parâmetro

- indico ao spring nos parametros do método, declarando o id e dizer pro spring que ele tem que injetar esse id no 
parametro do método)

````
    @PostMapping("/{id}")
    public String helloWordPost(@PathVariable String id @RequestBody User body){
        return "Hello World" + body.getName() + id;
    }
}
````
