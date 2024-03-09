package fr.nirbose.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.nirbose.Data;

import java.util.ArrayList;
import java.util.List;

public class ApiHandler implements HttpHandler
{

    private static final List<Data> contents = new ArrayList<>();

    @Override
    public void handle(HttpExchange exchange)
    {
        if (exchange.getRequestMethod().equals("GET"))
        {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            StringBuilder resp = new StringBuilder();

            try
            {
                exchange.sendResponseHeaders(200, 0);
                exchange.getResponseHeaders().add("Content-Type", "application/json");

                resp.append(gson.toJson(contents));

                exchange.getResponseBody().write(resp.toString().getBytes());
                exchange.getResponseBody().close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void add(Data data)
    {
        contents.add(data);
    }
}
