package edu.uob;

import edu.uob.entity.*;
import edu.uob.entity.Character;

public class GameConsumed extends GameVistor{

    public GameConsumed(GameModel model, String currentPlayer, GameAction action) {
        super(model, currentPlayer, action);
    }

    @Override
    public void interactWithEntity(GameEntity gameEntity) {
        gameEntity.accept(this);
    }

    @Override
    public void interactWithEntity(Artefact artefact) {
        Player player = model.getPlayer(currentPlayer);
        Location currentLocation = model.getLocation(player.getCurrentLocation());
        Location storeroom = model.getStroeroom();
        player.dropArtefect(artefact.getName());
        currentLocation.removeEntity(artefact.getName());
        storeroom.addEntity(artefact);
    }

    @Override
    public void interactWithEntity(Character character) {
        Player player = model.getPlayer(currentPlayer);
        Location currentLocation = model.getLocation(player.getCurrentLocation());
        Location storeroom = model.getStroeroom();
        currentLocation.removeEntity(currentPlayer);
        storeroom.addEntity(character);
    }

    @Override
    public void interactWithEntity(Furniture furniture) {
        Player player = model.getPlayer(currentPlayer);
        Location currentLocation = model.getLocation(player.getCurrentLocation());
        Location storeroom = model.getStroeroom();
        currentLocation.removeEntity(furniture.getName());
        storeroom.addEntity(furniture);
    }

    @Override
    public void interactWithEntity(Location location) {
        Player player = model.getPlayer(currentPlayer);
        Location currentLocation = model.getLocation(player.getCurrentLocation());
        currentLocation.getDestinations().remove(location.getName());
    }

    @Override
    public void interactWithEntity(Player player) {
        player.descreaseHealth();
    }

}
