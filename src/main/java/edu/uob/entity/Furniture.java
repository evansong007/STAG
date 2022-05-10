package edu.uob.entity;

public class Furniture extends GameEntity{
    public Furniture(String name, String description) {
        super(name, description);
    }

    @Override
    public void addEntity(GameEntity entity) {
        entity.addFurniture(this);
    }

    @Override
    public void addCharacter(GameEntity entity) {

    }

    @Override
    public void addFurniture(GameEntity entity) {

    }

    @Override
    public void addLocation(GameEntity entity) {

    }

    @Override
    public void addPlayer(GameEntity entity) {

    }

    @Override
    public void addArtefact(GameEntity entity) {

    }
}
