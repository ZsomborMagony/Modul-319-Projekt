package entetys;

import entetys.classes.Barbarian;
import entetys.classes.Monk;
import mechanics.Dice;
import mechanics.Inventory;

import java.util.Scanner;

public class Player {
    public static int playerChosenClass = 0;

    public static String playerClass() {
        String playerClass = "";
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


        public static final String[] statNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom",
                "Charisma"};

        public static void stats() {

            // player stats output
            for (String items : statNames) {
                switch (items) {
                    case "Strength" -> System.out.println(items + ": " + playerStrength);
                    case "Dexterity" -> System.out.println(items + ": " + playerDexterity);
                    case "Constitution" -> System.out.println(items + ": " + playerConstitution);
                    case "Intelligence" -> System.out.println(items + ": " + playerIntelligence);
                    case "Wisdom" -> System.out.println(items + ": " + playerWisdom);
                    case "Charisma" -> System.out.println(items + ": " + playerCharisma);
                }
            }
        }

        //default stats

        static int playerStrength = 8; //8 start
        public static int playerDexterity = 8;
        static int playerConstitution = 8;
        static int playerIntelligence = 8;
        public static int playerWisdom = 8;
        static int playerCharisma = 8;
        public static int attributePoints = 27;//27 start
        private static int modifier;
        public static int level = 1;
        public static int hp = 20; //hitPoints
        public static int maxHp = 20;
        public static int xp = 0;
        public static boolean rest = true;
        public static int armorClass = 0;

        public static final Inventory playerInventory = new Inventory();

        public static void rest() { //long rest
            hp = maxHp;
            Monk.regenKiPoints();
            Barbarian.rageRestTimeCounter = 10;
            Barbarian.rageLeft = Barbarian.rageMax;
            Barbarian.barbarianRage.rageRestTimeCalculatorReset();
        }

        public static void playerHpCalculate() {
            int hitDie = 0;
            switch (playerChosenClass) {

                case 0 -> hitDie = 8;
                case 3 -> hitDie = 12;
            }
            if (level == 1) {
                maxHp = hitDie + statModifiers("constitution");
            } else {
                maxHp += Dice.d(hitDie) + statModifiers("constitution");
            }
        }

        public static void calculateAC() {
            if (playerInventory.getEquipmentValue(1) != null) {
                armorClass = 10 + statModifiers("dexterity");
            } else {
                armorClass = playerInventory.getArmorClassFromEquippedSlot(playerInventory.getEquipmentValue(1))
                        + statModifiers("dexterity");
            }
            if (playerInventory.getEquipmentValue(2) != null) {
                armorClass += 2;
            }
        }

        public static int statModifiers(String attribute) {
            int temp = 0;

            switch (attribute) {
                case "strength" -> temp = playerStrength;
                case "dexterity" -> temp = playerDexterity;
                case "constitution" -> temp = playerConstitution;
                case "intelligence" -> temp = playerIntelligence;
                case "wisdom" -> temp = playerWisdom;
                case "charisma" -> temp = playerCharisma;
            }
            switch (temp) {
                case 8, 9 -> modifier = -1;
                case 10, 11 -> modifier = 0;
                case 12, 13 -> modifier = 1;
                case 14, 15 -> modifier = 2;
                case 16, 17 -> modifier = 3;
                case 18, 19 -> modifier = 4;
                case 20 -> modifier = 5;

            }
            return modifier;
        }
        //player stat choice

        public static void addPointsManually(String attribute, int gainedAttributePoints) {

            attributePoints = gainedAttributePoints;
            Scanner userInput = new Scanner(System.in);
            int choice;
            int temp = 0;

            switch (attribute) {
                case "strength" -> temp = playerStrength;
                case "dexterity" -> temp = playerDexterity;
                case "constitution" -> temp = playerConstitution;
                case "intelligence" -> temp = playerIntelligence;
                case "wisdom" -> temp = playerWisdom;
                case "charisma" -> temp = playerCharisma;

            }
            if (temp <= 20) {


                do {
                    choice = userInput.nextInt();
                    if (choice < 9 && choice <= attributePoints && choice > 0) {
                        temp += choice;
                        if (temp >= 20) {
                            temp -= choice;
                            System.out.println("you tried to put in to many points please try again");
                            attributePoints += choice;
                            break;
                        }
                    } else {
                        System.out.println("you tried to put in to many points please try again");
                    }
                }
                while (choice > 8 || choice > attributePoints || choice < 0);
                if (choice > 0) {
                    attributePoints -= choice;
                } else {
                    attribute += choice;
                }
            }
            switch (attribute) {
                case "strength" -> playerStrength = temp;
                case "dexterity" -> playerDexterity = temp;
                case "constitution" -> playerConstitution = temp;
                case "intelligence" -> playerIntelligence = temp;
                case "wisdom" -> playerWisdom = temp;
                case "charisma" -> playerCharisma = temp;

            }

        }


        public static void rollPoints(int attribute, int gainedAttributePoints, int roll) {
            int temp = 0;
            switch (attribute) {
                case 0 -> temp = playerStrength;
                case 1 -> temp = playerDexterity;
                case 2 -> temp = playerConstitution;
                case 3 -> temp = playerIntelligence;
                case 4 -> temp = playerWisdom;
                case 5 -> temp = playerCharisma;
            }
            if (temp <= 20) {


                do {

                    if (roll < 9 && roll <= attributePoints) {
                        temp += roll;
                        if (temp >= 20) {
                            temp -= roll;
                            attributePoints += roll;
                            break;
                        }
                    }
                }
                while (roll > 8 || roll > attributePoints);
                attributePoints -= roll;

            }
            switch (attribute) {
                case 0 -> playerStrength = temp;
                case 1 -> playerDexterity = temp;
                case 2 -> playerConstitution = temp;
                case 3 -> playerIntelligence = temp;
                case 4 -> playerWisdom = temp;
                case 5 -> playerCharisma = temp;
            }

        }

        //rolls stats in order for player

        public static void rollStats() {

            rollPoints(0, 27, Dice.d(4));
            for (int count = 1; count <= 5; count++) {
                rollPoints(count, attributePoints, Dice.d(4));
            }
            if (attributePoints >= 4) {
                for (int count = 0; attributePoints >= 4; count++) {
                    rollPoints(Dice.d(6), attributePoints, Dice.d(4));
                }
            }
            int roll;
            do {
                roll = Dice.d(4);
                if (roll <= attributePoints) {
                    rollPoints(Dice.d(6), attributePoints, roll);
                } else if (attributePoints == 0) {
                    break;
                }
            } while (true);

        }

        public static void distributionStart(int choice) {
            String attribute = "";
            Scanner userInput = new Scanner(System.in);
            int temp = 0;
            while (choice < 0 || choice > 5) {
                System.out.println("please don't put more than 5 or less than 0 in ");
                choice = userInput.nextInt();

            }
            switch (choice) {
                case 0 -> attribute = "strength";
                case 1 -> attribute = "dexterity";
                case 2 -> attribute = "constitution";
                case 3 -> attribute = "intelligence";
                case 4 -> attribute = "wisdom";
                case 5 -> attribute = "charisma";
                default -> temp = 40;
            }
            switch (attribute) {
                case "strength" -> temp = playerStrength;
                case "dexterity" -> temp = playerDexterity;
                case "constitution" -> temp = playerConstitution;
                case "intelligence" -> temp = playerIntelligence;
                case "wisdom" -> temp = playerWisdom;
                case "charisma" -> temp = playerCharisma;
            }
            if (temp <= 16) {
                System.out.println("how many points do you want to put into " + attribute);
                addPointsManually(attribute, attributePoints);
            }
            System.out.println(attribute + " is already at 16 witch is the max an attribute can be at the start");

        }
    }

}