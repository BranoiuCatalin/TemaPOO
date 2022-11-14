package main.environmentCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class Firestorm extends EnvironmentCard{
    public Firestorm(Integer mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name);
    }

    public void useCard(ArrayList<MinionCard> attackedRow) {
        for(MinionCard minion : attackedRow) {
            minion.setHealth(minion.getHealth() - 1);
        }
    }

    @Override
    public String toString() {
        return "Firestorm{} " + super.toString();
    }
}
