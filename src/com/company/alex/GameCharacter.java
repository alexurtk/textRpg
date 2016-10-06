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
    protected int critChance;

    public String getName() {
        return name;
    }

    public GameCharacter(String charClass, String name, int hp, int attack, int defense) {
        this.name = name;
        this.charClass = charClass;
        this.attack = attack;
        this.attack = defense;
        this.hp = hp;
        this.critChance = 10;
    }

    public void showInfo(){
        System.out.println("Имя: "+name + "\nЗдоровье: " + hp);

    }

    public int makeAttack(){
        //20 -> 16..24

        int minAttack = (int)(attack*0.8f);
        int deltaAttack = (int)(attack*0.4f);
        int currentAttack = minAttack + GameClass.rand.nextInt(deltaAttack);
        if (GameClass.rand.nextInt(100)<critChance){
            currentAttack *= 2;
            System.out.println(name + " нанес критический урон " + currentAttack + "ед.");
        } else {
            System.out.println(name + " нанес урон" + currentAttack + "ед.");
        }
        return currentAttack;
    }

    public void getDamage(int inputDamage){
        System.out.println(name + " получил " + inputDamage + " урона");
        hp -= inputDamage;
    }
}
