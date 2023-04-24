package textadventure;

import java.util.HashMap;

public class Item {
	String examineText = "";
	String roomText = "";
	String useMethod = "";
	String revealText= "";
	String revealItem = "";
	String openTool = "";
	String itemContained = "";
	int strength = 0;
	boolean isCarryable = true;
	boolean containsItem = false;
	
	Item(String examineText) {
		this.examineText = examineText;
	}
	
	static void setItems(HashMap <String, Item> itemList, HashMap<String, Room> roomList) {
		 Item i = new Item("Moldy Sandwich");
	     i.roomText = "A modly sandwich lies on one of the tables";
	     i.examineText = "A sandwich which has some mold on it. Must not have been appetizing";
	     itemList.put("sandwich", i);
	     roomList.get("caf").itemList.add("sandwich");
	     
	     i = new Item("hammer");
	     i.roomText = "A hammer lies on the ground";
	     i.examineText = "A hammer used for construction. Looks like it can be used for other purposes aswell";
	     itemList.put("hammer", i);
	     roomList.get("grammar").itemList.add("hammer");
	     
	     i = new Item("sledgehammer");
	     i.roomText = "A sledgehammer lies in the centre of the room";
	     i.examineText = "It's a very big sledgehammer";
	     itemList.put("sledgehammer", i);
	     roomList.get("art").itemList.add("sledgehammer");
	     
	     i = new Item("Carpet");
	     i.roomText = "There's a dusty carpet on the ground";
	     i.examineText = "A carpet";
	     i.revealText = "The carpet moves off, revealing a shiny key";
	     i.revealItem = "key";
	     i.isCarryable = false;
	     itemList.put("carpet", i);
	     roomList.get("detention").itemList.add("carpet");
	     
	     i = new Item("Key");
	     i.examineText = "A shiny key, looks like it could be used somewhere";
	     i.roomText = "There is a shiny key on the ground";
	     itemList.put("key", i);
	}
	
	
	
}
