package miniwindows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mayra Salazar
 */
public class User implements Serializable {

    private String user;
    private String password;
    private ArrayList<Actividad> actividades;
    private ArrayList<File> mensajes;
    private static long SerialVersionUID = 777L;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
        new File("./Z/Users/" + user).mkdir();
        new File("./Z/Users/" + user + "/Documents").mkdir();
        new File("./Z/Users/" + user + "/Calendar").mkdir();
        new File("./Z/Users/" + user + "/Messages").mkdir();
        new File("./Z/Users/" + user + "/Music").mkdir();
        new File("./Z/Users/" + user + "/Pictures").mkdir();
        new File("./Z/Users/" + user + "/Email").mkdir();
        agregarElementos(new File("./Z/Users/" + user + "/Music"), new File("./Z/Users/" + user + "/Pictures"));
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

    public ArrayList<Actividad> getActividades() {
        return actividades;
    }

    public ArrayList<File> getMensajes() {
        return mensajes;
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

    private void agregarElementos(File music, File pictures) {
        File archivo_entrada = null;
        File archivo_salida = null;
        File[] musicArray = (new File("./Pruebas\\Music")).listFiles();
        File[] picturesArray = (new File("./Pruebas\\Pictures")).listFiles();
        try {
            for (int i = 0; i < musicArray.length; i++) {
                archivo_entrada = musicArray[i];
                archivo_salida = music;
                FileInputStream entrada_binaria = new FileInputStream(archivo_entrada);
                FileOutputStream salida_binaria = new FileOutputStream(archivo_salida.getAbsolutePath()+"\\" + archivo_entrada.getName());
                FileChannel canal_lectura = entrada_binaria.getChannel();
                FileChannel canal_escritura = salida_binaria.getChannel();
                long fsize = canal_lectura.size();
                MappedByteBuffer buffer_bytes = canal_lectura.map(FileChannel.MapMode.READ_ONLY, 0, fsize);
                canal_escritura.write(buffer_bytes);
                canal_lectura.close();
                entrada_binaria.close();
                canal_escritura.close();
                salida_binaria.close();
            }
            for (int i = 0; i < picturesArray.length; i++) {
                archivo_entrada = picturesArray[i];
                archivo_salida = pictures;
                FileInputStream entrada_binaria = new FileInputStream(archivo_entrada);
                FileOutputStream salida_binaria = new FileOutputStream(archivo_salida.getAbsolutePath()+"\\" + archivo_entrada.getName());
                FileChannel canal_lectura = entrada_binaria.getChannel();
                FileChannel canal_escritura = salida_binaria.getChannel();
                long fsize = canal_lectura.size();
                MappedByteBuffer buffer_bytes = canal_lectura.map(FileChannel.MapMode.READ_ONLY, 0, fsize);
                canal_escritura.write(buffer_bytes);
                canal_lectura.close();
                entrada_binaria.close();
                canal_escritura.close();
                salida_binaria.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
