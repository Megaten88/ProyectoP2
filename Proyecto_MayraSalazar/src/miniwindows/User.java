
package miniwindows;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mayra Salazar
 */
public class User implements Serializable {
    private String user;
    private String password;
    private ArrayList<Actividad> actividades;
    private static long SerialVersionUID = 866L;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
        new File("./Z/Users/" + user).mkdir();
        new File("./Z/Users/" + user +"/Documents").mkdir();
        new File("./Z/Users/" + user +"/Calendar").mkdir();
        new File("./Z/Users/" + user +"/Messages").mkdir();
        new File("./Z/Users/" + user +"/Music").mkdir();
        new File("./Z/Users/" + user +"/Pictures").mkdir();
        new File("./Z/Users/" + user +"/Email").mkdir();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public static void setSerialVersionUID(long SerialVersionUID) {
        User.SerialVersionUID = SerialVersionUID;
    }

    @Override
    public String toString() {
        return "User{" + "user=" + user + ", password=" + password + '}';
    }
    
}
