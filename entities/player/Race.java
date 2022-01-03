package com.till.projekty.rpg.entities.player;

import com.till.projekty.rpg.entities.Attributes;

import java.util.HashMap;

public enum Race {
    ORC(new HashMap<>(){{put(Attributes.STRENGTH, 2); put(Attributes.DEXTERITY, -1); put(Attributes.INTELIGENCE, -1); put(Attributes.CONSTITUTION, 1); put(Attributes.WISDOM, 0); put(Attributes.CHARISMA, -1);}}),
    ELF(new HashMap<>(){{put(Attributes.STRENGTH, -1); put(Attributes.DEXTERITY, -1); put(Attributes.INTELIGENCE, 2); put(Attributes.CONSTITUTION, -1); put(Attributes.WISDOM, 1); put(Attributes.CHARISMA, 0);}}),
    HUMAN(new HashMap<>(){{put(Attributes.STRENGTH, 0); put(Attributes.DEXTERITY, 0); put(Attributes.INTELIGENCE, 0); put(Attributes.CONSTITUTION, 0); put(Attributes.WISDOM, 0); put(Attributes.CHARISMA, 0);}});

    HashMap<Attributes, Integer> attributes;

    Race(HashMap<Attributes, Integer> attributes) {
        this.attributes = attributes;
    }

    public HashMap<Attributes, Integer> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<Attributes, Integer> attributes) {
        this.attributes = attributes;
    }
}
