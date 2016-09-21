
package miniwindows;

import java.io.Serializable;

/**
 *
 * @author Mayra Salazar
 */
public class Mensajes implements Serializable{
    private User user1;
    private User user2;
    private String mensajes;
    private static long SerialVersionUID = 888L;

    public Mensajes(User user1, User user2, String mensajes) {
        this.user1 = user1;
        this.user2 = user2;
        this.mensajes = mensajes;
    }

    
    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public String getMensajes() {
        return mensajes;
    }

    public void setMensajesUser1 (String mensajes) {
        this.mensajes += user1 + ": " + mensajes;
    }
    public void setMensajesUser2 (String mensajes) {
        this.mensajes += user2 + ": " + mensajes;
    }
    
}
