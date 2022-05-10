package edu.uob.entity;

import java.util.HashMap;

public class Player extends GameEntity {

    private Integer health ;
    private HashMap<String,GameEntity> inventory;
    private String currentLocation;
    public Player(String name, String description) {
        super(name, description);
        this.health = 3;
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
