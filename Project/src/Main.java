import entetys.allClasses;
import entetys.player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 0;
        int choice;

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
        if (choice==1) {
            int attributepoints=27;
            System.out.println("you have a max of  attribute points you can distribute them now");
            System.out.println("lets start with Strength");
            choice=userInput.nextInt();
            if (choice < 9) {
                attributepoints-=choice;
                player.playerStats.playerStrength = player.playerStats.playerStrength + choice;
            }else {
                System.out.println("you cant put more than 8 points into one attribute ");
            }
        }

    }
}