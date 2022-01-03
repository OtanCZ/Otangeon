package com.till.projekty.rpg;

import com.till.projekty.rpg.entities.player.Player;
import com.till.projekty.rpg.functions.*;

public class Main {
    public static Player player = CreatePlayer.start();

    public static void main(String[] args) {
        System.out.println("   ____  __                                \n" +
                "  / __ \\/ /_____ _____  ____ ____  ____  ____ \n" +
                " / / / / __/ __ `/ __ \\/ __ `/ _ \\/ __ \\/ __ \\\n" +
                "/ /_/ / /_/ /_/ / / / / /_/ /  __/ /_/ / / / /\n" +
                "\\____/\\__/\\__,_/_/ /_/\\__, /\\___/\\____/_/ /_/ \n" +
                "                     /____/                   ");
        //Game.startStory();

        while(true){
            Game.cityMenu();
        }
    }
}
