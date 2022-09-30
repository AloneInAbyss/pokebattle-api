# PokéBattle Changelog
Todas as alterações notáveis em cada nova versão do projeto serão documentadas aqui.

> Inspirado no [Keep a Changelog](https://keepachangelog.com/en/1.0.0/)

## [1.0.0] - 2022-09-30
Primeira release estável da *PokéBattle API*. Principais funcionalidades: endpoints do Usuário, Pokémons e Batalha em funcionamento, com tratamento de erros e documentação visual e interativa.

> Engloba todos os commits da versão `v0.1.0` até a `v0.13.0`

### Adicionado
- Endpoints do usuário: `/users/register`, `/users/{username}`, `/users/{username}/team`
- Endpoint para pegar pokémons: `/pokemons/{username}`
- Endpoint das batalhas: `/battle/{username}/{username}`
- Template para uso da API no [Insomnia](https://insomnia.rest/)
- Documentação feita com [OpenAPI](https://swagger.io/specification/) e [Swagger](https://swagger.io/tools/swagger-ui/)
- Diagrama de classes do projeto
