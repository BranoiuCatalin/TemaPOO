package main.heroCards;

import main.Card;

public class HeroCard extends Card {
    private Integer mana;
    private String description;
    private String colors;
    private String name;
    private Integer health;

    public HeroCard() {
    }

    public HeroCard(Integer mana, String description, String colors, String name, Integer health) {
        super(mana, description, colors, name);
        this.health = health;
    }


    public Integer getMana() {
        return mana;
    }

    public void setMana(Integer mana) {
        this.mana = mana;
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

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
}
