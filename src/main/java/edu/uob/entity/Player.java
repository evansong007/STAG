package edu.uob.entity;

import edu.uob.GameVisitor;

import java.util.HashMap;

public class Player extends GameEntity {

    private Integer health ;
    private final HashMap<String,Artefact> inventory;
    private String currentLocation;
    public Player(String name, String description) {
        super(name, description);
        this.health = 3;
        this.inventory = new HashMap<>();
    }

    @Override
    public void accept(GameVisitor vistor) {
        vistor.interactWithEntity(this);
    }


    public HashMap<String, Artefact> getInventory() {
        return inventory;
    }

    public String getCurrentLocation(){
        return currentLocation;
    }

    public void setCurrentLocation(String location){
        this.currentLocation = location;
    }

    public Integer getHealth(){
        return health;
    }

    public void getArtefect(Artefact entity){
        inventory.put(entity.getName(),entity);
    }

    public Artefact dropArtefect(String entity){
        return inventory.remove(entity);
    }

    public void descreaseHealth(){
        health -= 1;
    }

    public void increaseHealth(){
        health += 1;
    }

    public void resethealth(){
        health = 3;
    }
}
