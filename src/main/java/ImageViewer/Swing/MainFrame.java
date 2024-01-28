package ImageViewer.Swing;

import ImageViewer.BaseImage;
import ImageViewer.Image;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MainFrame extends JFrame implements Image{
    private int actualValue = 0;
    JButton botonPrev = new JButton("Prev");
    JButton botonNext = new JButton("Next");
    JLabel imageLabel = new JLabel();

    public MainFrame(List<String> iP)  {
        this.setTitle("Image Viewer");
        this.setSize(720,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.lightGray);
        panel.setBorder(new EmptyBorder(10, 0, 0, 0));

        agregarBotones(panel);
        agregarAccion(iP, panel);

        nuevoLabel(iP, actualValue, panel);

        add(panel);
    }

    private void nuevoLabel(List<String> iP, int imagen, JPanel panel) {
        ImageIcon imageIcon = new ImageIcon(iP.get(imagen));
        JLabel imageLabel = new JLabel(imageIcon);
        panel.add(imageLabel, BorderLayout.NORTH);
    }

    private void agregarBotones(JPanel panel) {
        botonPrev.setPreferredSize(new Dimension(210, 30));
        botonNext.setPreferredSize(new Dimension(210, 30));

        JPanel panelBotones = new JPanel(new BorderLayout());
        panelBotones.setBackground(Color.lightGray);

        panelBotones.add(botonPrev, BorderLayout.WEST);
        panelBotones.add(botonNext, BorderLayout.EAST);
        panel.add(panelBotones, BorderLayout.SOUTH);
    }

    private void agregarAccion(List<String> ListImage, JPanel panel) {
        ActionListener actionPrev = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prev(ListImage.size());
                nuevoLabel(ListImage, actualValue, panel);
                System.out.println(actualValue);
            }
        };
        ActionListener actionNext = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                next(ListImage.size());
                nuevoLabel(ListImage, actualValue, panel);
                System.out.println(actualValue);
            }
        };

        botonPrev.addActionListener(actionPrev);
        botonNext.addActionListener(actionNext);
    }

    @Override
    public void next(int value) {
        if (actualValue < (value - 1)) {
            actualValue += 1;
        } else {
            actualValue = 0;
        }
    }

    @Override
    public void prev(int value) {
        if (actualValue > 0) {
            actualValue -= 1;
        } else {
            actualValue = 2;
        }
    }
}
