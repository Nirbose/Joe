package fr.nirbose.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server
{

    public final static int DEFAULT_PORT = 8080;

    public static void create()
    {
        create(DEFAULT_PORT);
    }

    public static void create(int port)
    {
        startHttpServer(port);
    }

    private static void startHttpServer(int port)
    {
        Thread thread = new Thread(() -> {
            try
            {
                HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
                server.createContext("/", new RootHandler());
                server.createContext("/api", new ApiHandler());
                server.setExecutor(null);

                server.start();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}
