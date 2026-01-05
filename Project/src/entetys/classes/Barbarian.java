package entetys.classes;

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

    Rage Effects:-
    Ends on next turn
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

    //Primal Champion
    /*
    strength = +4 and constitution = +4
     */

    public boolean startingOptions;
    public boolean rage;
    public short rageLeft = 2;
    public short rageRestTimeCounter;

    public Barbarian(){

    };

    // !!! How can save the inventory inforamtion?
    public boolean isStartingOptions(){
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
        } else if (user==2) {
            startingOptions = false; //Option b
        } else {
            System.out.println("Invalid Pick");
        }

        return startingOptions;
    };

    public void rageActivation(){
        rage = false;
//        if (rageLeft > 0 && ....armour........){
//            rage = true;
//            rageLeft -= 1;
//            System.out.println("Rage activated");
//        } else {
//            System.out.println("You don't have any Rage left, wait until it recharge");
//        }
    };

    public void rageRestTimeCalculator(short rageRestTimeCounter){
        this.rageRestTimeCounter = rageRestTimeCounter;
    };
}
