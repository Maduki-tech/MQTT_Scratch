package de.schlueter.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Client
 */
public class Client {
    int port = 0;
    public Client(int port) {
        this.port = port;
    }

    public String connect() {
        String result = null;
        try (Socket socket = new Socket("localhost", this.port)) {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String time = reader.readLine();
            result = time;

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
