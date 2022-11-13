package main.heroCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class KingMudface extends HeroCard{
    public KingMudface(Integer mana, String description, String colors, String name) {
        super(mana, description, colors, name, 30);
    }

    public void specialAbility(ArrayList<MinionCard> alliedRow) {
        for(MinionCard minion : alliedRow) {
            minion.setHealth(minion.getHealth() + 1);
        }
    }
}
