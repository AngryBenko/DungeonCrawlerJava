import java.util.Random;

public class DungeonRoom {
    // rand.nextInt(x) + 1 is inclusive of x;
    // but rand.nextInt(x) is not inclusive of x;
    private Random rand = new Random();
    private boolean roomCleared;
    private boolean activeRoom;
    private final int roomNumber;
    private final int maxEnemies;

    public DungeonRoom(int roomNumber, boolean roomCleared, boolean activeRoom) {
        this.roomNumber = roomNumber;
        this.roomCleared = roomCleared;
        this.activeRoom = activeRoom;
        maxEnemies = rand.nextInt(4) + 1;
        //maxEnemies = 1;
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
    public boolean isFinalRoom(int num) {
        if(roomNumber == num) {
            return true;
        }
        return false;
    }
}