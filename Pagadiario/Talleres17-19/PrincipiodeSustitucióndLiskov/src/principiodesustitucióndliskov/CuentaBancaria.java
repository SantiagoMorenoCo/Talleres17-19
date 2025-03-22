
package principiodesustitucióndliskov;
abstract class CuentaBancaria {
    protected double saldo;

   public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
  }

 public void depositar(double cantidad) {
     if (cantidad > 0) {
       saldo += cantidad;
       System.out.println("Depósito de $" + cantidad + " realizado. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("monto a depositar debe ser mayor a cero.");
        }
    }

    public abstract void retirar(double cantidad);

    public double obtenerSaldo() {
        return saldo;
    }
}
class CuentaAhorros extends CuentaBancaria {
    private double saldoMinimo;

    public CuentaAhorros(double saldoInicial, double saldoMinimo) {
        super(saldoInicial);
        this.saldoMinimo = saldoMinimo;
    }

    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0 && (saldo - cantidad) >= saldoMinimo) {
            saldo -= cantidad;
            System.out.println("Retiro de $" + cantidad + " realizado. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("No puedes retirar $" + cantidad + ". Saldo insuficiente o por debajo del saldo mínimo.");
        }
    }
}
 class Main {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaAhorros(1000, 200); 

        cuenta.depositar(500);
        cuenta.retirar(300);
        cuenta.retirar(1200); 

        System.out.println("Saldo final: $" + cuenta.obtenerSaldo());
    }
}


