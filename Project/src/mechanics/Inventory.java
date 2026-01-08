package mechanics;

import entetys.Armor;
import entetys.Player;
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
    Weapons[] heavyWeapons = {
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
    Armor[] lightArmor2 = {
            Armor.padded,
            Armor.leather

    };
    Armor[] lightArmor = {
            Armor.padded,
            Armor.leather,
            Armor.studdedLeather
    };
    Armor[] mediumArmor = {
            Armor.hide,
            Armor.chainShirt,
            Armor.scaleMail,
            Armor.breastplate,
            Armor.halfPlate
    };
    Armor[] heavyArmor = {
            Armor.ringMail,
            Armor.chainMail,
            Armor.splint,
            Armor.plate
    };
    Armor[] shield = {
            Armor.shield
    };
    Armor[][] armors = {
            lightArmor,
            mediumArmor,
            heavyArmor,
            shield

    };
    Weapons[][] weapons = {
            simpleWeapons,
            heavyWeapons
    };
    String[] inventory = new String[10];
    String[] equipped = new String[3];//[0] Weapon [1] Armor [2] Shield


    public void openInventory() {

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

    public String getEquipmentValue(int slot) {
        String equipmentSlotValue = equipped[slot];
        return equipmentSlotValue;
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
        System.out.println(lightArmor2[0].armorClass);
        System.out.println(armors[0][0].name);
        System.out.println("witch Item do you want to equip? (0-9)");
        choice = userInput.nextInt();


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
                }
            }
        }
    }

    public int getArmorClassFromEquippedSlot(String itemName) {

        int armorClass = 0;

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

        Scanner userInput = new Scanner(System.in);
        System.out.println("Items in inventory:");
        for (String contens : inventory) {
            if (contens == null) {
                contens = "empty";
            }
            System.out.println(contens);
        }
        System.out.println("do you want to take something?");
        if (userInput.nextLine().equalsIgnoreCase("y")) {
            System.out.println("which Item do you want to take 0-9");
            int choice = userInput.nextInt();
            for (int i = 0; i < Player.PlayerStats.playerInventory.inventory.length; i++) {
                if (Player.PlayerStats.playerInventory.inventory[i] == null) {
                    Player.PlayerStats.playerInventory.inventory[i] = inventory[choice];
                    inventory[i] = null;
                    break;
                }
            }
        }
    }

    public void addWeaponToInventory(int simpleOrHeavy, int weaponNr) {
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
