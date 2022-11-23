package main.environmentCards;

import main.Card;
import main.minionCards.MinionCard;

import java.util.ArrayList;

public class Firestorm extends EnvironmentCard{
    public Firestorm(Integer mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name, "environment");
    }

    public void useCard(ArrayList<ArrayList<MinionCard>> table, int affectedRow) {
        for(MinionCard minion : table.get(affectedRow)) {
            minion.setHealth(minion.getHealth() - 1);
        }
    }

    @Override
    public String toString() {
        return "Firestorm{} " + super.toString();
    }
}
