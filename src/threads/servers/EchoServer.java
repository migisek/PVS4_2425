package threads.servers;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        int port = 11111;
        System.out.println("Spoustim server na portu: " + port);

        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server posloucha...");

            try(Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client se pripojil: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

                String line;
                while ((line = in.readLine()) != null){
                    System.out.println("Od klienta prislo: " + line);
                    pw.println(line);
                }
                System.out.println("Klient se odpojil");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
