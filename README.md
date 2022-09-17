# PokéBattle API
O projeto consiste em batalhas entre times de *Pokémons*, onde cada usuário pode criar um time e batalhar contra outros jogadores. Cada usuário precisa obter seus próprios pokémons, através de um endpoint cuja interação é limitada por tempo. 

> Os dados dos *Pokémons* foram obtidos pela [PokéAPI](https://pokeapi.co). 

## Como funciona?
Veja abaixo uma simples explicação dos principais endpoints, e na próxima seção a descrição detalhada de cada um.

A funcionalidade da API é simples: um usuário pode se registrar através do endpoint `/users/register`, onde vai receber um **TOKEN PRIVADO** que é usado para interagir com os endpoints relacionados com sua conta (funciona como uma senha). Seu nome de usuário pode ser usado por outras pessoas para interagirem com seu perfil e batalharem contra você.

Para obter um pokémon use `/users/<SEU TOKEN PRIVADO>/pokemons`, e para visualizá-los use `/users/<SEU NOME DE USUÁRIO>`. **Você só pode obter um pokémon a cada 5 minutos**. Cada conta ganha 5 pokémons aleatórios quando é criada. Um time poderá ser formado usando três pokémons diferentes, através do endpoint `/users/<TOKEN PRIVADO>/team`. 

Para visualizar o perfil público de alguém, use `/users/<NOME DO USUÁRIO>`, onde poderá ver seu time e sua lista de pokémons. Para iniciar uma batalha entre dois jogadores, use `/battle/<NOME DO USUÁRIO>/<NOME DO OUTRO USUÁRIO>`.

## Lista de Endpoints

- [Criação de usuário](#post-usersregister)
- [Ver perfil de usuário](#get-usersnome-de-usuário)
- [Obter novo pokémon](#get-userstoken-privadopokemons)
- [Criar novo time de pokémons](#post-userstoken-privadoteam)
- [Batalhar contra um usuário](#get-battlenome-de-usuárionome-de-usuário)

### **POST** `/users/register`
Cria um novo usuário. Retorna um **Token Privado** que deve ser usado para interagir com endpoints da sua conta.

#### Campos da requisição
- Nome de usuário: `"username": "<nome>"` onde *nome* é formado apenas por letras e acentos.

#### Exemplos
```
POST <URL>/users/register

{
  "username": "aloneinabyss"
}
```

##### Resposta
```
STATUS CODE: 201

{
  "username": "aloneinabyss",
  "private_token": "XXXXX"
}
```

### **GET** `/users/<NOME DE USUÁRIO>`
Retorna as informações de um usuário.

#### Exemplos
```
GET <URL>/users/aloneinabyss
```

##### Resposta
```
STATUS CODE: 200

{
  "username": "aloneinabyss",
  "pokemons": [
    {
      "id": 35,
      "name": "clefairy",
      "type": "fairy",
      "stats": {
        "hp": 90,
        "attack": 60,
        "defense": 100
      }
    }
    ...
  ],
  "team": [
    {
      "id": 35,
      "name": "clefairy"
      ...
    },
    ...
  ]
}
```

### **GET** `/users/<TOKEN PRIVADO>/pokemons`
Usado para obter um novo pokémon aleatório. Só pode ser chamado a cada 5 minutos por cada usuário.

#### Exemplos
```
GET <URL>/users/XXXXX/pokemons
```

##### Resposta
```
STATUS CODE: 200

{
  "pokemon": {
    "id": 35,
    "name": "clefairy",
    "type": "fairy",
    "stats": {
      "hp": 90,
      "attack": 60,
      "defense": 100
    }
  }
}
```

### **POST** `/users/<TOKEN PRIVADO>/team`
Define qual time de pokémons será usado em batalhas com seu usuário. Um time deve ter obrigatóriamente **três pokémons**.

#### Campos da requisição
- Time: `"team": { "1": "<id | nome>", "2": "<id | nome>", "3": "<id | nome>" }` onde é possível passar o id ou o nome do pokémon desejado para cada posição do time (de 1 a 3). Só serão aceitos pokémons que o usuário possuir em sua conta.

#### Exemplos
```
PUT <URL>/users/XXXXX/team

{
  "team": {
    "1": clefairy,
    "2": 19,
    "3": 130
  }
}
```

##### Resposta
```
STATUS CODE: 200

{
  "team": [
    {
      "id": 35,
      "name: "clefairy"
      ...
    },
    ...
  ]
}
```

### **GET** `/battle/<NOME DE USUÁRIO>/<NOME DE USUÁRIO>`
Inicia uma batalha entre dois usuários diferentes. A batalha será realizada entre os times de pokémons de cada usuário. Consiste nas seguintes etapas: cada time possui três slots de pokémons, primeiro os dois pokémons no primeiro slot de cada time são escolhidos para batalhar entre si, então um dos possível stats (**hp**, **attack** ou **defense**) é sorteado para ser o critério de decisão do vencedor do round, em seguida o mesmo acontece com os pokémons do segundo slot, e por fim do terceiro slot. O jogador com mais número de rounds vencidos ganha a batalha.

#### Exemplos
```
GET <URL>/battle/aloneinabyss/devilady
```

##### Resposta
```
STATUS CODE: 200

{
  "battle": {
    "round_1": {
      "winner": "aloneinabyss",
      "criteria": "hp",
      "player_1": {
        "pokemon": {
          "name": "clefairy",
          ...
        }
      },
      "player_2": {
        "pokemon": {
          "name": "rattata",
          ...
        }
      }
    },
    "round_2": {
      "winner": "devilady",
      "criteria": "attack",
      "player_1": {
        "pokemon": {
          "name": "bulbasaur",
          ...
        }
      },
      "player_2": {
        "pokemon": {
          "name": "pikachu",
          ...
        }
      }
    },
    ...
  },
  "winner": "aloneinabyss"
}
```


## Funcionalidades
Planejadas:
- [x] Documentação inicial
- [ ] Endpoints relacionados aos usuários
- [ ] Endpoints relacionados aos pokémons
- [ ] Endpoints relacionados às batalhas
- [ ] Disponibilizar template para usar no Insomnia
- [ ] Hospedar o projeto em nuvem

Desejadas:
- [ ] Imagem de perfil
- [ ] Histórico de batalhas
- [ ] Habilidades especiais para cada tipo de pokémon
- [ ] Recompensas por vencer batalhas
- [ ] Conquistas para completar
- [ ] Ranking de jogadores


## Outras Informações
Só estão disponíveis os pokémons da primeira geração.

Esta é uma REST API desenvolvida durante o curso de Java da **Let's Code**.
