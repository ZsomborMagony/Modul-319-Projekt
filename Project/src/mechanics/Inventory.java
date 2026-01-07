package mechanics;

import entetys.Armor;
import entetys.Weapons;

import java.util.Scanner;

public class Inventory {
    Weapons[] simpleWeapons = {
            Weapons.club,
            Weapons.dagger,
            Weapons.greatclub,
            Weapons.handaxe,
            Weapons.javelin,
            Weapons.lightHammer,
            Weapons.mace,
            Weapons.quarterStaff,
            Weapons.sickle,
            Weapons.spear,
            Weapons.unarmedStrike,
            Weapons.crossbowLight,
            Weapons.dart,
            Weapons.shortbow,
            Weapons.sling
    };
    Weapons[] heavyWeapons={
            Weapons.battleaxe,
            Weapons.flail,
            Weapons.glaive,
            Weapons.greataxe,
            Weapons.greatsword,
            Weapons.halberd,
            Weapons.lance,
            Weapons.longsword,
            Weapons.maul,
            Weapons.morningstar,
            Weapons.pike,
            Weapons.rapier,
            Weapons.scimitar,
            Weapons.shortsword,
            Weapons.trident,
            Weapons.warPick,
            Weapons.warhammer,
            Weapons.whip,
            Weapons.blowgun,
            Weapons.crossbowHand,
            Weapons.crossbowHeavy,
            Weapons.longbow,
            Weapons.net
    };
    Armor[] lightArmor={
      Armor.padded,
      Armor.leather,
      Armor.studdedLeather
    };
    Armor[] mediumArmor={
            Armor.hide,
            Armor.chainShirt,
            Armor.scaleMail,
            Armor.breastplate,
            Armor.halfPlate
    };
    Armor[] heavyArmor={
            Armor.ringMail,
            Armor.chainMail,
            Armor.splint,
            Armor.plate
    };
    Armor[] shield ={
            Armor.shield
    };
    Armor[][] armors={
            lightArmor,
            mediumArmor,
            heavyArmor,
            shield

    };
    Weapons[][] weapons={
            simpleWeapons,
            heavyWeapons
    };
    String[] inventory = new String[10];
    String[] equipped = new String[3];


    public void openInventory() {
        inventory[0]=weapons[1][1].name;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Items in inventory:");
        for (String contens : inventory) {
            if (contens == null) {
                contens = "empty";
            }
            System.out.println(contens);
        }
        System.out.println("do you want to equip something? Y/N");
        if (userInput.nextLine().equalsIgnoreCase("y")) {
            equipItem();
        }
    }

    void openEquipment() {
        System.out.println("equipped Items: ");
        for (String contens : equipped) {
            if (contens == null) {
                contens = "empty";
            }
            System.out.println(contens);
        }
    }

    void equipItem() {
        Scanner userInput = new Scanner(System.in);
        int choice;
        System.out.println("witch Item do you want to equip? (0-9)");
        choice = userInput.nextInt();
        for (int i=0;i<=armors.length;i++){
            for (int i1=0;i1<=armors[i].length;i1++){
                if (inventory[choice].equals(armors[i][i1].name)){
                    equipped[2]=armors[i][i1].name;
                }
            }
        }
        for (int i=0;i<=weapons.length;i++){
            for (int i1=0;i1<=weapons[i].length;i1++){
                if (inventory[choice].equals(weapons[i][i1].name)){
                    equipped[0]=weapons[i][i1].name;
                }
            }
        }
    }

    void sellItems() {
        System.out.println("Items in inventory:");
        for (String contens : inventory) {
            if (contens == null) {
                contens = "empty";
            }
            System.out.println(contens);
        }

    }
}
