import entetys.AllClasses;
import entetys.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int choice;
        String[] yesOrNo = {"(0) Yes", "(1) No"};


        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to our Adventure please choose one of the following classes");
        for (String classOptions : AllClasses.classes) {

            System.out.println("(" + count + ") " + classOptions);
            count++;
        }
        do {
            choice = userInput.nextInt();
            if (choice < 0 || choice > 3) {
                System.out.println("Invalid");
            }

        } while (choice < 0 || choice > 3);
        Player.playerChosenClass = choice;
        System.out.println("you chose the Class " + Player.playerClass(""));

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

            for (String items : Player.PlayerStats.statNames) {
                System.out.println(items);
            }
            System.out.println("lets start with Strength you have " + 27 + " attribute points");
            Player.PlayerStats.test("strength", 27);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("Next is Dexterity");
            Player.PlayerStats.test("dexterity", Player.PlayerStats.attributePoints);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("Next is Constitution");
            Player.PlayerStats.test("constitution", Player.PlayerStats.attributePoints);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("Next is Intelligence");
            Player.PlayerStats.test("intelligence", Player.PlayerStats.attributePoints);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("Next is Wisdom");
            Player.PlayerStats.test("wisdom", Player.PlayerStats.attributePoints);

            System.out.println("you have " + Player.PlayerStats.attributePoints + " attribute points left");
            System.out.println("and for the last Stat Charisma");
            Player.PlayerStats.test("charisma", Player.PlayerStats.attributePoints);


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

                    Player.PlayerStats.test(Player.PlayerStats.statNames[choice], Player.PlayerStats.attributePoints);
                } while (Player.PlayerStats.attributePoints > 0);

            }
        }

        System.out.println("looks good here are your stats");
        Player.PlayerStats.stats();

    }
}