package main.minionCards;

import java.util.ArrayList;

public class TheRipper extends MinionCard{
    public TheRipper(Integer mana, Integer health, Integer attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, false, true, "front");
    }

    public void specialAbility(MinionCard enemyMinion) {
        enemyMinion.setAttackDamage(enemyMinion.getAttackDamage() - 2);
    }

    @Override
    public String toString() {
        return "TheRipper{} " + super.toString();
    }

}
