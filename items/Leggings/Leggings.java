package com.till.projekty.rpg.items.Leggings;

import com.till.projekty.rpg.items.ItemCategory;
import com.till.projekty.rpg.items.helmets.Helmet;

public enum Leggings {
    Leather_Leggings(new Legging("Tepláky", "Vzpomněl jsem si na ten song a je mi blbě", ItemCategory.Leggings, null, 10, 3)),
    Iron_Leggings(new Legging("Železné kalhoty", "deskriptšn", ItemCategory.Leggings, null, 25, 5)),
    Gold_Leggings(new Legging("Pozlacené tepláky", "Mega swag", ItemCategory.Leggings, null, 50, 4)),
    Diamond_Leggings(new Legging("Diamantové kalhoty", "dajmnds", ItemCategory.Leggings, null, 100, 7));

    private Legging legging;

    Leggings(Legging legging) {
        this.legging = legging;
    }

    public Legging getLegging() {
        return legging;
    }

    public void setLegging(Legging legging) {
        this.legging = legging;
    }
}

