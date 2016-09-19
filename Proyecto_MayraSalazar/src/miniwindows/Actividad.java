
package miniwindows;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Mayra Salazar
 */
public class Actividad implements Serializable{
    Date fecha;
    String titulo;
    int recordatorio;
    private static long SerialVersionUID = 655L;

    public Actividad(Date fecha, String titulo, int recordatorio) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.recordatorio = recordatorio;
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(int recordatorio) {
        this.recordatorio = recordatorio;
    }
    
}
