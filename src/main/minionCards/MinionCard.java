package main.minionCards;

public class MinionCard {
    private Integer mana;
    private Integer health;
    private Integer attackDamage;
    private String description;
    private String colors;
    private String name;
    private Boolean attacked;
    private Boolean frozen;
    private Boolean isTank;
    private Boolean hasSpecialAbility;

    public MinionCard() {}

    public MinionCard(Integer mana, Integer health, Integer attackDamage, String description, String colors, String name, Boolean attacked, Boolean frozen, Boolean isTank, Boolean hasSpecialAbility) {
        this.mana = mana;
        this.health = health;
        this.attackDamage = attackDamage;
        this.description = description;
        this.colors = colors;
        this.name = name;
        this.attacked = attacked;
        this.frozen = frozen;
        this.isTank = isTank;
        this.hasSpecialAbility = hasSpecialAbility;
    }

    public Boolean getHasSpecialAbility() {
        return hasSpecialAbility;
    }

    public void setHasSpecialAbility(Boolean hasSpecialAbility) {
        this.hasSpecialAbility = hasSpecialAbility;
    }

    public void useSpecialAbility() {

    }

    public void attack() {

    }

    public Boolean getTank() {
        return isTank;
    }

    public void setTank(Boolean tank) {
        isTank = tank;
    }

    public Boolean getAttacked() {
        return attacked;
    }

    public void setAttacked(Boolean attacked) {
        this.attacked = attacked;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(Integer attackDamage) {
        this.attackDamage = attackDamage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
