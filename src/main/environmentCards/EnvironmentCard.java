package main.environmentCards;

import main.Card;

public class EnvironmentCard extends Card {
    private Integer mana;
    private String description;
    private String colors;
    private String name;

    public EnvironmentCard() {
    }

    public EnvironmentCard(Integer mana, String description, String colors, String name) {
        super(mana, description, colors, name);
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
}
