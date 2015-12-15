package GUIStuff; // 04 Dec, 11:35 PM

import GUIStuff.screenpanels.SelectionScreen;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static final int WIDTH = 480;
    public static final int HEIGHT = 480;


    public JPanel rootP;

    public MainFrame(String title) {
        super(title);


        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rootP = new JPanel();
        rootP.setLayout(null);
        rootP.setName("root panel");

        SelectionScreen s = new SelectionScreen(this);
        rootP.add(s).setBounds(
                WIDTH/2 - (s.getFinalWidth()/2),
                HEIGHT/2 - (s.getFinalHeight()/2),
                s.getFinalWidth(),
                s.getFinalHeight()
        );

        add(rootP);
        setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
