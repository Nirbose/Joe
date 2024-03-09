package fr.nirbose;

import fr.nirbose.server.Server;
;import java.util.UUID;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Server.create();

        Thread.sleep(5000);









        Joe.print(new Data(UUID.randomUUID(), "Hello World", 0, "Main"));
    }
}