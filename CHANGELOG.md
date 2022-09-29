# PokéBattle Changelog
Todas as alterações notáveis em cada nova versão do projeto serão documentadas aqui.

> Inspirado no [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [0.12.2] - 2022-09-29
### Adicionado
- Alteração na classe de Exceptions
- Mensagens de erro no endpoint de busca de usuário
- Testes para endpoint de busca de usuário

## [0.12.1] - 2022-09-29
### Adicionado
- Redirecionamento no endpoint de criação de usuário para a página de exibição do usuário
- Testes para endpoint de criação de usuário

## [0.12.0] - 2022-09-29
### Adicionado
- Validações e mensagens de erro no endpoint de criação do usuário

## [0.11.0] - 2022-09-29
### Adicionado
- Endpoint para obter um novo pokémon

### Modificado
- Tempo para obter um pokémon reduzido de 5 para 2 minutos
- Diagrama de classes atualizado

## [0.10.2] - 2022-09-28
### Modificado
- Removido retorno do campo team caso seu valor seja nulo

## [0.10.1] - 2022-09-28
### Modificado
- Retorno do endpoint de criação do time

## [0.10.0] - 2022-09-28
### Adicionado
- Endpoint e lógica para mudar o time de um usuário

### Modificado
- Corrigida a identação padrão para 4 espaços

## [0.9.0] - 2022-09-28
### Adicionado
- Endpoint e lógica para ver o perfil de um usuário

### Modificado
- Atualizado diagrama de classes

## [0.8.1] - 2022-09-28
### Modificado
- Template do Insomnia atualizado

## [0.8.0] - 2022-09-28
### Adicionado
- Validação do nome do usuário

### Corrigido
- Lógica para obter novos pokémons para o usuário

## [0.7.0] - 2022-09-28
### Adicionado
- Registro automático dos pokémons no banco de dados a partir dos arquivos com os dados

## [0.6.1] - 2022-09-26
### Adicionado
- Template do **Insomnia** para testes da API

## [0.6.0] - 2022-09-26
A funcionalidade para pegar os pokémons da PokéAPI ainda precisa ser implementada.

### Adicionado
- Service para User e Pokemon
- Endpoint para criação de conta

## [0.5.2] - 2022-09-26
### Adicionado
- Campos com @JsonIgnore

### Removido
- Relacionamento @ManyToMany desnecessário nas entidades

## [0.5.1] - 2022-09-26
### Adicionado
- Validações nos atributos das entidades
- @NoArgsConstructor nas entidades
- Corrigido construtor nas entidades
- Validador "Unique" no *username*

### Removido
- Anotação @MapsId nas entidades

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
