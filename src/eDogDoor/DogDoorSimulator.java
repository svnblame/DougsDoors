package eDogDoor;

/**
 * Tests operation of a DogDoor
 * 
 * @author Gene Kelley <gene@bizflowdesigns.com>
 * @version 1.0
 */
public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        door.addAllowedBark(new Bark("rowlf"));
        door.addAllowedBark(new Bark("rooowlf"));
        door.addAllowedBark(new Bark("rawlf"));
        door.addAllowedBark(new Bark("woof"));
        // Create a BarkRecognizer, connect it to the door, and have
        // it listen for barking
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);  
        
        // Simulate the hardware hearing a bark
        System.out.println("Bruce starts barking.");
        recognizer.recognize(new Bark("rowlf"));
        
        System.out.println("\nBruce has gone outside...");
        
        try {
        	// Simulate time passing as Fido takes care of his business :-)
            Thread.currentThread().sleep(10000);
        } catch(InterruptedException e) { }
        
        System.out.println("\nBruce is all done...");
        System.out.println("...but he's stuck outside!");
        
        // Simulate the hardware hearing a bark (not Bruce!)
        Bark smallDogBark = new Bark("yip");
        System.out.println("A small dog starts barking.");
        recognizer.recognize(smallDogBark);
        
        try {
        	// Simulate time passing as Fido takes care of his business :-)
            Thread.currentThread().sleep(5000);
        } catch(InterruptedException e) { }
        
        // Simulate the hardware hearing a bark again
        System.out.println("Bruce starts barking");
        recognizer.recognize(new Bark("rooowlf"));
        
        System.out.println("\nBruce's back inside...");
    }
}
