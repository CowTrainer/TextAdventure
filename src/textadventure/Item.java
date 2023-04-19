package textadventure;

import java.util.HashMap;

public class Item {
	String examineText = "";
	String roomText = "";
	String useMethod = "";
	String revealMethod = "";
	String revealText= "";
	String revealItem = "";
	String openTool = "";
	String itemContained = "";
	int strength = 0;
	boolean isCarryable = true;
	boolean containsItem = false;
	boolean isDoor = false;
	boolean isOpen = false;
	
	Item(String examineText) {
		this.examineText = examineText;
	}
	
	static void setItems(HashMap <String, Item> itemList, HashMap<String, Room> roomList) {
		
	}
	
	
	
}
