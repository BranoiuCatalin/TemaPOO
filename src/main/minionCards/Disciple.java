package main.minionCards;

public class Disciple extends MinionCard{
    public Disciple(Integer mana, Integer health, Integer attackDamage, String description, String colors, String name) {
        super(mana, health, 0, description, colors, name, false, false, false, true);
    }

    public void specialAbility(MinionCard alliedMinion) {
        alliedMinion.setHealth(alliedMinion.getHealth() + 2);
    }
}
