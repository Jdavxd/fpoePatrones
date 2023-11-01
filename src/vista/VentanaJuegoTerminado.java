package vista;

import funcionalidadesAparte.Boton;
import funcionalidadesAparte.metodosImagen;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import modelo.BaldosaModel;

/**
 *@author Julian Rengifo 2241016
 *@author Genaro Vegas 2241850
 */
public class VentanaJuegoTerminado extends JFrame {

    //rutaAbsoluta
    private String rutaAbsoluta;

    //dimensiones de la ventana
    private int ancho;
    private int largo;

    //btn
    private JButton btnJugar;

    //labelFondo
    private JLabel lblFondo;

    //labels
    private JLabel lblImgPuntaje;
    private JLabel lblImgErrores;
    private JLabel lblImgAciertos;
    private JLabel lblFinDelJuego;

    private JLabel lblPuntaje;
    private JLabel lblErrores;
    private JLabel lblAciertos;

    //contenedor principal
    private Container contPrincipal;

    //logica(de aqui se obtienen las estadisticas)
    private BaldosaModel logica;

    //contructor
    public VentanaJuegoTerminado(BaldosaModel logica) {
        ancho = 700;
        largo = 500;

        this.logica = logica;

        setSize(ancho, largo);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Adosa");
        setResizable(false);

        inciarComponentes();
    }

    //
    private void inciarComponentes() {
        //Ruta absoluta//
        rutaAbsoluta = new File("").getAbsolutePath();

        //lblFondo//
        lblFondo = new JLabel(metodosImagen.
                establecerIcon("\\src\\imagenes\\fondo.jpg",
                ancho, largo));
        lblFondo.setBounds(0, 0, ancho, largo);

        //lbls (imgs)//
        lblFinDelJuego = new JLabel(metodosImagen.
        establecerIcon("\\src\\imagenes\\imgJuegoTerminado.png", ancho - 50, 90));
        lblFinDelJuego.setBounds(20, 30, ancho - 50, 90);

        lblImgAciertos = new JLabel(metodosImagen.
                establecerIcon("\\src\\imagenes\\imgAciertos.png", 300, 75));
        lblImgAciertos.setBounds(100, 130, 300, 75);

        lblImgErrores = new JLabel(metodosImagen.
                establecerIcon("\\src\\imagenes\\imgFallos.png", 300, 75));
        lblImgErrores.setBounds(100, 210, 300, 75);

        lblImgPuntaje = new JLabel(metodosImagen.
                establecerIcon("\\src\\imagenes\\imgPuntaje.png", 300, 80));
        lblImgPuntaje.setBounds(100, 290, 300, 80);

        //lbls (texto estadisiticas)//
        lblPuntaje = new JLabel(logica.getPuntaje() + "");
        lblPuntaje.setFont(new Font("Serif", Font.PLAIN, 60));
        lblPuntaje.setBounds(420, 305, 300, 50);

        lblAciertos = new JLabel(logica.getAciertos() + "");
        lblAciertos.setFont(new Font("Serif", Font.PLAIN, 60));
        lblAciertos.setBounds(420, 145, 220, 50);

        lblErrores = new JLabel(logica.getErrores() + "");
        lblErrores.setFont(new Font("Serif", Font.PLAIN, 60));
        lblErrores.setBounds(420, 228, 220, 50);

        //btnJugar//
        
        btnJugar = new Boton();
        btnJugar.setIcon(metodosImagen.
                establecerIcon("", 300, 75));
        btnJugar.setBounds(200, 380, 300, 75);
        btnJugar.setRolloverIcon(metodosImagen.
                establecerIcon("", 300, 75));
        
        btnJugar.addActionListener(new ManejadorDeEventos());

        //contPrincipal//
        contPrincipal = getContentPane();
        contPrincipal.setLayout(null);
        contPrincipal.add(lblFondo);

        lblFondo.add(lblPuntaje);
        lblFondo.add(lblAciertos);
        lblFondo.add(lblErrores);

        lblFondo.add(lblFinDelJuego);
        lblFondo.add(lblImgAciertos);
        lblFondo.add(lblImgErrores);
        lblFondo.add(lblImgPuntaje);

        lblFondo.add(btnJugar);

    }
//*************************************CLASES*******************************//

    //clase majnejadorea de eventos (btnJugar)
    private class ManejadorDeEventos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            VentanaInicial ventanaInicial = new VentanaInicial(0);
        }

    }
}