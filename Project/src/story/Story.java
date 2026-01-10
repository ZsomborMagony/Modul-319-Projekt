package story;

import entetys.Player;
import mechanics.Inventory;
import mechanics.MakeCharacter;

public class Story {
    public static void intro() {
        System.out.println("King: " +
                "Well, well, well, look what we got here. The almighty hero of this kingdom reduced to such a state. " +
                "I am a bit disappointed. I thought you would put up a much tougher fight but well it doesn’t matter.");
        System.out.println("Player: " +
                "Why are you doing this? Why are you cooperating with these monsters? Why do you want to kill me?");
        System.out.println("King: " +
                "As to why I am doing this is because you are a too big of an obstacle to my plans. You know it was such" +
                " a pain in the ass trapping you here. You should have died long ago by my associate that I sent after " +
                "you, but it doesn’t matter. You know these monster became quite handy in capturing you. Of course they" +
                " can’t kill you because of your strength but they are extremely useful because of their numbers and " +
                "annoying resilience.");
        System.out.println("Player: " +
                "Are you controlling them? ");
        System.out.println("King: " +
                "Bravo as expected from the great hero, you noticed it. Yes I am controlling them. " +
                "It took months of preparations to be able to control this many monsters but as I see," +
                " it was all worth it.");
        System.out.println("Player: " +
                "What is this plan, that you are willing to kill your own soldiers that came with me." +
                " You can clearly see, that the people of this county are suffering from hunger," +
                " monster attacks and diseases. Why are you so desperate on killing me even though" +
                " I did nothing but good for the people of this country.");
        System.out.println("King: " +
                "Money and Power. Everything is buyable with money. Everything is achievable with Power. Everything is" +
                " about money and Power. It doesn’t matter what kind of methods you use to get them, because if " +
                "you have them than you can do whatever you want.");
        System.out.println("Player: " +
                "YOU ARE DOING ALL THIS JUST FOR MONEY AND POWER?! You are selling the country out, letting people " +
                "suffer, making everything overpriced so you can get enough money?");
        System.out.println("King: " +
                "ENOUGH! I heard more than needed of your bullshit and now die.");
        System.out.println("(The King takes out a strange black orb and points it towards you)");
        System.out.println("(The black orb lights up and you feel a strange sensation and realize " +
                "that you are losing your strength)");
        System.out.println("Player: " +
                "What is that thing? It is taking my powers and strength away.");
        System.out.println("King: " +
                "I myself have little idea about this object, but all I need to know is that it is extremely" +
                "powerful and is able to kill you.");
        System.out.println("(You feel extremely weak and you realize that if this keeps up you will faint in no time)");
        System.out.println("King: " +
                "HA!HA!HA!Ha! finally the great hero will die and I can finally do my things without " +
                "worrying about you interfering.");
        System.out.println("Player: " +
                "Old King! Remember I will come to find you even if I am in hell. I will climb up from there " +
                "to find you and drag you down with me! ");
        System.out.println("(You cough up a mouthful of blood)");
        System.out.println("(Before you faint, you hear a loud explosions and multiple people attacking)");
        System.out.println("(but in the end you faint because of exhaustion)");
        System.out.println(" ");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        MakeCharacter.makeCharakter();

        System.out.println(" ");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("(You wake up feeling weak and slightly lightheaded)");
        System.out.println("(You look around to see 3 similar faces that you recognize." +
                " You also realize that you are in the Adventure Hall)");
        System.out.println("(You remember, that they are the blurry figure you saw before" +
                " fainting and your childhood friends)");
        System.out.println("Cleric Companion: Are you feeling any better?");
        System.out.println("Player: Yeah! I managed to recover thanks to your quick actions," +
                " but I feel like I am missing something.");
        System.out.println("Barbarian Companion: How should I explain it to you? Dou you remember the black orb" +
                " that the bastard king was holding?");
        System.out.println("Player: Yeah." +
                "Barbarian Companion: That thing took away most of your powers somehow. Luckily we were fast enough to" +
                " intercept it before it took everything away though I don’t know what power you have remaining.");
        System.out.println("Cleric Companion: Considering the situation at hand, I advise you to retire for the " +
                "time being and enjoy life as much as possible");
        System.out.println("Mage Companion(traitor): We understand that it is hard for you to accept it but right " +
                "now you are nothing else but an ordinary human.");
        System.out.println("Player: I am happy to hear that you guys are so concerned about me, but I can’t give up now" +
                " that I saw how the king treats his own people and letting them suffer. I must become strong " +
                "again to be able to stand against the king.");
        System.out.println("Barbarian Companion: We thought you would say and we also have an idea on how to make " +
                "you stronger again, but first of all we are going to check how much power you have left.");
        System.out.println("(After this short discussion, Your team with you approval conducted several small " +
                "experiences to see how much power you have remaining)");
        System.out.println("Cleric Companion: It seems like you still have your ability to use any weapon after " +
                "you touch them(Weapon Mastery) and also magic.");
        System.out.println("Mage Companion(traitor): *Frowns*");
        System.out.println("Cleric Companion: It also seems like the power of Weapon Mastery and " +
                "magic also became stronger.");
        System.out.println("Player: That’s good. At least I have something to use against the king and his monsters.");
        System.out.println("Barbarian Companion: Now that we checked your powers, we need you to become stronger and we" +
                " have the best method for you.");
        System.out.println("Cleric Companion: After your fight with the king, strange dungeons appeared in the basement" +
                " of the Adventurer’s Hall. We do not know how it appeared. All we know is that they are ranging from" +
                " low level dungeons to high level ones and that there are 13 of them.");
        System.out.println("Barbarian Companion: What really strange is that 3 of them are sealed and there are no" +
                " methods to get in there at the moment.");
        System.out.println("Player: It certainly is strange.");
        System.out.println("Mage Companion(traitor): Right now the goal is for you to become stronger and we will" +
                " inform you when we find some useful information to these dungeon.");
        System.out.println("Player: Thank you guys for your help again.");
        System.out.println("Cleric Companion: No Problem.");
        System.out.println("(You dress up, take a look in the weapon chest and go to the first dungeon)");
        System.out.println(" ");

        Inventory startChest =new Inventory();
        Player.PlayerStats.playerInventory.fillArmor();
        Player.PlayerStats.playerInventory.fillWeapons();
        startChest.fillWeapons();
        startChest.fillArmor();
        startChest.addWeaponToInventory(1,14);
        startChest.addWeaponToInventory(0,0);
        startChest.openChest();
        Player.PlayerStats.playerInventory.openInventory();

        Dungeon1.dungeon1.enterDungeon1();

    }
}
