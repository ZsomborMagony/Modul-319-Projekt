package entetys.classes;

import entetys.Player;
import mechanics.Attack;
import mechanics.Dice;

import java.util.Scanner;

public class Cleric {
    public static int[] spellSlots = {0, 0, 0, 0, 0, 0, 0, 0, 0};

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

    int regenCantrips() {
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

    int regenPreparedSpells() {
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

    public static void regenSpellSlots() {
        switch (Player.PlayerStats.level) {
            case 1 -> spellSlots[0] = 2;
            case 2 -> spellSlots[0] = 3;
            case 3 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 2;
            }
            case 4 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
            }
            case 5 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 2;
            }
            case 6 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
            }
            case 7 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 1;
            }
            case 8 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 2;
            }
            case 9 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 1;
            }
            case 10 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 2;
            }
            case 11, 12 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 2;
                spellSlots[5] = 1;
            }
            case 13, 14 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 2;
                spellSlots[5] = 1;
                spellSlots[6] = 1;
            }
            case 15, 16 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 2;
                spellSlots[5] = 1;
                spellSlots[6] = 1;
                spellSlots[7] = 1;
            }
            case 17 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 2;
                spellSlots[5] = 1;
                spellSlots[6] = 1;
                spellSlots[7] = 1;
                spellSlots[8] = 1;
            }
            case 18 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 1;
                spellSlots[6] = 1;
                spellSlots[7] = 1;
                spellSlots[8] = 1;
            }
            case 19 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 2;
                spellSlots[6] = 1;
                spellSlots[7] = 1;
                spellSlots[8] = 1;
            }
            case 20 -> {
                spellSlots[0] = 4;
                spellSlots[1] = 3;
                spellSlots[2] = 3;
                spellSlots[3] = 3;
                spellSlots[4] = 3;
                spellSlots[5] = 2;
                spellSlots[6] = 2;
                spellSlots[7] = 1;
                spellSlots[8] = 1;
            }
        }
    }

    int regenDivinityCharges() {
        switch (Player.PlayerStats.level) {
            case 1 -> {
                return 0;
            }
            case 2, 3, 4, 5 -> {
                return 2;
            }
            case 18, 19, 20 -> {
                return 4;
            }
            default -> {
                return 3;
            }
        }
    }
//lv2
    void divineSpark() {
        Scanner userInput = new Scanner(System.in);
        int temp;
        do {
            System.out.println("(0) Heal");
            System.out.println("(1) Damage");
            temp = userInput.nextInt();
        } while (temp != 0 || temp != 1);
        int roll;
        if (Player.PlayerStats.level < 7) {
            roll = Dice.d(8);
        } else if (Player.PlayerStats.level < 13) {
            roll = Dice.d(8) + Dice.d(8);
        } else if (Player.PlayerStats.level < 18) {
            roll = Dice.d(8) + Dice.d(8) + Dice.d(8);
        } else {
            roll = Dice.d(8) + Dice.d(8) + Dice.d(8) + Dice.d(8);
        }
        if (temp == 0) {
            if (roll < (Player.PlayerStats.maxHp - Player.PlayerStats.hp)) {
                Player.PlayerStats.hp += roll;
            } else {
                Player.PlayerStats.hp = Player.PlayerStats.maxHp;
            }
        } else {
            Attack.enemyHp -= roll;
        }
    }
    //7
    //adds 1d8 on weapon attack
    int divineStrike(int damage){

        damage+=Dice.d(8);
        return damage;
    }

}

