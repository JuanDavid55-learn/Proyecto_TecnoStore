package Controlador;

import Modelo.Marca;
import java.util.ArrayList;

public interface GestionMarcas {
    
    public abstract void RegistrarMarca(Marca m);
        
    public abstract void EliminarMarca(int id);
    
    ArrayList<Marca> ListarMarcas();
}
