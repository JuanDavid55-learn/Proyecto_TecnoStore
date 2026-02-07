package Vista;

import Controlador.GestiónVentas;
import Controlador.GestiónVentasDAO;
import Controlador.GestionarCelulares;
import Controlador.GestionarCelularesDAO;
import java.util.Scanner;
import Modelo.celulares;
import Modelo.detalle_ventas;
import Modelo.ventas;

public class MenuVentas {
    GestiónVentas gv = new GestiónVentasDAO();
    
    private void registrarVenta() {
        GestionarCelulares gcls = new GestionarCelularesDAO();
        ventas v = new ventas();
        detalle_ventas dv = new detalle_ventas();
        
        // registrar la venta        
        System.out.println("Ingrese el id del cliente: ");
        v.setId_cliente(new Scanner(System.in).nextInt());
        System.out.println("Ingrese la fecha (YYYY-MM-DD): ");
        v.setFecha(new Scanner(System.in).nextLine());
        System.out.println("Ingrese el total: ");
        v.setTotal(new Scanner(System.in).nextDouble());
        int idVenta = gv.RegistrarVenta(v);
        
        //calcular el subtotalde detalle venta mas e IVA
        double subtotalConIVA = gv.CalcularVenta_Totl_Mas_IVA(v, idVenta);
        
        //actualizar el stock del celular
        System.out.println("Ingrese el id del celular vendido:");
        int idCelular = new Scanner(System.in).nextInt();
        celulares cel = gcls.BuscarCelular(idCelular);
        System.out.println("Ingrese la cantidad vendida:");
        int cantidadVendida = gv.ActualizarStock(cel, idCelular);
        
        //regsitrar el detalle venta
        dv.setId_venta(idVenta);
        dv.setId_celular(idCelular);
        dv.setCantidad(cantidadVendida);
        dv.setSubtotal(subtotalConIVA);
        gv.GuardarDetalleVenta(dv);
        System.out.println("Proceso de venta completado con éxito.");
    }

    private void eliminarMarc() {
        
    }

    public void menuVentas() {
        int op = 0;
        do {
            System.out.println("""
                           ******************************
                                       VENTAS
                           1.   Registrar.
                           2.   Ver reportes y análisis.
                           3.   Regresar.
                           ******************************
                           """);
            op = new Scanner(System.in).nextInt();
            while (op < 1 || op > 4) {
                System.out.println("Error, opcion no valida");
                op = new Scanner(System.in).nextInt();
            }
            switch (op) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    eliminarMarc();
                    break;
            }
        } while (op != 3);
    }
}
