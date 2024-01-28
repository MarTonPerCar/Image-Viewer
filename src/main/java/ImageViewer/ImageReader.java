package ImageViewer;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageReader {

    public static List<String> obtenerRutasImagenes(String directorio) {
        List<String> rutasImagenes = new ArrayList<>();
        File carpeta = new File(directorio);

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
            List<String> extensionesImagenes = Arrays.asList("jpg", "jpeg", "png");
            for (File archivo : archivos) {
                if (archivo.isFile() && esImagen(archivo, extensionesImagenes)) {
                    rutasImagenes.add(archivo.getAbsolutePath());
                }
            }
        }
        return rutasImagenes;
    }

    private static boolean esImagen(File archivo, List<String> extensionesImagenes) {
        for (String extension : extensionesImagenes) {
            if (archivo.getName().toLowerCase().endsWith("." + extension)) {
                return true;
            }
        }
        return false;
    }
}
