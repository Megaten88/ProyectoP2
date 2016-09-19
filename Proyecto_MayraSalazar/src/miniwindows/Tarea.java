
package miniwindows;

import java.util.Date;

/**
 *
 * @author Mayra Salazar
 */
public class Tarea extends Actividad{
    String notas;

    public Tarea(String notas, Date fecha, String titulo, int recordatorio) {
        super(fecha, titulo, recordatorio);
        this.notas = notas;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }
    
}
