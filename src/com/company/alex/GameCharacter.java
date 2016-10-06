package com.company.alex;

/**
 * Created by a.tkachenko on 06.10.2016.
 */
public class GameCharacter {
    protected String name;
    protected String charClass;
    protected int hp;
    protected int attack;
    protected int defense;

    public String getName() {
        return name;
    }

    public GameCharacter(String name, String charClass, int hp, int attack, int defense) {
        this.name = name;
        this.charClass = charClass;
        this.attack = attack;
        this.attack = defense;
        this.hp = hp;
    }

    public void ShowInfo(){


    }
}
