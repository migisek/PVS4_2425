package threads.servers.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BroadcastEchoServer {
    private static final int PORT = 11111;
    public static final List<PrintWriter> clientOutputs =
            Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        System.out.println("Startuji server na " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Priopjil se klient z portu: " + clientSocket.getPort());

                BroadcastClientHandle handler = new BroadcastClientHandle(clientSocket);
                handler.start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void broadCast(String messge) {
        for (PrintWriter pw : clientOutputs) {
            pw.println(messge);
        }
    }
}

class BroadcastClientHandle extends Thread {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public BroadcastClientHandle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            BroadcastEchoServer.clientOutputs.add(out);

            String received;
            while ((received = in.readLine()) != null) {
                System.out.println("S: " + received);

                if ("quit".equalsIgnoreCase(received)) {
                    break;
                }

                BroadcastEchoServer.broadCast("[" + socket.getPort() + "]: " + received);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Odpojil se: " + socket.getPort());
            BroadcastEchoServer.clientOutputs.remove(out);

            try {
                socket.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
