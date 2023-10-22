/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javax.swing.ImageIcon;

/**
 *
 * @author julia
 */
public class BaldosaModel {
    private String estilo; 
    private ImageIcon imagen;
    
    
    
     public BaldosaModel(String estilo, String rutaImagen) {
        this.estilo = estilo;
        this.imagen = new ImageIcon(rutaImagen);
    }
     
       public ImageIcon getImagen() {
        return imagen;
    }

   
    
}
