import GUIStuff.MainFrame;

public class MainLauncher implements Runnable {


    public static void main(String[] args) {

        Thread jabardasthiDalaHuaThread = new Thread(new MainLauncher());
        jabardasthiDalaHuaThread.start();

    }

    @Override
    public void run() {
        new MainFrame("Hangman");
    }
}
