package main.environmentCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class HeartHound extends EnvironmentCard{
    public HeartHound(Integer mana, String description, String colors, String name) {
        super(mana, description, colors, name);
    }

    public void useCard(ArrayList<MinionCard> attackedRow) {
        //TODO Implement use method
    }
}