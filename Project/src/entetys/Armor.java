package entetys;

import mechanics.Dice;

public class Armor {

    public String name = "test";
    public int cost = 0;
    public int armorClass = 0;
    public int strength = 0;
    public int weight = 0;

    public Armor(String name, int cost, int armorClass, int strength, int weight) {

        this.name = name;
        this.cost = cost;
        this.armorClass = armorClass;
        this.strength = strength;
        this.weight = weight; // Weight in lb

    }
    //    10 Copper = 1 Silver
    //    10 Silver = 1 Gold

    // Light Armor
    public static Armor padded = new Armor("Padded", 500, 11
            + Player.PlayerStats.statModifiers("dexterity"), 0, 8);
    public static Armor leather = new Armor("Leather", 1000, 11
            + Player.PlayerStats.statModifiers("dexterity"), 0, 10);
    public static Armor studdedLeather = new Armor("Studded Leather", 4500, 12
            + Player.PlayerStats.statModifiers("dexterity"), 0, 13);

    // Medium Armor
    public static Armor hide = new Armor("Hide", 1000, 12
            + Player.PlayerStats.statModifiers("dexterity"), 0, 12);
    public static Armor chainShirt = new Armor("Chain Shirt", 5000, 13
            + Player.PlayerStats.statModifiers("dexterity"), 0, 20);
    public static Armor scaleMail = new Armor("Scale Mail", 5000, 14
            + Player.PlayerStats.statModifiers("dexterity"), 0, 45);
    public static Armor breastplate = new Armor("Breastplate", 40000, 14
            + Player.PlayerStats.statModifiers("dexterity"), 0, 20);
    public static Armor halfPlate = new Armor("Half Plate", 75000, 15
            + Player.PlayerStats.statModifiers("dexterity"), 0, 40);

    // Heavy Armor
    public static Armor ringMail = new Armor("Ring Mail", 3000, 14, 0,
            40);
    public static Armor chainMail = new Armor("Chain Mail", 7500, 16, 13,
            55);
    public static Armor splint = new Armor("Splint", 20000, 17, 15,
            60);
    public static Armor plate = new Armor("Plate", 150000, 18, 15,
            65);

    // Shield
    public static Armor shield = new Armor("Shield", 1000, 2, 0,
            6);


    // cost = cost + Player.PlayerStats.statModifiers("dexterity");
}
