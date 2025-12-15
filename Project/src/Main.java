

import entetys.Monsters;
import entetys.Player;
import entetys.Weapons;
import entetys.classes.Cleric;
import entetys.classes.Monk;
import mechanics.Attack;
import mechanics.Dice;

public class Main {
    public static void main(String[] args) {
        //MakeCharacter.makeCharakter();
        Monk.regenKiPoints(true);
        Attack.monsterAttack(Dice.d(8)+Dice.d(8)+3);
        System.out.println(Player.PlayerStats.hp);

    }
}