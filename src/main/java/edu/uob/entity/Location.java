package edu.uob.entity;

import com.alexmerz.graphviz.objects.Edge;
import com.alexmerz.graphviz.objects.Graph;
import edu.uob.GameVistor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Location extends GameEntity {

    private HashMap<String, GameEntity> entitylist;

    private HashSet<String> destinations;


    public Location(String name, String description) {
        super(name, description);
        this.entitylist = new HashMap<>();
        this.destinations = new HashSet<>();
    }

    @Override
    public void accept(GameVistor vistor) {
        vistor.interactWithEntity(this);
    }

    public void addEntity(GameEntity entity){
        entitylist.put(entity.name,entity);
    }

    public void addPlayer(Player entity) {
        entitylist.put(entity.name, entity);
    }

    public void addDestination(String nameOfLocation) {
        destinations.add(nameOfLocation);
    }


    public HashSet<String> getDestinations() {
        return destinations;
    }

    public String getEntities() {
        String entities = entitylist.keySet().toString();

        return entities;
    }

    public HashMap<String,GameEntity> getEntitylist(){
        return entitylist;
    }

    public GameEntity getEntity(String entity){
        return entitylist.get(entity);
    }

    public void removeEntity(String entity){
        entitylist.remove(entity);
    }


}
