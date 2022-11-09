package com.pokebattle.pokebattleapi.service.battle;

import java.util.HashMap;
import java.util.Random;

import com.pokebattle.pokebattleapi.model.Pokemon;

import lombok.Getter;

@Getter
public class Round {

    private HashMap<String, Pokemon> usersPokemons;
    private RoundCriteria criteria;
    private String winner;

    public Round(HashMap<String, Pokemon> usersPokemons) {
        this.usersPokemons = usersPokemons;
    }

    public void startRoundBattle() {
        this.criteria = RoundCriteria.random();

        Integer pokemonOneStat;
        Integer pokemonTwoStat;

        switch (this.criteria) {
            case ATTACK:
                pokemonOneStat = this.usersPokemons.get("playerOne").getAttributes().getAttack();
                pokemonTwoStat = this.usersPokemons.get("playerTwo").getAttributes().getAttack();
                break;
                
            case DEFENSE:
                pokemonOneStat = this.usersPokemons.get("playerOne").getAttributes().getDefense();
                pokemonTwoStat = this.usersPokemons.get("playerTwo").getAttributes().getDefense();
                break;
            
            case HP:
                pokemonOneStat = this.usersPokemons.get("playerOne").getAttributes().getHp();
                pokemonTwoStat = this.usersPokemons.get("playerTwo").getAttributes().getHp();
                break;
            
            default:
                throw new RuntimeException("Impossible!");
        }

        if (pokemonOneStat > pokemonTwoStat) {
            this.winner = "playerOne";
        } else if (pokemonOneStat < pokemonTwoStat) {
            this.winner = "playerTwo";
        } else {
            Random random = new Random();
            
            int n = random.nextInt(2);
            if (n == 1) {
                this.winner = "playerOne";
            } else {
                this.winner = "playerTwo";
            }
        }
    }
    
}
