package main.minionCards;

public class Berserker extends MinionCard {
    public Berserker(Integer mana, Integer health, Integer attackDamage, String description, String colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, false, false);
    }
}
