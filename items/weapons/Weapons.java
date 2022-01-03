package com.till.projekty.rpg.items.weapons;

import com.till.projekty.rpg.entities.player.Class;
import com.till.projekty.rpg.items.ItemCategory;

public enum Weapons  {
    //Warrior weapons
    BIG_STICK(new Weapon("Velká tyčka", "Velká tyčka, můžeš s ní zmlátit všechno, co existuje", ItemCategory.Weapon, Class.Warrior, 7, 5)),
    IRON_SWORD(new Weapon("Železný Meč", "Standardní meč, kdokoliv by ho ocenil.", ItemCategory.Weapon, Class.Warrior, 23, 8)),
    True_Sword(new Weapon("TEN meč", "TEN meč, ten ten, ten origál ten TEN!", ItemCategory.Weapon, Class.Warrior, 50, 15)),

    //Archer weapons
    STONES(new Weapon("Kamínky", "Lmao hoď po nich šutr, ez.", ItemCategory.Weapon, Class.Archer, 5, 3)),
    Old_Bow(new Weapon("Starý luk", "Škoda že k němu není i majitel, alespoň by ně naučil jak s ním střílet.", ItemCategory.Weapon, Class.Archer, 21, 7)),
    Compound_Bow(new Weapon("Závodní luk", "Podle logiky Koroze dává stejný damage jako odstřelovačka na real náboje. Ofc.", ItemCategory.Weapon, Class.Archer, 47, 16)),

    //Mage weapons
    STICK(new Weapon("Tyčka podobající se hůlce", "Nečetl jsem Harryho Pottera, netuším jak to funguje, prostě máš dmg čus.", ItemCategory.Weapon, Class.Mage, 6, 3)),
    Carved_Wand(new Weapon("Ozdobená kouzelná hůlka", "Designovaná od designera nábytku", ItemCategory.Weapon, Class.Mage, 20, 6)),
    Steel_Pole(new Weapon("Ocelová hůl", "Bacha na blesky!", ItemCategory.Weapon, Class.Mage, 48, 12)),
    ;

    private Weapon weapon;

    Weapons(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
