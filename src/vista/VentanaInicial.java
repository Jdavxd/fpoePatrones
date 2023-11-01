
package vista;

import funcionalidadesAparte.Boton;
import funcionalidadesAparte.metodosImagen;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *@author Julian Rengifo 2241016
 *@author Genaro Vegas 2241850
 */
public class VentanaInicial extends JFrame {
    //Sonido
    private File archivowav;
    private Clip clip;
    private AudioInputStream audioInputStream;
    private boolean pasoVentana;

    //opcion
    private int opcion;

    //timer
    private Timer tiempo;

    //Ruta absoluta
    private String rutaAbsoluta;

    //Ancho y alto de ventana
    private int anchoV = 700;
    private int largoV = 500;

    //Iconos(Imagenes)
    private ImageIcon imgJugar;
    private ImageIcon imgJugarShadow;
    private ImageIcon imgComoJugar;
    private ImageIcon imgComoJugarShadow;
    private ImageIcon imgParaQueSirve;
    private ImageIcon imgParaQueSirveShadow;
    private ImageIcon imgFondo;

    //Botones
    private JButton btnJugar;
    private JButton btnParaQueSirve;
    private JButton btnComoJugar;

    //Contenedor Principal
    private Container contPrincipal;

    //Label de Fondo
    private JLabel lblFondo;

    // Constructor 
    public VentanaInicial(int opcion){
        iniciarComponentes();
        iniciarVentana();
        this.opcion = opcion;
        this.pasoVentana = false;
    }

    //
    private void iniciarVentana() {
        setSize(anchoV, largoV);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Adosa");

        Image icon = new ImageIcon(getClass().getResource("/imagenes/iconoVentana.png")).getImage();
        setIconImage(icon);

        setResizable(false);
    }

    //
    private void iniciarComponentes() {
        //Ruta absoluta
        rutaAbsoluta = new File("").getAbsolutePath();
        
        //Fondo
        imgFondo = metodosImagen.establecerIcon("\\src\\imagenes\\imgPortada2.jpg",
                anchoV, largoV);

        //Lbl fondo
        lblFondo = new JLabel(imgFondo);
        lblFondo.setBounds(0, 0, anchoV, largoV);

        //timer//
        tiempo = new Timer(100, new ManejadorDeEventosTiempo());
        tiempo.start();

        //Botones//
        /*btnJugar*/
        btnJugar = new Boton();
        btnJugar.setBounds(220, 280, 250, 150);
        //imagenes 
        imgJugar = metodosImagen.establecerIcon("\\src\\imagenes\\imgJugar.png",
                obtenerAnchoBoton(btnJugar), obtenerAltoBoton(btnJugar));

        imgJugarShadow = metodosImagen.establecerIcon("\\src\\imagenes\\imgJugarFondo.png",
                obtenerAnchoBoton(btnJugar), obtenerAltoBoton(btnJugar));

        btnJugar.setIcon(imgJugar);
        btnJugar.setRolloverIcon(imgJugarShadow);

        /*btnComoJugar*/
        btnComoJugar = new Boton();
        btnComoJugar.setBounds(10, 280, 200, 130);
        //imagnes
        imgComoJugar = metodosImagen.establecerIcon("\\src\\imagenes\\imgComoJugar.png",
                obtenerAnchoBoton(btnComoJugar), obtenerAltoBoton(btnComoJugar));
        imgComoJugarShadow = metodosImagen.establecerIcon("\\src\\imagenes\\imgComoJugar.png",
                obtenerAnchoBoton(btnComoJugar), obtenerAltoBoton(btnComoJugar));
        btnComoJugar.setIcon(imgComoJugar);
        btnComoJugar.setRolloverIcon(imgComoJugarShadow);

        /*btnParaQueSirve*/
        btnParaQueSirve = new Boton();
        btnParaQueSirve.setBounds(470, 280, 200, 130);
        //imagens
        imgParaQueSirve = metodosImagen.establecerIcon("\\src\\imagenes\\imgParaQueSirve.png",
                obtenerAnchoBoton(btnParaQueSirve), obtenerAltoBoton(btnParaQueSirve));
        imgParaQueSirveShadow = metodosImagen.establecerIcon("\\src\\imagenes\\imgParaQueSirve.png", obtenerAnchoBoton(btnParaQueSirve), obtenerAltoBoton(btnParaQueSirve));
        btnParaQueSirve.setIcon(imgParaQueSirve);
        btnParaQueSirve.setRolloverIcon(imgParaQueSirveShadow);

        //Contenedor Principal//
        contPrincipal = getContentPane();
        contPrincipal.setLayout(null);
        //Añadiendo objetos
        contPrincipal.add(lblFondo);
        //Aadiendo objetos al lblFondo
        lblFondo.add(btnJugar);
        lblFondo.add(btnComoJugar);
        lblFondo.add(btnParaQueSirve);

        ////Añadiendo listeners
        btnJugar.addMouseListener(new ManejadorDeEventos());

        btnComoJugar.addMouseListener(new ManejadorDeEventos());

        btnParaQueSirve.addMouseListener(new ManejadorDeEventos());

    }
    
//*****************************METODOS***************************************//

    //Sonido
    //Activar sonido de cierto boton
    public void reproducirSonido(String cualSonido) {
        switch (cualSonido) {
            case "boton" ->
                play("src\\sonidos\\boton.wav");
            case "inicio" -> {
            switch (opcion) {
                case 0 -> play("");
                case 1 -> play("");
                case 2 -> play("");
                default -> {
                }
            }
            }
            default -> {
            }
        }
    }

    //reproduce un sonido recibido
    private void play(String filePath) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }

        archivowav = new File(filePath);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(archivowav);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            System.err.println(e.getMessage());
        }
    }

    //Metodos para obtener el ancho y alto de un boton en el contenedor
    private int obtenerAnchoBoton(JButton btn) {
        int ancho = (int) btn.getBounds().getWidth();
        return ancho;
    }

    private int obtenerAltoBoton(JButton btn) {
        int alto = (int) btn.getBounds().getHeight();
        return alto;
    }

//*********************************CLASES************************************//
    //Clase manejadora de eventos
    private class ManejadorDeEventos extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == btnJugar) {
                dispose();
                //Se abre la ventana del juego
                pasoVentana = true;
                if (clip != null) {
                    clip.stop();
                }
                reproducirSonido("boton");
                BaldosaJuego ventanaJuego = new BaldosaJuego();
            } else if (e.getSource() == btnComoJugar) {
                dispose();
                //Se abre la ventana como jugar
                reproducirSonido("boton");
                if (clip != null) {
                    clip.stop();
                }
                pasoVentana = true;
                VentanaComoJugar ventanaComoJugar = new VentanaComoJugar();
            } else if (e.getSource() == btnParaQueSirve) {
                dispose();
                reproducirSonido("boton");
                if (clip != null) {
                    clip.stop();
                }
                pasoVentana = true;
                reproducirSonido("boton");
                VentanaInstrucciones ventanaParaQueSirve
                        = new VentanaInstrucciones();
            }
        }

    }

    private class ManejadorDeEventosTiempo implements ActionListener {

        //tiempo
        private double t = 0;

        boolean sonidoInicializado = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            //se aumenta el tiempo 1 segundo
            t += 0.1;
            if (t > 1) {
                if (!sonidoInicializado && !pasoVentana) {
                    reproducirSonido("inicio");
                    sonidoInicializado = true;
                }
            }
        }
    }

}
