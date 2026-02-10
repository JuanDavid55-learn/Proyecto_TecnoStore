package Vista;

import static Controlador.Funciones.validacion;

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
            op = validacion(1, 5, "Eliga una opcion.");
            switch (op) {
                case 1:
                    MenuMarcas mm = new MenuMarcas();
                    mm.menuMarca();
                    break;
                case 2:
                    MenuCelulares mc = new MenuCelulares();
                    mc.menuCelulares();
                    break;
                case 3:
                    MenuClientes mcl = new MenuClientes();
                    mcl.menuClientes();
                    break;
                case 4:
                    MenuVentas mv = new MenuVentas();
                    mv.menuVentas();
                    break;
                case 5:
                    System.out.println("Gracias por usar nuestro sistema!");
                    break;
            }
        } while (op != 5);
    }
}
