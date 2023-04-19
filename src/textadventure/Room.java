package textadventure;

import java.util.ArrayList;
import java.util.HashMap;

class Room {
	private ArrayList<String> itemList;
    private String name;
    private String description;
    private String n, s, e, w;
    // ArrayList<String, item> itemList = new ArrayList<>();

    private Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    private void setExits(String n, String s, String e, String w) {
        this.n = n;
        this.s = s;
        this.e = e;
        this.w = w;
    }

    String getExit(char direction) {
        switch (direction) {
            case 'n': return n;
            case 's': return s;
            case 'e': return e;
            case 'w': return w;
        }
        return null;
    }

    String getName() {
        return this.name;
    }

    String getDescription() {
        return this.description;
    }
    

    static void setRooms(HashMap<String, Room> map) {
        Room room = new Room("Detention Room", "Delinquent students are left for self reflection in this isolated space. There is nothing here except an old dusty carpet, and a large closet of left over supplies. The office is located to the east.");
        room.setExits("", "", "office", "");
        map.put("detention", room);

        room = new Room("Office", "Office space for staff and teachers to work. Various items are scattered on the table.");
        room.setExits("hallway", "", "", "");
        map.put("office", room);

        room = new Room("Hallway", "Main hallway of the school's ground floor, connecting the cafeteria and the main entrance. A stairwell is up ahead.");
        room.setExits("stair", " office", "caf", "entrance");
        map.put("hallway", room);

        room = new Room("Stairwell", "Stairs headed up to the second floor. However the doors are locked.");
        room.setExits("", "hallway", "", "");
        map.put("stair", room);

        room = new Room("Cafeteria", "The caf is empty now. Feels unusual compared to the loud and lively cafeteria you are used to. There is a fire exit to the south in case of an emergency.");
        room.setExits("", "fire", "", "hallway");
        map.put("caf", room);

        room = new Room("Fire Exit", "");
        room.setExits("caf", "", "", "");
        map.put("fire", room);

        room = new Room("Main Entrance", "You see the front lawn through the doors of the main foyer. Freedom is so close. Yet the doors are locked.");
        room.setExits("", "", "hallway", "");
        map.put("entrance", room);
    }
}
