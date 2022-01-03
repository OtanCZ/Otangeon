package com.till.projekty.rpg.items.chestplates;

import com.till.projekty.rpg.items.ItemCategory;
import com.till.projekty.rpg.items.boots.Boot;

public enum Chestplates {
    Leather_Chestplate(new Chestplate("Kožená bunda", "Hlavně jí nenamoč!", ItemCategory.Chestplate, null, 10, 3)),
    Iron_Chestplate(new Chestplate("Železný kyrys", "Má na sobě napsáno kekma.net", ItemCategory.Chestplate, null, 25, 8)),
    Gold_Chestplate(new Chestplate("Zlatá zbroj", "Určitě hodně karátů zlata", ItemCategory.Chestplate, null, 50, 6)),
    Diamond_Chestplate(new Chestplate("Diamantové brnění", "stejně to nikdo nebude číst tak proč to píšu?", ItemCategory.Chestplate, null, 100, 12));

    private Chestplate chestplate;

    Chestplates(Chestplate chestplate) {
        this.chestplate = chestplate;
    }

    public Chestplate getChestplate() {
        return chestplate;
    }

    public void setChestplate(Chestplate chestplate) {
        this.chestplate = chestplate;
    }
}
