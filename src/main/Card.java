package main;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Card {
    private Integer mana;
    private String description;
    private ArrayList<String> colors;
    private String name;
    @JsonIgnore
    private String cardPositioning;

    public Card() {
    }


    public Card(Integer mana, String description, ArrayList<String> colors, String name, String positioning) {
        this.mana = mana;
        this.description = description;
        this.colors = colors;
        this.name = name;
        this.cardPositioning = positioning;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getCardPositioning() {
        return cardPositioning;
    }

    public void setCardPositioning(String cardPositioning) {
        this.cardPositioning = cardPositioning;
    }

    @Override
    public String toString() {
        return "Card{" +
                "mana=" + mana +
                ", description='" + description + '\'' +
                ", colors=" + colors +
                ", name='" + name + '\'' +
                '}';
    }
}
