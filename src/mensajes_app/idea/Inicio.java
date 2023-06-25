package mensajes_app.idea;
import java.sql.Connection;
import java.sql.SQLException;

public class Inicio {
    public static void main(String[] args) {

        Conexion conexion = new Conexion();

        try(Connection conexion_sucess = conexion.get_connection()) {

        }catch (SQLException e) {
            System.out.println(e);
        }
    }
}
