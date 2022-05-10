package edu.uob.entity;

import java.util.HashMap;

public class Player extends GameEntity {

    private Integer health = 3;
    private HashMap<String,GameEntity> inventory;
    private String currentLocation;
    public Player(String name, String description) {
        super(name, description);
    }

    @Override
    public void addEntity(GameEntity entity) {
        entity.addPlayer(this);
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
