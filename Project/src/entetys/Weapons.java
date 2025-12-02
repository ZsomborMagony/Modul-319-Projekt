package entetys;// Fragen
/*
 - damages
 - Info? Maybe
 - static void (so wir nicht nochmal ein Class erstellen muss)
 - Verbesserungs Vorschlag
 - Wictig (Cant, run the code. Issue resolve (Diego))
 */


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

//    10 Copper = 1 Silver
//    10 Silver = 1 Gold

    public static Weapons club = new Weapons("Club", Dice.d(4), 10,
            2, "1d4");
    public static Weapons dagger = new Weapons("Dagger", Dice.d(4), 200,
            1, "1d4");
    public static Weapons greatclub = new Weapons("Greatclub", Dice.d(8), 20,
            10, "1d8");
    public static Weapons handaxe = new Weapons("Handaxe", Dice.d(6), 500,
            2, "1d6");
    public static Weapons javelin = new Weapons("Javelin", Dice.d(6), 50,
            2, "1d6");
    public static Weapons lightHammer = new Weapons("Light Hammer", Dice.d(4), 200,
            2, "1d4");
    public static Weapons mace = new Weapons("Mace", Dice.d(6), 500,
            4, "1d6");
    public static Weapons quarterStaff = new Weapons("Quarter Staff", Dice.d(6), 20,
            4, "1d6");
    public static Weapons sickle = new Weapons("Sickle", Dice.d(4), 100,
            2, "1d4");
    public static Weapons spear = new Weapons("Spear", Dice.d(6), 100,
            3, "1d6");
    public static Weapons unarmedStrike = new Weapons("Unarmed Strike", 1, 0,
            0, "1");

    // Simple Ranged Weapons
    public static Weapons crossbowLight = new Weapons("Crossbow, light", Dice.d(8), 2500,
            5, "1d8");
    public static Weapons dart = new Weapons("Dart", Dice.d(4), 5,
            0.25, "1d4");
    public static Weapons shortbow = new Weapons("Shortbow", Dice.d(6), 2500,
            2, "1d6");
    public static Weapons sling = new Weapons("Sling", Dice.d(4), 10,
            0, "1d4");

    // Martial Melee Weapons
    public static Weapons battleaxe = new Weapons("Battleaxe", Dice.d(8), 1000,
            4, "1d8");
    public static Weapons flail = new Weapons("Flail", Dice.d(8), 1000,
            2, "1d8");
    public static Weapons glaive = new Weapons("Glaive", Dice.d(10), 2000,
            6, "1d10");
    public static Weapons greataxe = new Weapons("Greataxe", Dice.d(12), 3000,
            7, "1d12");
    public static Weapons greatsword = new Weapons("Greatsword", Dice.d(6) + Dice.d(6),
            5000, 6, "2d6");
    public static Weapons halberd = new Weapons("Halberd", Dice.d(10), 2000,
            6, "1d10");
    public static Weapons lance = new Weapons("Lance", Dice.d(12), 1000,
            6, "1d12");
    public static Weapons longsword = new Weapons("Longsword", Dice.d(8), 1500,
            3, "1d8");
    public static Weapons maul = new Weapons("Maul", Dice.d(6) + Dice.d(6), 1000,
            10, "2d6");
    public static Weapons morningstar = new Weapons("Morningstar", Dice.d(8), 1500,
            4, "1d8");
    public static Weapons pike = new Weapons("Pike", Dice.d(10), 500,
            18, "1d10");
    public static Weapons rapier = new Weapons("Rapier", Dice.d(8), 2500,
            2, "1d8");
    public static Weapons scimitar = new Weapons("Scimitar", Dice.d(6), 2500,
            3, "1d6");
    public static Weapons shortsword = new Weapons("Shortsword", Dice.d(6), 1000,
            2, "1d6");
    public static Weapons trident = new Weapons("Trident", Dice.d(6), 500,
            4, "1d6");
    public static Weapons warPick = new Weapons("War Pick", Dice.d(8), 500,
            2, "1d8");
    public static Weapons warhammer = new Weapons("Warhammer", Dice.d(8), 1500,
            2, "1d8");
    public static Weapons whip = new Weapons("Whip", Dice.d(4), 200,
            3, "1d4");

    // Martial Ranged Weapons
    public static Weapons blowgun = new Weapons("Blowgun", 1, 1000,
            1, "1");
    public static Weapons crossbowHand = new Weapons("Crossbow, hand", Dice.d(6), 7500,
            3, "1d6");
    public static Weapons crossbowHeavy = new Weapons("Crossbow, heavy", Dice.d(10), 5000,
            18, "1d10");
    public static Weapons longbow = new Weapons("Longsword", Dice.d(8), 5000,
            3, "1d8");
    public static Weapons net = new Weapons("Net", 0, 100,
            3, "0");


}

