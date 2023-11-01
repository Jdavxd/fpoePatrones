
package controlador;

import funcionalidadesAparte.metodosImagen;
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
            
            baldosa = metodosImagen.establecerIcon(nuevaRuta, anchoBaldosa, altoBaldosa);
            listaDeBaldosas.add(baldosa);
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
