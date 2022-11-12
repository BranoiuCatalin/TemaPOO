package main.minionCards;

public class Goliath extends MinionCard{
    public Goliath(Integer mana, Integer health, Integer attackDamage, String description, String colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, true, false);
    }
}
