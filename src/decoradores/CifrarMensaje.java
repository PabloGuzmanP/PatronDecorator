package decoradores;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;

import mensajes.InterfaceMensaje;

import java.util.Base64;

public class CifrarMensaje extends DecoradorMensaje{
    private String usuario;
    private String password;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public CifrarMensaje(String usuario, String password, InterfaceMensaje Formatomensaje) {
        super(Formatomensaje);
        this.usuario = usuario;
        this.password = password;
    }
    @Override
    public InterfaceMensaje ProcesarMensaje() {
        this.Formatomensaje = Formatomensaje.ProcesarMensaje();
        encryptMessage();
        return Formatomensaje;
    }
    private InterfaceMensaje encryptMessage() {
        try {
            Key key = new SecretKeySpec(password.getBytes(), "AES");
            Cipher c = Cipher.getInstance("AES");

            c.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = c.doFinal(Formatomensaje.getContenido().getBytes());
            Base64.Encoder encoder = Base64.getEncoder();
            String encryptedValue= encoder.encodeToString(encVal);

            Formatomensaje.setContenido(encryptedValue);
            return Formatomensaje;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
