package decoradores;

import mensajes.InterfaceMensaje;

public class DatosEmpresa extends DecoradorMensaje {
    private String nombreEmpresa;
    private String direccion;
    private String telefono;
    private String correo;

    public DatosEmpresa(InterfaceMensaje mensaje, String nombreEmpresa, String direccion, String telefono, String correo) {
        super(mensaje);
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        this.Formatomensaje = Formatomensaje.ProcesarMensaje();
        agregarDatosEmpresa();
        return Formatomensaje;
    }

    private InterfaceMensaje agregarDatosEmpresa() {
        try {
            String contenido = Formatomensaje.getContenido();
            String footer = "\n\n-- Datos de la empresa --\n" +
                    "Nombre: " + nombreEmpresa + "\n" +
                    "Dirección: " + direccion + "\n" +
                    "Teléfono: " + telefono + "\n" +
                    "Correo electrónico: " + correo + "\n";

            String mensajeConEmpresa = contenido + footer;

            Formatomensaje.setContenido(mensajeConEmpresa);
            return Formatomensaje;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
