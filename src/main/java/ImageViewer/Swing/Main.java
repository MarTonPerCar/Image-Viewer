package ImageViewer.Swing;

import ImageViewer.ImageReader;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> imagePaths = ImageReader.obtenerRutasImagenes("C:/Users/Mario/IdeaProjects/Image-Viewer/Imagenes");
        MainFrame frame = new MainFrame(imagePaths);
        frame.setVisible(true);
    }
}
