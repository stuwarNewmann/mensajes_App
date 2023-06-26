package mensajes_app.idea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        Conexion db_connect = new Conexion();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection conexion = db_connect.get_connection()){

            String query = "SELECT * FROM mensajes";
            preparedStatement = conexion.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                System.out.println("--------------------------------------------------------------");
                System.out.println("ID: " + resultSet.getInt("id_mensaje"));
                System.out.println("Mensaje: " + resultSet.getString("mensaje"));
                System.out.println("Autor: " + resultSet.getString("autor_mensaje"));
                System.out.println("Fecha: " + resultSet.getString("fecha_mensaje"));
                System.out.println("---------------------------------------------------------------");
            }

        }catch (SQLException exception){
            System.out.println(exception);
            System.out.println("No se pueden recuperar los mensajes.");
        }
    }

    public static void deleteMensajeDB(int id_mensaje){

    }

    public static void updateMensajeDB(Mensaje mensaje){

    }
}
