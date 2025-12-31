package mechanics;

import entetys.AllClasses;
import entetys.Monsters;
import entetys.Player;
import entetys.classes.Monk;

import java.util.Scanner;

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
    static int enemyXp;
    static int xp = 0;


    public void fight(int i) {
        Scanner userInput = new Scanner(System.in);
        enemyHp = monsterList[i].hp;
        enemyName = monsterList[i].name;
        enemyXp = monsterList[i].xp;
        int attackChoice;
        while (enemyHp>0){

                System.out.println("enemy hp: " + enemyHp);
                System.out.println("witch attack do you chose");
                attackChoice = userInput.nextInt();
                //array of possible attacks
                playerAttack();

                monsterAttack();//function from monster 1d6 to Dice.d(6) or from 2d4 to (Dice.d(4)+Dice.d(4))

        }
    }

    private void selectAttacks() {
        if (Player.playerChosenClass == 0) {   //Monk


        } else if (Player.playerChosenClass == 1) {     //Warlock

        } else if (Player.playerChosenClass == 2) {     //Barbarian

        } else if (Player.playerChosenClass == 3) {     //Cleric

        }
    }

    public void playerAttack(int attackRoll) {
        this.enemyHp -= attackRoll;
        if (this.enemyHp > 0) {
            System.out.println("you dealt " + attackRoll + " damage");
        } else {
            System.out.println("you defetet " + enemyName + " you gained " + xp);
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

