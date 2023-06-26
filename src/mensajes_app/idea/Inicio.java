package mensajes_app.idea;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;



public class Inicio {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int optionIn;
        do {
            System.out.println("-----------------------------------------------");
            System.out.println("Aplicacion de mensajes, Selecciona una opcion:");
            System.out.println("1. Crear Mensaje");
            System.out.println("2. Listar Mensajes");
            System.out.println("3. Editar Mensaje");
            System.out.println("4. Eliminar Mensaje");
            System.out.println("5. Salir");
            System.out.println("_______________________________________________");


            //leemos la opcion del ususario
            optionIn = scanner.nextInt();



            switch (optionIn) {
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensaje();
                    break;
                case 3:
                    MensajeService.editarMensaje();
                    break;
                case 4:
                    MensajeService.borrarMensaje();
                    break;
                default:
                    break;
            }

        } while (optionIn != 5);

    }

}
