package GUIStuff.screenpanels; // 05 Dec, 05:13 AM

import GUIStuff.MainFrame;

import javax.swing.*;

public class MyPanel extends JPanel {

    MainFrame mainFrame;

    public MyPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public int getFinalWidth(){
        return (int) getLayout().minimumLayoutSize(this).getWidth();
    }

    public int getFinalHeight(){
        return (int) getLayout().minimumLayoutSize(this).getHeight();
    }


    void moveToNextScreen(MyPanel mp){
        mainFrame.rootP.remove(this);
        mainFrame.rootP.add(mp).setBounds(
                MainFrame.WIDTH/2 - (mp.getFinalWidth()/2),
                MainFrame.HEIGHT/2 - (mp.getFinalHeight()/2),
                mp.getFinalWidth(),
                mp.getFinalHeight()
        );
        mainFrame.rootP.repaint();
        mainFrame.rootP.revalidate();
    }

    void justMoveToNextScreen(MyPanel mp){
        mainFrame.rootP.remove(this);
        mainFrame.rootP.add(mp);
//                MainFrame.WIDTH/2 - (mp.getFinalWidth()/2),
//                MainFrame.HEIGHT/2 - (mp.getFinalHeight()/2),
//                mp.getFinalWidth(),
//                mp.getFinalHeight()
//        );
        mainFrame.rootP.repaint();
        mainFrame.rootP.revalidate();
    }

}
