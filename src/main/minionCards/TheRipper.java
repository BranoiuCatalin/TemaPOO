package main.minionCards;

public class TheRipper extends MinionCard{
    public TheRipper(Integer mana, Integer health, Integer attackDamage, String description, String colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, false, true);
    }

    public void specialAbility(MinionCard enemyMinion) {
        enemyMinion.setAttackDamage(enemyMinion.getAttackDamage() - 2);
    }
}
