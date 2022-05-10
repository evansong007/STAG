package edu.uob.entity;

public class Furniture extends GameEntity{
    public Furniture(String name, String description) {
        super(name, description);
    }

    @Override
    public void interactWithEntity(GameEntity entity) {
        entity.interactWithEntity(this);
    }

    @Override
    public void interactWithArtefact(GameEntity entity) {

    }

    @Override
    public void interactWithCharacter(GameEntity entity) {

    }

    @Override
    public void interactWithFurniture(GameEntity entity) {

    }

    @Override
    public void interactWithLocation(GameEntity entity) {

    }

    @Override
    public void interactWithPlayer(GameEntity entity) {

    }
}
