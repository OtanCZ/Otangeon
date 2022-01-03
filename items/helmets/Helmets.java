package com.till.projekty.rpg.items.helmets;

import com.till.projekty.rpg.items.ItemCategory;
import com.till.projekty.rpg.items.chestplates.Chestplate;

public enum Helmets {
    Leather_Helmet(new Helmet("Kšilt", "Musíš nosit naopak aby jsi byl GANGSTA", ItemCategory.Helmet, null, 10, 1)),
    Iron_Helmet(new Helmet("Železná helma", "Vypadá jak ta cheap helma z EFT s 3 armor level od Ragmana", ItemCategory.Helmet, null, 25, 3)),
    Gold_Helmet(new Helmet("Koruna", "Ty píčo a kdo říkal že nemůžeš být král Dungeonu?", ItemCategory.Helmet, null, 50, 2)),
    Diamond_Helmet(new Helmet("Diamantová přilba", "radši sis měl udělat krumpáč a enchanting table debile", ItemCategory.Helmet, null, 100, 5));

    private Helmet helmet;

    Helmets(Helmet helmet) {
        this.helmet = helmet;
    }

    public Helmet getHelmet() {
        return helmet;
    }

    public void setHelmet(Helmet helmet) {
        this.helmet = helmet;
    }
}
