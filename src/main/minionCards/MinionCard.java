package main.minionCards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import main.Card;

import java.util.ArrayList;

public class MinionCard extends Card {
    //@JsonInclude(JsonInclude.Include.NON_NULL)

    private Integer health;
    private Integer attackDamage;
    @JsonIgnore
    private Boolean attacked;
   @JsonIgnore
    private Boolean frozen;
    @JsonIgnore
    private Boolean tank;
    @JsonIgnore
    private Boolean hasSpecialAbility;

    public MinionCard() {}

    public MinionCard(Integer mana, Integer health, Integer attackDamage, String description, ArrayList<String> colors, String name, Boolean attacked, Boolean frozen, Boolean isTank, Boolean hasSpecialAbility) {
        super(mana, description, colors, name);
        this.health = health;
        this.attackDamage = attackDamage;
        this.attacked = attacked;
        this.frozen = frozen;
        this.tank = isTank;
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
        return tank;
    }

    public void setTank(Boolean tank) {
        tank = tank;
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

    @Override
    public String toString() {
        return "MinionCard{" +
                "health=" + health +
                ", attackDamage=" + attackDamage +
                ", attacked=" + attacked +
                ", frozen=" + frozen +
                ", isTank=" + tank +
                ", hasSpecialAbility=" + hasSpecialAbility +
                "} " + super.toString();
    }
}
