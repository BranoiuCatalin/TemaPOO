package main.heroCards;

import com.fasterxml.jackson.annotation.JsonIgnore;
import main.Card;
import main.minionCards.MinionCard;

import java.util.ArrayList;

public class HeroCard extends Card {

    private Integer health;
    @JsonIgnore
    private Boolean attacked = false;

    public HeroCard() {
    }

    public HeroCard(Integer mana, String description, ArrayList<String> colors, String name, Integer health) {
        super(mana, description, colors, name, "hero");
        this.health = health;
    }

    public void specialAbility(ArrayList<MinionCard> affectedCards) {

    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Boolean getAttacked() {
        return attacked;
    }

    public void setAttacked(Boolean attacked) {
        this.attacked = attacked;
    }
}
