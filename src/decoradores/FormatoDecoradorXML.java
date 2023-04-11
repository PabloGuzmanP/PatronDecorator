package decoradores;
import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import mensajes.InterfaceMensaje;
import mensajes.ContenidoMensaje;


public class FormatoDecoradorXML extends DecoradorMensaje{
    public FormatoDecoradorXML(InterfaceMensaje Formatomensaje) {
        super(Formatomensaje);
    }

    @Override
    public InterfaceMensaje ProcesarMensaje() {
        Formatomensaje = Formatomensaje.ProcesarMensaje();
        Formatomensaje = xmlMessage();
        return Formatomensaje;
    }

    private InterfaceMensaje xmlMessage() {
        try {
            JAXBContext jc = JAXBContext.newInstance(Formatomensaje.getClass());
            JAXBElement<InterfaceMensaje> je2 = new JAXBElement<InterfaceMensaje>(new QName(Formatomensaje.getClass().getName()), (Class<InterfaceMensaje>) Formatomensaje.getClass(), Formatomensaje);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            marshaller.marshal(je2, output);
            return new ContenidoMensaje(new String(output.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error de conversion al formato XML");
        }
    }
}
