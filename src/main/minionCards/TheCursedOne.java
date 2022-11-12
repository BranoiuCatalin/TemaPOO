package main.minionCards;

public class TheCursedOne extends MinionCard{
    public TheCursedOne(Integer mana, Integer health, Integer attackDamage, String description, String colors, String name) {
        super(mana, health, 0, description, colors, name, false, false, false, true);
    }

    public void specialAbility(MinionCard enemyMinion) {
        int aux;
        aux = enemyMinion.getHealth();
        enemyMinion.setHealth(enemyMinion.getAttackDamage());
        enemyMinion.setAttackDamage(aux);
    }
}
