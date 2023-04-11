package mensajes;

public class ContenidoMensaje implements InterfaceMensaje{
    private String contenidoMensaje;


    public ContenidoMensaje() {
    }

    public ContenidoMensaje(String mensaje) {
        this.contenidoMensaje = mensaje;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        return this;
    }

    @Override
    public String getContenido() {
        return contenidoMensaje;
    }

    @Override
    public void setContenido(String contenido) {
        this.contenidoMensaje = contenido;
    }


    public String getContenidoMensaje() {
        return contenidoMensaje;
    }

    public void setContenidoMensaje(String contenidoMensaje) {
        this.contenidoMensaje = contenidoMensaje;
    }
}
