package textadventure;

import java.util.ArrayList;
import java.util.HashMap;

class Room {
	ArrayList<String> itemList = new ArrayList<>();
    private String name;
    private String description;
    private String n, s, e, w, u, d;
    private Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    void setExits(String n, String s, String e, String w, String u, String d) {
        this.n = n;
        this.s = s;
        this.e = e;
        this.w = w;
        this.u = u;
        this.d = d;
    }
    
    void setDesc (String desc) {
    	description = desc;
    }
    String getExit(char direction) {
        switch (direction) {
            case 'n': return n;
            case 's': return s;
            case 'e': return e;
            case 'w': return w;
            case 'u;: return u;
            case 'd': return d;
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
        Room room = new Room("Detention Room", "Delinquent students are left for self reflection in this isolated space. The office is located to the east, but behind a locked door");
        room.setExits("", "", "", "", "", "");
        map.put("detention", room);

        room = new Room("Office", "Office space for staff and teachers to work. There is a hallway to the north");
        room.setExits("hallway", "", "", "detention", "", "");
        map.put("office", room);

        room = new Room("Hallway", "Main hallway of the school's ground floor, connecting the cafeteria and the main entrance. A stairwell is up ahead.");
        room.setExits("stair", "office", "caf", "hallway2", "", "");
        map.put("hallway", room);
        
        room = new Room("Hallway", "School Hallway. There is another hallway to the east, the main entrance to the west. There are rooms to the north and south");
        room.setExits("grammar", "art", "hallway", "entrance", "", "");
        map.put("hallway2", room);
        
        room = new Room("Grammar Club", "Normal classroom lined with writings of madmen. On the whiteboard there are various writings containing lie and lay");
        room.setExits("", "hallway2", "", "", "", "");
        map.put("grammar", room);
        
        room = new Room("Art Room", "Pieces of art are plastered across the room. The easels are laid in a circle around the centre");
        room.setExits("hallway2", "", "", "", "", "");
        map.put("art", room);
        
        room = new Room("Stairwell", "Stairs headed up to the second floor. However the doors are locked.");
        room.setExits("", "hallway", "", "", "", "");
        map.put("stair", room);

        room = new Room("Cafeteria", "The caf is empty now. Feels unusual compared to the loud and lively cafeteria you are used to. There is a fire exit to the south in case of an emergency.");
        room.setExits("", "fire", "", "hallway", "", "");
        map.put("caf", room);

        room = new Room("Fire Exit", "");
        room.setExits("caf", "", "", "", "", "");
        map.put("fire", room);

        room = new Room("Main Entrance", "You see the front lawn through the doors of the main foyer. Freedom is so close. Yet the doors are locked.\nA small dent can be seen near the hinge of the door");
        room.setExits("", "", "hallway2", "", "", "");
        map.put("entrance", room);
    }
}
