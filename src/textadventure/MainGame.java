package textadventure;

import java.util.Scanner;

public class MainGame {

	public static void main(String[] args) {
		System.out.println("Hello world");

        Scanner input = new Scanner(System.in);
        String word;
		
        while (true) {
            word = input.nextLine();
            String[] words = word.split("\\s");

            for (int i=0; i<words.length; i++) {
                words[i] = words[i].toLowerCase();
            }
            
            switch (words[0]) {
                case "n": case "north": case "s": case "south": case: "e": case "east": case "w": case "west":
                    moveToRoom(words[0]);
                    break;
            
                default:
                    break;
            }
        }
	}

    void moveToRoom() {
        
    }
}
