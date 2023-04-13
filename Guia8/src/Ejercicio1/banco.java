
package Ejercicio1;

import Ejercicio1.entidades.CuentaBancaria;
import Ejercicio1.servicios.CuentaBancariaServicio;


public class banco {

 
    public static void main(String[] args) {
        
        CuentaBancariaServicio servicio = new CuentaBancariaServicio();
        
        CuentaBancaria cuenta;
                       
        cuenta = servicio.crearCuenta();
        servicio.consultarDatos(cuenta);
        servicio.menu(cuenta);
    }
    
}
