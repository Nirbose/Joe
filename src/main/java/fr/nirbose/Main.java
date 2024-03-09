package fr.nirbose;

import fr.nirbose.server.Server;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");

        try
        {
            Server.create();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}