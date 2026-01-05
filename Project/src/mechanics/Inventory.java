package mechanics;

import entetys.Weapons;

public class Inventory {
   static String[] inventory = new String[10];
    String[] equipped = new String[4];
   public static void openInventory(){
        for (String contens:inventory){
            if (contens==null){
                contens="empty";
            }
            System.out.println(contens);
        }
    }

}
