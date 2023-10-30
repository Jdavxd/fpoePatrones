/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 *
 * @author julia rengifo
 */
public class BaldosaController {
    
    private ArrayList<ImageIcon> listaDeBaldosas;
    private final int altoBaldosa = 100;
    private final int anchoBaldosa = 100;
    
    
    
    
    public BaldosaController() {
        listaDeBaldosas = new ArrayList<>();
        inicializarBaldosas();
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

    
       private void inicializarBaldosas() {
        ImageIcon baldosa;
        String rutaAux = "\\src\\img\\imagen.jpg";

        for (int i = 1; i <= 14; i++) {
            
            String nuevaRuta = rutaAux.replace("imagen",i+"");
            
            baldosa = metodosUtiles.establecerIcon(nuevaRuta, anchoBaldosa, altoBaldosa);
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
