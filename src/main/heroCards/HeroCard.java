package main.heroCards;

import main.Card;

import java.util.ArrayList;

public class HeroCard extends Card {

    private Integer health;

    public HeroCard() {
    }

    public HeroCard(Integer mana, String description, ArrayList<String> colors, String name, Integer health) {
        super(mana, description, colors, name);
        this.health = health;
    }


    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
