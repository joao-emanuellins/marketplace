* Criar projeto no spring initializr
  * Add dependencies
    * Spring Web
    * Spring Data JPA
    * Spring Kafka
    * PostgreSQL Driver
* Criar o docker compose para subir o postgresql e o kafka
* Configurar o PostgreSQL
  * Configurar o application.properties
  
* Estruturar o projeto de acordo com a arquitetura hexagonal
  * Criar os pacotes
    * com.hexagonal.sales
      * application
        * core
          * domain
          * exceptions
          * usecases
        * ports
          * inputs
          * outputs
      * adapters
        * inputs
          * controllers
            * requests
            * responses
          * consumers
            * messages
        * outputs
          * repositories
            * entities
          * clients
            * requests
            * responses
          * producers
            * messages
      * configs
        * kafka
        * domain
* Criar o sql do projeto e configurar o flyway para o controle de migrations
* Criar o controller para a criação do usuário
  * Criar o UserController
  * Criar o UserSignUpRequest e validar com o jakarta
  * Criar o User do domain e validar o email
  * Criar o SignUpInputBound com o método execute que recebe e devolve um User do domain.
  * Criar o UserResponse
  * User o SignUpInputBound no UserController
  * Criar o EncryptOutputBound e UserOutputBound com os respectivos métodos que vamos user no caso de uso
  * Criar o caso de uso SignUpUseCase
