package entetys;

public class player {
   public static int playerChosenClass;

        public static String playerClass(String playerClass) {

            switch (playerChosenClass) {
                case 0 -> playerClass = "Monk";
                case 1 -> playerClass = "Warlock";
                case 2 -> playerClass = "Barbarian";
                case 3 -> playerClass = "Cleric";
                default -> playerClass = "invalid";
            }
            return playerClass;
        }

    }

