package threads.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ReverseClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 11111;
        System.out.println("Pripojuji se k " + host + ":" + port);

        try(Socket socket = new Socket(host, port)){
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println("Pripojeno k serveru!");

            String response = in.readLine();
            if (response == null){
                System.out.println("Server ukoncil pripojeni");
                return;
            }

            pw.println(new StringBuilder(response).reverse());
            System.out.println("Echo od serveru: " + in.readLine());

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
