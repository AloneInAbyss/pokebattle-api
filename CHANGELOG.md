# PokéBattle Changelog
Todas as alterações notáveis em cada nova versão do projeto serão documentadas aqui.

> Inspirado no [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [0.5.0] - 2022-09-26
### Adicionado
- Relacionamentos da JPA

### Modificado
- Diagrama de classes atualizado

## [0.4.1] - 2022-09-26
### Corrigido
- Link quebrado da imagem do diagrama de classes

## [0.4.0] - 2022-09-26
### Adicionado
- Novos modelos: Team e Attributes

### Modificado
- Lógica do projeto reformulada: a API não fará mais o uso de um token privado para autenticação
- Diagrama de classes atualizado
- Todos os Controllers, Services, Repositories, Dtos, Forms e Models foram refatorados

## [0.3.0] - 2022-09-26
### Adicionado
- Services para *Users*, *Pokémons* e *Battles*
- Getters e Constructors onde necessário nos Dtos, Models e Forms

### Modificado
- Arquivo TODO.md no .gitignore

### Corrigido
- Anotações @RestController e @RequestMapping nos Controllers

## [0.2.1] - 2022-09-26
### Modificado
- Endpoint de criação de times mudado do método **POST** para **PUT**

## [0.2.0] - 2022-09-26
### Adicionado
- Controllers para *Users* e *Battles*
- Dtos pra envio de dados dos endpoints
- Forms para receber dados nos endpoints
- Models e Enums e para *Users* e *Pokémons*

## [0.1.0] - 2022-09-19
### Adicionado
- Arquivos iniciais do projeto, gerados pelo [Spring Initializer](https://start.spring.io/)
- Documentação inicial
- Diagrama de classes
- Arquivo de changelog
