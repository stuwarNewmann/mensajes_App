package mensajes_app.idea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajeDao {

    public static void createMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement preparedstatement = null;
            try{
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";
                preparedstatement = conexion.prepareStatement(query);
                preparedstatement.setString(1, mensaje.getmensaje());
                preparedstatement.setString(2, mensaje.getAutor_mensaje());
                preparedstatement.executeUpdate();
                System.out.println("Mensaje Creado Correctamente");
            }catch (SQLException exception){
                System.out.println(exception);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajeDB(){

    }

    public static void deleteMensajeDB(int id_mensaje){

    }

    public static void updateMensajeDB(Mensaje mensaje){

    }
}
