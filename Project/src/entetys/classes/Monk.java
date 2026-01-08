package entetys.classes;

import entetys.Player;
import mechanics.Dice;

public class Monk {

    int proficiencyBonus() {
        switch (Player.PlayerStats.level) {
            case 1, 2, 3, 4 -> {
                return 2;
            }
            case 5, 6, 7, 8 -> {
                return 3;
            }
            case 9, 10, 11, 12 -> {
                return 4;
            }
            case 13, 14, 15, 16 -> {
                return 5;
            }
            case 17, 18, 19, 20 -> {
                return 6;
            }
            default -> {
                return 0;
            }
        }
    }

    static int levelToAbilitys() {
        switch (Player.PlayerStats.level) {
            case 1 -> {
                return 0;
            }
            case 2 -> {
                return 1;
            }
            case 3, 4 -> {
                return 2;
            }
            default -> {
                return 3;
            }

        }

    }


    //ability options
//    static String abilitys[] = {
//
//            "Martial Arts, unarmored Defense",
//            "Martial Arts, unarmored Defense, Regen ki Points, Flurry of Blows",
//            "Martial Arts, unarmored Defense, Regen ki Points, Flurry of Blows, Deflect Attack",
//            "Martial Arts, unarmored Defense, Regen ki Points, Flurry of Blows, Deflect Attack, extra Attack",
//
//    };
    static String[] abilitys = {
            "Martial Arts",
            "unarmored Defense",
            "Regen ki Points",
            "Flurry of Blows",
            "Deflect Attack",
            "extra Attack"
    };

    public static void attackAbilitys() {
        if (levelToAbilitys() == 0) {

            for (int i = 0; i <= 1; i++) {
                if (i != 1 && i != 2) {
                    System.out.println(abilitys[i] + " ");
                }
            }
        } else if (levelToAbilitys() == 1) {

            for (int i = 0; i <= 3; i++) {
                if (i != 1 && i != 2) {
                    System.out.println(abilitys[i] + " ");
                }
            }
        } else if (levelToAbilitys() == 2) {

            for (int i = 0; i <= 4; i++) {
                if (i != 1 && i != 2) {
                    System.out.println(abilitys[i] + " ");
                }
            }
        } else if (levelToAbilitys() == 3) {

            for (int i = 0; i <= 5; i++) {
                if (i != 1 && i != 2) {
                    System.out.println(abilitys[i] + " ");
                }
            }
        } else {
            System.out.println("invalid level");
        }

    }

    public static void abilityOptions() {
        if (levelToAbilitys() == 0) {

            for (int i = 0; i <= 1; i++) {
                System.out.println(abilitys[i] + " ");
            }
        } else if (levelToAbilitys() == 1) {

            for (int i = 0; i <= 3; i++) {
                System.out.println(abilitys[i] + " ");
            }
        } else if (levelToAbilitys() == 2) {

            for (int i = 0; i <= 4; i++) {
                System.out.println(abilitys[i] + " ");
            }
        } else if (levelToAbilitys() == 3) {

            for (int i = 0; i <= 5; i++) {
                System.out.println(abilitys[i] + " ");
            }
        } else {
            System.out.println("invalid level");
        }
    }

    /*
            lv1
    
           martialArts
            level 1-5 = 1d6
            level 5-11 = 1d8
            level 11-17 = 1d10
            level 17-21 = 1d12
    
           applies if no weapon is equipped or a simple weapon or a light martial weapon
           uses dex modifier instead of strength action
    
    */
    public static int martialArts() {
        int level = Player.PlayerStats.level;
        int attack = 0;
        switch (level) {
            case 1, 2, 3, 4 -> attack = Dice.d(6) +
                    Player.PlayerStats.statModifiers("dexterity");

            case 5, 6, 7, 8, 9, 10 -> attack = Dice.d(8) +
                    Player.PlayerStats.statModifiers("dexterity");

            case 11, 12, 13, 14, 15, 16 -> attack = Dice.d(10) +
                    Player.PlayerStats.statModifiers("dexterity");

            case 17, 18, 19, 20 -> attack = Dice.d(12) +
                    Player.PlayerStats.statModifiers("dexterity");
        }
        return attack;
    }

    /*
        unarmored defense if no armor or shield base armor + dex modifier
    */
    public static void unarmoredDefense() {


        if (Player.PlayerStats.playerInventory.getEquipmentValue(1)!=null) {
            Player.PlayerStats.armorClass = 10 + Player.PlayerStats.statModifiers("dexterity")
                    + Player.PlayerStats.statModifiers("wisdom");
        }


    }


//lv2

    /*
    ki points
     */
    public static int kiPoints = 0;

    public static int regenKiPoints() {
        int level = Player.PlayerStats.level;

        if (Player.PlayerStats.rest == true) {
            switch (level) {
                case 1 -> kiPoints = 0;
                default -> {
                    kiPoints = level;
                    Player.PlayerStats.rest = false;
                }
            }
        }
        return kiPoints;
    }

    //Flurry of Blows -1ki Point for 2 unarmed strikes as a bonus action
    public static int flurryOfBlows() {
        int level = Player.PlayerStats.level;
        int attack = 0;
        if (kiPoints > 0) {
            if (level >= 10) {

                attack = martialArts() + martialArts() + martialArts();
                Monk.kiPoints -= 1;
            } else {
                attack = martialArts() + martialArts();
                Monk.kiPoints -= 1;
            }
        } else {
            System.out.println("you don't have enough Ki Points");
        }
        return attack;
    }

    //uncanny metabolism regain ki points once per long rest (martial arts die)
//regain hit points (level + martial arts roll)
    public void uncannyMetabolism() {
        int martialArtsMinusDexterity = martialArts() - Player.PlayerStats.statModifiers("dexterity");
        int level = Player.PlayerStats.level;
        kiPoints += martialArtsMinusDexterity;
        Player.PlayerStats.hp += level + martialArtsMinusDexterity;
    }


//lv3

    //Deflect Attack
    public static boolean reducedDamage = true;

    public static int deflectAttack(int damage, int monsterDex) {
        //int attackOrDamage[2];
        int level = Player.PlayerStats.level;

        int playerRoll = Dice.d(10) + Player.PlayerStats.statModifiers("dexterity") + level;
        if (playerRoll < damage) {
            damage -= playerRoll;
            reducedDamage = true;
        } else if (kiPoints > 0 && monsterDex <= 8 + Player.PlayerStats.statModifiers("wisdom")) {
            Monk.kiPoints -= 1;
            damage = martialArts() - Player.PlayerStats.statModifiers("dexterity") + martialArts();
            reducedDamage = false;
        }
        return damage;


    }

// lv5

    //extra attack
    public int extraAttack(int attack) {
        attack += attack;
        return attack;
    }

//stunning strike?

    //lv 20
//body and mind
    public void bodyAndMind() {
        if (Player.PlayerStats.playerDexterity < 20) {
            Player.PlayerStats.playerDexterity += 4;
        }
        if (Player.PlayerStats.playerWisdom < 20) {
            Player.PlayerStats.playerWisdom += 4;
        }
    }


}

