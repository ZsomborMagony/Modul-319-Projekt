import entetys.Player;
import mechanics.Attack;
import mechanics.Inventory;
import mechanics.MakeCharacter;

public class Main {
    public static void main(String[] args) {

        Inventory chest = new Inventory();
        chest.addWeaponToInventory(0,0);
        chest.openChest();
        Player.PlayerStats.playerInventory.openInventory();
    }
}