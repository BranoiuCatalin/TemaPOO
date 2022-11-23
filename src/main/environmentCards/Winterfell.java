package main.environmentCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class Winterfell extends EnvironmentCard{
    public Winterfell(Integer mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name, "environment");
    }

    public void useCard(ArrayList<ArrayList<MinionCard>> table, int affectedRow) {
        for(MinionCard minion : table.get(affectedRow)) {
            minion.setFrozen(true);
        }
    }

    @Override
    public String toString() {
        return "Winterfell{} " + super.toString();
    }
}
