package eDogDoor;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class represents the dog door that will interface
 * with custom door hardware.
 * @author Gene Kelley <gene@bizflowdesigns.com>
 * @version 1.0
 */
public class DogDoor {
    private boolean open;
    private List allowedBarks;
    
    public DogDoor() {
    	this.allowedBarks = new LinkedList();
        this.open = false;
    }
    
    public void addAllowedBark(Bark bark) {
    	allowedBarks.add(bark);
    }
    
    public List getAllowedBarks() {
    	return allowedBarks;
    }
    
    /**
     * Opens the door
     */
    public void open() {
        System.out.println("The dog door opens.");
        open = true;
        
        // Have the dog door close automatically after a period of time
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                // Now, the DogDoor handles closing itself no matter what 
                // device sends signal to open it. (Eliminates need for 
                // duplicate code)
                close();
                timer.cancel();
            }
        }, 5000);
    }
    
    /**
     * Closes the door
     */
    public void close() {
        System.out.println("The dog door closes.");
        open = false;
    }
    
    /**
     * Returns the state of the door
     * true:open, false:closed
     * @return boolean
     */
    public boolean isOpen() {
        return open;
    }
}
