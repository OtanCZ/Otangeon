package com.till.projekty.rpg.utils;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.util.Scanner;

public class Utils {
    static MP3Player player;
    static String path = "src/com/till/projekty/rpg/sounds/ano.mp3";

    private static Scanner scan = new Scanner(System.in);

    public static String lineFromConsole() {
        return scan.next();
    }

    public static int intFromConsole() {
        return scan.nextInt();
    }

    public static int random(int min, int max){
        return (int)(min + (Math.random()*(max-min)));
    }

    public static void printText(String text, int time) {
        //SEBRAT TALK.MP3 ENTITY, POKUĎ NEBUDE TAK NĚJAKEJ DEFAULT
        try {
            /*
            File file = new File(path);
            player = new MP3Player(file);
            */
            for (String s : text.split(" ")) {
                for (char c : s.toCharArray()) {
                    //player.play();
                    System.out.print(c);

                    switch(c){
                        case ',' -> Thread.sleep(time*10);
                        case '.' -> Thread.sleep(time*20);
                        default -> Thread.sleep(time);
                    }
                }
                System.out.print(" ");
                Thread.sleep(time);
            }
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*
    public static Player createPlayer(){
        return new Player(EntityType.PLAYER, Utils.readFromConsole(), 20, 20, 0, 100, 100, 0, new int[]{0, 0, 0, 0, 0, 0}, new ArrayList<>(), Races.HUMAN, Classes.Warrior);
    }
    */
}
