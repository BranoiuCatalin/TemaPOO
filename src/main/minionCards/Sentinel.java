package main.minionCards;

public class Sentinel extends MinionCard{
    public Sentinel(Integer mana, Integer health, Integer attackDamage, String description, String colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, false, false);
    }
}
