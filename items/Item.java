package com.till.projekty.rpg.items;
import com.till.projekty.rpg.entities.player.Class;
import com.till.projekty.rpg.utils.Utils;

public class Item {
    String name;
    String description;
    ItemCategory category;
    Class usedBy;
    double price;
    ItemRarity rarity;

    public Item(String name, String description, ItemCategory category, Class usedBy, double price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.usedBy = usedBy;
        this.rarity = generateRarity();
        this.price = price*rarity.getStatBoost();
    }

    public ItemRarity generateRarity(){
        int chance = Utils.random(0, 100);

        if(chance > 40){
            if(chance > 65){
              if(chance > 90){
               if(chance > 96){
                   return ItemRarity.Chaotic;
               }
               return ItemRarity.Legendary;
              }
              return ItemRarity.Epic;
            }
            return ItemRarity.Rare;
        }
        return ItemRarity.Common;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public Class getUsedBy() {
        return usedBy;
    }

    public void setUsedBy(Class usedBy) {
        this.usedBy = usedBy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemRarity getRarity() {
        return rarity;
    }

    public void setRarity(ItemRarity rarity) {
        this.rarity = rarity;
    }
}
