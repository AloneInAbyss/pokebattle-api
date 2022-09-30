package com.pokebattle.pokebattleapi.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokebattle.pokebattleapi.exceptions.pokebattle.PokebattleException;
import com.pokebattle.pokebattleapi.exceptions.pokebattle.PokebattleExceptionCodes;
import com.pokebattle.pokebattleapi.model.Pokemon;
import com.pokebattle.pokebattleapi.model.User;
import com.pokebattle.pokebattleapi.service.battle.BattleResult;
import com.pokebattle.pokebattleapi.service.battle.Round;

@Service
public class BattleService {

    @Autowired
    private UserService userService;

    public BattleResult startBattle(String playerOneUsername, String playerTwoUsername) {

        User playerOne = userService.getUserInfo(playerOneUsername);
        User playerTwo = userService.getUserInfo(playerTwoUsername);

        if (playerOne.getTeam() == null || playerTwo.getTeam() == null) {
            throw new PokebattleException(PokebattleExceptionCodes.NO_TEAM_DEFINED);
        }

        HashMap<String, Pokemon> usersPokemonsSlotOne = new HashMap<>();
        HashMap<String, Pokemon> usersPokemonsSlotTwo = new HashMap<>();
        HashMap<String, Pokemon> usersPokemonsSlotThree = new HashMap<>();

        usersPokemonsSlotOne.put("playerOne", playerOne.getTeam().getSlotOne());
        usersPokemonsSlotOne.put("playerTwo", playerTwo.getTeam().getSlotOne());

        usersPokemonsSlotTwo.put("playerOne", playerOne.getTeam().getSlotTwo());
        usersPokemonsSlotTwo.put("playerTwo", playerTwo.getTeam().getSlotTwo());

        usersPokemonsSlotThree.put("playerOne", playerOne.getTeam().getSlotThree());
        usersPokemonsSlotThree.put("playerTwo", playerTwo.getTeam().getSlotThree());

        Round roundOne = new Round(usersPokemonsSlotOne);
        Round roundTwo = new Round(usersPokemonsSlotTwo);
        Round roundThree = new Round(usersPokemonsSlotThree);
        List<Round> rounds = List.of(roundOne, roundTwo, roundThree);

        rounds.forEach(Round::startRoundBattle);

        BattleResult result = getBattleWinner(rounds);

        return result;

    }

    private BattleResult getBattleWinner(List<Round> rounds) {

        HashMap<String, Integer> playerRoundWinsCount = new HashMap<>();
        playerRoundWinsCount.put("playerOne", 0);
        playerRoundWinsCount.put("playerTwo", 0);

        String battleWinner;

        rounds.forEach(round -> {
            String winner = round.getWinner();
            playerRoundWinsCount.put(winner, playerRoundWinsCount.get(winner) + 1);
        });

        if (playerRoundWinsCount.get("playerOne") > playerRoundWinsCount.get("playerTwo")) {
            battleWinner = "playerOne";
        } else {
            battleWinner = "playerTwo";
        }

        return new BattleResult(battleWinner, rounds);

    }
    
}
