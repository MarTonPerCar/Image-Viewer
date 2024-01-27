package ImageViewer.Swing;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(String[] iP)  {
        this.setTitle("Image Viewer");
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
