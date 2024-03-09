package fr.nirbose;

import fr.nirbose.server.ApiHandler;
import java.util.UUID;

public class Joe
{

    public static void print(Object o)
    {
        int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
        String className = Thread.currentThread().getStackTrace()[2].getClassName();

        ApiHandler.add(new Data(UUID.randomUUID(), o, line, className));
    }

}
