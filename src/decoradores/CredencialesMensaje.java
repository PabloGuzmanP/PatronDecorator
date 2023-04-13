package decoradores;

import mensajes.InterfaceMensaje;

public class CredencialesMensaje extends DecoradorMensaje{
    private String usuario;
    private String password;

    public CredencialesMensaje(String usuario, String password, InterfaceMensaje mensaje) {
        super(mensaje);
        this.usuario = usuario;
        this.password = password;
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        this.Formatomensaje = Formatomensaje.ProcesarMensaje();
        agregarCredenciales();
        return Formatomensaje;
    }

    private void agregarCredenciales(){
        try {
            String contenido = Formatomensaje.getContenido();
            String header = "<soapenv:Header>\n" +
                    "<usuario>" + usuario + "</usuario>\n" +
                    "<password>" + password + "</password>\n" +
                    "</soapenv:Header>\n";

            String mensajeSOAP = contenido.replace("<soapenv:Body>", header + "<soapenv:Body>");

            Formatomensaje.setContenido(mensajeSOAP);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
