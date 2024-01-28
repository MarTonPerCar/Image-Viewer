package ImageViewer.Swing;

import ImageViewer.BaseImage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    public MainFrame(List<BaseImage> iP)  {
        this.setTitle("Image Viewer");
        this.setSize(520,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.lightGray);
        panel.setBorder(new EmptyBorder(10, 0, 0, 0));

        nuevoLabel(iP, 0, panel);
        agregarBotones(panel);

        add(panel);
    }

    private void nuevoLabel(List<BaseImage> iP, int imagen, JPanel panel) {
        ImageIcon imageIcon = new ImageIcon(iP.get(imagen).path());
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.NORTH);
    }

    private void agregarBotones(JPanel panel) {
        JButton botonIzquierdo = new JButton("Prev");
        JButton botonDerecho = new JButton("Next");

        botonIzquierdo.setPreferredSize(new Dimension(210, 30));
        botonDerecho.setPreferredSize(new Dimension(210, 30));

        JPanel panelBotones = new JPanel(new BorderLayout());
        panelBotones.setBackground(Color.lightGray);

        panelBotones.add(botonIzquierdo, BorderLayout.WEST);
        panelBotones.add(botonDerecho, BorderLayout.EAST);
        panel.add(panelBotones, BorderLayout.SOUTH);
    }
}
