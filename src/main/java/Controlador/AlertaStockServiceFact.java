package Controlador;

import Modelo.celulares;
import java.util.ArrayList;

public interface AlertaStockServiceFact {
    
    ArrayList<celulares> generarListaCelStockBajo();
    
    void VerAertaDeStock();
}
