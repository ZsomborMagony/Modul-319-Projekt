package entetys;

import java.util.Scanner;

public class player {
    public static int playerChosenClass;

    public static String playerClass(String playerClass) {

        switch (playerChosenClass) {
            case 0 -> playerClass = "Monk";
            case 1 -> playerClass = "Warlock";
            case 2 -> playerClass = "Barbarian";
            case 3 -> playerClass = "Cleric";
            default -> playerClass = "invalid";
        }
        return playerClass;
    }

    public class playerStats {
        public static void statNames() {

            String[] stats={"(0) Strength","(1) Dexterity",};
        }
        public static int playerStrength; //8 start
        public static int playerDexterity;
        public static int playerConstitution;
        public static int playerIntelligence;
        public static int playerWisdom;
        public static int playerCharisma;
        public static int attributePoints;//27 start

        public static void addPoints(int selectedAttribute, int gainedAttributePoints) {

            attributePoints = gainedAttributePoints;
            Scanner userInput = new Scanner(System.in);
            int choice;

            switch (selectedAttribute) {
                case 0: {
                    do {
                        //strength
                        choice = userInput.nextInt();
                        if (choice < 9 && choice <= attributePoints) {
                            playerStrength += choice;
                        } else {
                            System.out.println("you tried to put in to many points please try again");
                        }
                    } while (choice > 8 || choice > attributePoints);
                    attributePoints-=choice;
                    break;
                }
                case 1: {
                    //dex
                    choice = userInput.nextInt();
                    if (choice < 9 && choice <= attributePoints) {
                        playerDexterity += choice;
                    } else {
                        System.out.println("you tried to put in to many points please try again");
                    }

                    while (choice > 8 || choice > attributePoints) ;
                    attributePoints-=choice;
                    break;

                }
                case 2: {
                    //con
                    choice = userInput.nextInt();
                    if (choice < 9 && choice <= attributePoints) {
                        playerConstitution += choice;
                    } else {
                        System.out.println("you tried to put in to many points please try again");

                    }
                    while (choice > 8 || choice > attributePoints) ;
                    attributePoints-=choice;
                    break;
                }
                case 3: {
                    //int
                    choice = userInput.nextInt();
                    if (choice < 9 && choice <= attributePoints) {
                        playerIntelligence += choice;
                    } else {
                        System.out.println("you tried to put in to many points please try again");
                    }
                }
                while (choice > 8 || choice > attributePoints) ;
                attributePoints-=choice;
                break;

                case 4: {
                    //wis
                    choice = userInput.nextInt();
                    if (choice < 9 && choice <= attributePoints) {
                        playerWisdom += choice;
                    } else {
                        System.out.println("you tried to put in to many points please try again");
                    }
                }
                while (choice > 8 || choice > attributePoints) ;
                attributePoints-=choice;
                break;

                case 5: {
                    //char
                    choice = userInput.nextInt();
                    if (choice < 9 && choice <= attributePoints) {
                        playerCharisma += choice;
                    } else {
                        System.out.println("you tried to put in to many points please try again");
                    }
                }
                while (choice > 8 || choice > attributePoints) ;
                attributePoints-=choice;
                break;

            }
        }
    }

}