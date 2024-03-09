package fr.nirbose;

import java.util.UUID;

public class Data
{

    private final String uuid;
    private final Object o;
    private final int line;
    private final String className;

    public Data(UUID uuid, Object o, int line, String className)
    {
        this.uuid = uuid.toString();
        this.o = o;
        this.line = line;
        this.className = className;
    }

}
