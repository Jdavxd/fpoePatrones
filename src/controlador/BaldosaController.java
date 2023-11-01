
package controlador;

import funcionalidadesAparte.metodosImagen;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *@author Julian Rengifo 2241016
 *@author Genaro Vegas 2241850
 * Clase que funciona como controlador de las imagenes de las baldosas
 */
public class BaldosaController {

    private ArrayList<ImageIcon> listaDeBaldosas;
    private final int altoBaldosa = 80;
    private final int anchoBaldosa = 80;

    //constructor
    public BaldosaController() {
        listaDeBaldosas = new ArrayList<>();
        inicializarBaldosas();
    }

    private void inicializarBaldosas() {
        ImageIcon baldosa;
        String rutaAux = "\\src\\imagenes\\baldosas\\numero.png";

        for (int i = 1; i <= 14; i++) {
            
            String nuevaRuta = rutaAux.replace("numero",i+"");
            
            baldosa = metodosUtiles.establecerIcon(nuevaRuta, anchoBaldosa, altoBaldosa);
            listaDeBaldosas.add(baldosa);
        }

    }
    public class metodosUtiles {
        public static ImageIcon establecerIcon(String rutaArchivo, int ancho, int alto)
            {
        
        String rutaAbsoluta = new File("").getAbsolutePath();
        ImageIcon imagen = new ImageIcon(rutaAbsoluta.concat(rutaArchivo));
        Image image = (imagen).getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        
        return new ImageIcon(image);
    }
}


    
    public ImageIcon getImgBaldosa(int cualBaldosa){
        return listaDeBaldosas.get(cualBaldosa);
    }
    
    public ImageIcon getImgBaldosaAleatoria(){
        return listaDeBaldosas.get((int) (Math.random() * 
                listaDeBaldosas.size()));
    }

}
