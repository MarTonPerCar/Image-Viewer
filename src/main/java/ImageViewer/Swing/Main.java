package ImageViewer.Swing;

import ImageViewer.BaseImage;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] imagePaths = {
                "C:/Users/Mario/IdeaProjects/Image-Viewver/Imagenes/Araña1030.jpg",
                "C:/Users/Mario/IdeaProjects/Image-Viewer2/Imagenes/Caballo909.jpg",
                "C:/Users/Mario/IdeaProjects/Image-Viewver/Imagenes/Oveja1017.jpg"};
        List<BaseImage> imagenes = CrearImagenes(imagePaths);
        MainFrame frame = new MainFrame(imagenes);
        frame.setVisible(true);
    }

    private static List<BaseImage> CrearImagenes(String[] iP) {
        List<BaseImage> ListaImagenes = new ArrayList<BaseImage>();
        for (int i = 0; i <= (iP.length - 1); i++) {
            ListaImagenes.add(
                    new BaseImage(
                            i,
                            iP[i]
                    )
            );
        }
        return ListaImagenes;
    }
}
