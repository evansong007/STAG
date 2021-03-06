package edu.uob;

import edu.uob.entity.*;
import edu.uob.entity.Character;

import java.util.HashMap;

public class GameProduceVisitor extends GameVisitor {
    private final Location currentLocation;

    public GameProduceVisitor(GameModel model, String currentPlayer, GameAction action) {
        super(model, currentPlayer, action);
        Player player = model.getPlayer(currentPlayer);
        this.currentLocation = model.getLocation(player.getCurrentLocation());
    }

    @Override
    public void interactWithEntity(Artefact artefact) {
        //remove form current location
        HashMap<String, Location> locationHashMap = model.getLocationsMap();
        locationHashMap.forEach((k, v) -> v.removeEntity(artefact.getName()));
        //add entity to current location
        this.currentLocation.addEntity(artefact);


    }

    @Override
    public void interactWithEntity(Character character) {

        //remove form current location
        HashMap<String, Location> locationHashMap = model.getLocationsMap();
        locationHashMap.forEach((k, v) -> v.removeEntity(character.getName()));
        //add entity to current location
        this.currentLocation.addEntity(character);

    }

    @Override
    public void interactWithEntity(Furniture furniture) {

        //remove form current location
        HashMap<String, Location> locationHashMap = model.getLocationsMap();
        locationHashMap.forEach((k, v) -> v.removeEntity(furniture.getName()));
        //add entity to current location
        currentLocation.addEntity(furniture);

    }

    @Override
    public void interactWithEntity(Location location) {
        currentLocation.getDestinations().add(location.getName());
    }

    @Override
    public void interactWithEntity(Player player) {
        if (player.getHealth() < 3) {
            player.increaseHealth();
        }
    }

}
