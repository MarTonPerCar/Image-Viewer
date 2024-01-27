package ImageViewer.Swing;

public class Main {
    public static void main(String[] args) {
        String[] imagePaths = {
                "C:/Users/Mario/IdeaProjects/Image-Viewver/Imagenes/Araña1030.jpg",
                "C:/Users/Mario/IdeaProjects/Image-Viewer2/Imagenes/Caballo909.jpg",
                "C:/Users/Mario/IdeaProjects/Image-Viewver/Imagenes/Oveja1017.jpg"};
        MainFrame frame = new MainFrame(imagePaths);
        frame.setVisible(true);
    }
}
