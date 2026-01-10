package story;

import entetys.Player;
import mechanics.Attack;
import mechanics.Leveling;

import java.util.Scanner;

public class Dungeon1 {
    final Attack dungeon1Fight = new Attack();
    final Scanner userInput = new Scanner(System.in);
    int choice;
    public static final Dungeon1 dungeon1 = new Dungeon1();

    public void enterDungeon1() {
        Player.PlayerStats.rest();
        System.out.println("(you enter into the first room of the dungeon you see a path ahead which splits two paths)");
        System.out.println("(do you chose the right path witch goes slightly down hill or ");
        System.out.println("do you choose the left one from where you feel a slight draft and hear a fait " +
                "sound of running water");
        System.out.println("(0)right");
        System.out.println("(1)left");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (userInput.nextByte() == 0) {

            firstRight();

        } else {
            firstLeft();
        }
    }

    void firstRight() {
        System.out.println("(you head down the right path you notice the air smells muddy)");
        System.out.println("(you feel the ground getting more slippery by the step)");
        System.out.println("(suddenly the path vanishes before your eyes and you see the cave ceiling)");
        System.out.println("(you notice your picking up speed as your sliding down the path gets narrower and steeper)");
        System.out.println("*Thud*");
        System.out.println("(you hit the ground as you slowly start taking in your new surroundings you" +
                " hear movement behind you)");
        System.out.println("(you turn around and se a stick like creature running towards you)");
        System.out.println();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        dungeon1Fight.fight(2);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        System.out.println("(you scan the room again you notice a faint light down a mine shaft you follow it)");
        System.out.println();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        firstRightRoom();
    }

    void firstRightRoom() {
        System.out.println("(you come closer to the light and suddenly your in a well lit room with a camp inside )");
        System.out.println("(you look around for anyone else but see no one )");
        System.out.println("(do you want to rest here?)Y/N");
        userInput.nextLine();
        if (userInput.nextLine().equalsIgnoreCase("y")) {
            System.out.println("(you head to sleep)");
            Player.PlayerStats.rest();
            System.out.println("(you wake up refreshed and ready to press on )");
            System.out.println("(as you get ready to press on you see a scroll which wasn't there yesterday curios you examine it)");
            System.out.println("(as soon as you read the scroll you get the feeling you somehow gained new knowledge)");
            System.out.println("(+900xp)");
            Player.PlayerStats.xp += 900;
            Leveling.addExp();
        }
        System.out.println("(you press on down the mine shaft)");
        System.out.println("(you get out of the mine shaft into a big cavern with a small village )");
        System.out.println();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        village();

    }

    void firstLeft() {
        System.out.println("(you head down the left path you hear the sound getting closer)");
        System.out.println("(you enter a room with a hole in the ceiling through which you can see day light and you see" +
                "a stream of water heading down the path way it seem to come from the wall)");
        System.out.println("(you follow the stream)");
        System.out.println();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        firstLeftRoom();
    }

    void firstLeftRoom() {
        System.out.println("(as you follow the stream you see a wooden wall in front of you with a guard standing " +
                "next to the gate)");
        System.out.println("Guard : to enter our village you need to pay 15 gold");
        System.out.println("(you say hello to the guard)");
        System.out.println("(you examine the guard he seems to have no sense of humor so you better pay and get on)");
        System.out.println("you give him the 15 gold and head inside");
        System.out.println();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        village();
    }

    void village() {
        System.out.println("end of current content");
    }
}
