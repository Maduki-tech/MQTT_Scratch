package de.schlueter.broker;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Broker
 */
public class Broker {
    int port = 0;
    ServerSocket serverSocket;

    public Broker(int port) {
        this.port = port;
    }

    public void listed() {
        try {
            serverSocket = new ServerSocket(this.port);

            Socket socket = serverSocket.accept();
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            Date date = new Date();
            Format df = new SimpleDateFormat("yyyy-mm-dd");
            String dateString = df.format(date);
            writer.println(dateString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
