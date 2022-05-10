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

    public abstract void interactWithEntity(GameEntity entity);

    public abstract void interactWithArtefact(GameEntity entity);

    public abstract void interactWithCharacter(GameEntity entity);

    public abstract void interactWithFurniture(GameEntity entity);

    public abstract void interactWithLocation(GameEntity entity);

    public abstract void interactWithPlayer(GameEntity entity);


}
