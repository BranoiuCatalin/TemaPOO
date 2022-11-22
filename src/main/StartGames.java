package main;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import fileio.ActionsInput;
import fileio.CardInput;
import fileio.GameInput;
import fileio.Input;
import main.environmentCards.EnvironmentCard;
import main.environmentCards.Firestorm;
import main.environmentCards.HeartHound;
import main.environmentCards.Winterfell;
import main.heroCards.EmpressThorina;
import main.heroCards.GeneralKocioraw;
import main.heroCards.KingMudface;
import main.heroCards.LordRoyce;
import main.minionCards.*;

import java.io.IOException;
import java.util.*;

public class StartGames {

    private static Player playerOne;
    private static Player playerTwo;
    private static Integer currentPlayer;
    private static Integer nrPlayersEnded = 0;
    private static ArrayList<ArrayList<Card>> table;

    public void startGame (Input input, ArrayNode output) {
        playerOne = new Player();
        playerTwo = new Player();
        table = new ArrayList<ArrayList<Card>>();
        ArrayList<Card> emptyRow = new ArrayList<Card>();
        for(int i =0; i<4; i++) {
            table.add(emptyRow);
        }
        for(GameInput game : input.getGames()) {
            playerOne.setDeck(new ArrayList<>());
            for(CardInput cardIn : input.getPlayerOneDecks().getDecks().get(game.getStartGame().getPlayerOneDeckIdx())) {
                switch(cardIn.getName()) {
                    case "Disciple":
                        playerOne.getDeck().add(new Disciple(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Goliath":
                        playerOne.getDeck().add(new Goliath(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Sentinel":
                        playerOne.getDeck().add(new Sentinel(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Berserker":
                        playerOne.getDeck().add(new Berserker(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "The Cursed One":
                        playerOne.getDeck().add(new TheCursedOne(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Miraj":
                        playerOne.getDeck().add(new Miraj(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Warden":
                        playerOne.getDeck().add(new Warden(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "The Ripper":
                        playerOne.getDeck().add(new TheRipper(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;

                    case "Winterfell":
                        playerOne.getDeck().add(new Winterfell(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Heart Hound":
                        playerOne.getDeck().add(new HeartHound(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Firestorm":
                        playerOne.getDeck().add(new Firestorm(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    default:
                        System.out.println("Carte nerecunoscuta!");
                }

            }

            playerTwo.setDeck(new ArrayList<>());
            for(CardInput cardIn : input.getPlayerTwoDecks().getDecks().get(game.getStartGame().getPlayerTwoDeckIdx())) {
                switch(cardIn.getName()) {
                    case "Disciple":
                        playerTwo.getDeck().add(new Disciple(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Goliath":
                        playerTwo.getDeck().add(new Goliath(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Sentinel":
                        playerTwo.getDeck().add(new Sentinel(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Berserker":
                        playerTwo.getDeck().add(new Berserker(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "The Cursed One":
                        playerTwo.getDeck().add(new TheCursedOne(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Miraj":
                        playerTwo.getDeck().add(new Miraj(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Warden":
                        playerTwo.getDeck().add(new Warden(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "The Ripper":
                        playerTwo.getDeck().add(new TheRipper(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;

                    case "Winterfell":
                        playerTwo.getDeck().add(new Winterfell(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Heart Hound":
                        playerTwo.getDeck().add(new HeartHound(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Firestorm":
                        playerTwo.getDeck().add(new Firestorm(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    default:
                        System.out.println("Carte nerecunoscuta!");
                }

            }

            //System.out.println(playerTwo.getDeck());

            Collections.shuffle(playerOne.getDeck(), new Random(game.getStartGame().getShuffleSeed()));
            Collections.shuffle(playerTwo.getDeck(), new Random(game.getStartGame().getShuffleSeed()));

            //System.out.println(playerTwo.getDeck());



            playerOne.setHand(new ArrayList<>());
            playerTwo.setHand(new ArrayList<>());

            CardInput playerOneHero = game.getStartGame().getPlayerOneHero();
            switch (playerOneHero.getName()) {
                case "Empress Thorina" ->
                        playerOne.setHeroCard(new EmpressThorina(playerOneHero.getMana(), playerOneHero.getDescription(), playerOneHero.getColors(), playerOneHero.getName()));
                case "General Kocioraw" ->
                        playerOne.setHeroCard(new GeneralKocioraw(playerOneHero.getMana(), playerOneHero.getDescription(), playerOneHero.getColors(), playerOneHero.getName()));
                case "King Mudface" ->
                        playerOne.setHeroCard(new KingMudface(playerOneHero.getMana(), playerOneHero.getDescription(), playerOneHero.getColors(), playerOneHero.getName()));
                case "Lord Royce" ->
                        playerOne.setHeroCard(new LordRoyce(playerOneHero.getMana(), playerOneHero.getDescription(), playerOneHero.getColors(), playerOneHero.getName()));
            }

            CardInput playerTwoHero = game.getStartGame().getPlayerTwoHero();
            switch (playerTwoHero.getName()) {
                case "Empress Thorina" ->
                        playerTwo.setHeroCard(new EmpressThorina(playerTwoHero.getMana(), playerTwoHero.getDescription(), playerTwoHero.getColors(), playerTwoHero.getName()));
                case "General Kocioraw" ->
                        playerTwo.setHeroCard(new GeneralKocioraw(playerTwoHero.getMana(), playerTwoHero.getDescription(), playerTwoHero.getColors(), playerTwoHero.getName()));
                case "King Mudface" ->
                        playerTwo.setHeroCard(new KingMudface(playerTwoHero.getMana(), playerTwoHero.getDescription(), playerTwoHero.getColors(), playerTwoHero.getName()));
                case "Lord Royce" ->
                        playerTwo.setHeroCard(new LordRoyce(playerTwoHero.getMana(), playerTwoHero.getDescription(), playerTwoHero.getColors(), playerTwoHero.getName()));
            }

            //System.out.println(playerTwoHero);
            //System.out.println(playerTwo.getHeroCard());

            currentPlayer = game.getStartGame().getStartingPlayer();

            playerOne.getHand().add(playerOne.getDeck().get(0));
            playerOne.getDeck().remove(0);
            playerTwo.getHand().add(playerTwo.getDeck().get(0));
            playerTwo.getDeck().remove(0);

            doActions(game.getActions(), output);
        }

    }

    public void doActions (ArrayList<ActionsInput> actions, ArrayNode output) {
        for (ActionsInput action : actions) {
            switch (action.getCommand()) {
                case "getPlayerDeck":
                    getPlayerDeck(action.getPlayerIdx(), output);
                    break;
                case "getPlayerHero":
                    getPlayerHero(action.getPlayerIdx(), output);
                    break;
                case "getPlayerTurn":
                    getPlayerTurn(output);
                    break;
                case "endPlayerTurn":
                    endPlayerTurn(output);
                    break;
                case "placeCard":
                    placeCard(action.getPlayerIdx(), output);
                    break;
                case "getCardsOnTable":
                    getCardsOnTable(output);
                    break;
            }
        }
    }
    public void getCardsOnTable(ArrayNode output) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode array = mapper.createArrayNode();
        ArrayList<Card> cardsOnTable = new ArrayList<Card>();
        for(int i=0; i<4; i++) {
            for(Card card : table.get(i)) {
                cardsOnTable.add(card);
            }
        }
        try {
        ObjectNode outObject = mapper.createObjectNode();
        outObject.put("command", "getCardsOnTable");
        JsonNode node = null;
        node = mapper.valueToTree(cardsOnTable);
        outObject.put("output", node);
        output.add(outObject);
        }
        catch (Exception ex) {
        ex.printStackTrace();
    }

}
    public void placeCard(Integer handId, ArrayNode output) {
        Card currentCard = null;
        //Integer
        if(currentPlayer == 1) {
            currentCard = playerOne.getHand().get(handId);
            if(Objects.equals(currentCard.getCardPositioning(), "environment")) {
                try {
                    ObjectMapper mapper = new ObjectMapper();

                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "placeCard");
                    outObject.put("playerIdx", handId);
                    outObject.put("error", "Cannot place environment card on table.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if(currentCard.getMana() > playerOne.getMana()) {
                    try {
                        ObjectMapper mapper = new ObjectMapper();

                        ObjectNode outObject = mapper.createObjectNode();
                        outObject.put("command", "placeCard");
                        outObject.put("playerIdx", handId);
                        outObject.put("error", "Not enough mana to place card on table.");
                        output.add(outObject);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if(Objects.equals(currentCard.getCardPositioning(), "front")) {
                        if(table.get(2).size() == 5) {
                            try {
                                ObjectMapper mapper = new ObjectMapper();

                                ObjectNode outObject = mapper.createObjectNode();
                                outObject.put("command", "placeCard");
                                outObject.put("playerIdx", handId);
                                outObject.put("error", "Cannot place card on table since row is full.");
                                output.add(outObject);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            table.get(2).add(currentCard);
                            playerOne.setMana(playerOne.getMana() - currentCard.getMana());
                            playerOne.getHand().remove(handId);
                        }
                    } else
                    if(Objects.equals(currentCard.getCardPositioning(), "back")) {
                        if(table.get(3).size() == 5) {
                            try {
                                ObjectMapper mapper = new ObjectMapper();

                                ObjectNode outObject = mapper.createObjectNode();
                                outObject.put("command", "placeCard");
                                outObject.put("playerIdx", handId);
                                outObject.put("error", "Cannot place card on table since row is full.");
                                output.add(outObject);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }   else {
                            table.get(3).add(currentCard);
                            playerOne.setMana(playerOne.getMana() - currentCard.getMana());
                            playerOne.getHand().remove(handId);
                            }
                    }
                }
            }
        } else {
            currentCard = playerTwo.getHand().get(handId);
            if(Objects.equals(currentCard.getCardPositioning(), "environment")) {
                try {
                    ObjectMapper mapper = new ObjectMapper();

                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "placeCard");
                    outObject.put("playerIdx", handId);
                    outObject.put("error", "Cannot place environment card on table.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                if(currentCard.getMana() > playerTwo.getMana()) {
                    try {
                        ObjectMapper mapper = new ObjectMapper();

                        ObjectNode outObject = mapper.createObjectNode();
                        outObject.put("command", "placeCard");
                        outObject.put("playerIdx", handId);
                        outObject.put("error", "Not enough mana to place card on table.");
                        output.add(outObject);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    if(Objects.equals(currentCard.getCardPositioning(), "front")) {
                        if(table.get(2).size() == 5) {
                            try {
                                ObjectMapper mapper = new ObjectMapper();

                                ObjectNode outObject = mapper.createObjectNode();
                                outObject.put("command", "placeCard");
                                outObject.put("playerIdx", handId);
                                outObject.put("error", "Cannot place card on table since row is full.");
                                output.add(outObject);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        } else {
                            table.get(2).add(currentCard);
                            playerTwo.setMana(playerTwo.getMana() - currentCard.getMana());
                            playerTwo.getHand().remove(handId);
                        }
                    } else
                    if(Objects.equals(currentCard.getCardPositioning(), "back")) {
                        if(table.get(3).size() == 5) {
                            try {
                                ObjectMapper mapper = new ObjectMapper();

                                ObjectNode outObject = mapper.createObjectNode();
                                outObject.put("command", "placeCard");
                                outObject.put("playerIdx", handId);
                                outObject.put("error", "Cannot place card on table since row is full.");
                                output.add(outObject);

                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }   else {
                            table.get(3).add(currentCard);
                            playerTwo.setMana(playerTwo.getMana() - currentCard.getMana());
                            playerTwo.getHand().remove(handId);
                        }
                    }
                }
            }
        }


    }
    public void endPlayerTurn(ArrayNode output) {
        if(currentPlayer == 1) {
            currentPlayer = 2;
        }
        else {
            currentPlayer = 1;
        }
        nrPlayersEnded++;
        if(nrPlayersEnded == 2) {
            nrPlayersEnded = 0;
        }
    }
    public void getPlayerDeck(Integer playerId, ArrayNode output) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode array = mapper.createArrayNode();

            ObjectNode outObject = mapper.createObjectNode();
            outObject.put("command", "getPlayerDeck");
            outObject.put("playerIdx", playerId);
            JsonNode node = null;
            //System.out.println(playerTwo.getDeck());


            if(playerId == 1) {
                node = mapper.valueToTree(playerOne.getDeck()); }
            else if(playerId == 2) {
                node = mapper.valueToTree(playerTwo.getDeck());
            }

            outObject.put("output", node);
            output.add(outObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void getPlayerHero(Integer playerId, ArrayNode output) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode array = mapper.createArrayNode();

            ObjectNode outObject = mapper.createObjectNode();
            outObject.put("command", "getPlayerHero");
            outObject.put("playerIdx", playerId);
            JsonNode node = null;
            if(playerId == 1) {
                node = mapper.valueToTree(playerOne.getHeroCard()); }
            else if(playerId == 2) {
                node = mapper.valueToTree(playerTwo.getHeroCard());
            }
            outObject.put("output", node);
            output.add(outObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getPlayerTurn(ArrayNode output) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode array = mapper.createArrayNode();

            ObjectNode outObject = mapper.createObjectNode();
            outObject.put("command", "getPlayerTurn");
            outObject.put("output", currentPlayer);
            output.add(outObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
