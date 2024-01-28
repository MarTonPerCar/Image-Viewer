package ImageViewer.Swing;

import ImageViewer.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainFrame extends JFrame implements Image{
    private int actualValue = 0;
    JButton botonPrev = new JButton("Prev");
    JButton botonNext = new JButton("Next");
    JLabel imageLabel = new JLabel();

    public MainFrame(List<String> iP)  {
        this.setTitle("Image Viewer");
        this.setSize(520,420);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.lightGray);

        agregarBotones(panel);
        agregarAccion(iP, panel);
        nuevoLabel(iP.get(actualValue), panel);
    }

    public void nuevoLabel(String imagePath, JPanel panel) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            java.awt.Image resizedImage = originalImage.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            if (imageLabel != null) {
                panel.remove(imageLabel);
            }
            imageLabel = new JLabel(resizedIcon);
            imageLabel.setBounds(0, 0, resizedIcon.getIconWidth(), resizedIcon.getIconHeight());
            imageLabel.setLocation(30, 80);

            panel.add(imageLabel);
            panel.revalidate();
            panel.repaint();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void agregarBotones(JPanel panel) {
        botonNext.setBounds(280, 120, 200, 60);
        botonPrev.setBounds(280, 190, 200, 60);

        panel.add(botonNext);
        panel.add(botonPrev);

        add(panel);
    }

    private void agregarAccion(List<String> ListImage, JPanel panel) {
        ActionListener actionPrev = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prev(ListImage.size());
                nuevoLabel(ListImage.get(actualValue), panel);
            }
        };
        ActionListener actionNext = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                next(ListImage.size());
                nuevoLabel(ListImage.get(actualValue), panel);
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
