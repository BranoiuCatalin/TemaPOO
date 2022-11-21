package main.minionCards;

import java.util.ArrayList;

public class Disciple extends MinionCard{
    public Disciple(Integer mana, Integer health, Integer attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, 0, description, colors, name, false, false, false, true, "back");
    }

    public void specialAbility(MinionCard alliedMinion) {
        alliedMinion.setHealth(alliedMinion.getHealth() + 2);
    }

    @Override
    public String toString() {
        return "Disciple{} " + super.toString();
    }
}
