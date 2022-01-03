package com.till.projekty.rpg.entities;

import com.till.projekty.rpg.entities.player.Class;

import java.util.HashMap;

public class Entity implements Cloneable {
    private String name;

    private double maxhp;
    private double hp;

    private double damage;

    private double maxmana;
    private double mana;

    private double maxstamina;
    private double stamina;

    private double defense;

    private HashMap<Attributes, Integer> attributes;
    private Class clazz;

    private int lvl;
    private double xp;
    private double money;

    public Entity(String name, double maxhp, double hp, double damage, double maxmana, double mana, double maxstamina, double stamina, double defense, HashMap<Attributes, Integer> attributes, Class clazz, int lvl, double xp, double money) {
        this.name = name;
        this.maxhp = maxhp;
        this.hp = hp;
        this.damage = damage;
        this.maxmana = maxmana;
        this.mana = mana;
        this.maxstamina = maxstamina;
        this.stamina = stamina;
        this.defense = defense;
        this.attributes = attributes;
        this.clazz = clazz;
        this.lvl = lvl;
        this.xp = xp;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxhp() {
        return maxhp;
    }

    public void setMaxhp(double maxhp) {
        this.maxhp = maxhp;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getMaxmana() {
        return maxmana;
    }

    public void setMaxmana(double maxmana) {
        this.maxmana = maxmana;
    }

    public double getMana() {
        return mana;
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public double getMaxstamina() {
        return maxstamina;
    }

    public void setMaxstamina(double maxstamina) {
        this.maxstamina = maxstamina;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(double stamina) {
        this.stamina = stamina;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public HashMap<Attributes, Integer> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<Attributes, Integer> attributes) {
        this.attributes = attributes;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public double getXp() {
        return xp;
    }

    public void setXp(double xp) {
        this.xp = xp;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Entity{" +
                ", name='" + name + '\'' +
                ", maxhp=" + maxhp +
                ", hp=" + hp +
                ", damage=" + damage +
                ", maxmana=" + maxmana +
                ", mana=" + mana +
                ", maxstamina=" + maxstamina +
                ", stamina=" + stamina +
                ", defense=" + defense +
                ", lvl=" + lvl +
                ", xp=" + xp +
                '}';
    }
}