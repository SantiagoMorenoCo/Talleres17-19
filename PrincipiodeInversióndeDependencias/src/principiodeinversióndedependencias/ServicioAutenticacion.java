
package principiodeinversióndedependencias;
interface ServicioAutenticacion{
 boolean autenticar(String usuario, String clave);
}

class AutenticacionLocal implements ServicioAutenticacion {
    @Override
    public boolean autenticar(String usuario, String clave) {
        System.out.println("Autenticando con usuario y contraseña...");
        return "admin".equals(usuario) && "1234".equals(clave);
    }
}
class AutenticacionOAuth implements ServicioAutenticacion {
    @Override
    public boolean autenticar(String usuario, String clave) {
        System.out.println("Autenticando...");
        return "valido".equals(clave);
    }
}
class GestorAutenticacion {
    private ServicioAutenticacion servicioAutenticacion;
    public GestorAutenticacion(ServicioAutenticacion servicioAutenticacion) {
        this.servicioAutenticacion = servicioAutenticacion;
    }

    public void iniciarSesion(String usuario, String clave) {
        if (servicioAutenticacion.autenticar(usuario, clave)) {
            System.out.println("Inicio de sesión exitoso.");
        } else {
            System.out.println("Error en la autenticación.");
        }
    }
}

 class Main {
    public static void main(String[] args) {
        // Autenticación con usuario y contraseña
        GestorAutenticacion authLocal = new GestorAutenticacion(new AutenticacionLocal());
        authLocal.iniciarSesion("admin", "1234"); 
        authLocal.iniciarSesion("usuario", "wrong"); 

        // Autenticación con OAuth
        GestorAutenticacion authOAuth = new GestorAutenticacion(new AutenticacionOAuth());
        authOAuth.iniciarSesion("usuario", "valido"); 
        authOAuth.iniciarSesion("usuario", "invalido"); 
    }
}

