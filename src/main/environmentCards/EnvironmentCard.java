package main.environmentCards;

import main.Card;
import main.minionCards.MinionCard;

import java.util.ArrayList;

public class EnvironmentCard extends Card {

    public EnvironmentCard() {
    }

    public EnvironmentCard(Integer mana, String description, ArrayList<String> colors, String name, String positioning) {
        super(mana, description, colors, name, positioning);
    }

    public void useCard(ArrayList<ArrayList<MinionCard>> table, int affectedRow) {}

    @Override
    public String toString() {
        return "EnvironmentCard{} " + super.toString();
    }
}
