package Vista;

import java.util.Scanner;
import Controlador.ConexiónDB;
import Modelo.Marca;

public class Proyecto_TecnoStore {

    public static void main(String[] args) {
        int op = 0;
        do {
            System.out.println("""
                           ******************************
                           1.   Gestionar Marcas.
                           2.   Gestionar Celulares.
                           3.   Gestionar Clientes.
                           4.   Gestionar Ventas.
                           5.   Salir.
                           ******************************
                           """);
            op = new Scanner(System.in).nextInt();
            while (op < 1 || op > 5) {
                System.out.println("Error, opcion no valida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    MenuMarcas m = new MenuMarcas();
                    m.menuMarca();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    System.out.println("Gracias por usar nuestro sistema!");
                    break;
            }
        } while (op != 3);
    }
}
