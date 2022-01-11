package com.till.projekty.rpg.entities.enemy;

import com.till.projekty.rpg.entities.Entity;
import com.till.projekty.rpg.entities.player.Class;
import static com.till.projekty.rpg.Main.player;

import java.util.HashMap;

public enum Enemies {
    SKELETON_ARCHER(new Enemy("Skeleton Archer", 10, 10, 5, 20, 20, 10, 10, 1, new HashMap<>(), Class.Archer, player.getLvl(), 6, 10)),
    SKELETON_WARRIOR(new Enemy("Skeleton Warrior", 20, 20, 2, 20, 20, 10, 10, 2, new HashMap<>(), Class.Archer, player.getLvl(), 7, 10)),
    WITCH(new Enemy("Witch", 15, 15, 4, 20, 20, 10, 10, 0, new HashMap<>(), Class.Archer, player.getLvl(), 10, 10)),
    ZOMBIE(new Enemy("Zombie", 10, 10, 2, 20, 20, 10, 10, 0, new HashMap<>(), Class.Archer, player.getLvl(), 5, 5)),
    ;

    private Entity entity;

    Enemies(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "Enemies{" +
                "entity=" + entity +
                '}';
    }
}
