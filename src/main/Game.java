package main;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class Game {
    private static Game game = null;

    private Player playerOne;
    private Player playerTwo;
    private ArrayList<MinionCard>[] table;
    private Integer currentPlayer;

    private Game() {}

    public void getCardsOnTable() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<5; j++) {
                if(table[i].get(j) != null) {
                    System.out.println(table[i].get(j));
                }else {
                    System.out.println("None");
                }
            }
        }
    }

    public void getPlayerTurn() {
        System.out.println(currentPlayer);
    }

    public void getPlayerHero(Integer playerId) {
        if(playerId == 1) {
            System.out.println(playerOne.getHeroCard());
        }
        if(playerId == 2) {
            System.out.println(playerTwo.getHeroCard());
        }
    }

    public void getCardPosition(Integer x, Integer y) {
        if(table[x].get(y) != null) {
            System.out.println(table[x].get(y));
        }else {
            System.out.println("No card at that position.");
        }
    }

    public void getPlayerMana(Integer playerId) {
        if(playerId == 1) {
            System.out.println(playerOne.getMana());
        }
        if(playerId == 2) {
            System.out.println(playerTwo.getMana());
        }
    }

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }
}
