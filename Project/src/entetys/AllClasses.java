package entetys;

import mechanics.Dice;

public class AllClasses {

    public static String[] classes = {

            "Monk",
            "Warlock",
            "Barbarian",
            "Cleric"
    };

    public class monk {

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
        public static int martialArts(int level) {
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
        public static int unarmoredDefense(boolean shieldOrArmor) {
            int armorClass = 0;
            if (shieldOrArmor == false) {
                armorClass = 10 + Player.PlayerStats.statModifiers("dexterity")
                        + Player.PlayerStats.statModifiers("wisdom");
            }
            return armorClass;
        }


        //lv2

        /*
        ki points
         */
        public static int kiPoints = 0;

        public static int regenKiPoints(int level, boolean rest) {


            if (rest == true) {
                switch (level) {
                    case 1 -> kiPoints = 0;
                    default -> kiPoints = level;
                }
            }
            return kiPoints;
        }

        //Flurry of Blows -1ki Point for 2 unarmed strikes as a bonus action
        public static int flurryOfBlows(int level, int kiPoints) {
            int attack = 0;
            if (kiPoints > 0) {
                attack = martialArts(level) + martialArts(level);
                monk.kiPoints -= 1;
            } else {
                System.out.println("you don't have enough Ki Points");
            }
            return attack;
        }

        //uncanny metabolism regain ki points once per long rest (martial arts die)
        //regain hit points (level + martial arts roll)
        public static void uncannyMetabolism(int level, int martialArtsMinusDexterity) {
            kiPoints += martialArtsMinusDexterity;
            Player.PlayerStats.hp += level + martialArtsMinusDexterity;
        }


        //lv3

        //Deflect Attack
        public static boolean reducedDamage = true;

        public static int deflectAttack(int level, int damage, int kiPoints, int monsterDex) {
            //int attackOrDamage[2];

            int playerRoll = Dice.d(10) + Player.PlayerStats.statModifiers("dexterity") + level;
            if (playerRoll < damage) {
                damage -= playerRoll;
                reducedDamage = true;
            } else if (kiPoints > 0 && monsterDex <= 8 + Player.PlayerStats.statModifiers("wisdom")) {
                monk.kiPoints -= 1;
                damage = martialArts(level) - Player.PlayerStats.statModifiers("dexterity") + martialArts(level);
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

        //lv 6


    }
}




