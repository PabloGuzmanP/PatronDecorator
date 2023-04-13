package patrondecorator;

import decoradores.*;
import mensajes.InterfaceMensaje;
import mensajes.MensajeCliente;

public class PatronDecoratorMain {
    public static void main(String[] args) {

        MensajeCliente MensajeUsuario = new MensajeCliente(
                "Fabrizio Bolaño", "fbolano@javeriana.edu.co", "99887766");
        System.out.println("Mensaje Original ==> " + MensajeUsuario);

        InterfaceMensaje F1Mensaje = new CifrarMensaje("user", "HG58YZ3CR9123456",
                new MensajeSOAP(
                        new FormatoDecoradorXML(MensajeUsuario))).ProcesarMensaje();
        System.out.println("Mensaje No. 1 =====================================>\n"
                + F1Mensaje.getContenido() + "\n\n");

        InterfaceMensaje F2Mensaje = new MensajeSOAP(
                new CifrarMensaje("user", "HG58YZ3CR9123456",
                        new FormatoDecoradorXML(MensajeUsuario))).ProcesarMensaje();
        System.out.println("message2 =====================================>\n"
                + F2Mensaje.getContenido());

        InterfaceMensaje F3Mensaje = new CredencialesMensaje("user", "HG58YZ3CR9123456",
                new MensajeSOAP(
                        new CifrarMensaje("user", "HG58YZ3CR9123456",
                            new FormatoDecoradorXML(MensajeUsuario)))).ProcesarMensaje();
        System.out.println("message3 =====================================>\n"
                + F3Mensaje.getContenido());

        InterfaceMensaje F4Mensaje = new DatosEmpresa(
                new MensajeSOAP(
                    new CifrarMensaje("user", "HG58YZ3CR9123456",
                        new FormatoDecoradorXML(MensajeUsuario))), "Mi Empresa", "Mi Dirección", "12345678", "correo@miempresa.com").ProcesarMensaje();
        System.out.println("message4 =====================================>\n"
                + F4Mensaje.getContenido());
    }
}
