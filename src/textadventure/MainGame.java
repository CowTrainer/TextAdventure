package textadventure;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class MainGame {
	
    static HashMap<String, Room> roomMap = new HashMap<>();
    static HashMap<String, Item> itemMap = new HashMap<String,Item>();
    static String curRoom;
    static boolean isPlaying = true;
     //list of all item objects
	//These hashmaps could also be in the Room and Item class if it's more convenient to create them there. They would have to be static though.

	//the inventory could be an array
	ArrayList<String> inventory = new ArrayList<String>();
	String currentRoom;
	Player player;
	
	int turns = 0;


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
