package Controlador;

import Modelo.clientes;
import java.util.ArrayList;

public interface GestionClientes {
    
    void RegistrarCliente(clientes cli);

    void ActualizarCliente(clientes cli, int id);

    void EliminarCliente(int id);

    ArrayList<clientes> ListarClientes();

    clientes BuscarCliente(int id);
}