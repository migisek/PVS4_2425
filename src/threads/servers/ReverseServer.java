package threads.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReverseServer {
    public static void main(String[] args) {
        int port = 11111;
        //slovo, ktere kontroluje od klienta
        String keyWord = "test";
        System.out.println("Spoustim server na portu: " + port);

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server posloucha...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client se pripojil: " + clientSocket.getInetAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

                pw.println(keyWord);

                String line = in.readLine();
                System.out.println("Od klienta prislo: " + line);
                if (new StringBuilder(line).reverse().toString().equals(keyWord)) {
                    pw.println("Reverse OK!");
                } else {
                    pw.println("Reverse NOT OK!");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
