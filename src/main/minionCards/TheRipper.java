package main.minionCards;

import java.util.ArrayList;

import static java.lang.Math.max;

public class TheRipper extends MinionCard{
    public TheRipper(Integer mana, Integer health, Integer attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, false, true, "front");
    }

    public void useSpecialAbility(MinionCard enemyMinion) {
        enemyMinion.setAttackDamage(max(enemyMinion.getAttackDamage() - 2, 0));
    }

    @Override
    public String toString() {
        return "TheRipper{} " + super.toString();
    }

}
