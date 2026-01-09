package mechanics;

import entetys.Armor;
import entetys.Player;
import entetys.Weapons;

import java.util.Scanner;

public class Inventory {
    final Weapons[] simpleWeapons = new Weapons[15];
    final Weapons[] heavyWeapons = new Weapons[23];


  public void fillWeapons() {
        simpleWeapons[0]=Weapons.club;
        simpleWeapons[1]=Weapons.dagger;
        simpleWeapons[2]=Weapons.greatclub;
        simpleWeapons[3]=Weapons.handaxe;
        simpleWeapons[4]=Weapons.javelin;
        simpleWeapons[5]=Weapons.lightHammer;
        simpleWeapons[6]=Weapons.mace;
        simpleWeapons[7]=Weapons.quarterStaff;
        simpleWeapons[8]=Weapons.sickle;
        simpleWeapons[9]=Weapons.spear;
        simpleWeapons[10]=Weapons.unarmedStrike;
        simpleWeapons[11]=Weapons.crossbowLight;
        simpleWeapons[12]=Weapons.dart;
        simpleWeapons[13]=Weapons.shortbow;
        simpleWeapons[14]=Weapons.sling;
        heavyWeapons[0] =Weapons.battleaxe;
        heavyWeapons[1] =Weapons.flail;
        heavyWeapons[2] =Weapons.glaive;
        heavyWeapons[3] =Weapons.greataxe;
        heavyWeapons[4] =Weapons.greatsword;
        heavyWeapons[5] =Weapons.halberd;
        heavyWeapons[6] =Weapons.lance;
        heavyWeapons[7] =Weapons.longsword;
        heavyWeapons[8] =Weapons.maul;
        heavyWeapons[9] =Weapons.morningstar;
        heavyWeapons[10] =Weapons.pike;
        heavyWeapons[11] =Weapons.rapier;
        heavyWeapons[12] =Weapons.scimitar;
        heavyWeapons[13] =Weapons.shortsword;
        heavyWeapons[14] =Weapons.trident;
        heavyWeapons[15] =Weapons.warPick;
        heavyWeapons[16] =Weapons.warhammer;
        heavyWeapons[17] =Weapons.whip;
        heavyWeapons[18] =Weapons.blowgun;
        heavyWeapons[19] =Weapons.crossbowHand;
        heavyWeapons[20] =Weapons.crossbowHeavy;
        heavyWeapons[21] =Weapons.longbow;
        heavyWeapons[22] =Weapons.net;

    }

    final Armor[] lightArmor = new Armor[3];

   public void fillArmor() {

        lightArmor[0] = Armor.padded;
        lightArmor[1] = Armor.leather;
        lightArmor[2] = Armor.studdedLeather;

        mediumArmor[0] = Armor.hide;
        mediumArmor[1] = Armor.chainShirt;
        mediumArmor[2] = Armor.scaleMail;
        mediumArmor[3] = Armor.breastplate;
        mediumArmor[4] = Armor.halfPlate;

        heavyArmor[0] = Armor.ringMail;
        heavyArmor[1] = Armor.chainMail;
        heavyArmor[2] = Armor.splint;
        heavyArmor[3] = Armor.plate;

        shield[0]=Armor.shield;
    }

    final Armor[] mediumArmor = new Armor[5];
    final Armor[] heavyArmor = new Armor[4];
    final Armor[] shield = new Armor[1];
    final Armor[][] armors = {
            lightArmor,
            mediumArmor,
            heavyArmor,
            shield

    };
    final Weapons[][] weapons = {
            simpleWeapons,
            heavyWeapons
    };
    final String[] inventory = new String[10];
    final String[] equipped = new String[3];//[0] Weapon [1] Armor [2] Shield
    public int[] money = {0};


    public void openInventory() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Items in inventory:");
        for (String contents : inventory) {
            if (contents == null) {
                contents = "empty";
            }
            System.out.println(contents);
        }
        System.out.println("do you want to equip something? Y/N");
        if (userInput.nextLine().equalsIgnoreCase("y")) {
            equipItem();
        }
    }

    public String getEquipmentValue(int slot) {
        return equipped[slot];

    }

    public void openEquipment() {
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
        fillArmor();
        fillWeapons();

        for (int i = 0; i < armors.length; i++) {
            for (int i1 = 0; i1 < armors[i].length; i1++) {
                if (armors[i][i1].name != null) {
                    if (inventory[choice].equals(armors[i][i1].name)) {
                        equipped[2] = armors[i][i1].name;
                    }
                }
            }
        }
        for (int i = 0; i < weapons.length; i++) {
            for (int i1 = 0; i1 < weapons[i].length; i1++) {
                if (inventory[choice].equals(weapons[i][i1].name)) {
                    equipped[0] = weapons[i][i1].name;
                    inventory[choice] = null;
                    break;
                }
            }
        }
    }

    public int getArmorClassFromEquippedSlot(String itemName) {

        int armorClass = 0;
        fillArmor();

        for (int i = 0; i < armors.length; i++) {
            for (int i1 = 0; i1 < armors[i].length; i1++) {
                if (itemName.equals(armors[i][i1].name)) {
                    if (itemName.equals(armors[2][i1].name)) {
                        armorClass = armors[i][i1].armorClass - Player.PlayerStats.statModifiers("dexterity");
                    } else {
                        armorClass = armors[i][i1].armorClass;
                    }
                }
            }
        }
        return armorClass;
    }

    public String getDamageRangeFromEquippedSlot(String itemName) {
        fillWeapons();
        String damageRange = null;

        for (int i = 0; i < weapons.length; i++) {
            for (int i1 = 0; i1 < weapons[i].length; i1++) {
                if (itemName.equals(weapons[i][i1].name)) {

                    damageRange = weapons[i][i1].damageRange;

                }
            }
        }
        return damageRange;
    }

    public void openChest() {
fillWeapons();
fillArmor();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Items in inventory:");
        for (String contens : inventory) {
            if (contens == null) {
                contens = "empty";
            }
            System.out.println(contens);
        }
        System.out.println("do you want to take something? Y/N");
        if (userInput.nextLine().equalsIgnoreCase("y")) {
            System.out.println("which Item do you want to take 0-9");
            int choice = userInput.nextInt();
            for (int i = 0; i < Player.PlayerStats.playerInventory.inventory.length; i++) {
                if (Player.PlayerStats.playerInventory.inventory[i] == null) {
                    Player.PlayerStats.playerInventory.inventory[i] = inventory[choice];
                    inventory[choice] = null;
                    break;
                }
            }
            openChest();
        }
    }

    public void addWeaponToInventory(int simpleOrHeavy, int weaponNr) {
        fillWeapons();
        fillArmor();
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = weapons[simpleOrHeavy][weaponNr].name;
                break;
            }
        }
    }

    public void addArmorToInventory(int armorType, int armorNr) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                inventory[i] = armors[armorType][armorNr].name;
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
