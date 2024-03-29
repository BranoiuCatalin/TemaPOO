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
import fileio.*;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.max;

public class StartGames {
    private final Player[] players = new Player[2];
    private Integer currentPlayer;
    private Integer nrPlayersEnded = 0;
    private Integer manaToGive = 2;
    private ArrayList<ArrayList<MinionCard>> table;
    private int[] gamesWon = new int[2];

    public void startGame(Input input, ArrayNode output) {
        gamesWon[0] = 0;
        gamesWon[1] = 0;
        for (GameInput game : input.getGames()) {
            manaToGive = 2;
            nrPlayersEnded = 0;
            players[0] = new Player();
            players[1] = new Player();
            table = new ArrayList<ArrayList<MinionCard>>();
            ArrayList<Card> emptyRow = new ArrayList<Card>();
            for (int i = 0; i < 4; i++) {
                table.add(new ArrayList<MinionCard>());
            }
            players[0].setDeck(new ArrayList<>());
            for (CardInput cardIn : input.getPlayerOneDecks().getDecks().get(game.getStartGame().getPlayerOneDeckIdx())) {
                switch (cardIn.getName()) {
                    case "Disciple":
                        players[0].getDeck().add(new Disciple(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Goliath":
                        players[0].getDeck().add(new Goliath(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Sentinel":
                        players[0].getDeck().add(new Sentinel(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Berserker":
                        players[0].getDeck().add(new Berserker(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "The Cursed One":
                        players[0].getDeck().add(new TheCursedOne(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Miraj":
                        players[0].getDeck().add(new Miraj(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Warden":
                        players[0].getDeck().add(new Warden(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "The Ripper":
                        players[0].getDeck().add(new TheRipper(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;

                    case "Winterfell":
                        players[0].getDeck().add(new Winterfell(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Heart Hound":
                        players[0].getDeck().add(new HeartHound(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Firestorm":
                        players[0].getDeck().add(new Firestorm(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    default:
                        System.out.println("Carte nerecunoscuta!");
                }

            }

            players[1].setDeck(new ArrayList<>());
            for (CardInput cardIn : input.getPlayerTwoDecks().getDecks().get(game.getStartGame().getPlayerTwoDeckIdx())) {
                switch (cardIn.getName()) {
                    case "Disciple":
                        players[1].getDeck().add(new Disciple(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Goliath":
                        players[1].getDeck().add(new Goliath(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Sentinel":
                        players[1].getDeck().add(new Sentinel(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Berserker":
                        players[1].getDeck().add(new Berserker(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "The Cursed One":
                        players[1].getDeck().add(new TheCursedOne(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Miraj":
                        players[1].getDeck().add(new Miraj(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Warden":
                        players[1].getDeck().add(new Warden(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "The Ripper":
                        players[1].getDeck().add(new TheRipper(cardIn.getMana(), cardIn.getHealth(), cardIn.getAttackDamage(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;

                    case "Winterfell":
                        players[1].getDeck().add(new Winterfell(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Heart Hound":
                        players[1].getDeck().add(new HeartHound(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    case "Firestorm":
                        players[1].getDeck().add(new Firestorm(cardIn.getMana(), cardIn.getDescription(), cardIn.getColors(), cardIn.getName()));
                        break;
                    default:
                        System.out.println("Carte nerecunoscuta!");
                }

            }

            //System.out.println(players[1].getDeck());

            Collections.shuffle(players[0].getDeck(), new Random(game.getStartGame().getShuffleSeed()));
            Collections.shuffle(players[1].getDeck(), new Random(game.getStartGame().getShuffleSeed()));

            //System.out.println(players[1].getDeck());


            players[0].setHand(new ArrayList<>());
            players[1].setHand(new ArrayList<>());

            CardInput playerOneHero = game.getStartGame().getPlayerOneHero();
            switch (playerOneHero.getName()) {
                case "Empress Thorina" ->
                        players[0].setHeroCard(new EmpressThorina(playerOneHero.getMana(), playerOneHero.getDescription(), playerOneHero.getColors(), playerOneHero.getName()));
                case "General Kocioraw" ->
                        players[0].setHeroCard(new GeneralKocioraw(playerOneHero.getMana(), playerOneHero.getDescription(), playerOneHero.getColors(), playerOneHero.getName()));
                case "King Mudface" ->
                        players[0].setHeroCard(new KingMudface(playerOneHero.getMana(), playerOneHero.getDescription(), playerOneHero.getColors(), playerOneHero.getName()));
                case "Lord Royce" ->
                        players[0].setHeroCard(new LordRoyce(playerOneHero.getMana(), playerOneHero.getDescription(), playerOneHero.getColors(), playerOneHero.getName()));
            }

            CardInput playerTwoHero = game.getStartGame().getPlayerTwoHero();
            switch (playerTwoHero.getName()) {
                case "Empress Thorina" ->
                        players[1].setHeroCard(new EmpressThorina(playerTwoHero.getMana(), playerTwoHero.getDescription(), playerTwoHero.getColors(), playerTwoHero.getName()));
                case "General Kocioraw" ->
                        players[1].setHeroCard(new GeneralKocioraw(playerTwoHero.getMana(), playerTwoHero.getDescription(), playerTwoHero.getColors(), playerTwoHero.getName()));
                case "King Mudface" ->
                        players[1].setHeroCard(new KingMudface(playerTwoHero.getMana(), playerTwoHero.getDescription(), playerTwoHero.getColors(), playerTwoHero.getName()));
                case "Lord Royce" ->
                        players[1].setHeroCard(new LordRoyce(playerTwoHero.getMana(), playerTwoHero.getDescription(), playerTwoHero.getColors(), playerTwoHero.getName()));
            }

            //System.out.println(playerTwoHero);
            //System.out.println(players[1].getHeroCard());

            currentPlayer = game.getStartGame().getStartingPlayer();

            players[0].getHand().add(players[0].getDeck().get(0));
            players[0].getDeck().remove(0);
            players[1].getHand().add(players[1].getDeck().get(0));
            players[1].getDeck().remove(0);

//            getPlayerDeck(1, output);
//            getPlayerDeck(2, output);
//
//            getCardsInHand(1, output);
//            getCardsInHand(2, output);


            doActions(game.getActions(), output);
        }

    }

    public void doActions(ArrayList<ActionsInput> actions, ArrayNode output) {
        Boolean gameEnded = false;
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
                    placeCard(action.getHandIdx(), output);
                    break;
                case "getCardsOnTable":
                    getCardsOnTable(output);
                    break;
                case "getCardsInHand":
                    getCardsInHand(action.getPlayerIdx(), output);
                    break;
                case "getPlayerMana":
                    getPlayerMana(action.getPlayerIdx(), output);
                    break;
                case "useEnvironmentCard":
                    useEnvironmentCard(action.getHandIdx(), action.getAffectedRow(), output);
                    break;
                case "getEnvironmentCardsInHand":
                    getEnvironmentCardsInHand(action.getPlayerIdx(), output);
                    break;
                case "getCardAtPosition":
                    getCardAtPosition(action.getX(), action.getY(), output);
                    break;
                case "getFrozenCardsOnTable":
                    getFrozenCardsOnTable(output);
                    break;
                case "cardUsesAttack":
                    cardUsesAttack(action.getCardAttacker(), action.getCardAttacked(), output);
                    break;
                case "cardUsesAbility":
                    cardUsesAbility(action.getCardAttacker(), action.getCardAttacked(), output);
                    break;
                case "useAttackHero":
                    gameEnded = useAttackHero(action.getCardAttacker(), output);
                    break;
                case "useHeroAbility":
                    useHeroAbility(action.getAffectedRow(), output);
                    break;
                case "getPlayerOneWins":
                    getPlayerWins(1,output);
                    break;
                case "getPlayerTwoWins":
                    getPlayerWins(2,output);
                    break;
                case "getTotalGamesPlayed":
                    getPlayerWins(3,output);
                    break;

            }
            if(gameEnded && action.getCommand() == "endPlayerTurn") {
                break;

            }
            for(ArrayList<MinionCard> row : table) {
                for(int i = row.size()-1; i>=0; i--) {
                    if(row.get(i).getHealth() <= 0) {
                        row.remove(i);
                    }
                }
            }
            if(table.get(3).size() > 0)
            System.out.println("aa" + table.get(3).get(0).getAttacked());
        }
    }

    public void getPlayerWins(int playerId, ArrayNode output) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode outObject = mapper.createObjectNode();
                if(playerId == 3) {
                    outObject.put("command", "getTotalGamesPlayed");
                } else if(playerId == 1) {
                    outObject.put("command", "getPlayerOneWins");
                } else {
                    outObject.put("command", "getPlayerTwoWins");
                }

                if(playerId == 3) {
                    outObject.put("output", Arrays.stream(gamesWon).sum());
                } else {
                    outObject.put("output", gamesWon[playerId-1]);
                }
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

    }
    public void useHeroAbility(int affectedRow, ArrayNode output) {
        if(players[currentPlayer-1].getMana() < players[currentPlayer-1].getHeroCard().getMana()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "useHeroAbility");
                outObject.put("affectedRow", affectedRow);
                outObject.put("error", "Not enough mana to use hero's ability.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(players[currentPlayer-1].getHeroCard().getAttacked()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "useHeroAbility");
                outObject.put("affectedRow", affectedRow);
                outObject.put("error", "Hero has already attacked this turn.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if(players[currentPlayer-1].getHeroCard() instanceof LordRoyce || players[currentPlayer-1].getHeroCard() instanceof EmpressThorina) {
            if((currentPlayer == 1 && affectedRow>1) || (currentPlayer == 2 && affectedRow<2)){
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "useHeroAbility");
                    outObject.put("affectedRow", affectedRow);
                    outObject.put("error", "Selected row does not belong to the enemy.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else {
                players[currentPlayer-1].getHeroCard().specialAbility(table.get(affectedRow));
                players[currentPlayer-1].getHeroCard().setAttacked(true);
                players[currentPlayer-1].setMana(players[currentPlayer-1].getMana() - players[currentPlayer-1].getHeroCard().getMana());
            }
        }
        else  {
            if((currentPlayer == 1 && affectedRow<2) || (currentPlayer == 2 && affectedRow>1)){
                try {
                    ObjectMapper mapper = new ObjectMapper();
                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "useHeroAbility");
                    outObject.put("affectedRow", affectedRow);
                    outObject.put("error", "Selected row does not belong to the current player.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else {
                players[currentPlayer-1].getHeroCard().specialAbility(table.get(affectedRow));
                players[currentPlayer-1].getHeroCard().setAttacked(true);
                players[currentPlayer-1].setMana(players[currentPlayer-1].getMana() - players[currentPlayer-1].getHeroCard().getMana());
            }
        }
    }
    public Boolean useAttackHero(Coordinates attacker, ArrayNode output) {
        if(table.get(attacker.getX()).size() <= attacker.getY()) {
            return false;
        }
        MinionCard atkrCard = table.get(attacker.getX()).get(attacker.getY());

        if (atkrCard.getFrozen()) {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "useAttackHero");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                outObject.put("error", "Attacker card is frozen.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (atkrCard.getAttacked()) {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "useAttackHero");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                outObject.put("error", "Attacker card has already attacked this turn.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (Stream.of(table.get((3-attacker.getX())), table.get((3-attacker.getX()) ^ 1)).flatMap(List::stream).anyMatch(card -> card.getTank())){
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "useAttackHero");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                outObject.put("error", "Attacked card is not of type 'Tank'.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            players[2-currentPlayer].getHeroCard().setHealth(players[2-currentPlayer].getHeroCard().getHealth() - atkrCard.getAttackDamage());
            atkrCard.setAttacked(true);
        }
        if(players[2-currentPlayer].getHeroCard().getHealth()<=0) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                ObjectNode outObject = mapper.createObjectNode();
                if(currentPlayer == 1) {
                outObject.put("gameEnded", "Player one killed the enemy hero.");
                }
                else {
                    outObject.put("gameEnded", "Player two killed the enemy hero.");
                }
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            gamesWon[currentPlayer-1]++;
            return true;
        }
        return false;
    }
    public void cardUsesAbility(Coordinates attacker, Coordinates attacked, ArrayNode output) {
        if(table.get(attacker.getX()).size() <= attacker.getY() || table.get(attacked.getX()).size() <= attacked.getY()) {
            return;
        }
        MinionCard atkrCard = table.get(attacker.getX()).get(attacker.getY());
        MinionCard atkdCard = table.get(attacked.getX()).get(attacked.getY());
        System.out.println(attacker);
        System.out.println(atkrCard.getAttacked());
        if (atkrCard.getFrozen()) {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "cardUsesAbility");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                node = mapper.valueToTree(attacked);
                outObject.put("cardAttacked", node);
                outObject.put("error", "Attacker card is frozen.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (atkrCard.getAttacked()) {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "cardUsesAbility");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                node = mapper.valueToTree(attacked);
                outObject.put("cardAttacked", node);
                outObject.put("error", "Attacker card has already attacked this turn.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (atkrCard instanceof Disciple) {
            if((currentPlayer == 1 && attacked.getX()<2) || (currentPlayer == 2 && attacked.getX()>1)) {
                try {
                    ObjectMapper mapper = new ObjectMapper();


                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "cardUsesAbility");
                    JsonNode node = null;
                    //System.out.println(players[1].getDeck());

                    node = mapper.valueToTree(attacker);
                    outObject.put("cardAttacker", node);
                    node = mapper.valueToTree(attacked);
                    outObject.put("cardAttacked", node);
                    outObject.put("error", "Attacked card does not belong to the current player.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                atkrCard.useSpecialAbility(atkdCard);
                atkrCard.setAttacked(true);
            }
        }
        else if((currentPlayer == 1 && attacked.getX()>1) || (currentPlayer == 2 && attacked.getX()<2)) {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "cardUsesAbility");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                node = mapper.valueToTree(attacked);
                outObject.put("cardAttacked", node);
                outObject.put("error", "Attacked card does not belong to the enemy.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else if (!atkdCard.getTank() && Stream.of(table.get(attacked.getX()), table.get(attacked.getX() ^ 1)).flatMap(List::stream).anyMatch(card -> card.getTank())){
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "cardUsesAbility");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                node = mapper.valueToTree(attacked);
                outObject.put("cardAttacked", node);
                outObject.put("error", "Attacked card is not of type 'Tank'.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            atkrCard.useSpecialAbility(atkdCard);
            atkrCard.setAttacked(true);
        }
    }
    public void cardUsesAttack(Coordinates attacker, Coordinates attacked, ArrayNode output) {
        if(table.get(attacker.getX()).size() <= attacker.getY() || table.get(attacked.getX()).size() <= attacked.getY()) {
            return;
        }
        MinionCard atkrCard = table.get(attacker.getX()).get(attacker.getY());
        MinionCard atkdCard = table.get(attacked.getX()).get(attacked.getY());
        if((currentPlayer == 1 && attacked.getX()>1) || (currentPlayer == 2 && attacked.getX()<2)) {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "cardUsesAttack");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                node = mapper.valueToTree(attacked);
                outObject.put("cardAttacked", node);
                outObject.put("error", "Attacked card does not belong to the enemy.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (atkrCard.getAttacked()) {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "cardUsesAttack");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                node = mapper.valueToTree(attacked);
                outObject.put("cardAttacked", node);
                outObject.put("error", "Attacker card has already attacked this turn.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (atkrCard.getFrozen()) {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "cardUsesAttack");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                node = mapper.valueToTree(attacked);
                outObject.put("cardAttacked", node);
                outObject.put("error", "Attacker card is frozen.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (!atkdCard.getTank() && Stream.of(table.get(attacked.getX()), table.get(attacked.getX() ^ 1)).flatMap(List::stream).anyMatch(card -> card.getTank())){
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "cardUsesAttack");
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(attacker);
                outObject.put("cardAttacker", node);
                node = mapper.valueToTree(attacked);
                outObject.put("cardAttacked", node);
                outObject.put("error", "Attacked card is not of type 'Tank'.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            atkdCard.setHealth(atkdCard.getHealth() - atkrCard.getAttackDamage());
            atkrCard.setAttacked(true);
        }
    }
    public void getFrozenCardsOnTable(ArrayNode output) {
        List<Card> frozCards = table.stream().flatMap(List::stream).filter(card -> card.getFrozen()).collect(Collectors.toList());
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode outObject = mapper.createObjectNode();
            outObject.put("command", "getFrozenCardsOnTable");
            JsonNode node = null;
            node = mapper.valueToTree(frozCards);
            outObject.put("output", node);
            output.add(outObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void getCardAtPosition(int x, int y, ArrayNode output) {
        if(table.get(x).size() <= y) {
            try {
                ObjectMapper mapper = new ObjectMapper();

                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "getCardAtPosition");
                outObject.put("x", x);
                outObject.put("y", y);
                outObject.put("output", "No card available at that position.");
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                ObjectMapper mapper = new ObjectMapper();


                ObjectNode outObject = mapper.createObjectNode();
                outObject.put("command", "getCardAtPosition");
                outObject.put("x", x);
                outObject.put("y", y);
                JsonNode node = null;
                //System.out.println(players[1].getDeck());

                node = mapper.valueToTree(table.get(x).get(y));
                outObject.put("output", node);
                output.add(outObject);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
    public void getEnvironmentCardsInHand(int playerId, ArrayNode output) {
        List<Card> envCards = players[playerId-1].getHand().stream().filter(card -> card.getCardPositioning() == "environment").collect(Collectors.toList());

        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode array = mapper.createArrayNode();

            ObjectNode outObject = mapper.createObjectNode();
            outObject.put("command", "getEnvironmentCardsInHand");
            outObject.put("playerIdx", playerId);
            JsonNode node = null;
            //System.out.println(players[1].getDeck());

            node = mapper.valueToTree(envCards);
            outObject.put("output", node);
            output.add(outObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void useEnvironmentCard(int handId, int affectedRow, ArrayNode output) {
        if (players[currentPlayer - 1].getHand().size() > handId) {
            Card currentCard = players[currentPlayer - 1].getHand().get(handId);
            if (!(Objects.equals(currentCard.getCardPositioning(), "environment"))) {
                try {
                    ObjectMapper mapper = new ObjectMapper();

                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "useEnvironmentCard");
                    outObject.put("handIdx", handId);
                    outObject.put("affectedRow", affectedRow);
                    outObject.put("error", "Chosen card is not of type environment.");
                    output.add(outObject);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (currentCard.getMana() > players[currentPlayer - 1].getMana()) {
                try {
                    ObjectMapper mapper = new ObjectMapper();

                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "useEnvironmentCard");
                    outObject.put("handIdx", handId);
                    outObject.put("affectedRow", affectedRow);
                    outObject.put("error", "Not enough mana to use environment card.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if((currentPlayer == 1 && affectedRow>1) || (currentPlayer == 2 && affectedRow<2)) {
                try {
                    ObjectMapper mapper = new ObjectMapper();

                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "useEnvironmentCard");
                    outObject.put("handIdx", handId);
                    outObject.put("affectedRow", affectedRow);
                    outObject.put("error", "Chosen row does not belong to the enemy.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (currentCard instanceof HeartHound && table.get(3-affectedRow).size() == 5){
                try {
                    ObjectMapper mapper = new ObjectMapper();

                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "useEnvironmentCard");
                    outObject.put("handIdx", handId);
                    outObject.put("affectedRow", affectedRow);
                    outObject.put("error", "Cannot steal enemy card since the player's row is full.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                ((EnvironmentCard)currentCard).useCard(table, affectedRow);
                players[currentPlayer-1].setMana(players[currentPlayer-1].getMana()-currentCard.getMana());
                players[currentPlayer-1].getHand().remove(handId);
            }
        }
    }

    public void getPlayerMana(int playerId, ArrayNode output) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode array = mapper.createArrayNode();

            ObjectNode outObject = mapper.createObjectNode();
            outObject.put("command", "getPlayerMana");
            outObject.put("playerIdx", playerId);
            outObject.put("output", players[playerId - 1].getMana());
            output.add(outObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getCardsInHand(Integer playerId, ArrayNode output) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayNode array = mapper.createArrayNode();

            ObjectNode outObject = mapper.createObjectNode();
            outObject.put("command", "getCardsInHand");
            outObject.put("playerIdx", playerId);
            JsonNode node = null;
            //System.out.println(players[1].getDeck());

            node = mapper.valueToTree(players[playerId - 1].getHand());
            outObject.put("output", node);
            output.add(outObject);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getCardsOnTable(ArrayNode output) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode array = mapper.createArrayNode();
        ArrayList<Card> cardsOnTable = new ArrayList<Card>();
//        for (int i = 0; i < 4; i++) {
//            for (Card card : table.get(i)) {
//                cardsOnTable.add(card);
//            }
//        }
        try {
            ObjectNode outObject = mapper.createObjectNode();
            outObject.put("command", "getCardsOnTable");
            JsonNode node = null;
            node = mapper.valueToTree(table);
            outObject.put("output", node);
            output.add(outObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void printTable() {
        System.out.println(table.get(0));
        System.out.println(table.get(1));
        System.out.println(table.get(2));
        System.out.println(table.get(3));
    }

    public void placeCard(Integer handId, ArrayNode output) {
        //System.out.println("PLAYER:" + currentPlayer + "MANA BEFORE:" + players[currentPlayer - 1].getMana());
        //printTable();
        Card currentCard = null;
        //Integer

        if (players[currentPlayer - 1].getHand().size() > handId) {
            //System.out.println(players[currentPlayer - 1].getHand());
           // System.out.println("HAND ID" + handId);
            currentCard = players[currentPlayer - 1].getHand().get((int) handId);
            if (Objects.equals(currentCard.getCardPositioning(), "environment")) {
                try {
                    ObjectMapper mapper = new ObjectMapper();

                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "placeCard");
                    outObject.put("handIdx", handId);
                    outObject.put("error", "Cannot place environment card on table.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else if (currentCard.getMana() > players[currentPlayer - 1].getMana()) {
                try {
                    ObjectMapper mapper = new ObjectMapper();

                    ObjectNode outObject = mapper.createObjectNode();
                    outObject.put("command", "placeCard");
                    outObject.put("handIdx", handId);
                    outObject.put("error", "Not enough mana to place card on table.");
                    output.add(outObject);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                //.println("aaaaa");
            } else if (Objects.equals(currentCard.getCardPositioning(), "front")) {
                if (table.get(3 - currentPlayer).size() == 5) {
                    try {
                        ObjectMapper mapper = new ObjectMapper();

                        ObjectNode outObject = mapper.createObjectNode();
                        outObject.put("command", "placeCard");
                        outObject.put("handIdx", handId);
                        outObject.put("error", "Cannot place card on table since row is full.");
                        output.add(outObject);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    table.get(3 - currentPlayer).add((MinionCard) currentCard);
                    players[currentPlayer - 1].setMana(players[currentPlayer - 1].getMana() - currentCard.getMana());
                    players[currentPlayer - 1].getHand().remove((int) handId);
                }
            } else if (Objects.equals(currentCard.getCardPositioning(), "back")) {
                if (table.get(6 - 3 * currentPlayer).size() == 5) {
                    try {
                        ObjectMapper mapper = new ObjectMapper();

                        ObjectNode outObject = mapper.createObjectNode();
                        outObject.put("command", "placeCard");
                        outObject.put("handIdx", handId);
                        outObject.put("error", "Cannot place card on table since row is full.");
                        output.add(outObject);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    table.get(6 - 3 * currentPlayer).add((MinionCard) currentCard);
                    players[currentPlayer - 1].setMana(players[currentPlayer - 1].getMana() - currentCard.getMana());
                    players[currentPlayer - 1].getHand().remove((int) handId);
                }
            }
        }

        //.println("MANA AFTER:" + players[currentPlayer - 1].getMana());
        //.println(currentCard);
    }

    public void endPlayerTurn(ArrayNode output) {
        for(int i=0; i<2; i++) {
            for(MinionCard card : table.get((4-2*currentPlayer) + i)) {
                card.setFrozen(false);
                card.setAttacked(false);
            }
        }
        players[currentPlayer-1].getHeroCard().setAttacked(false);
        System.out.println("reset for player" + currentPlayer);

        if (currentPlayer == 1) {
            currentPlayer = 2;
        } else {
            currentPlayer = 1;
        }
        nrPlayersEnded++;
        if (nrPlayersEnded == 2) {
            nrPlayersEnded = 0;
            players[0].setMana(players[0].getMana() + manaToGive);
            players[1].setMana(players[1].getMana() + manaToGive);
            manaToGive++;
            manaToGive = Math.min(10, manaToGive);
            if (players[0].getDeck().size() != 0) {
                players[0].getHand().add(players[0].getDeck().get(0));
                players[0].getDeck().remove(0);
            }
            if (players[1].getDeck().size() != 0) {
                players[1].getHand().add(players[1].getDeck().get(0));
                players[1].getDeck().remove(0);
            }
            //.println(players[0].getMana());
            //.println(players[1].getMana());
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
            //System.out.println(players[1].getDeck());


            node = mapper.valueToTree(players[playerId - 1].getDeck());


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
            node = mapper.valueToTree(players[playerId - 1].getHeroCard());

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
