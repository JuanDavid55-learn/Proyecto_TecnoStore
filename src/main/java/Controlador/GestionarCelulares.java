package Controlador;

import Modelo.celulares;
import java.util.ArrayList;

public interface GestionarCelulares {
    
    void RegistrarCelular(celulares cel);

    void ActualizarCelular(celulares cel, int id);

    void EliminarCelular(int id);

    ArrayList<celulares> ListarCelulares();

    celulares BuscarCelular(int id);
    
    ArrayList<String> ListarCelularesResum();
    
    int validarValorPsitivoPrecio();
    
    int validarValorPsitivoStock();
}