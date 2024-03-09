package fr.nirbose.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server
{

    public final static int DEFAULT_PORT = 8080;

    public static void create() throws IOException
    {
        create(DEFAULT_PORT);
    }

    public static void create(int port) throws IOException
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new RootHandler());
        server.setExecutor(null);
        server.start();
    }

}
