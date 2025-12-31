package mechanics;

import entetys.Player;

public class Leveling {
    public static void addExp() {

        if (Player.PlayerStats.xp < 300) {
            Player.PlayerStats.level = 1;
        } else if (Player.PlayerStats.xp < 900) {
            Player.PlayerStats.level = 2;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 2_700) {
            Player.PlayerStats.level = 3;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 6_500) {
            Player.PlayerStats.level = 4;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 14_000) {
            Player.PlayerStats.level = 5;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 23_000) {
            Player.PlayerStats.level = 6;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 34_000) {
            Player.PlayerStats.level = 7;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 48_000) {
            Player.PlayerStats.level = 8;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 64_000) {
            Player.PlayerStats.level = 9;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 85_000) {
            Player.PlayerStats.level = 10;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 100_000) {
            Player.PlayerStats.level = 11;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 120_000) {
            Player.PlayerStats.level = 12;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 140_000) {
            Player.PlayerStats.level = 13;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 165_000) {
            Player.PlayerStats.level = 14;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 195_000) {
            Player.PlayerStats.level = 15;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 225_000) {
            Player.PlayerStats.level = 16;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 265_000) {
            Player.PlayerStats.level = 17;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 305_000) {
            Player.PlayerStats.level = 18;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else if (Player.PlayerStats.xp < 355_000) {
            Player.PlayerStats.level = 19;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        } else {
            Player.PlayerStats.level = 20;
            System.out.println("Congrats your now level " + Player.PlayerStats.level);
        }


    }
}
