package edu.uob.entity;


import edu.uob.GameVisitor;
import java.util.HashMap;
import java.util.HashSet;

public class Location extends GameEntity {

    private final HashMap<String, GameEntity> entitylist;

    private final HashSet<String> destinations;


    public Location(String name, String description) {
        super(name, description);
        this.entitylist = new HashMap<>();
        this.destinations = new HashSet<>();
    }

    @Override
    public void accept(GameVisitor vistor) {
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

    public String getDescriptionOfMap() {
        String entities = "You can see: \n";
        for (GameEntity entity: entitylist.values()) {
            entities = entities.concat(entity.name +" : "+ entity.getDescription() + "\n") ;
        }
        entities = entities.concat("You can go : ");
        for (String path: destinations) {
            entities = entities.concat(path) + " ";
        }
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
