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
        System.out.println("Jdeš k Dungeonu.");

        for (int i = 0; i < roomsToBoss; i++) {
            chooseNextRoom();
            roomLogic();
        }
    }

    public static void roomLogic(){
        switch(nextRoom()){
            case Empty -> System.out.println("Narazil si na prázdnou místnost.");
            case Encounter -> encounterRoom();
            case Chest -> chestRoom();
            default -> System.err.println("Jseš kokot nemá to tu být.");
        }
    }

    public static void chestRoom(){
        while(true){
            System.out.println("Našel jsi bednu, chceš jí otevřít?");
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
            System.out.println("Našel jsi " + generatedItem.getRarity() + " " + generatedItem.getName() + ".");
            System.out.println("Chceš je vzít?");
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
            System.out.println("Kam chceš jít dál?");
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