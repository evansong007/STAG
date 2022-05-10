package edu.uob.entity;

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

    public abstract void addEntity(GameEntity entity);

    public abstract void addCharacter(GameEntity entity);

    public abstract void addFurniture(GameEntity entity);

    public abstract void addLocation(GameEntity entity);

    public abstract void addPlayer(GameEntity entity);

    public abstract void addArtefact(GameEntity entity);
}
