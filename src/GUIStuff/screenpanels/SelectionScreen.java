package GUIStuff.screenpanels; // 05 Dec, 03:53 AM

import GUIStuff.MainFrame;
import hangman.NamesLibrary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectionScreen extends MyPanel {

    JButton opt1B, opt2B, opt3B, opt4B;

    public SelectionScreen(MainFrame mf) {
        super(mf);

        mainFrame = mf;
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        opt1B = new JButton("Bollywood");
        opt1B.setAlignmentX(Component.CENTER_ALIGNMENT);
        opt1B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moveToNextScreen(new DifficultyScreen(mainFrame));
                PlayScreen.OPTION = NamesLibrary.BOLLYWOOD;
            }
        });

        opt2B = new JButton("Hollywood");
        opt2B.setAlignmentX(Component.CENTER_ALIGNMENT);
        opt2B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moveToNextScreen(new DifficultyScreen(mainFrame));
                PlayScreen.OPTION = NamesLibrary.HOLLYWOOD;

            }
        });

        opt3B = new JButton("option 3");
        opt3B.setAlignmentX(Component.CENTER_ALIGNMENT);
        opt3B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                moveToNextScreen(new DifficultyScreen(mainFrame));
                PlayScreen.OPTION = NamesLibrary.OTHER;
            }
        });


        add(opt1B);
        add(Box.createRigidArea(new Dimension(0,5)));
        add(opt2B);
        add(Box.createRigidArea(new Dimension(0,5)));
        add(opt3B);
        add(Box.createRigidArea(new Dimension(0,5)));


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }


}
