
package miniwindows;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 *
 * @author Mayra Salazar
 */
public class HiloHora extends Thread{
    private JMenu barra;
    private boolean vive;

    public HiloHora(JMenu barra) {
        this.barra = barra;
        this.vive = true;
    }

    public JMenu getBarra() {
        return barra;
    }

    public void setBarra(JMenu barra) {
        this.barra = barra;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    @Override
    public void run() {
        while(vive){
            SimpleDateFormat fm = new SimpleDateFormat("HH:mm");
            Date hora = new Date();
            barra.setText("Hora: " + fm.format(hora));
        }
    }
    
    
}
