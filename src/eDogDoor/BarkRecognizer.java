package eDogDoor;

import java.util.Iterator;
import java.util.List;

public class BarkRecognizer {
    // Store the dog door that this bark recognizer is attached to
    private DogDoor door;
    
    // Constructor needs to know which door it will open
    public BarkRecognizer(DogDoor door) {
        this.door = door;
    }
    
    // Every time the hardware hears a bark, it will call this method
    // with the sound of the bark it heard
    public void recognize(Bark bark) {
        System.out.println("   BarkRecognizer: Heard a `" + 
        		bark.getSound() + "`");
        List allowedBarks = door.getAllowedBarks();
        for (Iterator i = allowedBarks.iterator(); i.hasNext(); ) {
        	Bark allowedBark = (Bark)i.next();
        	if (allowedBark.equals(bark)) {
        		door.open();
        		return;
        	}
        }
        System.out.println("This dog is not allowed.");
    }
}
