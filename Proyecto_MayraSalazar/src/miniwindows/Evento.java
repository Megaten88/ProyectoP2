
package miniwindows;

import java.util.Date;

/**
 *
 * @author Mayra Salazar
 */
public class Evento extends Actividad{
    private Date horainicio;
    private Date horafin;

    public Evento(Date horainicio, Date horafin, Date fecha, String titulo, int recordatorio) {
        super(fecha, titulo, recordatorio);
        this.horainicio = horainicio;
        this.horafin = horafin;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }
    
}
