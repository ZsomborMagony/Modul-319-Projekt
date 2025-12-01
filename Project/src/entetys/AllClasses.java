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
        public static int unarmoredDefense(String shieldOrArmor) {
            int armorClass = 0;
            if (shieldOrArmor.equalsIgnoreCase("n")) {
                armorClass = 10 + Player.PlayerStats.statModifiers("dexterity")
                        + Player.PlayerStats.statModifiers("wisdom");
            }
            return armorClass;
        }

        //increased movement if not wearing armor or have shield equipped
        public static int unarmoredMovement(String shieldOrArmor, int level) {

            int movement = 0;
            if (shieldOrArmor.equalsIgnoreCase("n")) {
                switch (level) {
                    case 1 -> movement += 0;
                    case 2, 3, 4, 5 -> movement += 10;
                    case 6, 7, 8, 9 -> movement += 15;
                    case 10, 11, 12, 13 -> movement += 20;
                    case 14, 15, 16, 17 -> movement += 25;
                    case 18, 19, 20 -> movement += 30;
                }
            }

            return movement;
        }

        /*
        ki points
         */
        public static int kiPoints = 0;

        public static int regenKiPoints(int level, String rest) {


            if (rest.equalsIgnoreCase("y")) {
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
                monk.kiPoints = kiPoints - 1;
            }else {
                System.out.println("you don't have enough Ki Points");
            }
            return attack;
        }
        //
    }

}




