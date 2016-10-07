package com.company.alex;

/**
 * Created by a.tkachenko on 06.10.2016.
 */
public class GameCharacter {
    protected String name;
    protected String charClass;
    protected int hp;
    protected int hpMax;
    protected int attack;
    protected int defense;
    protected int critChance;
    protected int level;
    protected boolean isAlive = true;
    protected boolean blockStance = false;

    public String getName() {
        return name;
    }

    public String getCharClass() {
        return charClass;
    }

    public GameCharacter(String charClass, String name, int hp, int attack, int defense) {
        this.name = name;
        this.charClass = charClass;
        this.attack = attack;
        this.defense = defense;
        this.hp = hp;
        this.hpMax = hp;
        this.critChance = 10;
        this.level = 1;
    }

    public void showInfo() {
        System.out.print("Имя: " + name + " LVL-" + level + " HP: " + hp+"/"+hpMax);

    }

    public int getHpMax() {
        return hpMax;
    }

    public int makeAttack(){
        //20 -> 16..24
        int minAttack = (int)(attack*0.8f);
        int deltaAttack = (int)(attack*0.4f);
        int currentAttack = minAttack + GameClass.rand.nextInt(deltaAttack);
        if (GameClass.rand.nextInt(100)<critChance){
            currentAttack *= 2;
            System.out.println(name + " нанес критический урон " + currentAttack + " ед.");
        } else {
            System.out.println(name + " нанес урон " + currentAttack + " ед.");
        }
        return currentAttack;
    }

    public void getDamage(int inputDamage){
        int allDamage = inputDamage - this.defense;
        if (blockStance){
            allDamage -= this.defense;
            System.out.println(name + " дополнительно заблокировал " + (allDamage > 0 ? defense + "ед. урона.": "весь урон."));
        }
        if (allDamage < 0) allDamage = 0;
        System.out.println(name + " получил " + allDamage + " урона.");
        hp -= allDamage;
        if (hp < 1)
            isAlive = false;
    }

    public void setBlockStance(){
        blockStance = true;
        System.out.println(name + " стал в защитную стойку.");
    }

    public void makeNewRound(){
        blockStance = false;
    }
}
