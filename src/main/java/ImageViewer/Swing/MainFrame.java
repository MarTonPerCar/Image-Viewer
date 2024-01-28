package ImageViewer.Swing;

import ImageViewer.BaseImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    public MainFrame(List<BaseImage> iP)  {
        this.setTitle("Image Viewer");
        this.setSize(600,700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 0, 0, 0));
        nuevoLabel(iP, 0, panel);
    }

    private void nuevoLabel(List<BaseImage> iP, int imagen, JPanel panel) {
        ImageIcon imageIcon = new ImageIcon(iP.get(imagen).path());
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.NORTH);
        add(panel);
    }
}
