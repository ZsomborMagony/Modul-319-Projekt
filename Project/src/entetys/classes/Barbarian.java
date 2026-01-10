package entetys.classes;

import entetys.Player;
import entetys.Weapons;
import mechanics.Attack;
import mechanics.Inventory;

import java.util.Scanner;

public class Barbarian {

    // Variable
    public static boolean startingOptions;
    public static boolean unarmoredDefense;
    public static short rageMax;
    public static short rageLeft = 2;
    public static short rageRestTimeCounter;
    public static byte rageDamage = 2;
    static boolean loopUntilGameEnds = true;


    // Constructor
    public Barbarian() {

    }


    // Methods

    public static void start() {
        while (loopUntilGameEnds) {
            Barbarian.barbarianRage.lvlRageDamage();
            Barbarian.barbarianRage.lvlRageMax();
        }
    }

    //Geld System!!!
    public static void isStartingOptions() {
        System.out.println("Starting options for Barbarian");
        System.out.println("Option A");
        System.out.println(" - Greataxe");
        System.out.println(" - 4 Handaxes");
        System.out.println(" - 15 GP");
        System.out.println();

        System.out.println("Option B");
        System.out.println(" - 75 GP");
        System.out.println(" ");

        System.out.println("[1] Option A , [2] Option B ");
        Scanner userInput = new Scanner(System.in);
        int user = userInput.nextInt();

        if (user == 1) {
            startingOptions = true; //Option A

            System.out.println("You selected:");
            System.out.println("Option A");
            System.out.println(" - Greataxe");
            System.out.println(" - Handaxe");
            System.out.println(" - 15 GP");
            System.out.println(" ");

            Player.PlayerStats.playerInventory.addWeaponToInventory(1, 3);
            Player.PlayerStats.playerInventory.addWeaponToInventory(0, 3);


        } else if (user == 2) {
            startingOptions = false; //Option B

            System.out.println("You selected:");
            System.out.println("Option B");
            System.out.println(" - 75 GP");
            System.out.println(" ");
            Player.PlayerStats.playerInventory.money[0] += 75;

        } else {
            System.out.println("Invalid Pick");
        }
    }
        public  static void barbarianAttackAbilities() {
        switch (Player.PlayerStats.level){
            case 1-> {
                System.out.println("[1] Rage");
            }
            case 2,3,4-> {
                System.out.println("[1] Rage");
                System.out.println("[2] Reckless Attack");
            }
            case 5,6 ->{
                System.out.println("[1] Rage");
                System.out.println("[2] Reckless Attack");
                System.out.println("[3] Extra Attack");
            }
            default -> {

                System.out.println("[1] Rage");
                System.out.println("[2] Reckless Attack");
                System.out.println("[3] Extra Attack");
                System.out.println("[4] Feral Instinct");
            }
        }
        }
    public static int barbarianAbilities() {
        // Abilities
        /*
        lvl 1 [Rage, Unarmored Defense]
        lvl 2-4 [Rage, Unarmored Defense, Reckless Attack]
        lvl 5-6 [Rage, Unarmored Defense, Reckless Attack, Extra Attack]
        lvl 7-19 [Rage, Unarmored Defense, Reckless Attack, Extra Attack, Feral Instinct]
        lvl 20 [Rage, Unarmored Defense, Reckless Attack, Extra Attack, Feral Instinct, Primal Champion]
         */

        Scanner userInput = new Scanner(System.in);
        int user;
        int attackChoice;

        switch (Player.PlayerStats.level) {
            case 1 -> {
                System.out.println("[1] Rage, [2] Unarmored Defense");
                user = userInput.nextInt();

                switch (user) {
                    case 1 -> attackChoice = 1;
                    case 2 -> attackChoice = 2;
                    default -> {
                        System.out.println("Invalid Entry");
                        attackChoice = 0;
                    }
                }
            }
            case 2, 3, 4 -> {
                System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack");
                user = userInput.nextInt();

                switch (user) {
                    case 1 -> attackChoice = 1;
                    case 2 -> attackChoice = 2;
                    case 3 -> attackChoice = 3;
                    default -> {
                        System.out.println("Invalid Entry");
                        attackChoice = 0;
                    }
                }
            }
            case 5, 6 -> {
                System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack, [4] Extra Attack");
                user = userInput.nextInt();

                switch (user) {
                    case 1 -> attackChoice = 1;
                    case 2 -> attackChoice = 2;
                    case 3 -> attackChoice = 3;
                    case 4 -> attackChoice = 4;
                    default -> {
                        System.out.println("Invalid Entry");
                        attackChoice = 0;
                    }
                }
            }
            default -> {
                System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack, [4] Extra Attack, [5] Feral Instinct");
                user = userInput.nextInt();

                switch (user) {
                    case 1 -> attackChoice = 1;
                    case 2 -> attackChoice = 2;
                    case 3 -> attackChoice = 3;
                    case 4 -> attackChoice = 4;
                    case 5 -> attackChoice = 5;
                    default -> {
                        System.out.println("Invalid Entry");
                        attackChoice = 0;
                    }
                }
            }
        }

        return attackChoice;

    }


    public static class barbarianRage {

//        Rage only if:-
//        Armor Restriction: No Heavy Armor

//        Rage Effects:-
//        Half Damage from enemies
//        +Rage Attack Damage

        public static int rage(int attackRoll) {
            int attackDamage = 0;


            if (rageLeft > 0 && Player.PlayerStats.playerInventory.getEquipmentValue(0) != null) {
                attackDamage = attackRoll + lvlRageDamage();
                rageLeft--;
                rageRestTimeCounter = 0;
                System.out.println("Rage Activated");
            } else {
                System.out.println("Failed!");
                System.out.println("(None Rages left) or (Heavy Armor is on)");
                attackDamage = attackRoll;
            }

            return attackDamage;
        }

        public static void lvlRageMax() {
            /*
            lvl 1, 2 = Total=2
            lvl 3, 4, 5 = Total=3
            lvl 6, 7, 8 = Total=4
            lvl 9, 10, 11 = Total=4
            lvl 12, 13, 14, 15 = Total=5
            lvl 16 = Total=5
            lvl 17, 18, 19, 20 = Total=6
     */

            switch (Player.PlayerStats.level) {
                case 1, 2 -> rageMax = 2;
                case 3, 4, 5 -> rageMax = 3;
                case 6, 7, 8, 9, 10, 11 -> rageMax = 4;
                case 12, 13, 14, 15, 16 -> rageMax = 5;
                default -> rageMax = 6;
            }
        }

        public static void rageRestTimeCounter() {
            long placeholderRound = 0;
            if (placeholderRound != Attack.round) {
                rageLeft--;
                placeholderRound = Attack.round;
            }
        }

        public static void rageRestTimeCalculatorReset() {
//            Short Rest (2 Turns) = +1
//            Long Rest (10 Turns) = +all

            lvlRageMax();
            if (rageLeft != rageMax) {
                if (rageRestTimeCounter == 2) {
                    rageLeft++;
                } else if (rageRestTimeCounter == 10) {
                    rageLeft = rageMax;
                    rageRestTimeCounter = 0;
                }
            }

        }

        public static int lvlRageDamage() {

            /*
            lvl 1, 2 = Damage=+2
            lvl 3, 4, 5 = Damage=+2
            lvl 6, 7, 8 = Damage=+2
            lvl 9, 10, 11 = Damage=+3
            lvl 12, 13, 14, 15 = Damage=+3
            lvl 16 = Damage=+4
            lvl 17, 18, 19, 20 = Damage=+4
             */
            switch (Player.PlayerStats.level) {
                case 1, 2, 3, 4, 5, 6, 7, 8 -> rageDamage = 2;
                case 9, 10, 11, 12, 13, 14, 15 -> rageDamage = 3;
                default -> rageDamage = 4;
            }
            return rageDamage;
        }
    }

    public static int recklessAttack(int attackRoll1, int attackRoll2) {
//        2d rolls for attack, also for enemies
        return attackRoll1 + attackRoll2;
    }


    public static int extraAttack(int attackRoll) {
//        attack = 2 * attack

        attackRoll += attackRoll;
        return attackRoll;
    }

    public static void unarmoredDefense() {


        if (Player.PlayerStats.playerInventory.getEquipmentValue(1) != null) {
            Player.PlayerStats.armorClass = 10 + Player.PlayerStats.statModifiers("dexterity")
                    + Player.PlayerStats.statModifiers("constitution");
        }


    }

    public static int feralInstinct(int attackRoll1, int attackRoll2) {
//        1d and 1d rolls, chooses one,then 1d + dex

        Scanner userInput = new Scanner(System.in);
        int user = userInput.nextInt();
        int attackRoll;
        System.out.println("Pick one attack roll");
        System.out.println("Press [1] for attack roll: " + attackRoll1);
        System.out.println("Press [2] for attack roll: " + attackRoll2);
        switch (user) {
            case 1 -> attackRoll = attackRoll1;
            case 2 -> attackRoll = attackRoll2;
            default -> {
                System.out.println("Invalid Pick");
                attackRoll = attackRoll1;
            }
        }

        return attackRoll;
    }


}
