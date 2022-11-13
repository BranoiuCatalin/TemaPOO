package main.heroCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class EmpressThorina extends HeroCard{
    public EmpressThorina(Integer mana, String description, String colors, String name) {
        super(mana, description, colors, name, 30);
    }

    public void specialAbility(ArrayList<MinionCard> attackedRow) {
        int maxHealth = 0;
        int maxHealthIndex = -1;
        for(int i=0; i<attackedRow.size(); i++) {
            if(attackedRow.get(i).getHealth() > maxHealth) {
                maxHealthIndex = i;
                maxHealth = attackedRow.get(i).getHealth();
            }
        }
        attackedRow.remove(maxHealthIndex);
    }
}
