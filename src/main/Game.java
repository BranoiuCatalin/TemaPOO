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

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }
}
