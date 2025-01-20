package threads.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 11111;

        System.out.println("Pripojuji se k " + host + ":" + port);

        try(Socket socket = new Socket(host, port)){
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);

            System.out.println("Pripojeno k serveru!");

            while (true){
                System.out.println("Zadej zpravu, zadej quit pro ukonceni");

                String message = sc.nextLine();

                if (message.equalsIgnoreCase("quit")){
                    break;
                }

                pw.println(message);

                String response = in.readLine();

                if (response == null){
                    System.out.println("Server ukoncil pripojeni");
                    break;
                }
                System.out.println("Echo od serveru: " + response);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
