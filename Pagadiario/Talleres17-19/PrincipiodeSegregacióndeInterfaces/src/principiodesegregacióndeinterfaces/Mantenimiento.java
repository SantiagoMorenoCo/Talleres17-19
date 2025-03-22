
package principiodesegregacióndeinterfaces;
 interface Reparable {
    void reparar();
}
interface Limpieza {
    void limpiar();
}
class Maquina implements Reparable {
    @Override
    public void reparar() {
        System.out.println("La máquina ha sido reparada.");
    }
}

class Vehiculo implements Reparable, Limpieza {
    @Override
    public void reparar() {
        System.out.println("El vehículo ha sido reparado.");
    }

    @Override
    public void limpiar() {
        System.out.println("🧽 El vehículo ha sido limpiado.");
    }
}
class Ventana implements Limpieza {
    @Override
    public void limpiar() {
        System.out.println("✨ La ventana ha sido limpiada.");
    }
}

 class Main {
    public static void main(String[] args) {
        Reparable maquina = new Maquina();
        Reparable vehiculo = new Vehiculo();
        Limpieza ventana = new Ventana();
        Limpieza vehiculoLimpieza = new Vehiculo();

        maquina.reparar();
        vehiculo.reparar();
        ventana.limpiar();
        vehiculoLimpieza.limpiar();
    }
}

