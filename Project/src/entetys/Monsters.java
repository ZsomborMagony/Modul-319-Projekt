package entetys;

import mechanics.Dice;

public class Monsters {
    public int strength;
    public int dexterity;
    public int constitution;
    public int intelligence;
    public int wisdom;
    public int charisma;
    public int hp;
    public int armorClass;
    public String attack;


    public Monsters(int hp, int armorClass, int strength, int dexterity, int constitution, int intelligence
            , int wisdom, int charisma, String attack) {

        this.armorClass = armorClass;
        this.hp = hp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.attack = attack;
    }

    public static Monsters mimic = new Monsters(58, 12, 20, 13, 17
            , 2, 14, 7, "1d8+8");

}
