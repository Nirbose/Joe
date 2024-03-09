package fr.nirbose.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import fr.nirbose.Joe;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class RootHandler implements HttpHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        String line;
        StringBuilder resp = new StringBuilder();

        try
        {
            File newFile = new File("src/main/resources/static/index.html");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(newFile)));

            while ((line = bufferedReader.readLine()) != null)
            {
                resp.append(line);
            }
            bufferedReader.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        exchange.sendResponseHeaders(200, resp.length());
        OutputStream os = exchange.getResponseBody();
        os.write(resp.toString().getBytes());
        os.close();
    }
}
