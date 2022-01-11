package com.till.projekty.rpg.map.dungeon;
import com.till.projekty.rpg.entities.Entity;
import com.till.projekty.rpg.entities.enemy.Enemies;
import com.till.projekty.rpg.functions.Fight;
import com.till.projekty.rpg.functions.Game;
import com.till.projekty.rpg.items.Item;
import com.till.projekty.rpg.items.ItemCategory;
import com.till.projekty.rpg.items.Leggings.Leggings;
import com.till.projekty.rpg.items.boots.Boots;
import com.till.projekty.rpg.items.chestplates.Chestplates;
import com.till.projekty.rpg.items.helmets.Helmets;
import com.till.projekty.rpg.items.weapons.Weapons;
import com.till.projekty.rpg.utils.Utils;

import java.util.ArrayList;

import static com.till.projekty.rpg.Main.player;

public class Dungeon {
    public static void startDungeon(int roomsToBoss){
        Utils.printText("Jdeš k Dungeonu.", 20);

        for (int i = 0; i < roomsToBoss; i++) {
            chooseNextRoom();
            roomLogic();
        }
        Utils.printText("Vracíš se z dungeonu.", 20);
    }

    public static void roomLogic(){
        switch(nextRoom()){
            case Empty -> Utils.printText("Narazil si na prázdnou místnost.", 20);
            case Encounter -> encounterRoom();
            case Chest -> chestRoom();
            default -> {}
        }
    }

    public static void chestRoom(){
        while(true){
            Utils.printText("Našel jsi bednu, chceš jí otevřít?", 20);
            System.out.println("1 - Ano");
            System.out.println("2 - Ne");

            switch(Utils.intFromConsole()){
                case 1 -> {chestRoomConfirmation(generateChestItem()); return;}
                case 2 -> {return;}
                default -> {}
            }
        }
    }

    public static void chestRoomConfirmation(Item generatedItem){
        ArrayList<Item> newPlayerInv = player.getInventory();
        newPlayerInv.add(generatedItem);

        while(true){
            Utils.printText("Našel jsi " + generatedItem.getRarity() + " " + generatedItem.getName() + ".", 20);
            Utils.printText("Chceš je vzít?", 20);
            System.out.println("1 - Ano");
            System.out.println("2 - Ne");

            switch(Utils.intFromConsole()){
                case 1 -> {player.setInventory(newPlayerInv); return;}
                case 2 -> {return;}
                default -> {}
            }
        }
    }

    public static Item generateChestItem(){
        ItemCategory categoryToPickFrom = ItemCategory.values()[Utils.random(0, ItemCategory.values().length)];
        //Netuším, jak se tohle dá udělat líp (enumem poslat enum těch věcí), docela mě to sere protože teď to není modulární

        switch(categoryToPickFrom){
            case Weapon -> {return Weapons.values()[Utils.random(0, Weapons.values().length)].getWeapon();}
            case Helmet -> {return Helmets.values()[Utils.random(0, Helmets.values().length)].getHelmet();}
            case Chestplate -> {return Chestplates.values()[Utils.random(0, Chestplates.values().length)].getChestplate();}
            case Leggings -> {return Leggings.values()[Utils.random(0, Leggings.values().length)].getLegging();}
            case Boots -> {return Boots.values()[Utils.random(0, Boots.values().length)].getBoots();}
            default -> {return null;}
        }
    }

    public static void encounterRoom(){
        Entity enemy = null;
        try {
            enemy = (Entity) Enemies.values()[Utils.random(0, Enemies.values().length)].getEntity().clone();
            enemy.setLvl(player.getLvl());
            enemy.setMaxhp(enemy.getMaxhp()*enemy.getLvl());
            enemy.setHp(enemy.getHp()*enemy.getLvl());
            enemy.setDamage(enemy.getDamage()*enemy.getLvl());
            enemy.setMoney(enemy.getMoney()*enemy.getLvl());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Fight.fight(player, enemy);
    }

    public static void chooseNextRoom(){
        //lmao když je iluze velká, literally je jedno co člověk vybere xddd
        while(true){
            Utils.printText("Kam chceš jít dál?", 20);
            System.out.println("0 - Menu");

            for (int i = 1; i <= Utils.random(1, 3); i++) {
                switch(i){
                    case 1 -> System.out.println("1 - rovně");
                    case 2 -> System.out.println("2 - doprava");
                    case 3 -> System.out.println("3 - doleva");
                    default -> {}
                }
            }

            if(Utils.intFromConsole() == 0){Game.characterMenu();}
            else{return;}
        }
    }

    public static DungeonRoomTypes nextRoom(){
        return DungeonRoomTypes.values()[Utils.random(0, DungeonRoomTypes.values().length)];
    }
}