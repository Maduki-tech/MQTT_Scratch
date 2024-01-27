package de.schlueter;

import de.schlueter.broker.Broker;
import de.schlueter.client.Client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

/**
 * Connection_Test
 */
public class Connection_Test {
    private static int port = 3030;

    @Test
    void connect_test() {
        Broker broker = new Broker(port);

        new Thread(() -> { broker.listed(); }).start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Client client = new Client(port);
        String res = client.connect();

        Date date = new Date();
        Format df = new SimpleDateFormat("yyyy-mm-dd");
        String dateString = df.format(date);

        assertEquals(dateString, res);
    }
}
