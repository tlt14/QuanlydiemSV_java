import GUI.LoginGUI;

import java.awt.*;

public class MainClass {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    LoginGUI window = new LoginGUI();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
