package entetys.classes;

import entetys.Player;

public class Cleric {
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

    int cantrips() {
        switch (Player.PlayerStats.level) {
            case 1, 2, 3 -> {
                return 3;
            }
            case 4, 5, 6, 7, 8, 9 -> {
                return 4;
            }
            default -> {
                return 5;
            }
        }
    }

    int preparedSpells() {
        switch (Player.PlayerStats.level) {
            case 1 -> {
                return 4;
            }
            case 2 -> {
                return 5;
            }
            case 3 -> {
                return 6;
            }
            case 4 -> {
                return 7;
            }
            case 5 -> {
                return 9;
            }
            case 6 -> {
                return 10;
            }
            case 7 -> {
                return 11;
            }
            case 8 -> {
                return 12;
            }
            case 9 -> {
                return 14;
            }
            case 10 -> {
                return 15;
            }
            case 11, 12 -> {
                return 16;
            }
            case 13, 14 -> {
                return 17;
            }
            case 15, 16 -> {
                return 18;
            }
            case 17 -> {
                return 19;
            }
            case 18 -> {
                return 20;
            }
            case 19 -> {
                return 21;
            }
            case 20 -> {
                return 22;
            }
            default -> {
                return 0;
            }

        }
    }

    int spellSlots(){
        switch (Player.PlayerStats.level){
           case
        }
    }
}

