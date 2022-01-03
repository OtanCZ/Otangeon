
package com.till.projekty.rpg.entities.enemy;
import com.till.projekty.rpg.entities.Attributes;
import com.till.projekty.rpg.entities.Entity;
import com.till.projekty.rpg.entities.player.Class;
import java.util.HashMap;


public class Enemy extends Entity {
    public Enemy(String name, double maxhp, double hp, double damage, double maxmana, double mana, double maxstamina, double stamina, double defense, HashMap<Attributes, Integer> attributes, Class clazz, int lvl, double xp, double money) {
        super(name, maxhp, hp, damage, maxmana, mana, maxstamina, stamina, defense, attributes, clazz, lvl, xp, money);
    }
}
