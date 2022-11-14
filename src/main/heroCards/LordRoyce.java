package main.heroCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class LordRoyce extends HeroCard{
    public LordRoyce(Integer mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name, 30);
    }

    public void specialAbility(ArrayList<MinionCard> attackedRow) {
        int maxAttack = 0;
        int maxAttackIndex = -1;
        for(int i=0; i<attackedRow.size(); i++) {
            if(attackedRow.get(i).getAttackDamage() > maxAttack) {
                maxAttackIndex = i;
                maxAttack = attackedRow.get(i).getAttackDamage();
            }
        }
        attackedRow.get(maxAttackIndex).setFrozen(true);
    }
}
