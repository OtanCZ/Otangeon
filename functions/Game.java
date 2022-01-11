package com.till.projekty.rpg.functions;

import com.till.projekty.rpg.items.Item;
import com.till.projekty.rpg.map.dungeon.Dungeon;
import com.till.projekty.rpg.map.dungeon.DungeonRoomTypes;
import com.till.projekty.rpg.utils.Utils;

import java.util.ArrayList;

import static com.till.projekty.rpg.Main.player;

public class Game {

    public static void startStory(){
        Utils.printText("Vzbudil jsi se v velmi primitivní nemocnici, nevíš co se stalo.\nPřišla k tobě doktorka.\nEjjj, konečně jste se probudil. Potřebujeme Vaší existenci pro zničení Dungeonu, co tu je, prosím zničte ho kthx.\nAby jsi neskapal, tady máš 20 goldů, jdi si do obhcodu koupit nějakej gear.", 40);
    }

    public static void cityMenu(){
        while(true){
            Utils.printText("Jsi v městě, co chceš dělat?", 20);
            System.out.println("0 - Menu");
            System.out.println("1 - Vydat se do Dungeonu.");
            System.out.println("2 - Zajít do baru.");
            System.out.println("3 - Zajít do obchodu.");

            switch(Utils.intFromConsole()){
                case 0 -> {characterMenu();}
                case 1 -> {Dungeon.startDungeon(Utils.random(6, 15));}
                case 2 -> {barMenu();}
                case 3 -> {shopMenu();}
                default -> {}
            }
        }
    }

    public static void barMenu(){
        while(true){
            Utils.printText("Jsi v baru, co chceš dělat?", 20);
            System.out.println("0 - Odejít zpátky do města.");
            System.out.println("1 - Dát si pivečko. (+5 hp, -5 gold)");

            switch(Utils.intFromConsole()){
                case 0 -> {return;}
                case 1 -> {drinkBeer();}
                default -> {}
            }
        }
    }

    public static void drinkBeer(){
        if(player.getMoney() >= 5){
            Utils.printText("Ty píčo, to byl chálec.", 20);
            player.setMoney(player.getMoney()-5);

            if(player.getHp()+5 > player.getMaxhp()){
                player.setHp(player.getMaxhp());
            }
            else{
                player.setHp(player.getHp()+5);
            }
        }
        else{
            Utils.printText("Na to nemáš peníze!", 20);
        }
    }

    public static void characterMenu(){
        while(true){
            System.out.println("Jméno: " + player.getName() + ".");
            System.out.println("Rasa: " + player.getRace() + ".");
            System.out.println("Class: " + player.getClazz() + ".");
            System.out.println("Damage: " + player.getDamage() + ".");
            System.out.println("Defense: " + player.getDefense() + ".");
            System.out.println("Hp: " + player.getHp() + "/" + player.getMaxhp());
            System.out.println("Mana: " + player.getMana() + "/" + player.getMaxmana());
            System.out.println("Level: " + player.getLvl() + " (" + player.getXp() + "/" + Math.pow(5, player.getLvl()) + ")");
            System.out.println("Money: " + player.getMoney() + ".\n");

            System.out.println("0 - Zpátky");
            System.out.println("1 - Inventář");
            System.out.println("2 - Equipnuté itemy");
            System.out.println("3 - Attributy");

            switch(Utils.intFromConsole()){
                case 0 -> {return;}
                case 1 -> {player.printInventory();}
                case 2 -> {player.printEquipment();}
                case 3 -> {player.printAttributes();}
                default -> {}
            }
        }
    }

    public static void shopMenu(){
        Utils.printText("Ahoj, co chceš koupit?", 20);
        while(true){
            System.out.println("0 - Zpátky");
            ArrayList<Item> shopOffers = new ArrayList<>();
            for (int i = 0; i < Utils.random(1, 5); i++) {
                shopOffers.add(Dungeon.generateChestItem());
                System.out.println(i+1 + " - " + shopOffers.get(i).getRarity() + " " + shopOffers.get(i).getName() + " | " + shopOffers.get(i).getPrice() + " money.");
            }
            int choice = Utils.intFromConsole()-1;

            if(choice == -1){
                return;
            }

            if(choice >= 0 && choice < shopOffers.size()){
                if(player.getMoney() >= shopOffers.get(choice).getPrice()){
                    ArrayList<Item> oldInv = player.getInventory();
                    oldInv.add(shopOffers.get(choice));
                    player.setInventory(oldInv);
                    Utils.printText("Koupil jsi " + shopOffers.get(choice).getRarity() + " " + shopOffers.get(choice).getName(), 20);
                }
                else{
                    Utils.printText("Na to nemáš peníze!", 20);
                }
            }
        }
    }
}
