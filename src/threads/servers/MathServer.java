package threads.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class MathServer {

    public static void main(String[] args) {
        int port = 54321;

        try(ServerSocket socket = new ServerSocket(port)){
            System.out.println("Server ready...");
            //nepouziju try-with-resources u clientSocketu
            Socket clientSocket = socket.accept();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter pw = new PrintWriter(clientSocket.getOutputStream(), true);

            //vygeneruj ukol
            Random r = new Random();
            int num1 = r.nextInt(100);
            int num2 = r.nextInt(100);

            pw.println("Kolik je " + num1 + " + " + num2 + "?");

            int clientAnswer = Integer.parseInt(in.readLine());

            if (clientAnswer == num1 + num2){
                pw.println("Sprvna odpoved!");
            } else {
                pw.println("Nespravna odpoved, spravne je " + (num1+num2));
            }

            //socket musim zavrit sam:
            clientSocket.close();
            System.out.println("Spojeni ukonceno");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
