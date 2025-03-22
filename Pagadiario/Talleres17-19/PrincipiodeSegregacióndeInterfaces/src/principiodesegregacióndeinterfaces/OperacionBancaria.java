
package principiodesegregacióndeinterfaces;
interface Transferible {
    void transferir(double monto, String cuentaDestino);
}
interface Retirable {
    void retirar(double monto);
}
interface Pagos {
    void pagarFactura(String servicio, double monto);
}
class CuentaCorriente implements Transferible, Retirable, Pagos {
    private double saldo;

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void transferir(double monto, String cuentaDestino) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Transferencia de $" + monto + " realizada a " + cuentaDestino);
        } else {
            System.out.println("ransferencia fallida. Saldo insuficiente.");
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("✅ Retiro de $" + monto + " realizado.");
        } else {
            System.out.println("❌ Retiro fallido. Saldo insuficiente.");
        }
    }

    @Override
    public void pagarFactura(String servicio, double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("✅ Pago de $" + monto + " realizado para " + servicio);
        } else {
            System.out.println("❌ Pago fallido. Saldo insuficiente.");
        }
    }
}
class CuentaAhorros implements Transferible, Retirable {
    private double saldo;

    public CuentaAhorros(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void transferir(double monto, String cuentaDestino) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Transferencia de $" + monto + " realizada a " + cuentaDestino);
        } else {
            System.out.println("Transferencia fallida. Saldo insuficiente.");
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro de $" + monto + " realizado.");
        } else {
            System.out.println("Retiro fallido. Saldo insuficiente.");
        }
    }
}
class Main {
    public static void main(String[] args) {
        Transferible cuentaCorriente = new CuentaCorriente(1000);
        Retirable cuentaAhorros = new CuentaAhorros(500);
        Pagos cuentaParaPagos = new CuentaCorriente(1200);

        cuentaCorriente.transferir(200, "12345");
        cuentaAhorros.retirar(100);
        cuentaParaPagos.pagarFactura("Luz", 150);
    }
}

