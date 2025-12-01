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

    public static String name="test";
    public static int damage=1;
    public static int cost=1;
    public static double weight=1;
    public static String damageRange="1d6";

    // Simple Melee entetys.Weapons
    public Weapons(String name,int damage, int cost, double weight,String damageRange) {

        this.name = name;
        this.cost = cost;
        this.damage = damage;
        this.damageRange=damageRange;
        this.weight = weight; // Weight in lb

    }
       public static Weapons Club = new Weapons("Club",Dice.d(6),1,4,"1d6");

}

