package textadventure;

import java.util.Scanner;
import java.util.HashMap;

public class MainGame {
    static HashMap<String, Room> roomMap = new HashMap<>();
    static String curRoom;
    static boolean isPlaying = true;
    static int turnCounter = 0;

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
                    break;
                case "look":
                    showRoom();
                // case "i": case "inventory":
                    // if ()
                default:
                    System.out.println("**Invalid command**");
            }

            checkGameOver();
        }
	}

    static void setup() {
        Room.setRooms(roomMap);
        curRoom = "detention";
        System.out.println("Darn, you were caught 'using the washroom' again, and got sent to the office. It's well after school, but the principal forgot to let you out of the detention room. Escape the school.");
        showRoom();
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
        showRoom();
        turnCounter++;
    }

    static void showRoom() {
        Room room = roomMap.get(curRoom);
        System.out.println("-- "+room.getName()+" --");
        System.out.println(room.getDescription());
    }

    static void checkGameOver() {
        if (curRoom == "fire") {
            System.out.println("You pushed open the fire exit door and sounded the alarm. You were caught by the custodian and reported to the principal.");
            System.out.println("MISSION FAILED");
            System.exit(0);
        }

        if (turnCounter == 20) {
            System.out.println("You pulled an all-nighter studying last night, and haven't ate anything since. You fainted.");
            System.out.println("MISSION FAILED");
            System.exit(0);
        }
    }
}
