package main.environmentCards;

import main.minionCards.MinionCard;

import java.util.ArrayList;

public class HeartHound extends EnvironmentCard{
    public HeartHound(Integer mana, String description, ArrayList<String> colors, String name) {
        super(mana, description, colors, name, "environment");
    }

    public void useCard(ArrayList<ArrayList<MinionCard>> table, int affectedRow) {
        //TODO Implement use method
        if(table.get(affectedRow).size() == 0) {
            return;
        }
        int idx=0;
        for(int i = 1; i<table.get(affectedRow).size(); i++) {
            if(table.get(affectedRow).get(idx).getHealth() < table.get(affectedRow).get(i).getHealth()) {
                idx = i;
            }
        }
        table.get(3-affectedRow).add(table.get(affectedRow).get(idx));
        table.get(affectedRow).remove(idx);
    }

    @Override
    public String toString() {
        return "HeartHound{} " + super.toString();
    }
}
