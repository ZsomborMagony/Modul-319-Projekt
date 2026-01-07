package entetys.classes;
import entetys.Player;
import entetys.Weapons;
import mechanics.Inventory;

import java.util.Scanner;

public class Barbarian {

    // Starting option
    /*
    Option A:
    Greataxe
    4 Handaxes
    15 GP

    Option B:
    75 GP
     */

    // Rage
    /*
    Rage only if:-
    Armor Restriction: No Heavy Armor

    Ends on next turn

    Rage Effects:-
    Half Damage from enemies
    +Rage Attack Damage

    Short Rest (2 Turns) = +1
    Long Rest (10 Turns) = +all

     */

    // Abilities
    /*
    lvl 1 [Rage, Unarmored Defense]
    lvl 2-4 [Rage, Unarmored Defense, Reckless Attack]
    lvl 5-6 [Rage, Unarmored Defense, Reckless Attack, Extra Attack]
    lvl 7-19 [Rage, Unarmored Defense, Reckless Attack, Extra Attack, Feral Instinct]
    lvl 20 [Rage, Unarmored Defense, Reckless Attack, Extra Attack, Feral Instinct, Primal Champion]
     */

    // Abilities during different lvl
    // Rage
    /*
    lvl 1, 2 = Total=2, Damage=+2
    lvl 3, 4, 5 = Total=3, Damage=+2
    lvl 6, 7, 8 = Total=4, Damage=+2
    lvl 9, 10, 11 = Total=4, Damage=+3
    lvl 12, 13, 14, 15 = Total=5, Damage=+3
    lvl 16 = Total=5, Damage=+4
    lvl 17, 18, 19, 20 = Total=6, Damage=+4
     */

    // Unarmored Defense
    /*
    Armour Class = 10 + dex + con
    Shields allowed
     */

    // Reckless Attack
    /*
    2d rolls for attack, also for enemies
     */

    // Extra Attack
    /*
    attack = 2 * attack
     */

    // Feral Instinct
    /*
    1d and 1d rolls, chooses one,then 1d + dex
     */



    // Variable
    public static boolean startingOptions;
    public static boolean unarmoredDefense;
    public static short rageMax;
    public static short rageLeft = 2;
    public static short rageRestTimeCounter;
    public static byte rageDamage = 2;
    static boolean loopUntilGameEnds = true;


    // Constructor
    public Barbarian(){

    };


    // Methods

    public static void start(){
        while(loopUntilGameEnds){
            unarmoredDefenseOff();
            Barbarian.barbarianRage.lvlRageDamage();
            Barbarian.barbarianRage.lvlRageMax();
        }
    }

    //Geld System!!!
    public static void isStartingOptions(){
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

        if (user==1){
            startingOptions = true; //Option A

            System.out.println("You selected:");
            System.out.println("Option A");
            System.out.println(" - Greataxe");
            System.out.println(" - Handaxe");
            System.out.println(" - 15 GP");
            System.out.println(" ");

            Inventory.inventory[0] = Weapons.greataxe.name;
            Inventory.inventory[1] = Weapons.handaxe.name;



        } else if (user==2) {
            startingOptions = false; //Option B

            System.out.println("You selected:");
            System.out.println("Option B");
            System.out.println(" - 75 GP");
            System.out.println(" ");

        } else {
            System.out.println("Invalid Pick");
        }
    };

    public static void barbarianAbilities(){
        Scanner userInput = new Scanner(System.in);
        int user;
        int attackChoice;

        switch (Player.PlayerStats.level){
            case 1 -> {
                System.out.println("[1] Rage, [2] Unarmored Defense");
                user = userInput.nextInt();

                switch (user){
                    case 1 -> attackChoice = 1;
                    case 2 -> attackChoice = 2;
                    default -> System.out.println("Invalid Entry");
                }
            }
            case 2, 3, 4 ->{
                System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack");
                user = userInput.nextInt();

                switch (user){
                    case 1 -> attackChoice = 1;
                    case 2 -> attackChoice = 2;
//                    case 3 -> attackChoice = 3;
                    default -> System.out.println("Invalid Entry");
                }
            }
            case 5, 6 -> {
                System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack, [4] Extra Attack");
                user = userInput.nextInt();

                switch (user){
                    case 1 -> attackChoice = 1;
                    case 2 -> attackChoice = 2;
//                    case 3 -> attackChoice = 3;
//                    case 4 -> attackChoice = 4;
                    default -> System.out.println("Invalid Entry");
                }
            }
            default -> {
                System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack, [4] Extra Attack, [5] Feral Instinct");
                user = userInput.nextInt();

                switch (user) {
                    case 1 -> attackChoice = 1;
                    case 2 -> attackChoice = 2;
//                    case 3 -> attackChoice = 3;
//                    case 4 -> attackChoice = 4;
//                    case 5 -> attackChoice = 5;
                    default -> System.out.println("Invalid Entry");
                }
            }
        }

    }


    public static int unarmoredDefenseOn(){
        int armorClass = 0;
        if (unarmoredDefense == false){
            if (Inventory.equipped[1] == null){
                unarmoredDefense = true;
                armorClass = 10 + Player.PlayerStats.statModifiers("dexterity") + Player.PlayerStats.statModifiers("constitution");
                System.out.println("Unarmored Defense activated");
            }
        }
        return armorClass;
    };

    public static void unarmoredDefenseOff(){ // Auto off, when Armor on
        if (unarmoredDefense == true){
            if (Inventory.equipped[1] != null){
                unarmoredDefense = false;
                System.out.println("Unarmored Defense deactivated");
                System.out.println("You can only use Unarmored Defense without any armor wearing!!!");
            }
        }
    }

    public static class barbarianRage{

        public static int rage(int attackRoll){
            int attackDamage = 0;

            if (rageLeft > 0 /*&&....noHeavyArmor......*/){
                attackDamage = attackRoll + Barbarian.barbarianRage.lvlRageDamage();
                rageLeft--;
                rageRestTimeCounter = 0;
                System.out.println("Rage Activated");
            } else {
                System.out.println("Failed!");
                System.out.println("(None Rages left) or (Heavy Armor is on)");
                attackDamage = attackRoll;
            }

            return attackDamage;
        };

        public static void lvlRageMax(){
            switch (Player.PlayerStats.level){
                case 1, 2 -> rageMax = 2;
                case 3, 4, 5 -> rageMax = 3;
                case 6, 7, 8, 9, 10, 11 -> rageMax = 4;
                case 12, 13, 14, 15, 16 -> rageMax = 5;
                default -> rageMax = 6;
            }
        };

        public static void rageRestTimeCalculator(){
            if (rageLeft != rageMax){
                if (rageRestTimeCounter == 2){
                    rageLeft++;
                } else if (rageRestTimeCounter == 10) {
                    rageLeft = rageMax;
                    rageRestTimeCounter = 0;
                }
            }

        };

        public static int lvlRageDamage(){
            switch (Player.PlayerStats.level) {
                case 1, 2, 3, 4, 5, 6, 7, 8 -> rageDamage = 2;
                case 9, 10, 11, 12, 13, 14, 15 -> rageDamage = 3;
                default -> rageDamage = 6;
            }
            return rageDamage;
        };
    };

    public static int recklessAttack(int attackRoll){

        return attackRoll;
    };

    public static int extraAttack(int attackRoll) {
        attackRoll += attackRoll;
        return attackRoll;
    }

    public static int feralInstinct(int attackRoll){

        return attackRoll;
    }



}
