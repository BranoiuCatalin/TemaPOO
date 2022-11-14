package main.heroCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class GeneralKocioraw extends HeroCard{
    public GeneralKocioraw(Integer mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name, 30);
    }

    public void specialAbility(ArrayList<MinionCard> alliedRow) {
        for(MinionCard minion : alliedRow) {
            minion.setAttackDamage(minion.getAttackDamage() + 1);
        }
    }
}
