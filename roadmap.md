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
* Criar o sql do projeto e configurar o flyway para o controle de migrations
* Criar o controller para a criação do usuário
    * Criar o UserController
    * Criar o UserSignUpRequest e validar com o jakarta, add dependencia do jakarta
    * Criar o User do domain e validar o email
    * Criar o SignUpInputBound com o método execute que recebe e devolve um User do domain.
    * Criar o UserResponse
    * User o SignUpInputBound no UserController
    * Criar o EncryptOutputBound e UserOutputBound com os respectivos métodos que vamos user no caso de uso
    * Criar o caso de uso SignUpUseCase
    * Criar o UserRepository com método de findByEmail
    * Criar o UserRepositoryAdapter
    * Criar os mappers na UserEntity de .toDomain e o contructor
    * Add dependencia do spring security
    * Criar o BCryptAdapter para encriptar a senha
    * Criar o NotifyEmailAdapter para enviar o email
    * Criar o SignUpConfig para injetar as dependecias no caso de uso
    * Add @Component nos Adapters para serem gerenciados pelo spring boot
    * Add @Repository ao Repository
