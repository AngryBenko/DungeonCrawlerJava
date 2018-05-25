import java.util.Random;

public class DungeonRoom {
    // rand.nextInt(x) + 1 is inclusive of x;
    // but rand.nextInt(x) is not inclusive of x;
    private Random rand = new Random();
    private boolean roomCleared;
    private boolean activeRoom;
    private boolean finalRoom;
    private final int roomNumber;
    private int maxEnemies;

    public DungeonRoom(int roomNumber, boolean roomCleared, boolean activeRoom, boolean finalRoom) {
        this.roomNumber = roomNumber;
        this.roomCleared = roomCleared;
        this.activeRoom = activeRoom;
        this.finalRoom = finalRoom;
        setMaxEnemies(this.finalRoom);
        System.out.println("Max enemies: " + maxEnemies);
    }

    public void setActiveRoom(boolean value) {
        activeRoom = value;
    }
    public void setCleared(boolean value) {
        roomCleared = value;
    }
    public boolean getActiveRoom() { return activeRoom; }
    public boolean getCleared() { return roomCleared; }
    public int getRoomNumber() { return roomNumber; }
    public int getMaxEnemies() { return maxEnemies; }
    private void setMaxEnemies(boolean value) {
        if(value) {
            maxEnemies = 1;
        } else {
            maxEnemies = rand.nextInt(4) + 1;
            //maxEnemies = 4;
        }        
    }
}