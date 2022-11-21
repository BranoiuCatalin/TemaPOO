package main.minionCards;

import java.util.ArrayList;

public class Goliath extends MinionCard{
    public Goliath(Integer mana, Integer health, Integer attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, true, false, "front");
    }

    @Override
    public String toString() {
        return "Goliath{} " + super.toString();
    }

}
