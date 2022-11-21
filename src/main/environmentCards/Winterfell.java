package main.environmentCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class Winterfell extends EnvironmentCard{
    public Winterfell(Integer mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name, "environment");
    }

    public void useCard(ArrayList<MinionCard> attackedRow) {
        for(MinionCard minion : attackedRow) {
            minion.setFrozen(true);
        }
    }

    @Override
    public String toString() {
        return "Winterfell{} " + super.toString();
    }
}
