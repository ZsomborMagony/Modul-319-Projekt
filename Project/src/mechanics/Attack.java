package mechanics;

import entetys.AllClasses;
import entetys.Monsters;
import entetys.Player;
import entetys.classes.Monk;

//          attack example
//        Attack.enemyHp=Monsters.mimic.hp;
//        Attack.enemyName=Monsters.mimic.name;
//        Attack.playerAttack(Dice.d(4));
public class Attack {
    public static Monsters[] monsterList = {
            Monsters.mimic,//0
            Monsters.animated_armor,//1
            Monsters.twig_blight,//2
            Monsters.lizardfolk,//3
            Monsters.bugbear,//4
            Monsters.bugbear_chief,//5
            Monsters.Kuo_Toa,//6
            Monsters.chuul,//7
            Monsters.cloaker,//8
            Monsters.wyvern,//9
            Monsters.spined_devil//10
    };
    public static int enemyHp = 0;
    static String enemyName = "";
    static int xp=0;
    public static void fight(int i) {
        enemyHp = monsterList[i].hp;
        enemyName = monsterList[i].name;


    }


    public void playerAttack(int attackRoll) {
        this.enemyHp -= attackRoll;
        if (this.enemyHp > 0) {
            System.out.println("you dealt " + attackRoll + " damage");
        } else {
            System.out.println("you defetet " +enemyName+ " you gained "+xp);
        }

    }

    public void monsterAttack(int attackRoll) {
        Player.PlayerStats.hp -= attackRoll;
        System.out.println("you took " + attackRoll + " damage");
    }
//       Attack.enemyHp=Monsters.mimic.hp;
//       Attack.deflectAttackMonk(AllClasses.monk.deflectAttack(10,15,5,2));

    public void deflectAttackMonk(int damage) {

        if (Monk.reducedDamage == true) {
            Player.PlayerStats.hp -= damage;
            System.out.println("you took " + damage + " damage");
        } else {
            this.enemyHp -= damage;
            System.out.println("you dealt " + damage + " damage");
        }
    }
}

