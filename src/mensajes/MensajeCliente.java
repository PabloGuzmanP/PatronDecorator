package mensajes;

public class MensajeCliente implements InterfaceMensaje{
    private String nombre;
    private String email;
    private String telefono;

    public MensajeCliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    @Override
    public InterfaceMensaje ProcesarMensaje() {
        return this;
    }

    @Override
    public String getContenido() {
        return toString();
    }

    @Override
    public String toString() {
        return "MensajeCliente{" + "nombre=" + nombre + ", \nemail=" + email + ", telefono=" + telefono + '}';
    }


    @Override
    public void setContenido(String contenido) {
        throw new UnsupportedOperationException("No soportado.");
    }
}
