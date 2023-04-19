package textadventure;

import java.util.ArrayList;
import java.util.HashMap;

class Room {
	private ArrayList<String> itemList;
    private String name;
    private String description;
    private String n, s, e, w;

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
        Room room = new Room("Hallway", "This is the hallway");
        room.setExits("workshop", " office", "entrance", "caf");
        map.put("hallway", room);
    }
}
