package main.minionCards;

public class Miraj extends MinionCard{
    public Miraj(Integer mana, Integer health, Integer attackDamage, String description, String colors, String name) {
        super(mana, health, attackDamage, description, colors, name, false, false, false, true);
    }

    public void specialAbility(MinionCard enemyMinion) {
        int aux;
        aux = enemyMinion.getHealth();
        enemyMinion.setHealth(this.getHealth());
        this.setHealth(aux);
    }
}
