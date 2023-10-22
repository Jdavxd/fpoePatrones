/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author julia
 */
public class UsuarioModel {
    private int puntos = 0;
    private int vidas = 3;
    private int aciertos = 0;
    
    

    
    public int getVidas() {
      return vidas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void restarVida() {
        vidas--;
    }

    public void sumarPuntos() {
        puntos++;
    }
    
    public void getAciertos(){
        aciertos++;
    }

    
    
    
}




