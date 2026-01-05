package mechanics;

import entetys.Player;

public class Leveling {
    public static void addExp() {

        if (Player.PlayerStats.xp < 300) {
            Player.PlayerStats.level = 1;
        } else if (Player.PlayerStats.xp < 900) {
            Player.PlayerStats.level = 2;
        } else if (Player.PlayerStats.xp < 2_700) {
            Player.PlayerStats.level = 3;
        } else if (Player.PlayerStats.xp < 6_500) {
            Player.PlayerStats.level = 4;
        } else if (Player.PlayerStats.xp < 14_000) {
            Player.PlayerStats.level = 5;
        } else if (Player.PlayerStats.xp < 23_000) {
            Player.PlayerStats.level = 6;
        } else if (Player.PlayerStats.xp < 34_000) {
            Player.PlayerStats.level = 7;
        } else if (Player.PlayerStats.xp < 48_000) {
            Player.PlayerStats.level = 8;
        } else if (Player.PlayerStats.xp < 64_000) {
            Player.PlayerStats.level = 9;
        } else if (Player.PlayerStats.xp < 85_000) {
            Player.PlayerStats.level = 10;
        } else if (Player.PlayerStats.xp < 100_000) {
            Player.PlayerStats.level = 11;
        } else if (Player.PlayerStats.xp < 120_000) {
            Player.PlayerStats.level = 12;
        } else if (Player.PlayerStats.xp < 140_000) {
            Player.PlayerStats.level = 13;
        } else if (Player.PlayerStats.xp < 165_000) {
            Player.PlayerStats.level = 14;
        } else if (Player.PlayerStats.xp < 195_000) {
            Player.PlayerStats.level = 15;
        } else if (Player.PlayerStats.xp < 225_000) {
            Player.PlayerStats.level = 16;
        } else if (Player.PlayerStats.xp < 265_000) {
            Player.PlayerStats.level = 17;
        } else if (Player.PlayerStats.xp < 305_000) {
            Player.PlayerStats.level = 18;
        } else if (Player.PlayerStats.xp < 355_000) {
            Player.PlayerStats.level = 19;
        } else {
            Player.PlayerStats.level = 20;
        }


    }
}
