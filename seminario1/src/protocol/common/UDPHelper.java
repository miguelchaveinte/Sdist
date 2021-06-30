package protocol.common;

public class UDPHelper {
    private final java.io.ByteArrayOutputStream bos;
    private final java.io.ByteArrayInputStream  bis;

    public UDPHelper(byte[] entrada) {
        bos = new java.io.ByteArrayOutputStream();
        bis = new java.io.ByteArrayInputStream(entrada);
    }

    public byte[] aBytes(protocol.common.MensajeProtocolo mensaje) {
        bos.reset();
        try (java.io.ObjectOutput out = new java.io.ObjectOutputStream(bos)) {
            out.writeObject(mensaje);
            return bos.toByteArray();
        } catch (java.io.IOException ioe) {
            return null;
        }
    }

    public protocol.common.MensajeProtocolo aMensaje() {
        bis.reset(); /* sólo leemos un objeto en cada datagrama */

        try (java.io.ObjectInput in = new java.io.ObjectInputStream(bis)) {
            return (protocol.common.MensajeProtocolo) in.readObject();
        } catch (java.io.IOException | ClassNotFoundException ex) {
            return null;
        }
    }
}