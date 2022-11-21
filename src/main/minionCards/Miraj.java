package main.minionCards;

import java.util.ArrayList;

public class Miraj extends MinionCard{
    public Miraj(Integer mana, Integer health, Integer attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, false, true, "front");
    }

    public void specialAbility(MinionCard enemyMinion) {
        int aux;
        aux = enemyMinion.getHealth();
        enemyMinion.setHealth(this.getHealth());
        this.setHealth(aux);
    }


    @Override
    public String toString() {
        return "Miraj{} " + super.toString();
    }

}
