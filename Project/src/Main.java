import mechanics.MakeCharacter;

import java.util.Scanner;

import entetys.Weapons;

public class Main {
    public static void main(String[] args) {
       // MakeCharacter.makeCharakter();

        System.out.println("Name: "+Weapons.Club.name);
        System.out.println( "Damage: "+ Weapons.Club.damageRange);
        System.out.println("Cost: "+Weapons.Club.cost);
        System.out.println("Weight: "+Weapons.Club.weight);
    }
}