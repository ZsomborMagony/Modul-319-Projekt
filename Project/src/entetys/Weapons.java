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

    public static Weapons club = new Weapons("Club", Dice.d(4), 100, 2, "1d4");
    public static Weapons dagger = new Weapons("Dagger", Dice.d(4), 200, 1, "1d4");

}

