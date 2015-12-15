package GUIStuff.screenpanels; // 05 Dec, 04:51 AM

import GUIStuff.MainFrame;
import hangman.Difficulty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DifficultyScreen extends MyPanel {


    JButton opt1B, opt2B, opt3B, back;

    public DifficultyScreen(MainFrame mf) {
        super(mf);

        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));

        opt1B = new JButton("EASY");
        opt1B.setAlignmentX(Component.CENTER_ALIGNMENT);
        opt1B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayScreen.DIFFICULTY = Difficulty.EASY;
                justMoveToNextScreen(new PlayScreen(mainFrame));
            }
        });

        opt2B = new JButton("MEDIUM");
        opt2B.setAlignmentX(Component.CENTER_ALIGNMENT);
        opt2B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayScreen.DIFFICULTY = Difficulty.MEDIUM;
//                moveToNextScreen(new PlayScreen(mainFrame));
                justMoveToNextScreen(new PlayScreen(mainFrame));
            }
        });

        opt3B = new JButton("HARD");
        opt3B.setAlignmentX(Component.CENTER_ALIGNMENT);
        opt3B.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayScreen.DIFFICULTY = Difficulty.HARD;
//                moveToNextScreen(new PlayScreen(mainFrame));
                justMoveToNextScreen(new PlayScreen(mainFrame));
            }
        });

        back = new JButton("back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.rootP.remove(DifficultyScreen.this);
                SelectionScreen ds = new SelectionScreen(mainFrame);
                mainFrame.rootP.add(ds).setBounds(
                        MainFrame.WIDTH/2 - (ds.getFinalWidth()/2),
                        MainFrame.HEIGHT/2 - (ds.getFinalHeight()/2),
                        ds.getFinalWidth(),
                        ds.getFinalHeight()
                );
                mainFrame.rootP.repaint();
                mainFrame.rootP.revalidate();

            }
        });

        add(opt1B);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(opt2B);
        add(Box.createRigidArea(new Dimension(0,5)));
        add(opt3B);
        add(Box.createRigidArea(new Dimension(0,50)));
        add(back);
        add(Box.createRigidArea(new Dimension(0,5)));


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }


}
