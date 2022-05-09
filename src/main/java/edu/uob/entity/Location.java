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

    public void addEntity(GameEntity entity){
        if(!entityList.containsKey(entity.name)){
            entityList.put(entity.name,entity);
        }
    }

    public void addDestination(String nameOfLocation){
        destinations.add(nameOfLocation);
    }

    public void dropEntity(String nameOfEntity){
        entityList.remove(nameOfEntity);
    }


}
