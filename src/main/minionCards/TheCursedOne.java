package main.minionCards;

import java.util.ArrayList;

public class TheCursedOne extends MinionCard{
    public TheCursedOne(Integer mana, Integer health, Integer attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, 0, description, colors, name, false, false, false, true, "back");
    }

    public void useSpecialAbility(MinionCard enemyMinion) {
        int aux;
        aux = enemyMinion.getHealth();
        enemyMinion.setHealth(enemyMinion.getAttackDamage());
        enemyMinion.setAttackDamage(aux);
    }

    @Override
    public String toString() {
        return "TheCursedOne{} " + super.toString();
    }
}
