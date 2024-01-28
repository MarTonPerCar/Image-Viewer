package ImageViewer.Swing;

import ImageViewer.Image;
import ImageViewer.ImageReader;

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
    JButton botonDirectory = new JButton("Change Directory");
    JLabel imageLabel = new JLabel();

    public MainFrame()  {
        this.setTitle("Image Viewer");
        this.setSize(520,420);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        String defaultDirectory = "C:/Users/Mario/IdeaProjects/Image-Viewer/Imagenes";
        inicializarComponentes(defaultDirectory);
    }

    private void inicializarComponentes(String defaultDirectory) {
        List<String> imagePaths = ImageReader.obtenerRutasImagenes(defaultDirectory);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.lightGray);

        agregarBotones(panel);
        agregarAccion(imagePaths, panel);
        nuevoLabel(imagePaths.get(actualValue), panel);
    }

    private void nuevoLabel(String imagePath, JPanel panel) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            java.awt.Image resizedImage = originalImage.getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(resizedImage);

            if (imageLabel != null) {
                panel.remove(imageLabel);
            }
            imageLabel = new JLabel(resizedIcon);
            imageLabel.setBounds(0, 0, resizedIcon.getIconWidth(), resizedIcon.getIconHeight());
            imageLabel.setLocation(10, 60);

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
        botonDirectory.setBounds(310, 80, 130, 30);

        customizeButton(botonNext);
        customizeButton(botonPrev);
        customizeButton(botonDirectory);

        panel.add(botonNext);
        panel.add(botonPrev);
        panel.add(botonDirectory);

        add(panel);
    }

    private void agregarAccion(List<String> ListImage, JPanel panel) {
        if (botonPrev.getActionListeners().length != 0) {
            botonPrev.removeActionListener(botonPrev.getActionListeners()[0]);
            botonNext.removeActionListener(botonNext.getActionListeners()[0]);
            botonDirectory.removeActionListener(botonDirectory.getActionListeners()[0]);
        }
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

        ActionListener actionDirectory = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newDirectory = chooseDirectory();
                if (newDirectory != null) {
                    actualValue = 0;
                    inicializarComponentes(newDirectory);
                }
            }
        };

        botonPrev.addActionListener(actionPrev);
        botonNext.addActionListener(actionNext);
        botonDirectory.addActionListener(actionDirectory);
    }

    private void customizeButton(JButton button) {
        button.setBackground(new Color(60, 179, 113));
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setFont(new Font("Arial", Font.BOLD, 14));
    }

    private String chooseDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectoryFile = fileChooser.getSelectedFile();
            String selectedDirectory = selectedDirectoryFile.getAbsolutePath();
            return selectedDirectory;
        } else {
            JOptionPane.showMessageDialog(this, "Este directorio no se puede usar");
            return null;
        }
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
            actualValue = (value - 1);
        }
    }
}