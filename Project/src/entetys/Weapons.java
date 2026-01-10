package entetys;

import mechanics.Dice;

public class Weapons {

    public String name = "test";
    public int damage = 1;
    public int cost = 1;
    public double weight = 1;
    public String damageRange = "1d6";

    public Weapons(String name, int damage, int cost, double weight, String damageRange) {

        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.damageRange = damageRange;
        this.weight = weight; // Weight in lb

    }

    // Simple Melee Weapons
    public static final Weapons club = new Weapons("Club", Dice.d(4), 10,
            2, "1d4");
    public static final Weapons dagger = new Weapons("Dagger", Dice.d(4), 200,
            1, "1d4");
    public static Weapons greatClub = new Weapons("Greatclub", Dice.d(8), 20,
            10, "1d8");
    public static Weapons handAxe = new Weapons("Handaxe", Dice.d(6), 500,
            2, "1d6");
    public static final Weapons javelin = new Weapons("Javelin", Dice.d(6), 50,
            2, "1d6");
    public static final Weapons lightHammer = new Weapons("Light Hammer", Dice.d(4), 200,
            2, "1d4");
    public static final Weapons mace = new Weapons("Mace", Dice.d(6), 500,
            4, "1d6");
    public static final Weapons quarterStaff = new Weapons("Quarter Staff", Dice.d(6), 20,
            4, "1d6");
    public static final Weapons sickle = new Weapons("Sickle", Dice.d(4), 100,
            2, "1d4");
    public static final Weapons spear = new Weapons("Spear", Dice.d(6), 100,
            3, "1d6");
    public static final Weapons unarmedStrike = new Weapons("Unarmed Strike", 1, 0,
            0, "1");

    // Simple Ranged Weapons
    public static final Weapons crossbowLight = new Weapons("Crossbow, light", Dice.d(8), 2500,
            5, "1d8");
    public static final Weapons dart = new Weapons("Dart", Dice.d(4), 5,
            0.25, "1d4");
    public static final Weapons shortbow = new Weapons("Shortbow", Dice.d(6), 2500,
            2, "1d6");
    public static final Weapons sling = new Weapons("Sling", Dice.d(4), 10,
            0, "1d4");

    // Martial Melee Weapons
    public static final Weapons battleaxe = new Weapons("Battleaxe", Dice.d(8), 1000,
            4, "1d8");
    public static final Weapons flail = new Weapons("Flail", Dice.d(8), 1000,
            2, "1d8");
    public static final Weapons glaive = new Weapons("Glaive", Dice.d(10), 2000,
            6, "1d10");
    public static final Weapons greataxe = new Weapons("Greataxe", Dice.d(12), 3000,
            7, "1d12");
    public static final Weapons greatsword = new Weapons("Greatsword", Dice.d(6) + Dice.d(6),
            5000, 6, "2d6");
    public static final Weapons halberd = new Weapons("Halberd", Dice.d(10), 2000,
            6, "1d10");
    public static final Weapons lance = new Weapons("Lance", Dice.d(12), 1000,
            6, "1d12");
    public static final Weapons longsword = new Weapons("Longsword", Dice.d(8), 1500,
            3, "1d8");
    public static final Weapons maul = new Weapons("Maul", Dice.d(6) + Dice.d(6), 1000,
            10, "2d6");
    public static final Weapons morningstar = new Weapons("Morningstar", Dice.d(8), 1500,
            4, "1d8");
    public static final Weapons pike = new Weapons("Pike", Dice.d(10), 500,
            18, "1d10");
    public static final Weapons rapier = new Weapons("Rapier", Dice.d(8), 2500,
            2, "1d8");
    public static final Weapons scimitar = new Weapons("Scimitar", Dice.d(6), 2500,
            3, "1d6");
    public static final Weapons shortsword = new Weapons("Shortsword", Dice.d(6), 1000,
            2, "1d6");
    public static final Weapons trident = new Weapons("Trident", Dice.d(6), 500,
            4, "1d6");
    public static final Weapons warPick = new Weapons("War Pick", Dice.d(8), 500,
            2, "1d8");
    public static final Weapons warhammer = new Weapons("Warhammer", Dice.d(8), 1500,
            2, "1d8");
    public static final Weapons whip = new Weapons("Whip", Dice.d(4), 200,
            3, "1d4");

    // Martial Ranged Weapons
    public static final Weapons blowgun = new Weapons("Blowgun", 1, 1000,
            1, "1");
    public static final Weapons crossbowHand = new Weapons("Crossbow, hand", Dice.d(6), 7500,
            3, "1d6");
    public static final Weapons crossbowHeavy = new Weapons("Crossbow, heavy", Dice.d(10), 5000,
            18, "1d10");
    public static final Weapons longbow = new Weapons("Longsword", Dice.d(8), 5000,
            3, "1d8");
    public static final Weapons net = new Weapons("Net", 0, 100,
            3, "0");


}

