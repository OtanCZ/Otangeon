package com.till.projekty.rpg.items.helmets;

import com.till.projekty.rpg.entities.player.Class;
import com.till.projekty.rpg.items.Item;
import com.till.projekty.rpg.items.ItemCategory;

public class Helmet extends Item {
    double armor;

    public Helmet(String name, String description, ItemCategory category, Class usedBy, double price, double armor) {
        super(name, description, category, usedBy, price);
        this.armor = armor*getRarity().getStatBoost();;
    }

    public double getArmor() {
        return armor;
    }

    public void setArmor(double armor) {
        this.armor = armor;
    }
}
