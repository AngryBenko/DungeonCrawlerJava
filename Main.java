public class Main {
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    
    public static void main(String[] args) {
        /*// Creates game on a new thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameController g = new GameController(FRAME_WIDTH, FRAME_HEIGHT);
            }
        });*/
        GameController g = new GameController(FRAME_WIDTH, FRAME_HEIGHT);
    }
}
