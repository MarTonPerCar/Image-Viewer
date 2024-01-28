package ImageViewer.Swing;

import ImageViewer.BaseImage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> imagePaths = ImageReader.obtenerRutasImagenes("C:/Users/Mario/IdeaProjects/Image-Viewer/Imagenes");
        MainFrame frame = new MainFrame(imagePaths);
        frame.setVisible(true);
    }
}
