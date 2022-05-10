package edu.uob.entity;

public class Character extends GameEntity{
    public Character(String name, String description) {
        super(name, description);
    }

    @Override
    public void addEntity(GameEntity entity) {
        entity.addCharacter(this);
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
