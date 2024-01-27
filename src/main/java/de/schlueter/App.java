package de.schlueter;

import de.schlueter.broker.Broker;
import de.schlueter.client.Client;

/**
 * App
 */
public class App {
    private static int port = 3030;
    public static void main(String[] args) {
        Broker broker = new Broker(port);

        new Thread(() -> { broker.listed(); }).start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Client client = new Client(port);
        client.connect();
    }
}
