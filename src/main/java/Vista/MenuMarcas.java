package Vista;

import Controlador.GestionMarcas;
import Controlador.GestionMarcasDAO;
import Modelo.Marca;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuMarcas {
    GestionMarcas gm = new GestionMarcasDAO();

    private void registrarMarc() {
        Marca m = new Marca();
        System.out.println("Ingrese el nombre de la marca:");
        m.setNombre(new Scanner(System.in).nextLine());
        gm.RegistrarMarca(m);
    }

    private void eliminarMarc() {
        System.out.println("Ingrese el id de la marca a eliminar");
        int id = new Scanner(System.in).nextInt();
        gm.EliminarMarca(id);
    }

    private void listarMarc() {
        ArrayList<Marca> marcas = gm.ListarMarcas();
        for (Marca a : marcas) {
            System.out.println(a);
        }
    }

    public void menuMarca() {
        int op = 0;
        do {
            System.out.println("""
                           ******************************
                                       MARCAS
                           1.   Registrar
                           2.   Eliminar.
                           3.   Listar.
                           ******************************
                           """);
            op = new Scanner(System.in).nextInt();
            while (op < 1 || op > 3) {
                System.out.println("Error, opcion no valida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    registrarMarc();
                    break;
                case 2:
                    eliminarMarc();
                    break;
                case 3:
                    listarMarc();
                    break;
            }
        } while (op != 6);
    }
}
