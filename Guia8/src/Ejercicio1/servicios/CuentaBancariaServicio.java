
package Ejercicio1.servicios;

import Ejercicio1.entidades.CuentaBancaria;
import java.util.Scanner;


public class CuentaBancariaServicio {
    
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
   
    public CuentaBancaria crearCuenta(){
        System.out.print("N° de Cuenta : ");
        int numeroCuenta = leer.nextInt();
        System.out.print("DNI : ");
        long dniCliente = leer.nextLong();
        System.out.print("Saldo $ ");
        double saldoActual = leer.nextDouble();
        return new CuentaBancaria(numeroCuenta,dniCliente,saldoActual);
    }
    
    public void ingresar(CuentaBancaria cuenta, double nuevoImporte){
        System.out.println("Saldo Actual $ " + cuenta.getSaldoActual());
        cuenta.setSaldoActual(cuenta.getSaldoActual()+nuevoImporte);  
        System.out.println("Nuevo Saldo $ " + cuenta.getSaldoActual());
    }
    
    public void retirar(CuentaBancaria cuenta, double retira){
         System.out.println("Saldo Actual $ " + cuenta.getSaldoActual());
         System.out.println("El monto a retirar es $ " + retira);
         if (cuenta.getSaldoActual()>= retira) {
             cuenta.setSaldoActual(cuenta.getSaldoActual()-retira);
             System.out.println("Nuevo Saldo $ " + cuenta.getSaldoActual());
         }
         else {
             System.out.println("Se entrega " + cuenta.getSaldoActual() + " por fondo insuficiente ");
             cuenta.setSaldoActual(0);
             System.out.println("Nuevo Saldo $ " + cuenta.getSaldoActual());
         }
    }
    
    public void extraccionRapida(CuentaBancaria cuenta, double retira){
         System.out.println("Saldo Actual $ " + cuenta.getSaldoActual());
         System.out.println("El monto a retirar es $ " + retira);
         if (retira <= cuenta.getSaldoActual()*.20) {
             cuenta.setSaldoActual(cuenta.getSaldoActual()-retira);
             System.out.println("Nuevo Saldo $ " + cuenta.getSaldoActual());
         }
         else {
             System.out.println("Monto excede el 20% de su Saldo");
         }
    }
    
    public void consultarSaldo(CuentaBancaria cuenta){
        System.out.println("Saldo Actual de la cuenta " + cuenta.getNumeroCuenta()+ " es $ " + cuenta.getSaldoActual());
    }
    
    public void consultarDatos(CuentaBancaria cuenta){
        System.out.println("N° de Cuenta : " + cuenta.getNumeroCuenta());
        System.out.println("N° de DNI : " + cuenta.getDniCliente());
        System.out.println("SALDO $ " + cuenta.getSaldoActual());
    }
    
    public void menu(CuentaBancaria cuenta){
        int op;
        double importe;
        
        do {
            System.out.println();
            System.out.println("Menú de la cuenta bancaria");
            System.out.println();
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Realizar extracción rápida");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Consultar datos de la cuenta");
            System.out.println("0. Salir del menú");
            System.out.println();
            System.out.print("Ingrese uns opcion -> ");
            op=leer.nextInt();
            System.out.println();

            switch(op){
               
                case 1: 
                        System.out.print("Importe a ingresar $ ");
                        importe = leer.nextDouble();
                        ingresar(cuenta, importe);
                        continue;
                case 2:
                        System.out.print("Importe a retirar $ ");
                        importe = leer.nextDouble();
                        retirar(cuenta, importe);
                        continue;
                case 3:
                        System.out.print("Extracion Rapida 20% - Importe a retirar $ ");
                        importe = leer.nextDouble();
                        extraccionRapida(cuenta, importe);
                        continue;
                case 4:     
                        consultarSaldo(cuenta);
                        continue;
                case 5: 
                        consultarDatos(cuenta);
                        continue;
                case 0: 
                        System.out.println("Saliendo del Menu");
                        break;
                default: 
                        System.out.println("Opcion invalida");
            }
        } while(op!=0);    
    }
    
}

