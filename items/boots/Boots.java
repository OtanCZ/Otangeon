package com.till.projekty.rpg.items.boots;

import com.till.projekty.rpg.items.ItemCategory;

public enum Boots {
    Leather_Boots(new Boot("Kožené boty", "Hlavně je nenamoč!", ItemCategory.Boots, null, 10, 2)),
    Iron_Boots(new Boot("Železné boty", "Trochu zrezlé, tak si je nezabodni do nohy jinak rip bozo.", ItemCategory.Boots, null, 25, 5)),
    Gold_Boots(new Boot("Zlaté boty", "A diamanty v nich nechceš?", ItemCategory.Boots, null, 50, 4)),
    Diamond_Boots(new Boot("Diamantové boty", "MIIIIIIIINEEEEEEE DIIIIAMONDDDSSSSSSSSS", ItemCategory.Boots, null, 100, 9));

    private Boot boots;

    Boots(Boot boots) {
        this.boots = boots;
    }

    public Boot getBoots() {
        return boots;
    }

    public void setBoots(Boot boots) {
        this.boots = boots;
    }
}
