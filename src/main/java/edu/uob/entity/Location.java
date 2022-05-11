package edu.uob.entity;

import com.alexmerz.graphviz.objects.Edge;
import com.alexmerz.graphviz.objects.Graph;
import edu.uob.GameVistor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Location extends GameEntity{
    private HashMap<String,Artefact> artefectList;

    private HashMap<String,Character> characterList;

    private HashMap<String, Furniture> furnitureList;

    private HashMap<String,Player> playerList;

    private HashSet<String> destinations;


    public Location(String name, String description) {
        super(name, description);
        this.artefectList = new HashMap<>();
        this.characterList = new HashMap<>();
        this.furnitureList = new HashMap<>();
        this.playerList = new HashMap<>();
        this.destinations = new HashSet<>();
    }

    @Override
    public void accept(GameVistor vistor) {

    }

    public void addArtefact(Artefact entity) {
        artefectList.put(entity.name, entity);
    }

    public void addCharacter(Character entity) {
        characterList.put(entity.name, entity);
    }

    public void addFurniture(Furniture entity) {
        furnitureList.put(entity.name, entity);
    }

    public void addPlayer(Player entity) {
        playerList.put(entity.name, entity);
    }

    public void addDestination(String nameOfLocation){
        destinations.add(nameOfLocation);
    }


    public HashSet<String> getDestinations(){
        return destinations;
    }

    public String getEntities(){
        String atrefects = artefectList.keySet().toString();
        String characters = characterList.keySet().toString();
        String furnitures = furnitureList.keySet().toString();
        String players = playerList.keySet().toString();

        return atrefects + characters + furnitures + players;
    }

    public HashMap<String,Artefact> getArtefectList(){
        return artefectList;
    }

    public HashMap<String,Character> getCharacterList(){
        return characterList;
    }

    public HashMap<String,Furniture> getFurnitureList(){
        return furnitureList;
    }

    public Artefact getArtefect(String entity){
        return artefectList.get(entity);
    }

    public void removeArtefect(String entity){
        artefectList.remove(entity);
    }

    public void removePlayer(String player){
         playerList.remove(player);
    }

}
