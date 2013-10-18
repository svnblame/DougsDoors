package eDogDoor;

/**
 * Controls operation of a DogDoor
 * 
 * @author Gene Kelley <gene@bizflowdesigns.com>
 * @version 1.0
 */
public class Remote {
    
    private DogDoor door;
    
    public Remote(DogDoor door) {
        this.door = door;
    }
    
    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (door.isOpen()) {
            door.close();
        } else {
            door.open();
        }
    }
    
}
