package Ru.Kagan.ConsoleMessager;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", CentralServer.PORT);
        try {

            while(true)
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                Scanner scanner = new Scanner(System.in);
                while(true)
                {
                    String line = scanner.next();
                    out.println(line);
                    //String fromServerToClient = in.readLine();
                    //System.out.println(fromServerToClient);
                }
            }
        }
        finally {
            socket.close();
        }
    }
}
