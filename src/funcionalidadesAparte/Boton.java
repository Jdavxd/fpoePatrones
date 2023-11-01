
package funcionalidadesAparte;

import javax.swing.JButton;

public class Boton extends JButton {
    
    public Boton() {
            inicializar();
        }

    private void inicializar() {
        setRolloverEnabled(true);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
    }
}
