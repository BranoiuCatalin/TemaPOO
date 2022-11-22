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
    private Integer mana = 0;

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

    public HeroCard getHeroCard() {
        return heroCard;
    }

    public void setHeroCard(HeroCard heroCard) {
        this.heroCard = heroCard;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<MinionCard> getFrontRow() {
        return frontRow;
    }

    public void setFrontRow(ArrayList<MinionCard> frontRow) {
        this.frontRow = frontRow;
    }

    public ArrayList<MinionCard> getBackRow() {
        return backRow;
    }

    public void setBackRow(ArrayList<MinionCard> backRow) {
        this.backRow = backRow;
    }

    public Integer getBackrowIndex() {
        return backrowIndex;
    }

    public void setBackrowIndex(Integer backrowIndex) {
        this.backrowIndex = backrowIndex;
    }

    public Integer getFrontrowindex() {
        return frontrowindex;
    }

    public void setFrontrowindex(Integer frontrowindex) {
        this.frontrowindex = frontrowindex;
    }
}
