package com.till.projekty.rpg.items.boots;

import com.till.projekty.rpg.entities.player.Class;
import com.till.projekty.rpg.items.Item;
import com.till.projekty.rpg.items.ItemCategory;

public class Boot extends Item {
    //Ano, jen jedna. Tvůj život hraní této hry byl lež.
    double armor;

    public Boot(String name, String description, ItemCategory category, Class usedBy, double price, double armor) {
        super(name, description, category, usedBy, price);
        this.armor = armor*getRarity().getStatBoost();
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }
}
