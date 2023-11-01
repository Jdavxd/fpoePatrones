
package funcionalidadesAparte;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;

public class metodosImagen {
    public static ImageIcon establecerIcon(String rutaArchivo, int ancho, int alto)
            {
        
        String rutaAbsoluta = new File("").getAbsolutePath();
        ImageIcon imagen = new ImageIcon(rutaAbsoluta.concat(rutaArchivo));
        Image image = (imagen).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        
        return new ImageIcon(image);
    }
}
