import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        // Lauscht auf allen Interfaces; empfaengt Unicast-Pakete der Clients.
        DatagramSocket socket = new DatagramSocket(4999);
        Runtime.getRuntime().addShutdownHook(new Thread(socket::close));
        System.out.println("Server gestartet");
        byte[] buf = new byte[1024];
        while (true) {
            DatagramPacket p = new DatagramPacket(buf, buf.length);
            socket.receive(p);
            System.out.println(p.getAddress().getHostAddress() + ": "
                    + new String(p.getData(), 0, p.getLength()));
        }
    }
}
