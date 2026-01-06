

import entetys.Monsters;
import entetys.Player;
import entetys.Weapons;
import entetys.classes.Barbarian;
import mechanics.Attack;

public class Main {
    public static void main(String[] args) {
        //MakeCharacter.makeCharakter();
        System.out.println(Monsters.mimic);

//        Monster monsters = [Monsters dragon=new Monsters(),'b', 'c'. ];
//
//        Monster monsters[] = new Monster[10];
//
//        for(int i = 0; i < monsters.length; i++) {
//            monsters[i] =
//        }

        System.out.println(Weapons.club.name);
        Barbarian.BarbarianRage.lvlRage();
        Barbarian.BarbarianRage.rageActivation();
        System.out.println("rageMax: " + Barbarian.rageMax);
        System.out.println("rageLeft:" + Barbarian.rageLeft);
        System.out.println("rageRestTimeCounter:" + Barbarian.rageRestTimeCounter);
        System.out.println();

        Attack Player1 = new Attack();
        Player1.fight(0);

        System.out.println("rageRestTimeCounter:" + Barbarian.rageRestTimeCounter);
        System.out.println("round:" + Player1.round);
        System.out.println("rageLeft:" + Barbarian.rageLeft);


    }
}