package UDP;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket clientSocket = null;
        
        try {
            // Créer une socket UDP
            clientSocket = new DatagramSocket();
            
            // Adresse IP du serveur et port
            InetAddress IPAddress = InetAddress.getByName("localhost");
            int port = 1123;
            
            // Message à envoyer
            String message = "Bonjour, serveur UDP!";
            
            // Convertir le message en tableau de bytes
            byte[] sendData = message.getBytes();
            
            // Créer un paquet contenant les données à envoyer
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            
            // Envoyer le paquet au serveur
            clientSocket.send(sendPacket);
            
            System.out.println("Message envoyé au serveur.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
}
