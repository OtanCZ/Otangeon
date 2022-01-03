package com.till.projekty.rpg.items;

public enum ItemRarity {
    Common(1),
    Rare(1.5),
    Epic(3),
    Legendary(5),
    Chaotic(10);

    private double statBoost;

    ItemRarity(double statBoost) {
        this.statBoost = statBoost;
    }

    public double getStatBoost() {
        return statBoost;
    }

    public void setStatBoost(int statBoost) {
        this.statBoost = statBoost;
    }
}
