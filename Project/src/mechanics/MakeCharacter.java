package mechanics;

import entetys.AllClasses;
import entetys.Player;

import java.util.Scanner;

import static entetys.AllClasses.classes;

public class MakeCharacter {
    public static void makeCharakter() {
        int count = 0;
        int choice;
        int roll;
        String[] yesOrNo = {"(0) Yes", "(1) No"};

        System.out.println("Please choose your class");

        Scanner userInput = new Scanner(System.in);
        for (String classOptions : classes) {

            System.out.println("(" + count + ") " + classOptions);
            count++;
        }
        do {
            choice = userInput.nextInt();
            if (choice < 0 || choice > 3) {
                System.out.println("Invalid");
            }

        } while (choice < 0 || choice > 3);
        System.out.println("you chose the Class " + Player.playerClass(""));
        Player.playerChosenClass = choice;

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
            System.out.println("you have to distribute the 27 attribute points on the following 6 Stats you can" +
                    " distribute max a max of 8 points int each stat");

            for (String items : Player.PlayerStats.statNames) {
                System.out.println(items);
            }
            System.out.println("lets start with Strength you have " + 27 + " attribute points");
            Player.PlayerStats.addPointsManually("strength", 27);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("Next is Dexterity");
            Player.PlayerStats.addPointsManually("dexterity", Player.PlayerStats.attributePoints);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("Next is Constitution");
            Player.PlayerStats.addPointsManually("constitution", Player.PlayerStats.attributePoints);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("Next is Intelligence");
            Player.PlayerStats.addPointsManually("intelligence", Player.PlayerStats.attributePoints);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("Next is Wisdom");
            Player.PlayerStats.addPointsManually("wisdom", Player.PlayerStats.attributePoints);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("and for the last Stat Charisma");
            Player.PlayerStats.addPointsManually("charisma", Player.PlayerStats.attributePoints);


        } else {
            Player.PlayerStats.rollStats();
        }

        if (Player.PlayerStats.attributePoints > 0) {
            System.out.println("you seem to have forgotten a few points you have "
                    + Player.PlayerStats.attributePoints + " points left");
            System.out.println("your current stats look like this");
            Player.PlayerStats.stats();
            System.out.println("would you like to spend them");
            for (String option : yesOrNo) {
                System.out.println(option);
            }
            choice = userInput.nextInt();
            if (choice == 0) {
                do {
                    System.out.println("On which stat do you want to spent the "
                            + Player.PlayerStats.attributePoints + " points?");
                    count = 0;
                    for (String items : Player.PlayerStats.statNames) {
                        System.out.println("(" + count + ")" + items);
                        count++;
                    }
                    choice = userInput.nextInt();


                    Player.PlayerStats.distributionStart(choice);
                } while (Player.PlayerStats.attributePoints > 0);

            }
        }

        System.out.println("looks good here are your stats");
        Player.PlayerStats.stats();


    }
}
