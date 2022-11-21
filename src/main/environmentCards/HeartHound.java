package main.environmentCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class HeartHound extends EnvironmentCard{
    public HeartHound(Integer mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name, "environment");
    }

    public void useCard(ArrayList<MinionCard> attackedRow) {
        //TODO Implement use method
    }

    @Override
    public String toString() {
        return "HeartHound{} " + super.toString();
    }
}
