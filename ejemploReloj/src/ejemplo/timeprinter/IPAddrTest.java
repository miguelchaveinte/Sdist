package ejemplo.timeprinter;
import java.io.*;
import java.net.*;

public class IPAddrTest {
	public static void main(final String[ ] args) {
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println("IpAddress: " + ip.toString());
		String name = ip.getHostName();
		System.out.println("Host Nombre: " + name);
		name = ip.getCanonicalHostName();  //nombre de dominio completamente cualificado
		System.out.println("Host Nombre completo: " + name);

	}
}
