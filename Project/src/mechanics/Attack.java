package mechanics;

import entetys.Monsters;
import entetys.Player;
import entetys.classes.Monk;

import java.util.Scanner;

//          attack example
//          Attack test = new Attack();
//          test.fight();
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
    static int enemyXp = 0;
    int monsterNumber;
    public long round = 0;
    int enemyAC = 0;


    public void fight(int monsterNumber) {

        enemyHp = monsterList[monsterNumber].hp;
        enemyName = monsterList[monsterNumber].name;
        enemyXp = monsterList[monsterNumber].xp;
        enemyAC = monsterList[monsterNumber].armorClass;
        this.monsterNumber = monsterNumber;
        while (enemyHp > 0 && Player.PlayerStats.hp > 0) {

            System.out.println("enemy hp: " + enemyHp);
            System.out.println("your hp: " + Player.PlayerStats.hp);
            System.out.println("witch attack do you chose");
            playerAttack(selectAttacks());
            if (enemyHp > 0) {
                System.out.println("the Monster attacks you");
                monsterAttack(diceSelector(monsterNumber));
            }
            round++;
        }
        Leveling.addExp();
    }

    public static int diceSelector(int monsterNumber) {//function from monster 1d6+5 to Dice.d(6) or from 2d4 to (Dice.d(4)+Dice.d(4))
        int amountOfDice;
        int diceSize = 0;
        int attack = 0;
        if (monsterList[monsterNumber].attack.substring(1, 2).equalsIgnoreCase("d")) {
            amountOfDice = Integer.parseInt(monsterList[monsterNumber].attack.substring(0, 1));
            if (monsterList[monsterNumber].attack.substring(3, 4).equals("+")) {
                diceSize = Integer.parseInt(monsterList[monsterNumber].attack.substring(2, 3));
                attack = Integer.parseInt(monsterList[monsterNumber].attack.substring(4, 5));
            }
        } else {
            amountOfDice = Integer.parseInt(monsterList[monsterNumber].attack.substring(0, 2));
            if (monsterList[monsterNumber].attack.substring(4, 5).equals("+")) {
                diceSize = Integer.parseInt(monsterList[monsterNumber].attack.substring(3, 4));
                attack = Integer.parseInt(monsterList[monsterNumber].attack.substring(5, 6));
            } else if (monsterList[monsterNumber].attack.substring(5, 6).equals("+")) {
                diceSize = Integer.parseInt(monsterList[monsterNumber].attack.substring(3, 5));
                attack = Integer.parseInt(monsterList[monsterNumber].attack.substring(6, 8));

            }
        }
        while (amountOfDice > 0) {
            amountOfDice--;
            attack += Dice.d(diceSize);
        }
        return attack;
    }

    private int selectAttacks() {

        Scanner userInput = new Scanner(System.in);
        int attackChoice = 0;
        int attack = 0;

        if (Player.playerChosenClass == 0) {   //Monk

            Monk.attackAbilitys();
            System.out.println("Weapon attack");
            System.out.println("for first option input 0.");
            attack = userInput.nextInt();
            switch (attackChoice) {
                case 3 -> attack = Monk.martialArts();
                case 1 -> attack = Monk.flurryOfBlows();
                case 2 -> deflectAttackMonk(monsterNumber);
                case 0 -> attack = weaponDieSelector(Player.PlayerStats.playerInventory.
                        getDamageRangeFromEquippedSlot(Player.PlayerStats.playerInventory.getEquipmentValue(0)));
            }

        } else if (Player.playerChosenClass == 1) {     //Warlock

        } else if (Player.playerChosenClass == 2) {     //Barbarian

        } else if (Player.playerChosenClass == 3) {     //Cleric

        }
        return attack;
    }

    int weaponDieSelector(String damageRange) {
        int damage = 0;
        int amountOfDice = 0;
        int die = 0;
        if (damageRange.substring(1, 2).equals("d")) {
            amountOfDice = Integer.parseInt(damageRange.substring(0, 1));
        } else {
            amountOfDice = Integer.parseInt(damageRange.substring(0, 2));
        }
        if (!damageRange.substring(2, 3).equals("d")) {

            if (damageRange.substring(3, 4).isEmpty()) {
                die = Integer.parseInt(damageRange.substring(2, 3));
            } else {
                die = Integer.parseInt(damageRange.substring(2, 4));
            }
        }
        for (int i = 0; i < amountOfDice; i++) {
            damage += Dice.d(die);
        }
        return damage;
    }

    public void playerAttack(int attackRoll) {

        int hitOrMiss = Dice.d(20);
        switch (Player.playerChosenClass) {
            case 0 -> {
                hitOrMiss += Player.PlayerStats.statModifiers("dexterity");
            }
            case 1 -> {
                hitOrMiss += Player.PlayerStats.statModifiers("charisma");
            }
            case 2 -> {
                hitOrMiss += Player.PlayerStats.statModifiers("strength");
            }
            case 3 -> {
                hitOrMiss += Player.PlayerStats.statModifiers("wisdom");
            }
        }

        if (hitOrMiss >= monsterList[monsterNumber].armorClass) {
            this.enemyHp -= attackRoll;

            if (this.enemyHp > 0) {
                System.out.println("you dealt " + attackRoll + " damage");
            } else {
                System.out.println("you defeated " + enemyName + " you gained " + enemyXp + " xp");
            }
        } else {
            System.out.println("you missed");
        }
    }

    public void monsterAttack(int attackRoll) {
        int hitOrMiss = Dice.d(20);
        if (hitOrMiss >= Player.PlayerStats.armorClass) {
            Player.PlayerStats.hp -= attackRoll;
            System.out.println("you took " + attackRoll + " damage");


            if (Player.PlayerStats.hp < 0) {
                System.out.println("you died");
            }
        }
    }

    public void deflectAttackMonk(int monsterNumber) {
        int damage = Monk.deflectAttack(diceSelector(monsterNumber), monsterList[monsterNumber].dexterity);
        if (Monk.reducedDamage == true) {
            Player.PlayerStats.hp -= damage;
            System.out.println("you took " + damage + " damage");
        } else {
            this.enemyHp -= damage;
            System.out.println("you dealt " + damage + " damage");
        }
    }
}

