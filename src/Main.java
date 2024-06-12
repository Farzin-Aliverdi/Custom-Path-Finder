import Swing.Panels.MainFrame;

public class Main{
    public static void main(String[] args) {
        MainFrame app = new MainFrame();
        app.initialize();
        app.run();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
