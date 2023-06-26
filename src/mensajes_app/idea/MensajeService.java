package mensajes_app.idea;

import org.apache.kafka.common.protocol.types.Field;

import java.util.Scanner;

public class MensajeService {

    public static void crearMensaje(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = scanner.nextLine();
        System.out.println("Cual es tu nombre: ");
        String nombre = scanner.nextLine();

        //Creacion de objeto a enviar a la capa DAO
        Mensaje registroMensaje = new Mensaje();
        registroMensaje.setmensaje(mensaje);
        registroMensaje.setAutor_mensaje(nombre);

        MensajeDao.createMensajeDB(registroMensaje);

    }

    public static void listarMensaje(){
        System.out.println("-----------------------------------------------");
        System.out.println("TUS MENSAJES SON: ");
        System.out.println("-----------------------------------------------");
        MensajeDao.leerMensajeDB();
    }

    public static void borrarMensaje(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa por favor el id del mensaje a borrar: ");
        int id_mensaje = scanner.nextInt();

        //Llamado a la capa Dao
        MensajeDao.deleteMensajeDB(id_mensaje);

    }

    public static void editarMensaje(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe tu nuevo mensaje: ");
        String cuerpoMensaje = scanner.nextLine();
        System.out.println("Cual es el id del mensaje que desea editar: ");
        int id_mensaje = scanner.nextInt();
        //Creacion del objeto mensaje con los parametros seleccionados
        Mensaje update = new Mensaje();
        update.setId_mensaje(id_mensaje);
        update.setmensaje(cuerpoMensaje);
        //Conectect of DAO
        MensajeDao.updateMensajeDB(update);

    }
}


