package main;

import main.heroCards.HeroCard;
import main.minionCards.MinionCard;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<MinionCard> frontRow;
    private ArrayList<MinionCard> backRow;
    private HeroCard heroCard;
    private Integer backrowIndex;
    private Integer frontrowindex;

    public void getNextCard() {
        hand.add(deck.get(0));
        deck.remove(0);
    }

    public void unfreezeCards() {
        for(MinionCard minionCard : frontRow) {
            minionCard.setFrozen(false);
        }
        for(MinionCard minionCard : backRow) {
            minionCard.setFrozen(false);
        }
    }
}
