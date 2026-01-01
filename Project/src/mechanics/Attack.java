package mechanics;

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


    public void fight(int monsterNumber) {
        Scanner userInput = new Scanner(System.in);
        enemyHp = monsterList[monsterNumber].hp;
        enemyName = monsterList[monsterNumber].name;
        enemyXp = monsterList[monsterNumber].xp;
        int attackChoice;
        while (enemyHp > 0) {

            System.out.println("enemy hp: " + enemyHp);
            System.out.println("witch attack do you chose");
            attackChoice = userInput.nextInt();
            //array of possible attacks
            // playerAttack();

            monsterAttack(diceSelector(monsterNumber));//function from monster 1d6+5 to Dice.d(6) or from 2d4 to (Dice.d(4)+Dice.d(4))

        }
    }

    public static int diceSelector(int monsterNumber) {
        int amountOfDice;
        int diceSize;
        int attack = 0;
        if (monsterList[monsterNumber].attack.substring(1, 2).equalsIgnoreCase("d")) {
            amountOfDice = Integer.parseInt(monsterList[monsterNumber].attack.substring(0, 1));
            if (monsterList[monsterNumber].attack.substring(3, 4).equalsIgnoreCase("+")||
            monsterList[monsterNumber].attack.substring(3,4).isEmpty()) {
               if (monsterList[monsterNumber].attack.substring(4,5).equalsIgnoreCase("+"))
                diceSize = Integer.parseInt(monsterList[monsterNumber].attack.substring(2, 3));
            } else {
                diceSize = Integer.parseInt(monsterList[monsterNumber].attack.substring(2, 4));
            }
        } else {
            amountOfDice = Integer.parseInt(monsterList[monsterNumber].attack.substring(0, 2));
            if (!monsterList[monsterNumber].attack.substring(3, 4).isEmpty()) {
                diceSize = Integer.parseInt(monsterList[monsterNumber].attack.substring(2, 3));
            } else {
                diceSize = Integer.parseInt(monsterList[monsterNumber].attack.substring(2, 4));
            }
        }
        while (amountOfDice > 0) {
            amountOfDice--;
            attack += Dice.d(diceSize);
        }
        return attack;
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

