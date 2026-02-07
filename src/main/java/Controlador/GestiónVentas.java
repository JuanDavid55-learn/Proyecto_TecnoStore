package Controlador;

import Modelo.celulares;
import Modelo.detalle_ventas;
import Modelo.ventas;

public interface GestiónVentas {

    int RegistrarVenta(ventas v);
    
    double CalcularVenta_Totl_Mas_IVA(ventas v, int id);
    
    int ActualizarStock(celulares cel, int id);
    
    void GuardarDetalleVenta (detalle_ventas dv);
    
}
