import entetys.AllClasses;
import entetys.Player;
import mechanics.Dice;
import mechanics.MakeCharacter;

import java.util.Scanner;

import entetys.Weapons;

public class Main {
    public static void main(String[] args) {
        //MakeCharacter.makeCharakter();
        AllClasses.monk.regenKiPoints(2,true);
        System.out.println(AllClasses.monk.deflectAttack(2,3,AllClasses.monk.kiPoints));
    }
}