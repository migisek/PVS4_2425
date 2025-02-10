package threads.servers.multithread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BroadcastEchoServer {
    private static final int PORT = 11111;
    private static final List<PrintWriter> clientOutputs =
            Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        System.out.println("Startuji server na "+ PORT);

        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true){

            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
} class BroadcastClientHandle extends Thread {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public BroadcastClientHandle(Socket socket) {

    }
}
