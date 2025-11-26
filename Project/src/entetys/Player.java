package entetys;

import mechanics.Dice;

import java.util.Scanner;

public class Player {
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

    public class PlayerStats {


        public static String[] statNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom",
                "Charisma"};

        public static void stats() {

            // player stats output
            for (String items : statNames) {
                if (items.equals("Strength")) {
                    System.out.println(items + ": " + playerStrength);
                } else if (items.equals("Dexterity")) {
                    System.out.println(items + ": " + playerDexterity);
                } else if (items.equals("Constitution")) {
                    System.out.println(items + ": " + playerConstitution);
                } else if (items.equals("Intelligence")) {
                    System.out.println(items + ": " + playerIntelligence);
                } else if (items.equals("Wisdom")) {
                    System.out.println(items + ": " + playerWisdom);
                } else if (items.equals("Charisma")) {
                    System.out.println(items + ": " + playerCharisma);
                }
            }
        }


        public static int playerStrength = 8; //8 start
        public static int playerDexterity = 8;
        public static int playerConstitution = 8;
        public static int playerIntelligence = 8;
        public static int playerWisdom = 8;
        public static int playerCharisma = 8;
        public static int attributePoints = 27;//27 start

        //player stat choice

        public static void test(String attribute, int gainedAttributePoints) {

            attributePoints = gainedAttributePoints;
            Scanner userInput = new Scanner(System.in);
            int choice;
            int tmpAttr = 0;
            if (attribute.equalsIgnoreCase("strength")) {
                tmpAttr = playerStrength;
            } else if (attribute.equalsIgnoreCase("dexterity")) {
                tmpAttr = playerDexterity;
            } else if (attribute.equalsIgnoreCase("constitution")) {
                tmpAttr = playerConstitution;
            } else if (attribute.equalsIgnoreCase("intelligence")) {
                tmpAttr = playerIntelligence;
            } else if (attribute.equalsIgnoreCase("wisdom")) {
                tmpAttr = playerWisdom;
            } else if (attribute.equalsIgnoreCase("charisma")) {
                tmpAttr = playerCharisma;
            }
            if (tmpAttr <= 20) {


                do {
                    choice = userInput.nextInt();
                    if (choice < 9 && choice <= attributePoints) {
                        tmpAttr += choice;
                        if (tmpAttr >= 20) {
                            tmpAttr -= choice;
                            System.out.println("you tried to put in to many points please try again");
                            attributePoints += choice;
                            break;
                        }
                    } else {
                        System.out.println("you tried to put in to many points please try again");
                    }
                }
                while (choice > 8 || choice > attributePoints);
                attributePoints -= choice;

            }

            if (attribute.equalsIgnoreCase("strength")) {
                playerStrength = tmpAttr;
            } else if (attribute.equalsIgnoreCase("dexterity")) {
                playerDexterity = tmpAttr;
            } else if (attribute.equalsIgnoreCase("constitution")) {
                playerConstitution = tmpAttr;
            } else if (attribute.equalsIgnoreCase("intelligence")) {
                playerIntelligence = tmpAttr;
            } else if (attribute.equalsIgnoreCase("wisdom")) {
                playerWisdom = tmpAttr;
            } else if (attribute.equalsIgnoreCase("charisma")) {
                playerCharisma = tmpAttr;
            }

        }


        //stas rolled
        public static void addPointsRoll(int selectedAttribute, int gainedAttributePoints, int roll) {

            attributePoints = gainedAttributePoints;
            int choice;

            switch (selectedAttribute) {
                case 0: {

                    //strength
                    if (playerStrength >= 20) {
                        break;
                    }
                    do {
                        choice = roll;
                        if (choice < 9 && choice <= attributePoints) {
                            playerStrength += choice;
                            if (playerStrength >= 20) {
                                playerStrength -= choice;

                                attributePoints += choice;
                                break;
                            }
                        }
                    }
                    while (choice > 8 || choice > attributePoints);
                    attributePoints -= choice;
                    break;
                }
                case 1: {
                    //dex
                    if (playerDexterity >= 20) {
                        break;

                    }
                    do {

                        choice = roll;
                        if (choice < 9 && choice <= attributePoints) {
                            playerDexterity += choice;
                            if (playerDexterity >= 20) {
                                playerDexterity -= choice;

                                attributePoints += choice;
                                break;
                            }
                        }

                    } while (choice > 8 || choice > attributePoints);
                    attributePoints -= choice;
                    break;

                }
                case 2: {
                    //con
                    if (playerConstitution >= 20) {
                        break;
                    }
                    do {
                        choice = roll;
                        if (choice < 9 && choice <= attributePoints) {
                            playerConstitution += choice;
                            if (playerConstitution >= 20) {
                                playerConstitution -= choice;

                                attributePoints += choice;
                                break;
                            }
                        }
                    } while (choice > 8 || choice > attributePoints);
                    attributePoints -= choice;
                    break;
                }
                case 3: {
                    //int
                    if (playerIntelligence >= 20) {
                        break;
                    }
                    do {
                        choice = roll;
                        if (choice < 9 && choice <= attributePoints) {
                            playerIntelligence += choice;
                            if (playerIntelligence >= 20) {
                                playerIntelligence -= choice;

                                attributePoints += choice;
                                break;
                            }
                        }

                    } while (choice > 8 || choice > attributePoints);
                    attributePoints -= choice;
                    break;
                }
                case 4: {
                    //wis
                    if (playerWisdom >= 20) {
                        break;
                    }
                    do {
                        choice = roll;
                        if (choice < 9 && choice <= attributePoints) {
                            playerWisdom += choice;
                            if (playerWisdom >= 20) {
                                playerWisdom -= choice;

                                attributePoints += choice;
                                break;
                            }
                        }

                    } while (choice > 8 || choice > attributePoints);
                    attributePoints -= choice;
                    break;
                }
                case 5: {
                    //char
                    if (playerCharisma >= 20) {
                        break;
                    }
                    do {
                        choice = roll;
                        if (choice < 9 && choice <= attributePoints) {
                            playerCharisma += choice;
                            if (playerCharisma >= 20) {
                                playerCharisma -= choice;

                                attributePoints += choice;
                                break;
                            }
                        }

                    } while (choice > 8 || choice > attributePoints);
                    attributePoints -= choice;
                    break;
                }
            }
        }

        public static void rollStats() {

            addPointsRoll(0, 27, Dice.d(4));
            for (int count = 1; count <= 5; count++) {
                addPointsRoll(count, attributePoints, Dice.d(4));
            }
            if (attributePoints >= 4) {
                for (int count = 0; attributePoints >= 4; count++) {
                    addPointsRoll(Dice.d(6), attributePoints, Dice.d(4));
                }
            }
            int roll;
        }


    }

}