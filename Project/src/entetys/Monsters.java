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
    public String name;
    public int xp;


    public Monsters(String name, int hp, int armorClass, int strength, int dexterity, int constitution, int intelligence
            , int wisdom, int charisma, String attack) {
        this.name = name;
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


    public static Monsters mimic = new Monsters("mimic", 58, 12, 20, 13, 17
            , 2, 14, 7, "1d8+8");
    public static Monsters animated_armor = new Monsters("animated_armor", 33, 18, 14, 11, 13,
            1, 3, 1, "6d8+6");
    public static Monsters twig_blight = new Monsters("twig_blight", 4, 13, 6, 13, 12,
            4, 8, 3, "1d6+1");
    //gut für das Dungeon 4. 4/10 Dungeon.
    public static Monsters lizardfolk = new Monsters("lizardfolk", 22, 15, 15, 10, 13,
            7, 12, 7, "4d8+4");
    //gut für das Dungeon 4. 4/10 Dungeon
    public static Monsters bugbear = new Monsters("bugbear", 27, 16, 15, 14, 13,
            8, 11, 9, "5d8+5");
    //gut für das Dungeon 3. 3/10 Dungeon.
    public static Monsters bugbear_chief = new Monsters("bugbear_chief", 65, 14, 17, 14, 14,
            11, 12, 11, "2d8+8");
    //The Bugbear Chief ist eine gute boss Monster für das 3. Dungeon. 3/10 Dungeons
    public static Monsters Kuo_Toa = new Monsters("Kuo_Toa", 18, 13, 13, 10, 11,
            11, 10, 8, "4d8");
    //Gut für Gegner in der Dungeon 6.
    public static Monsters chuul = new Monsters("chuul", 93, 16, 19, 10, 16,
            5, 11, 5, "11d10+33");
    //Boss Monster in der Dungeon 6. 6/10 Dungeon
    public static Monsters cloaker = new Monsters("cloaker", 78, 14, 17, 15, 12,
            13, 12, 14, "12d10+12");
    //gut als elite monsters in der dungeon 7.
    public static Monsters wyvern = new Monsters("wyvern", 110, 13, 19, 10, 16,
            5, 12, 6, "2d8+4");
    //Final Boss in der Dungeon 10. 10/10 Dungeons
    public static Monsters spined_devil = new Monsters("spined_devil", 22, 13, 10, 15, 12,
            11, 14, 8, "2d4");
    // Monster in der Dungeon 7. 7/10
}
