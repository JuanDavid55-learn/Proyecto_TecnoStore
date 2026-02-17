package Controlador;

import Modelo.celulares;
import Modelo.detalle_ventas;
import Modelo.ventas;
import java.util.ArrayList;
import java.util.Map;

public interface GestiónVentas {

    int RegistrarVenta(ventas v);
    
    double CalcularTotal(celulares cel, int cantidadVendida);
    
    double CalcularVenta_Totl_Mas_IVA(ventas v, int id);
    
    int ActualizarStock(celulares cel, int id);
    
    void GuardarDetalleVenta (detalle_ventas dv);
    
    void generarReporteVentas();
    
    void VerReporteVentas();

    ArrayList<String> top3CelularesMasVendidos();
    
    Map<String, Double> ventasTotalesPorMes();
}
