package com.company.alex;

/**
 * Created by a.tkachenko on 06.10.2016.
 */
public class Hero extends GameCharacter {

    private int currentExp;
    private int expToNextLevel;

    public Hero(String charClass, String name,  int hp, int attack, int defense) {
        super(charClass, name,  hp, attack, defense);
        initHero();
    }

    public void initHero(){
        this.currentExp = 0;
        this.expToNextLevel = 1000;
    }

    public void expGain(int exp){
        this.currentExp += exp;
        System.out.println(name + " получает " + exp + " exp.");
        if (currentExp > expToNextLevel){
            currentExp -= expToNextLevel;
            expToNextLevel *= 2;
            level++;
            System.out.println("*********************");
            System.out.println(name +" повысил уровень до " + level);
            attack += 5;
            System.out.println("Атака героя повысилась до " + attack);
            hp = hpMax;
            System.out.println("HP героя восстановлено");
            System.out.println("*********************");

        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(" EXP: "+currentExp + "/" + expToNextLevel);
    }
}
