package mechanics;

import entetys.AllClasses;
import entetys.Monsters;
import entetys.Player;
import entetys.classes.Barbarian;
import entetys.classes.Monk;

//          attack example
//        Attack.enemyHp=Monsters.mimic.hp;
//        Attack.playerAttack(Dice.d(4));
public class Attack {
    public static int enemyHp = 0;

    public static void playerAttack(int attackRoll) {
        enemyHp -= attackRoll;
        System.out.println("you dealt " + attackRoll + " damage");



    }

    public static void monsterAttack(int attackRoll) {
        Player.PlayerStats.hp -= attackRoll;
        System.out.println("you took " + attackRoll + " damage");
    }
//       Attack.enemyHp=Monsters.mimic.hp;
//       Attack.deflectAttackMonk(AllClasses.monk.deflectAttack(10,15,5,2));

    public static void deflectAttackMonk(int damage) {

        if (Monk.reducedDamage == true) {
            Player.PlayerStats.hp -= damage;
            System.out.println("you took " + damage + " damage");
        } else {
            enemyHp -= damage;
            System.out.println("you dealt " + damage + " damage");
        }
    }
}

