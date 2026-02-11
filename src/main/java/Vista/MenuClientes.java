package Vista;

import static Controlador.Funciones.validacion;
import Controlador.GestionClientes;
import Controlador.GestionClientesDAO;
import Modelo.clientes;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuClientes {
    GestionClientes gcls = new GestionClientesDAO();

    private void registrarCli() {
        clientes client = new clientes();
        
        System.out.println("Ingrese el nombre del cliente: ");
        client.setNombre(new Scanner(System.in).nextLine());
        client.setIdentificacion(gcls.validarIdenUnica());
        client.setCorreo(gcls.pedirCorreoFormato());
        System.out.println("Ingrese el telefono del cliente:");
        client.setTelefono(new Scanner(System.in).nextLine());
        gcls.RegistrarCliente(client);
    }

    private void actualizarCli() {
        listarCli();
        System.out.println("Ingrese el id del cliente a actualizar");
        int id = new Scanner(System.in).nextInt();
        clientes cli = gcls.BuscarCliente(id);
        if (cli != null) {
            System.out.println("CLIENTE BUSCADO");
            System.out.println(cli);
            System.out.println("""
                               Ingrese lo quiere modificar
                               1.   Nombre
                               2.   Identificacion
                               3.   Correo
                               4.   Telefono
                               """);
            int op = validacion(1, 4, "Eliga una opcion.");
            switch (op) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre");
                    cli.setNombre(new Scanner(System.in).nextLine());
                    break;
                case 2:
                    System.out.println("Ingrese la nueva identificacion");
                    cli.setIdentificacion(new Scanner(System.in).nextLine());
                    break;
                case 3:
                    System.out.println("Ingrese el nuevo correo");
                    cli.setCorreo(new Scanner(System.in).nextLine());
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo telefono");
                    cli.setTelefono(new Scanner(System.in).nextLine());
                    break;
            }
            gcls.ActualizarCliente(cli, id);
        } else {
            System.out.println("No se encuentra resgistrado dicho celular");
        }
    }
    
    private void eliminarCli() {
        listarCli();
        System.out.println("Ingrese el id del cliente a eliminar");
        int id = new Scanner(System.in).nextInt();
        gcls.EliminarCliente(id);
    }

    private void listarCli() {
        ArrayList<clientes> LosClientes = gcls.ListarClientes();
        for (clientes a : LosClientes) {
            System.out.println(a);
        }
    }

    private void buscarCli() {
        System.out.println("Ingrese el id del cliente a buscar");
        int id = new Scanner(System.in).nextInt();
        clientes a = gcls.BuscarCliente(id);
        if (a != null) {
            System.out.println(a);
        } else {
            System.out.println("No se encuentra registrado dicho cliente");
        }
    }
    
    public void menuClientes() {
        int op = 0;
        do {
            System.out.println("""
                           ******************************
                                      CLIENTES
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
                    registrarCli();
                    break;
                case 2:
                    actualizarCli();
                    break;
                case 3:
                    eliminarCli();
                    break;
                case 4:
                    listarCli();
                    break;
                case 5:
                    buscarCli();
                    break;
            }
        } while (op != 6);
    }
}
