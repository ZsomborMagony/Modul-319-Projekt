package mechanics;

import entetys.Player;

public class Leveling {
    public static void addExp(int experience) {
        experience += experience;
        if (experience < 300) {
            Player.PlayerStats.level = 1;
        } else if (experience < 900) {
            Player.PlayerStats.level = 2;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 2_700) {
            Player.PlayerStats.level = 3;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 6_500) {
            Player.PlayerStats.level = 4;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 14_000) {
            Player.PlayerStats.level = 5;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 23_000) {
            Player.PlayerStats.level = 6;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 34_000) {
            Player.PlayerStats.level = 7;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 48_000) {
            Player.PlayerStats.level = 8;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 64_000) {
            Player.PlayerStats.level = 9;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 85_000) {
            Player.PlayerStats.level = 10;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 100_000) {
            Player.PlayerStats.level = 11;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 120_000) {
            Player.PlayerStats.level = 12;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 140_000) {
            Player.PlayerStats.level = 13;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 165_000) {
            Player.PlayerStats.level = 14;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 195_000) {
            Player.PlayerStats.level = 15;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 225_000) {
            Player.PlayerStats.level = 16;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 265_000) {
            Player.PlayerStats.level = 17;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 305_000) {
            Player.PlayerStats.level = 18;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (experience < 355_000) {
            Player.PlayerStats.level = 19;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else {
            Player.PlayerStats.level = 20;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        }


    }
}
