package edu.uob.entity;

import edu.uob.GameVisitor;

public abstract class GameEntity
{
    String name;
    String description;

    public GameEntity(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public abstract void accept(GameVisitor vistor);



}
