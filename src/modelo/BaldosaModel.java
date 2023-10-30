/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author julia
 */
public class BaldosaModel {
    private ArrayList<Integer> baldosasOcultas;
    private ArrayList<Integer> baldosasAMostrar;
    private int numeroDeBaldosasAMostrar;
    private int vidas;
    private int puntaje;
    private int puntajeASumar;
    private double tiempoDeCambio;
    private int aciertos;
    private int errores;
    //constructor
    public BaldosaModel(){
        numeroDeBaldosasAMostrar = 3;
        vidas = 3;
        puntaje = 0;
        puntajeASumar = 5;
        tiempoDeCambio = 2;
        aciertos = 0;
        errores = 0;
        
        baldosasOcultas = new ArrayList<>();
        for(int i = 0; i<8; i++){
            baldosasOcultas.add(i);
        }
        
        baldosasAMostrar = new ArrayList<>();
        for(int i = 0; i<numeroDeBaldosasAMostrar; i++){
            int cualBaldosa = (int) (Math.random() * baldosasOcultas.size());
            baldosasAMostrar.add(baldosasOcultas.get(cualBaldosa));
            baldosasOcultas.remove(cualBaldosa);
        }
        
    }
    
    public boolean baldosaMostrandose(int cualNumero){
        return baldosasAMostrar.indexOf(cualNumero) != -1;
    }
    
    public int baldosaACambiar(){
        return baldosasAMostrar.get((int) (Math.random() *
                baldosasAMostrar.size()));
    }
    
    public ArrayList<Integer> getBaldosasAMostrar(){
        return baldosasAMostrar;
    }
    
    public void errorCometido(){
        vidas--;
        if(numeroDeBaldosasAMostrar > 3) {
        }
    }
    
    public int getVidas() {
        return vidas;
    }
    
       public void aumentarTiempoDeCambio() {
        if(tiempoDeCambio < 2){
            tiempoDeCambio += 0.2;
        }
        
    }
    
        public void disminuirTiempoDeCambio() {
        if(tiempoDeCambio > 1){
            tiempoDeCambio -= 0.2;
        }
        
    }
    
    public void reiniciarBaldosasSinMostrar(){
        baldosasOcultas.clear();
        for(int i = 0; i<8; i++){
            baldosasOcultas.add(i);
        }
    }
    
    public void nuevasBaldosasAMostrar() {
        reiniciarBaldosasSinMostrar();
        
        baldosasAMostrar.clear();
        for(int i = 0; i<numeroDeBaldosasAMostrar; i++){
            int cualBaldosa = (int) (Math.random() * baldosasOcultas.size());
            baldosasAMostrar.add(baldosasOcultas.get(cualBaldosa));
            baldosasOcultas.remove(cualBaldosa);
        }
        
    }
    
    public void aumentarBaldosasAMostrar(){
        if(numeroDeBaldosasAMostrar < 8) {
            numeroDeBaldosasAMostrar++;
        }
        
    }
    
    public void aumentarPuntaje(){
        puntaje += puntajeASumar;
    }
    
    public void aumentarPuntajeASumar(){
        puntajeASumar *= 2;
    }
    
    public int getPuntaje() {
        return puntaje;
    }
    
    public double getTiempoDeCambio() {
        return tiempoDeCambio;
    }
    
    public int getAciertos() {
        return aciertos;
    }
    
    public int getErrores() {
        return errores;
    }
    
    public void aumentarAciertos() {
        aciertos++;
    }
    
    public void aumentarErrores() {
        errores++;
    }
}
