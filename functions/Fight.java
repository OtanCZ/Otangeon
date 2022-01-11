package com.till.projekty.rpg.functions;

import com.till.projekty.rpg.entities.Entity;
import com.till.projekty.rpg.entities.player.Player;
import com.till.projekty.rpg.utils.Utils;

import static com.till.projekty.rpg.Main.player;

public class Fight {
    public static void fight(Player player, Entity enemy) {
        Utils.printText("Potkal jsi " + enemy.getName() + ".", 50);

        while (true) {
            FightStates playerState = playerTurn(player, enemy);
            FightStates enemyState = enemyTurn(player, enemy);

            if(playerState == FightStates.Attacking && enemyState == FightStates.Defending){
                enemy.setHp((enemy.getHp() - (player.getDamage()/2 + Math.max(player.getDamage()/2-enemy.getDefense(), 0))/3));
                Utils.printText(player.getName() + " zaútočil na bránicí se " + enemy.getName() + " -" + (player.getDamage()/2 + Math.max(player.getDamage()/2-enemy.getDefense(), 0))/3 + " hp! (" + enemy.getHp() + "/" + enemy.getMaxhp() + ")", 30);
            }

            else if(playerState == FightStates.Attacking){
                enemy.setHp((enemy.getHp() - (player.getDamage()/2 + Math.max(player.getDamage()/2-enemy.getDefense(), 0))));
                Utils.printText(player.getName() + " zaútočil na " + enemy.getName() + " -" + (player.getDamage()/2 + Math.max(player.getDamage()/2-enemy.getDefense(), 0)) + " hp! (" + enemy.getHp() + "/" + enemy.getMaxhp() + ")", 30);
            }

            else if(playerState == FightStates.Defending){
                Utils.printText(player.getName() + " se brání útoku od " + enemy.getName() + ".", 30);
            }

            else{
                Utils.printText(player.getName() + " zamyšeleně čumí, nic se nestalo.", 30);
            }

            if(playerState == FightStates.Defending && enemyState == FightStates.Attacking){
                player.setHp(player.getHp() - (enemy.getDamage()/2 + Math.max(enemy.getDamage()/2-player.getDefense(), 0))/3);
                Utils.printText(enemy.getName() + " zaútočil na bránicí se " + player.getName() + " -" + (enemy.getDamage()/2 + Math.max(enemy.getDamage()/2-player.getDefense(), 0))/3 + " hp! (" + player.getHp() + "/" + player.getMaxhp() + ")", 30);
            }

            else if(enemyState == FightStates.Attacking){
                player.setHp((player.getHp() - (enemy.getDamage()/2 + Math.max(enemy.getDamage()/2-player.getDefense(), 0))));
                Utils.printText(enemy.getName() + " zaútočil na " + player.getName() + " -" + (enemy.getDamage()/2 + Math.max(enemy.getDamage()/2-player.getDefense(), 0)) + " hp! (" + player.getHp() + "/" + player.getMaxhp() + ")", 30);
            }

            else if(enemyState == FightStates.Defending){
                Utils.printText(enemy.getName() + " se brání útoku od " + player.getName() + ".", 30);
            }

            else{
                Utils.printText(enemy.getName() + " zamyšleně čumí, nic se nestalo.", 30);
            }

            if (player.getHp() <= 0) {
                Utils.printText(player.getName() + " je sráč a prohrál fight.", 30);
                System.exit(0);
            }
            else if (enemy.getHp() <= 0) {
                Utils.printText("Zabil jsi " + enemy.getName() + ", získáváš " + enemy.getXp() + "xp.", 50);
                if(player.getXp()+enemy.getXp() >= Math.pow(5, player.getLvl())){
                    player.setLvl(player.getLvl()+1);
                    player.setXp(0);
                    player.setMaxhp(player.getMaxhp()+10);
                    Utils.printText("Level up! Nyní jsi level " + player.getLvl() + ".", 50);
                }
                else{
                    player.setXp(player.getXp()+enemy.getXp());
                }

                player.setMoney(player.getMoney() + enemy.getMoney());
                return;
            }
        }
    }

    public static FightStates playerTurn(Player player, Entity enemy) {
        while(true){
            System.out.println("0 - Menu\n" +
                    "1 - Fight\n" +
                    //"2 - Act\n" +
                    "2 - Defend\n");

            switch (Utils.intFromConsole()) {
                case 0 -> {
                    Game.characterMenu(); return FightStates.Else;
                }

                case 1 -> {
                    return FightStates.Attacking;
                }
/*
                case 2 -> {
                    return FightStates.Else;
                }
*/
                case 2 -> {
                    return FightStates.Defending;
                }
                default -> {}
            }
        }
    }

    public static FightStates enemyTurn(Player player, Entity enemy) {
        switch (Utils.random(1, 3)) {
            case 1 -> {
                return FightStates.Attacking;
            }
            case 2 -> {
                return FightStates.Defending;
            }
            default -> {}
        }
        return FightStates.Else;
    }
}