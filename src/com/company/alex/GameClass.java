package com.company.alex;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by a.tkachenko on 06.10.2016.
 */
public class GameClass {
    public static Random rand = new Random();

    private Hero[] heroPattern = new Hero[3];
    private Monster[] monsterPattern = new Monster[3];

    private Hero mainHero;
    private Monster currentMonster;
    private int currentRound;
    private int monsterID = 0;


    public GameClass() {
        initGame();
    }

    public void initGame(){
        heroPattern[0] = new Hero("Knight","Artur", 300, 10, 5);
        heroPattern[1] = new Hero("Barbarian", "Konan", 200, 20, 0);
        heroPattern[2] = new Hero("Dwarf", "Gimli", 100, 15, 20);

        monsterPattern[0] = new Monster("Humanoid", "Goblin", 50, 10, 1);
        monsterPattern[1] = new Monster("Humanoid", "Orc", 200, 12, 2);
        monsterPattern[2] = new Monster("Humanoid", "Troll", 90, 15, 1);

        currentRound = 1;
    }

    public void mainGameLoop(){
        Scanner sc = new Scanner(System.in);

        int inpInt = 0;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~ Начало игры...                     ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Выберите класс героя:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1)+")"+heroPattern[i].getCharClass());
        }
        inpInt = 1;//sc.nextInt();
        mainHero = heroPattern[inpInt-1];//
        System.out.println("Вы выбрали " + mainHero.getCharClass() + ", это " + mainHero.getName()+".");

        currentMonster = monsterPattern[0];

        do {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Текущий раунд: " + currentRound);
            mainHero.showInfo();
            currentMonster.showInfo();
            System.out.println("Ход игрока: 1)Атака 2)Защита 3)Пропустить ход 0)Завершить игру");
            mainHero.makeNewRound();
            inpInt = sc.nextInt();
            switch (inpInt){
                case 1:
                    currentMonster.getDamage(mainHero.makeAttack());
                    break;
                case 2:
                    mainHero.setBlockStance();
                    break;
                case 3:
                    System.out.println();
                    break;
            }
            if (inpInt == 0) break;
            currentMonster.makeNewRound();
            mainHero.getDamage(currentMonster.makeAttack());
            currentRound++;
            if (!currentMonster.isAlive){
                System.out.println(currentMonster.getName() + " погиб.");
                mainHero.expGain(currentMonster.getHpMax() * 5);
                monsterID++;
                if (monsterID < monsterPattern.length) {
                    currentMonster = monsterPattern[monsterID];
                    System.out.println("Появляется " + currentMonster.getName());
                } else  break;
            }

            if (!mainHero.isAlive)
                break;
        } while (true);
        if (!currentMonster.isAlive) System.out.println("Победил герой " + mainHero.getName());

        if (!mainHero.isAlive) System.out.println("Победил " + currentMonster.getName()+".");
        System.out.println("Игра завершена.");




    }
}
