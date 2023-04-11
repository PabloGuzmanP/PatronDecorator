package mensajes;

public interface InterfaceMensaje {
    public InterfaceMensaje ProcesarMensaje();
    public String getContenido();
    public void setContenido(String contenido);
}
