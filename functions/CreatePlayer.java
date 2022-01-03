package com.till.projekty.rpg.functions;

import com.till.projekty.rpg.entities.player.Class;
import com.till.projekty.rpg.entities.player.Player;
import com.till.projekty.rpg.entities.player.Race;
import com.till.projekty.rpg.utils.Utils;

public class CreatePlayer {
    public static Player start(){
        while(true) {
            Utils.printText("Napiš 1 pro vytvoření postavy.", 50);
            switch (Utils.intFromConsole()) {
                case 1 -> {return newPlayer();}
                default -> {}
            }
        }
    }

    public static Player newPlayer(){
        String name = selectName();
        Class clazz = selectClass();
        Race race = selectRace();
        while(true) {
            Utils.printText("Tvoje postava má jméno " + name + ", a je to " + race + " " + clazz + ".\nJseš s tím spokojen?", 50);
            System.out.println("1 - Ano\n2 - Ne");
            switch (Utils.intFromConsole()) {
                case 1 -> {
                    return new Player(name, 20, 20, 5, 100, 100, 100, 100, 0, clazz, 1, 0, race, 20);
                }

                case 2 -> {
                    Utils.printText("Co se ti na ní nelíbí?", 50);
                    System.out.println("1 - Jméno\n2 - Class\n3 - Rasa");
                    switch(Utils.intFromConsole()){
                        case 1 -> {name = selectName();}
                        case 2 -> {clazz = selectClass();}
                        case 3 -> {race = selectRace();}
                        default -> {}
                    }
                }

                default -> {}
            }
        }
    }

    public static String selectName() {
        Utils.printText("Jak se bude postava jmenovat?", 50);
        return Utils.lineFromConsole();
    }

    public static Class selectClass() {
        while(true){
            Utils.printText("Jakou chceš hrát classu?", 50);

            for (int i = 0; i < Class.values().length; i++) {
                System.out.println(i+1 + " - " + Class.values()[i]);
            }
            int selection = Utils.intFromConsole()-1;

            if(selection < Class.values().length && selection >= 0){
                return Class.values()[selection];
            }
        }
    }

    public static Race selectRace() {
        while(true){
            Utils.printText("Jakou chceš hrát rasu?", 50);
            for (int i = 0; i < Race.values().length; i++) {
                System.out.println(i+1 + " - " + Race.values()[i]);
            }
            int selection = Utils.intFromConsole()-1;

            if(selection < Race.values().length && selection >= 0){
                return Race.values()[selection];
            }
        }
    }
}
