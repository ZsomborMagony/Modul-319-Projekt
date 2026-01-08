
import entetys.Armor;
import entetys.Player;
import mechanics.Inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory chest = new Inventory();
        Armor[] armors={Armor.ringMail};
        System.out.println(armors[0].name);
        chest.addWeaponToInventory(1, 3);
        chest.addWeaponToInventory(0,1);
        chest.openChest();
        Player.PlayerStats.playerInventory.openInventory();
    }
}
