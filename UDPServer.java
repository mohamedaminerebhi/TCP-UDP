package UDP;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket serverSocket = null;
        
        try {
            // Créer une socket UDP sur le port 1123
            serverSocket = new DatagramSocket(1123);
            
            byte[] receiveData = new byte[1024];
            
            while (true) {
                // Préparer le paquet pour recevoir les données
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                
                // Recevoir les données du client
                serverSocket.receive(receivePacket);
                
                // Convertir les données en chaîne de caractères
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                
                // Afficher le message reçu
                System.out.println("Message reçu du client : " + message);
                
                // Effacer les données du paquet pour la prochaine réception
                receiveData = new byte[1024];
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}

