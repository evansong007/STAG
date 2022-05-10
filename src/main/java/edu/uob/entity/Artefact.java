package edu.uob.entity;

public class Artefact extends GameEntity {
    public Artefact(String name, String description) {
        super(name, description);
    }

    @Override
    public void addEntity(GameEntity entity) {
        entity.addArtefact(this);
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
