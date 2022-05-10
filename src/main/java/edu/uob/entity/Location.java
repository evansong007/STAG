package edu.uob.entity;

import com.alexmerz.graphviz.objects.Edge;
import com.alexmerz.graphviz.objects.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Location extends GameEntity{

    private HashMap<String,Artefact> artefactList;

    private HashMap<String,Character> characterList;

    private HashMap<String,Furniture> furnitureList;

    private HashMap<String,Player> playerList;
    private HashSet<String> destinations;


    public Location(String name, String description) {
        super(name, description);
        this.artefactList = new HashMap<>();
        this.characterList = new HashMap<>();
        this.furnitureList = new HashMap<>();
        this.playerList = new HashMap<>();
        this.destinations = new HashSet<>();
    }

    public void addEntity(GameEntity entity){
        entity.addLocation(this);
    }

    @Override
    public void addCharacter(GameEntity entity) {
        characterList.put(entity.name, (Character) entity);
    }

    @Override
    public void addFurniture(GameEntity entity) {
        furnitureList.put(entity.name, (Furniture) entity);
    }

    @Override
    public void addLocation(GameEntity entity) {
    }

    @Override
    public void addPlayer(GameEntity entity) {
        playerList.put(entity.name, (Player) entity);
    }

    @Override
    public void addArtefact(GameEntity entity) {
        artefactList.put(entity.name, (Artefact) entity);
    }

    public void addDestination(String nameOfLocation){
        destinations.add(nameOfLocation);
    }



}
