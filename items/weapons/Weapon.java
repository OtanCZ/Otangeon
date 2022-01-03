package com.till.projekty.rpg.items.weapons;

import com.till.projekty.rpg.entities.player.Class;
import com.till.projekty.rpg.items.Item;
import com.till.projekty.rpg.items.ItemCategory;
import com.till.projekty.rpg.items.ItemRarity;

public class Weapon extends Item {
    double damage;


    public Weapon(String name, String description, ItemCategory category, Class usedBy, double price, double damage) {
        super(name, description, category, usedBy, price);
        this.damage = damage*getRarity().getStatBoost();
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }
}
