package GUIStuff.screenpanels; // 05 Dec, 05:39 AM

import GUIStuff.MainFrame;
import hangman.WordFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayScreen extends MyPanel {

    public static int OPTION;
    public static int DIFFICULTY;

    String originalWord;
    String selectedWord;
    char[] selectedWordArray;

    JComponent[] components;
    JTextArea[] textAreaArray;
    JLabel[]    labelArray;
    Font font = new Font("Courier New", Font.BOLD, 30);

    JPanel letterHolder, hangmanHolder;

    JButton back;

    // Hangman body parts
    int       currectGuess  = 0;
    boolean   isWrong       = false;
    int       bodyPartIndex = -1;
    boolean[] drawBodyParts = {
            false,// head
            false,// stomach
            false,// right hand
            false,// left hand
            false,// right leg
            false// left leg
    };

    public PlayScreen(MainFrame mf) {
        super(mf);

        setLayout(new BorderLayout(5, 5));
        setSize(MainFrame.WIDTH, MainFrame.HEIGHT);
        setBorder(BorderFactory.createTitledBorder("Main PAnel"));

        letterHolder = new JPanel();


        // This responsible for generated the word according to the difficulty & option selected
        // and then generate missing lettered word from selected word
        final WordFactory wordFactory = new WordFactory();

        originalWord = wordFactory.generateWord(DIFFICULTY, OPTION);


        selectedWordArray = wordFactory.finalWordToGuessFrom(originalWord, DIFFICULTY);
        selectedWord = String.valueOf(selectedWordArray);


        components = new JComponent[selectedWordArray.length];
        textAreaArray = new JTextArea[selectedWordArray.length];
        labelArray = new JLabel[selectedWordArray.length];
        for (int i = 0; i < selectedWordArray.length; i++) {

            if (selectedWordArray[i] == '_') {
//                textAreaArray[i] = new JTextArea(String.valueOf(originalWord.charAt(i)));
                textAreaArray[i] = new JTextArea();
                textAreaArray[i].setPreferredSize(new Dimension(30, 30));
                textAreaArray[i].setFont(font);
                final int finalI = i;
                textAreaArray[i].addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        if (e.getKeyCode() != KeyEvent.VK_SPACE) {

                            textAreaArray[finalI].setText(null);
                            String text = String.valueOf(e.getKeyChar()).toUpperCase();
                            textAreaArray[finalI].setEditable(false);

                            if (String.valueOf(e.getKeyChar()).compareToIgnoreCase(String.valueOf(originalWord.charAt(finalI))) == 0) {

                                // CORRECT
                                currectGuess++;
                                isWrong = false;

                                textAreaArray[finalI].setText(text);
                            } else {

                                // WRONG

                                isWrong = true;
                                textAreaArray[finalI].setEditable(true);
                                textAreaArray[finalI].setText(null);
                                bodyPartIndex++;
                                drawBodyParts[bodyPartIndex] = true;
                                repaint();
                            }

                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        if (!isWrong) {
                            textAreaArray[finalI].setText(textAreaArray[finalI].getText().toUpperCase());
                            textAreaArray[finalI].setEnabled(false);
                        } else {
                            textAreaArray[finalI].setText(null);
                        }

                        if(bodyPartIndex >= 5){
                            // game over
                            mainFrame.rootP.remove(PlayScreen.this);
                            SelectionScreen ds = new SelectionScreen(mainFrame);
                            mainFrame.rootP.add(ds).setBounds(
                                    MainFrame.WIDTH / 2 - (ds.getFinalWidth() / 2),
                                    MainFrame.HEIGHT / 2 - (ds.getFinalHeight() / 2),
                                    ds.getFinalWidth(),
                                    ds.getFinalHeight()
                            );
                            mainFrame.rootP.repaint();
                            mainFrame.rootP.revalidate();
                            System.out.println("Lol!\nThe word was: " + originalWord);
                        }

                        if(currectGuess == wordFactory.missingLetters){

                            mainFrame.rootP.remove(PlayScreen.this);
                            SelectionScreen ds = new SelectionScreen(mainFrame);
                            mainFrame.rootP.add(ds).setBounds(
                                    MainFrame.WIDTH / 2 - (ds.getFinalWidth() / 2),
                                    MainFrame.HEIGHT / 2 - (ds.getFinalHeight() / 2),
                                    ds.getFinalWidth(),
                                    ds.getFinalHeight()
                            );
                            mainFrame.rootP.repaint();
                            mainFrame.rootP.revalidate();
                            System.out.println("WoooHooo!");
                        }

                    }
                });
                letterHolder.add(textAreaArray[i]);
                components[i] = textAreaArray[i];
            } else {

                labelArray[i] = new JLabel(String.valueOf(selectedWordArray[i]));
                labelArray[i].setPreferredSize(new Dimension(30, 30));
                labelArray[i].setFont(font);
                letterHolder.add(labelArray[i]);
                components[i] = labelArray[i];
            }



        }

        letterHolder.setBorder(BorderFactory.createTitledBorder("Letters"));

        hangmanHolder = new JPanel();
        hangmanHolder.setLayout(null);
        hangmanHolder.setPreferredSize(new Dimension(200, 200));
        hangmanHolder.setBorder(BorderFactory.createTitledBorder("hangman"));


        back = new JButton("back");
//        back.setPreferredSize(new Dimension(100,20));
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainFrame.rootP.remove(PlayScreen.this);
                SelectionScreen ds = new SelectionScreen(mainFrame);
                mainFrame.rootP.add(ds).setBounds(
                        MainFrame.WIDTH / 2 - (ds.getFinalWidth() / 2),
                        MainFrame.HEIGHT / 2 - (ds.getFinalHeight() / 2),
                        ds.getFinalWidth(),
                        ds.getFinalHeight()
                );
                mainFrame.rootP.repaint();
                mainFrame.rootP.revalidate();

            }
        });

        hangmanHolder.add(back).setBounds(500, 20, 50, 20);

        add(hangmanHolder, BorderLayout.NORTH);
        add(back, BorderLayout.WEST);
        add(letterHolder, BorderLayout.CENTER);
        add(new JPanel(), BorderLayout.SOUTH);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (drawBodyParts[0]) {
            g.drawOval(50, 50, 50, 50);// head
        }
        if (drawBodyParts[1]) {
            g.drawLine(75, 100, 75, 150);// stomach
        }
        if (drawBodyParts[2]) {
            g.drawLine(75, 110, 50, 130);// left arm
        }
        if (drawBodyParts[3]) {
            g.drawLine(75, 110, 100, 130);// right arm
        }
        if (drawBodyParts[4]) {
            g.drawLine(75, 150, 50, 170);// left leg
        }
        if (drawBodyParts[5]) {
            g.drawLine(75, 150, 100, 170);// right leg
        }

    }

    String setFontSize(int size, char c) {
        return "<html>" +
                "<span style='font-size:" + size + "px'>" +
                String.valueOf(c) +
                "</span>" +
                "</html>";
    }

}
