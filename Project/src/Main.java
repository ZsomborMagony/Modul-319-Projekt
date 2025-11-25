import entetys.allClasses;
import entetys.player;
import mechanics.dice;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int choice;
        String[] yesOrNo = {"(0) Yes", "(1) No"};


        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to our Adventure please choose one of the following classes");
        for (String classOptions : allClasses.classes) {

            System.out.println("(" + count + ") " + classOptions);
            count++;
        }
        do {
            choice = userInput.nextInt();
            if (choice < 0 || choice > 3) {
                System.out.println("Invalid");
            }

        } while (choice < 0 || choice > 3);
        player.playerChosenClass = choice;
        System.out.println("you chose the Class " + player.playerClass(""));

        System.out.println("please chose your attributes or do you want to roll for them?");
        System.out.println("(1) chose");
        System.out.println("(2) roll");
        do {
            do {
                choice = userInput.nextInt();
                if (choice == 2) {
                    System.out.println("so you'd like to roll your attributes");
                    break;
                }
            } while (choice != 1);
            if (choice == 1) {
                System.out.println("so you'd like to chose your attributes");
                break;
            }
        } while (choice != 2);
        if (choice == 1) {
            System.out.println("you have to distribute the 27 attribute points on the following 6 Stats");

            for (String items : player.playerStats.statNames) {
                System.out.println(items);
            }
            System.out.println("lets start with Strength you have " + 27 + " attribute points");
            player.playerStats.addPoints(0, 27);

            System.out.println("you have " + player.playerStats.attributePoints + " attribute points left");
            System.out.println("Next is Dexterity");
            player.playerStats.addPoints(1, player.playerStats.attributePoints);

            System.out.println("you have " + player.playerStats.attributePoints + " attribute points left");
            System.out.println("Next is Constitution");
            player.playerStats.addPoints(2, player.playerStats.attributePoints);

            System.out.println("you have " + player.playerStats.attributePoints + " attribute points left");
            System.out.println("Next is Intelligence");
            player.playerStats.addPoints(3, player.playerStats.attributePoints);

            System.out.println("you have " + player.playerStats.attributePoints + " attribute points left");
            System.out.println("Next is Wisdom");
            player.playerStats.addPoints(4, player.playerStats.attributePoints);

            System.out.println("you have " + player.playerStats.attributePoints + " attribute points left");
            System.out.println("and for the last Stat Charisma");
            player.playerStats.addPoints(5, player.playerStats.attributePoints);


        } else {
            player.playerStats.addPointsRoll(0, 27, dice.d(4));
           for (count=1;count<=5;count++){
               player.playerStats.addPointsRoll(count,player.playerStats.attributePoints,dice.d(4));
           }
           for (count=0;player.playerStats.attributePoints>=4;count++){
               player.playerStats.addPointsRoll(dice.d(6),player.playerStats.attributePoints,dice.d(4));
           }

        }

        if (player.playerStats.attributePoints > 0) {
            System.out.println("you seem to have forgotten a few points you have "
                    + player.playerStats.attributePoints + " points left");
            System.out.println("your current stats look like this");
            player.playerStats.stats();
            System.out.println("would you like to spend them");
            for (String option : yesOrNo) {
                System.out.println(option);
            }
            choice = userInput.nextInt();
            if (choice == 0) {
                do {
                    System.out.println("On which stat do you want to spent the "
                            + player.playerStats.attributePoints + " points?");
                    count = 0;
                    for (String items : player.playerStats.statNames) {
                        System.out.println("(" + count + ")" + items);
                        count++;
                    }
                    choice = userInput.nextInt();
                    player.playerStats.addPoints(choice, player.playerStats.attributePoints);
                } while (player.playerStats.attributePoints > 0);


            }
        }

        System.out.println("looks good here are your stats");
        player.playerStats.stats();

    }
}