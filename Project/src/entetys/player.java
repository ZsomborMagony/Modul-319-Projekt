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

    public class playerStats {
        public static int playerStrength=8;
        public static int playerDexterity=8;
        public static int playerConstitution=8;
        public static int playerIntelligence=8;
        public static int playerWisdom=8;
        public static int playerCharisma=8;
    }
}

