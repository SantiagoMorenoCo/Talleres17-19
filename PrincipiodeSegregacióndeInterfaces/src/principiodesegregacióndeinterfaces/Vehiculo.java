
package principiodesegregacióndeinterfaces;
interface Conducible {
    void conducir();
}
interface Transportador {
    void cargarMercancia(double peso);
}
class Motocicleta implements Conducible {
    @Override
    public void conducir() {
        System.out.println("La motocicleta está en movimiento.");
    }
}
class Camion implements Conducible, Transportador {
    @Override
    public void conducir() {
        System.out.println("El camión está en movimiento.");
    }

    @Override
    public void cargarMercancia(double peso) {
        System.out.println("Cargando " + peso + " kg de mercancía en el camión.");
    }
}

class Bicicleta implements Conducible {
    @Override
    public void conducir() {
        System.out.println(" La bicicleta está en movimiento.");
    }
}
 class Main {
    public static void main(String[] args) {
        Conducible moto = new Motocicleta();
        Conducible bici = new Bicicleta();
        Conducible camionConduccion = new Camion();
        Transportador camionCarga = new Camion();

        moto.conducir();
        bici.conducir();
        camionConduccion.conducir();
        camionCarga.cargarMercancia(2000);
    }
}
