package edu.uob.entity;

import com.alexmerz.graphviz.objects.Edge;
import com.alexmerz.graphviz.objects.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Location extends GameEntity{
    private HashMap<String,GameEntity> entityList;

    private HashSet<String> destinations;


    public Location(String name, String description) {
        super(name, description);
        this.entityList = new HashMap<>();
        this.destinations = new HashSet<>();
    }

    @Override
    public void interactWithEntity(GameEntity entity) {
        entity.interactWithLocation(this);
    }

    @Override
    public void interactWithArtefact(GameEntity entity) {
        entityList.put(entity.name,entity);
    }

    @Override
    public void interactWithCharacter(GameEntity entity) {
        entityList.put(entity.name,entity);
    }

    @Override
    public void interactWithFurniture(GameEntity entity) {
        entityList.put(entity.name,entity);
    }

    @Override
    public void interactWithLocation(GameEntity entity) {
    }

    @Override
    public void interactWithPlayer(GameEntity entity) {
        entityList.put(entity.name,entity);
    }

    public void addDestination(String nameOfLocation){
        destinations.add(nameOfLocation);
    }



}
