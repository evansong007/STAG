package edu.uob.entity;

import java.util.HashMap;

public class Player extends GameEntity {

    private Integer health = 3;
    private HashMap<String,GameEntity> inventory;
    private String currentLocation;
    public Player(String name, String description) {
        super(name, description);
    }


}
