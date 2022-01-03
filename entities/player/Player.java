package com.till.projekty.rpg.entities.player;
import com.till.projekty.rpg.entities.Attributes;
import com.till.projekty.rpg.entities.Entity;
import com.till.projekty.rpg.items.Item;
import com.till.projekty.rpg.items.ItemCategory;
import com.till.projekty.rpg.items.Leggings.Legging;
import com.till.projekty.rpg.items.boots.Boot;
import com.till.projekty.rpg.items.chestplates.Chestplate;
import com.till.projekty.rpg.items.helmets.Helmet;
import com.till.projekty.rpg.items.weapons.Weapon;
import com.till.projekty.rpg.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Entity {
    /**
     * Strength - DMG up pro melee, DMG down pro archer mage vs melee
     * Dexterity - DMG up pro archer, DMG down pro warrior mage vs archer
     * Intelligence - DMG up pro mage, DMG down pro warrior archer vs mage
     * Constitution - Stamina UP
     * Wisdom - Mana UP
     * Charisma - Slevy v obchodech, jestli je udělám.
     */

    ArrayList<Item> inventory;
    Race race;
    HashMap<ItemCategory, Item> equipment;

    public Player(String name, double maxhp, double hp, double damage, double maxmana, double mana, double maxstamina, double stamina, double defense, Class clazz, int lvl, double xp, Race race, double money) {
        super(name, maxhp, hp, damage, maxmana, mana, maxstamina, stamina, defense, race.getAttributes(), clazz, lvl, xp, money);
        this.inventory = new ArrayList<>();
        this.equipment = new HashMap<>();
        this.race = race;
    }

    public void printAttributes(){
        while(true){
            int total = 0;
            for (Attributes attribute: Attributes.values()) {
                System.out.println(attribute + " - " + this.getAttributes().get(attribute));
                total += this.getAttributes().get(attribute);
            }
            System.out.println("Volných bodů: " + (this.getLvl()-total) + ".");
            System.out.println("0 - Zpátky");
            System.out.println("1 - Rozdělit body");

            switch (Utils.intFromConsole()){
                case 0 -> {return;}
                case 1 -> {if(this.getLvl()-total >= 1){increaseAttribute();} else{System.out.println("Nemáš volné body!");}}
                default -> {}
            }
        }
    }

    public void increaseAttribute(){
        while(true){
            System.out.println("0 - Zpátky");
            for (int i = 0; i < Attributes.values().length; i++) {
                System.out.println(i+1 + " - " + Attributes.values()[i]);
            }

            int selected = Utils.intFromConsole()-1;
            if(!(selected < 0 || selected > Attributes.values().length)){HashMap<Attributes, Integer> yeolde = this.getAttributes(); yeolde.put(Attributes.values()[selected], yeolde.get(Attributes.values()[selected]) + 1); this.setAttributes(yeolde); return;}
        }
    }

    public void printEquipment(){
        for (ItemCategory category : this.getEquipment().keySet()) {
            System.out.println(category + " - " + this.getEquipment().get(category).getRarity() + " " + this.getEquipment().get(category).getName());
        }
        System.out.println("0 - Zpátky");
        Utils.intFromConsole();
    }

    public void printInventory(){
        if(inventory.size() > 0){
            while(true){
                System.out.println("0 - Zpátky");
                for (int i = 0; i < this.inventory.size(); i++) {
                    System.out.println(i+1 + " - " + this.inventory.get(i).getRarity() + " " + this.inventory.get(i).getName());
                }
                int choice = Utils.intFromConsole()-1;

                while(choice>=this.inventory.size() || choice<-1){
                    choice = Utils.intFromConsole()-1;
                }

                switch(choice){
                    case -1 -> {return;}
                    default -> inspectItem(this.inventory.get(choice));
                }
            }
        }

        else{
            Utils.printText("Tvůj inventář je prázdný!", 50);
        }
    }

    public void inspectItem(Item item){
        System.out.println("Jméno: " + item.getName() + ".");
        System.out.println("Rarita: " + item.getRarity() + ".");
        if(item.getCategory() == ItemCategory.Weapon){System.out.println("Damage: " + ((Weapon)item).getDamage() + ". "); if(this.equipment.containsKey(ItemCategory.Weapon)){System.out.print("(Momentálně: " + ((Weapon)this.equipment.get(ItemCategory.Weapon)).getDamage() + ")\n");}}
        if(item.getCategory() == ItemCategory.Helmet){System.out.println("Armor: " + ((Helmet)item).getArmor() + ". "); if(this.equipment.containsKey(ItemCategory.Helmet)){System.out.print("(Momentálně: " + ((Helmet)this.equipment.get(ItemCategory.Helmet)).getArmor() + ")\n");}}
        if(item.getCategory() == ItemCategory.Chestplate){System.out.println("Armor: " + ((Chestplate)item).getArmor() + ". "); if(this.equipment.containsKey(ItemCategory.Chestplate)){System.out.print("(Momentálně: " + ((Chestplate)this.equipment.get(ItemCategory.Chestplate)).getArmor() + ")\n");}}
        if(item.getCategory() == ItemCategory.Leggings){System.out.println("Armor: " + ((Legging)item).getArmor() + ". "); if(this.equipment.containsKey(ItemCategory.Leggings)){System.out.print("(Momentálně: " + ((Legging)this.equipment.get(ItemCategory.Leggings)).getArmor() + ")\n");}}
        if(item.getCategory() == ItemCategory.Boots){System.out.println("Armor: " + ((Boot)item).getArmor() + ". "); if(this.equipment.containsKey(ItemCategory.Boots)){System.out.print("(Momentálně: " + ((Boot)this.equipment.get(ItemCategory.Boots)).getArmor() + ")\n");}}
        System.out.println("Hodnota: " + item.getPrice() + ".");
        System.out.println("Kategorie: " + item.getCategory() + ".");
        if(item.getUsedBy() == null){System.out.println("Využívají: Všechny classy.");}
        else{System.out.println("Využívá: " + item.getUsedBy() + ".");}
        System.out.println("Popisek: " + item.getDescription() + ".\n");

        while(true) {
            System.out.println("0 - Zpátky");
            System.out.println("1 - Použít");
            System.out.println("2 - Zahodit");
            switch (Utils.intFromConsole()) {
                case 0 -> {return;}
                case 1 -> {equipItem(item); return;}
                case 2 -> {deleteItem(item); return;}
                default -> {}
            }
        }
    }

    public void equipItem(Item item){
        if(item.getUsedBy() == this.getClazz() || item.getUsedBy() == null){
            if(this.equipment.containsKey(item.getCategory())){
                if(item instanceof Helmet){this.setDefense(this.getDefense() + ((Helmet)item).getArmor() - ((Helmet)this.equipment.get(item.getCategory())).getArmor());}
                if(item instanceof Chestplate){this.setDefense(this.getDefense() + ((Chestplate)item).getArmor() - ((Chestplate)this.equipment.get(item.getCategory())).getArmor());}
                if(item instanceof Legging){this.setDefense(this.getDefense() + ((Legging)item).getArmor() - ((Legging)this.equipment.get(item.getCategory())).getArmor());}
                if(item instanceof Boot){this.setDefense(this.getDefense() + ((Boot)item).getArmor() - ((Boot)this.equipment.get(item.getCategory())).getArmor());}
                if(item instanceof Weapon){this.setDamage(this.getDamage() + ((Weapon)item).getDamage() - ((Weapon)this.equipment.get(item.getCategory())).getDamage());}
                this.inventory.add(this.equipment.get(item.getCategory()));
                this.equipment.remove(item.getCategory());
                this.equipment.put(item.getCategory(), item);
            }
            else {
                if(item instanceof Helmet){this.setDefense(this.getDefense() + ((Helmet)item).getArmor());}
                if(item instanceof Chestplate){this.setDefense(this.getDefense() + ((Chestplate)item).getArmor());}
                if(item instanceof Legging){this.setDefense(this.getDefense() + ((Legging)item).getArmor());}
                if(item instanceof Boot){this.setDefense(this.getDefense() + ((Boot)item).getArmor());}
                if(item instanceof Weapon){this.setDamage(this.getDamage() + ((Weapon)item).getDamage());}
                this.equipment.put(item.getCategory(), item);
            }

            this.inventory.remove(item);
        }
        else{
            Utils.printText("Tento item není pro tvojí classu!", 50);
        }
    }

    public void deleteItem(Item item){
        this.inventory.remove(item);
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public HashMap<ItemCategory, Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(HashMap<ItemCategory, Item> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "Player{" +
                "inventory=" + inventory +
                ", race=" + race +
                ", equipment=" + equipment +
                super.toString() +
                '}';
    }
}
