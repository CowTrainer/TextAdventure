package textadventure;

import java.util.Scanner;
import java.util.HashMap;

public class MainGame {
    static HashMap<String, Room> roomMap = new HashMap<>();
    static String curRoom;
    static boolean isPlaying = true;

	public static void main(String[] args) {

        setup();
		
        while (isPlaying) {

            String command = getCommand();
            String[] words = command.split("\\s");
            
            String word1 = words[0];
            switch (word1) {
                case "n": case "s": case "e": case "w":
                case "north": case "south": case "east": case "west":
                    moveToRoom(word1.charAt(0));
                    System.out.println(roomMap.get(curRoom).getName());
                    break;
            
                default:
                    break;
            }
        }
	}

    static void setup() {
        Room.setRooms(roomMap);
        curRoom = "hallway";
    }

    static Scanner sc = new Scanner(System.in);
    static String getCommand() {
		System.out.print("=> ");
		String text = sc.nextLine().toLowerCase();
		if (text.length() == 0) text = "look"; //default command		
		return text;
	}

    static void moveToRoom(char direction) {
        String newRoom = roomMap.get(curRoom).getExit(direction);

        if (newRoom.length() == 0) {
            System.out.println("You can't go that way.");
            return;
        }
        curRoom = newRoom;
    }
}
