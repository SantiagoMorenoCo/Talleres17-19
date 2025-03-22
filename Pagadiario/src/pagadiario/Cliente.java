package pagadiario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    private String nombre;
    private double saldo;

    public Cliente(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void registrarPago(double pago) {
        if (pago > 0 && pago <= saldo) {
            saldo -= pago;
        } else {
            System.out.println("Pago inválido para " + nombre);
        }
    }
}
class RegistroClientes {
    private List<Cliente> clientes;

    public RegistroClientes() {
        this.clientes = new ArrayList<>();
    }

    public void agregarCliente(String nombre, double saldo) {
        clientes.add(new Cliente(nombre, saldo));
    }

    public void registrarPago(String nombre, double pago) {
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                c.registrarPago(pago);
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void verSaldos() {
        for (Cliente c : clientes) {
            System.out.println(c.getNombre() + " tiene un saldo de: " + c.getSaldo());
        }
    }
}
 class GestionPOO {
    public static void main(String[] args) {
        RegistroClientes registro = new RegistroClientes();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Agregar cliente\n2. Registrar pago\n3. Ver saldos\n4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = scanner.nextDouble();
                    registro.agregarCliente(nombre, saldo);
                    break;
                case 2:
                    System.out.print("Nombre del cliente: ");
                    nombre = scanner.nextLine();
                    System.out.print("Monto del pago: ");
                    double pago = scanner.nextDouble();
                    registro.registrarPago(nombre, pago);
                    break;
                case 3:
                    registro.verSaldos();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
