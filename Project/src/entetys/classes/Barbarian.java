package entetys.classes;
import entetys.Player;
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

    // Weapons Mastery
    /*
    lvl 1-3 = 2 Weapons
    lvl 4-9 = 3 Weapons
    lvl 10-20 = 4 Weapons
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
    public static boolean rage;
    public static short rageMax;
    public static short rageLeft = 2;
    public static short rageRestTimeCounter;
    public static byte rageDamage = 2;


    // Constructor
    public Barbarian(){

    };


    // Methods

    //inventory Needed!
    public static void isStartingOptions(){
        System.out.println("Starting options for Barbarian");
        System.out.println("Option A");
        System.out.println(" - 4 Handaxes");
        System.out.println(" - 15 GP");
        System.out.println(" ");

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
            System.out.println(" - 4 Handaxes");
            System.out.println(" - 15 GP");
            System.out.println(" ");

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

    public static void abilities(){
        Scanner userInput = new Scanner(System.in);
        byte user;

        switch (Player.PlayerStats.level){
            case 1 -> {
                System.out.println("[1] Rage, [2] Unarmored Defense");
                user = userInput.nextByte();

                switch (user){
                    case 1 -> BarbarianRage.rageOnAndOff();
                    case 2 -> unarmoredDefense();
                    default -> System.out.println("Invalid Entry");
                }
            }
            case 2, 3, 4 ->{
                System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack");
                user = userInput.nextByte();

                switch (user){
                    case 1 -> BarbarianRage.rageOnAndOff();
                    case 2 -> unarmoredDefense();
                    default -> System.out.println("Invalid Entry");
                }
            }
            case 5, 6 -> System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack, [4] Extra Attack");
            default -> System.out.println("[1] Rage. [2] Unarmored Defense, [3] Reckless Attack, [4] Extra Attack, [5] Feral Instinct");
        }

    }


    public static void unarmoredDefense(){

    };

    public static class BarbarianRage{
        //inventory Needed!
        public static void rageOnAndOff(){
            if (rage){
                rage = false;
                System.out.println("Rage deactivated");
                rageRestTimeCalculator();
            } else if (rageLeft > 0 /* && ....noHeavyArmour........*/) {
                rage = true;
                rageLeft--;
                rageRestTimeCounter = 0;
                System.out.println("Rage activated");
            } else {
                System.out.println("You don't have any Rage left, wait until it recharge");
            }
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
}
