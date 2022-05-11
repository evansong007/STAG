package edu.uob;

import edu.uob.entity.*;
import edu.uob.entity.Character;

import java.util.HashMap;
import java.util.Map;

public class GameProduced extends GameVistor{
    public GameProduced(GameModel model, String currentPlayer, GameAction action) {
        super(model, currentPlayer, action);
    }

    @Override
    public void interactWithEntity(GameEntity gameEntity) {
        gameEntity.accept(this);
    }

    @Override
    public void interactWithEntity(Artefact artefact) {
        //remove form current location
        HashMap<String,Location> locationHashMap = model.getLocationsMap();
        locationHashMap.forEach((k,v)->v.removeEntity(artefact.getName()));
        Player player = model.getPlayer(currentPlayer);
        Location currentLocation = model.getLocation(player.getCurrentLocation());
        //add entity to current location
        currentLocation.addEntity(artefact);

    }

    @Override
    public void interactWithEntity(Character character) {
        //remove form current location
        HashMap<String,Location> locationHashMap = model.getLocationsMap();
        locationHashMap.forEach((k,v)->v.removeEntity(character.getName()));
        Player player = model.getPlayer(currentPlayer);
        Location currentLocation = model.getLocation(player.getCurrentLocation());
        //add entity to current location
        currentLocation.addEntity(character);
    }

    @Override
    public void interactWithEntity(Furniture furniture) {
        //remove form current location
        HashMap<String,Location> locationHashMap = model.getLocationsMap();
        locationHashMap.forEach((k,v)->v.removeEntity(furniture.getName()));
        Player player = model.getPlayer(currentPlayer);
        Location currentLocation = model.getLocation(player.getCurrentLocation());
        //add entity to current location
        currentLocation.addEntity(furniture);
    }

    @Override
    public void interactWithEntity(Location location) {
        Player player = model.getPlayer(currentPlayer);
        Location currentLocation = model.getLocation(player.getCurrentLocation());
        currentLocation.getDestinations().add(location.getName());
    }

    @Override
    public void interactWithEntity(Player player) {
        player.increaseHealth();
    }

}
