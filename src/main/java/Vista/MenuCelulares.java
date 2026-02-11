package Vista;

import static Controlador.Funciones.validacion;
import Controlador.GestionMarcas;
import Controlador.GestionMarcasDAO;
import Controlador.GestionarCelulares;
import Controlador.GestionarCelularesDAO;
import MODELO.Gama;
import Modelo.Marca;
import Modelo.celulares;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuCelulares {
    GestionarCelulares gcls = new GestionarCelularesDAO();

    private void registrarCel() {
        celulares celr = new celulares();
        GestionMarcas gm = new GestionMarcasDAO();
        
        ArrayList<Marca> marcas = gm.ListarMarcas();
        for (Marca a : marcas) {
            System.out.println(a);
        }
        System.out.println("Ingrese la marca del celular: ");
        celr.setId_marca(new Scanner(System.in).nextInt());
        System.out.println("Ingrese el modelo del celular:");
        celr.setModelo(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el sistema operativo:");
        celr.setSistema_operativo(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el tipo de gama: (BAJA / MEDIA / ALTA)");
        Gama gama = Gama.valueOf(new Scanner(System.in).nextLine());
        celr.setGama(gama);
        celr.setStock(gcls.validarValorPsitivoStock());
        celr.setPrecio(gcls.validarValorPsitivoPrecio());
        gcls.RegistrarCelular(celr);
    }

    private void actualizarCel() {
        listarCels();
        System.out.println("Ingrese el id del celular a actualizar");
        int id = new Scanner(System.in).nextInt();
        celulares cel = gcls.BuscarCelular(id);
        if (cel != null) {
            System.out.println("CELULAR BUSCADO");
            System.out.println(cel);
            System.out.println("""
                               Ingrese lo quiere modificar
                               1.   Stock
                               2.   Precio
                               """);
            int op = validacion(1, 2, "Eliga una opcion.");
            switch (op) {
                case 1:
                    cel.setStock(gcls.validarValorPsitivoStock());
                    break;
                case 2:
                    cel.setPrecio(gcls.validarValorPsitivoPrecio());
                    break;
            }
            gcls.ActualizarCelular(cel, id);
        } else {
            System.out.println("No se encuentra resgistrado dicho celular");
        }
    }
    
    private void eliminarCel() {
        listarCels();
        System.out.println("Ingrese el id del celular a eliminar");
        int id = new Scanner(System.in).nextInt();
        gcls.EliminarCelular(id);
    }

    private void listarCels() {
        ArrayList<celulares> LosCelulares = gcls.ListarCelulares();
        for (celulares a : LosCelulares) {
            System.out.println(a);
        }
    }

    private void buscarCel() {
        System.out.println("Ingrese el id del celular a buscar");
        int id = new Scanner(System.in).nextInt();
        celulares a = gcls.BuscarCelular(id);
        if (a != null) {
            System.out.println(a);
        } else {
            System.out.println("No se encuentra registrado dicho celular");
        }
    }
    
    public void menuCelulares() {
        int op = 0;
        do {
            System.out.println("""
                           ******************************
                                     CELULARES
                           1.   Registrar.
                           2.   Actualizar.
                           3.   Eliminar.
                           4.   Listar.
                           5.   Buscar.
                           6.   Regresar.
                           ******************************
                           """);
            op = validacion(1, 6, "Eliga una opcion.");
            switch (op) {
                case 1:
                    registrarCel();
                    break;
                case 2:
                    actualizarCel();
                    break;
                case 3:
                    eliminarCel();
                    break;
                case 4:
                    listarCels();
                    break;
                case 5:
                    buscarCel();
                    break;
            }
        } while (op != 6);
    }
}
