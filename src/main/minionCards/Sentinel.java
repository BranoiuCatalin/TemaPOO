package main.minionCards;

import java.util.ArrayList;

public class Sentinel extends MinionCard{
    public Sentinel(Integer mana, Integer health, Integer attackDamage, String description, ArrayList<String> colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, false, false);
    }

    @Override
    public String toString() {
        return "Sentinel{} " + super.toString();
    }
}
