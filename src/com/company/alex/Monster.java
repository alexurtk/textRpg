package com.company.alex;

/**
 * Created by a.tkachenko on 06.10.2016.
 */
public class Monster extends GameCharacter{

    public Monster(String charClass, String name,  int hp, int attack, int defense) {
        super(charClass, name, hp, attack, defense);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println();
    }
}
