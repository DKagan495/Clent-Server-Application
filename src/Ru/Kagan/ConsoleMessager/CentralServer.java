package Ru.Kagan.ConsoleMessager;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CentralServer {
    public static final int PORT = 1212;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        try
        {
            while(true) {
                Socket socket = serverSocket.accept();

                try
                {
                    BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                    while(true) {
                        String fromClientToServer = in.readLine();
                        //out.println("");
                        System.out.print(fromClientToServer);
                    }
                }
                finally {
                    socket.close();
                }
            }

        }
        finally {
            serverSocket.close();
        }


    }
}
