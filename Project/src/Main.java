import entetys.Monsters;
import entetys.Weapons;
import entetys.classes.Barbarian;
import entetys.classes.Monk;
import mechanics.Attack;
import mechanics.Dice;
import mechanics.Inventory;
import mechanics.MakeCharacter;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //MakeCharacter.makeCharakter();

        Attack Player1 = new Attack();
        Player1.fight(0);


    }
}