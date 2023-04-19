package textadventure;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class MainGame {
	
    static HashMap<String, Room> roomMap = new HashMap<>();
    static HashMap<String, Item> itemMap = new HashMap<String,Item>();
    static ArrayList<String> inventory = new ArrayList<String>();
    static String curRoom;
    static boolean isPlaying = true;
    static int turnCounter = 0;
	static Player player = new Player("Bobert");
	
	int turns = 0;


	public static void main(String[] args) {
        setup();
		
        while (isPlaying) {

            String command = getCommand().toLowerCase().trim();
            if (command.length() == 0) 
            	continue;
            String[] words = command.split("\\s");
            
            String word1 = words[0];
            String word2 = "";
            
            if (words.length >= 2) 
                word2 = words[1];
            switch (word1) {
                case "n": case "s": case "e": case "w":
                case "north": case "south": case "east": case "west":
                    moveToRoom(word1.charAt(0));
                    break;
                case "look":
                    showRoom();
                    break;
                case "take":
                	takeItem(word2);
                	break;
                case "swing":
                	if(curRoom.equals("entrance"))
                	{
	                	if (inventory.contains("hammer") && word2.equals("hammer")) {
	                		System.out.println("You swing your hammer at the door with great force, loosening the door slightly from it's hinges. Your hammer immediately breaks");
	                		inventory.remove("hammer");
	                	}
	                	if (inventory.contains("sledgehammer") && word2.equals("sledgehammer")) {
	                		if(player.sandwichBuff) {
		                		System.out.println("You swing your sledgehammer at the door with great force, tearing the door from it's hinges. The light flows in from the outside. You are finally free");
		                		System.out.println("YOU WIN!");
		                		System.exit(0);
	                		}
	                		else {
	                			System.out.println("You lift your sledgehammer up to swing it, but you are tired and deprived of energy, and thus unable to swing. Maybe you should get some refreshments");
	                		}
	                	}
	                	
                	}
                	break;
	                		
                case "examine":
                	lookItem(word2);
                	break;
                	
                case "move":
                	if(word2.equals("carpet"))
                		moveCarpet();
                	break;
                case "unlock":
                	if(curRoom.equals("detention") && word2.equals("door")){
                		unlockDoor();
                	}
                	break;
                case "eat":
                	if(inventory.contains("sandwich") && word2.equals("sandwich")) {
                		System.out.println("You suffer through the sandwich. You now feel much more energized");
                		inventory.remove("sandwich");
                		player.sandwichBuff = true;
                	}
                	break;
                case "i": case "inventory":
                    showInventory();
                    break;
                default:
                    System.out.println("**Invalid command**");
                    break;
            }
	
	            checkGameOver();
        }
	}

    static void setup() {
        Room.setRooms(roomMap);
        Item.setItems(itemMap, roomMap);
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
        room.itemList.forEach((x) -> {System.out.println(itemMap.get(x).roomText);});
    }
    
    static void lookItem(String itemName) {
    	if (inventory.contains(itemName)) {
            Item item = itemMap.get(itemName);
            System.out.println(item.examineText);
            return;
        }
        Room r = roomMap.get(curRoom);
        if (r.itemList.contains(itemName)) {
            Item item = itemMap.get(itemName);
            System.out.println(item.examineText);
            return;
        }
        System.out.println("Invalid item to examine");
    }
    
    static void moveCarpet() { 
    	System.out.println(itemMap.get("carpet").revealText);
    	roomMap.get("detention").itemList.add(itemMap.get("carpet").revealItem);
    }
    
    static void unlockDoor() {
    	if(inventory.contains("key")) {
    		System.out.println("You turn the key, opening the door. The key breaks off as soon as you finishing unlocking it");
    		inventory.remove("key");
    		roomMap.get("detention").itemList.remove("key");
    		roomMap.get("detention").setDesc("Delinquent students are left for self reflection in this isolated space. The office is located to the east, behind an unlocked door");
    		roomMap.get("detention").setExits("", "", "office", "");
    	}
    }
    
    
    static void showInventory() {
    	 System.out.println("\n-------------------------------------------------------------------------------");
         for (int i = 0; i < inventory.size(); ++i) {
             System.out.println(inventory.get(i));
         }
         if (inventory.size() == 0) {
             System.out.println("You have nothing, you are poor");
         }
         System.out.println("---------------------------------------------------------------------------------");
    }
    
    static void takeItem(String itemName) {
        Room r = roomMap.get(curRoom);
        if (!itemMap.get((Object)itemName).isCarryable) {
            System.out.println("You can't take that item");
            return;
        }
        if (!r.itemList.contains(itemName)) {
            System.out.println("No" + itemName + " exists");
            return;
        }
        r.itemList.remove(itemName);
        inventory.add(itemName);
        System.out.println("You take the " + itemName + " and shove it in your pocket");
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
