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

    public GameClass() {
        initGame();
    }

    public void initGame(){
        heroPattern[0] = new Hero("Knight","Artur", 100, 10, 5);
        heroPattern[1] = new Hero("Barbarian", "Konan", 200, 20, 0);
        heroPattern[2] = new Hero("Dwarf", "Gimli", 100, 15, 20);

        monsterPattern[0] = new Monster("Humanoid", "Goblin", 50, 5, 1);
        monsterPattern[1] = new Monster("Humanoid", "Orc", 80, 6, 2);
        monsterPattern[2] = new Monster("Humanoid", "Troll", 90, 5, 1);
    }

    public void mainGameLoop(){
        Scanner sc = new Scanner(System.in);

        int inpInt = 0;

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("~ Начало игры...                     ~");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Выберите класс героя:");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1)+")"+heroPattern[i].getClass());
        }
        inpInt = sc.nextInt();
        mainHero = heroPattern[inpInt-1];//
        System.out.println("Вы выбрали " + mainHero.getClass() + ", это " + mainHero.getName()+".");

        do {
            System.out.println("Сделайте ход:");
            inpInt = sc.nextInt();
            if (inpInt == 0) break;

        } while (true);



    }
}
